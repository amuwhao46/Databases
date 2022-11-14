import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/ListingDAO")
public class ListingDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public ListingDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NFTdb?allowPublicKeyRetrieval=true&useSSL=false"
            		+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
            		+ "&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
     protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }

    public List<Listing> allListedNfts() throws SQLException {
        List<Listing> allListNft = new ArrayList<Listing>();        
        String sql = "SELECT * FROM Listing";      
        connect_func();      

        try {
        	
        	  statement = (Statement) connect.createStatement();
        	  ResultSet resultSet = statement.executeQuery(sql);
        
        	// 
        	while (resultSet.next()) {
        		
        		int listid= resultSet.getInt("listid");
        		java.sql.Timestamp end= resultSet.getTimestamp("end");
        		
        		if (end.compareTo(new Date())<0) {
        			
        			this.delete(listid);
        		}
        		else{
        		String owner = resultSet.getString("owner");
        		int nftid = resultSet.getInt("nftid");
        		java.sql.Timestamp start= resultSet.getTimestamp("start");
        		double price = resultSet.getDouble("price");
        		allListNft.add(new Listing(listid, owner, nftid, start, end, price)); 
        		}	
        	}   
        resultSet.close();
        } catch(Exception e) {
        	throw new SQLException(e);
        }
     
        return allListNft;
    }
    
    public Listing getListedNft(int nft) throws SQLException {
        Listing getListNft = null;        
        String sql = "SELECT * FROM Listing WHERE nftid = ?";      
        connect_func();    
        
        try {
        	
        	  preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	  preparedStatement.setInt(1, nft);
        	  ResultSet resultSet = statement.executeQuery(sql);
        
        
        	while (resultSet.next()) {
        		
        		int listid= resultSet.getInt("listid");
        		java.sql.Timestamp end= resultSet.getTimestamp("end");
        		
        		if (end.compareTo(new Date())<0) {
        			this.delete(listid);
        		}
        		else{
        		String owner = resultSet.getString("owner");
        		int nftid = resultSet.getInt("nftid");
        		java.sql.Timestamp start= resultSet.getTimestamp("start");
        		double price = resultSet.getDouble("price");
        		
        		getListNft = new Listing(listid, owner, nftid, start, end, price);
        		
        		}	
        	}   
        resultSet.close();
        } catch(Exception e) {
        	throw new SQLException(e);
        }
     
        return getListNft;
    }
    
    public List<Listing> userListedNfts(String username) throws SQLException {
        List<Listing> allListNft = new ArrayList<Listing>();        
        String sql = "SELECT * FROM Listing WHERE owner= ?";      
        connect_func();      

        try {
        	

      	  preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
      	  preparedStatement.setString(1, username);
      	  ResultSet resultSet = statement.executeQuery(sql);
      
 
        	while (resultSet.next()) {
        		
        		int listid= resultSet.getInt("listid");
        		java.sql.Timestamp end= resultSet.getTimestamp("end");
        		
        		if (end.compareTo(new Date())<0) {
        			
        			this.delete(listid);
        		}
        		
        		else{
        		String owner = resultSet.getString("owner");
        		int nftid = resultSet.getInt("nftid");
        		java.sql.Timestamp start= resultSet.getTimestamp("start");
        		double price = resultSet.getDouble("price");
        		Listing newListing = new Listing(listid, owner, nftid, start, end, price);
        		allListNft.add(newListing);
        		}	
        	}   
        resultSet.close();
        } catch(Exception e) {
        	throw new SQLException(e);
        }
     
        return allListNft;
    }
    
    public void insert(Listing newListing) throws SQLException {
    	connect_func();         
		String sql = "insert into Listing(owner, nftid, start, end, price) values (?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, newListing.getOwner());
		preparedStatement.setInt(2, newListing.getNFTid());
		preparedStatement.setTimestamp(3, newListing.getStart());
		preparedStatement.setTimestamp(4, newListing.getEnd());
		preparedStatement.setDouble(5, newListing.getPrice());		
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(int nft) throws SQLException {
        String sql = "DELETE FROM Listing WHERE nftid = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, nft);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
      
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        Date start = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 12);
        Date end = cal.getTime();
        
        Timestamp startTime = new Timestamp(start.getTime());
        Timestamp endTime = new Timestamp(end.getTime());
        String[] INITIAL = {"use NFTdb; ",
        		"drop table if exists Listing; ",
		        ("CREATE TABLE if not exists Listing( " +
		        	"listid INTEGER NOT NULL AUTO_INCREMENT, " +
                    "owner VARCHAR(100), " +
		            "nftid INTEGER, " +
		            "start TIMESTAMP, " +
		            "end TIMESTAMP, " +
		            "price DOUBLE, " +
		            "PRIMARY KEY(listid), " +
		            "FOREIGN KEY(owner) REFERENCES User(userid), " +
		            "FOREIGN KEY(nftid) REFERENCES NFT(nftid)"+"); ")
				};
        
        String[] TUPLES = {("insert into Listing(owner, nftid, start, end, price)"+
    			"values ('jondoe@gmail.com', '1', '" + startTime.toString() + "', '" + endTime.toString() + "', '10'), "+
    			"('jondoe@gmail.com', '2', '" + startTime.toString() + "', '" + endTime.toString() + "', '10')," + 
    			"('jondoe@gmail.com', '3', '" + startTime.toString() + "', '" + endTime.toString() + "', '10')," + 
    			"('jondoe@gmail.com', '4', '" + startTime.toString() + "', '" + endTime.toString() + "', '10')," + 
    			"('jondoe@gmail.com', '5', '" + startTime.toString() + "', '" + endTime.toString() + "', '10')," + 
    			"('jondoe@gmail.com', '6', '" + startTime.toString() + "', '" + endTime.toString() + "', '10')," + 
    			"('jondoe@gmail.com', '7', '" + startTime.toString() + "', '" + endTime.toString() + "', '10')," + 
    			"('jondoe@gmail.com', '8', '" + startTime.toString() + "', '" + endTime.toString() + "', '10')," + 
    			"('jondoe@gmail.com', '9', '" + startTime.toString() + "', '" + endTime.toString() + "', '10')," + 
    			"('jondoe@gmail.com', '10', '" + startTime.toString() + "', '" + endTime.toString() + "', '10');")
		    	};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
