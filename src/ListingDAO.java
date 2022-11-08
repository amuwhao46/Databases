import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
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
        		
        		String listid= resultSet.getString("listid");
        		java.sql.Timestamp end= resultSet.getTimestamp("end");
        		
        		if (end.compareTo(new Date())<0) {
        			
        			this.delete(listid);
        		}
        		else{
        		String owner = resultSet.getString("owner");
        		String nftid = resultSet.getString("nftid");
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
    
    public Listing getListedNft(String nft) throws SQLException {
        Listing getListNft = null;        
        String sql = "SELECT * FROM Listing nftid = ?";      
       
        try {
        	
        	  preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	  preparedStatement.setString(1, nft);
        	  ResultSet resultSet = statement.executeQuery(sql);
        
        
        	while (resultSet.next()) {
        		
        		String listid= resultSet.getString("listid");
        		java.sql.Timestamp end= resultSet.getTimestamp("end");
        		
        		if (end.compareTo(new Date())<0) {
        			
        			this.delete(listid);
        		}
        		else{
        		String owner = resultSet.getString("owner");
        		String nftid = resultSet.getString("nftid");
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
        		
        		String listid= resultSet.getString("listid");
        		java.sql.Timestamp end= resultSet.getTimestamp("end");
        		
        		if (end.compareTo(new Date())<0) {
        			
        			this.delete(listid);
        		}
        		
        		else{
        		String owner = resultSet.getString("owner");
        		String nftid = resultSet.getString("nftid");
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
		String sql = "insert into Listing(owner, nftid, description, created_date, nft_image, owner, creator) values (?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, newListing.getOwner());
		preparedStatement.setString(2, newListing.getNFTid());
		preparedStatement.setTimestamp(3, newListing.getStart());
		preparedStatement.setTimestamp(4, newListing.getEnd());
		preparedStatement.setDouble(5, newListing.getPrice());		
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String nft) throws SQLException {
        String sql = "DELETE FROM Listing WHERE nftid = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, nft);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
      
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"use NFTdb; ",
        		"drop table if exists Listing; ",
		        ("CREATE TABLE if not exists Listing( " +
		        	"listid VARCHAR NOT NOT NULL AUTO_INCREMENT, " +
                    "owner VARCHAR(50), " +
		            "nftid VARCHAR(50), " +
		            "start TIMESTAMP, " +
		            "end TIMESTAMP, " +
		            "price DOUBLE, " +
		            "PRIMARY KEY(listid), " +
		            "FOREIGN KEY(owner) REFERENCES User(userid), " +
		            "FOREIGN KEY(nftid) REFERENCES User(nftid),"+"); ")
				};
String[] TUPLES = {("insert into Listing(owner, nftid, start, end, price," +
		"values ('jondoe@gmail.com', '100', 'Lots of homies','00-00-0000', 'photovalhold')," +
    		 	"('jondoe@gmail.com','Tinted Frostbite','Cooler than a cat','01-31-2001','3959')," +
    	 	 	"('jackenoff@gmail.com','Enraged Master','Entitled man is upset over small deal', '04-12-2001','1485')," +
    		 	"('bendover@gmail.com','Gleam Steam','Shiny steam cakes air and catches attention','09-12-2000','3780',)," +
    		 	"('erinmoore@gmail.com','Corrupt Rose','The baddest of all roses','04-18-2002','3921')," +
    		 	"('mikehunt@gmail.com','Fancy Unicorn','You know hes fly with his little hat','09-15-1999','426')," +
    			"('jessicacole@gmail.com','Murky Dragonfly','This guys been flying through the desert','04-10-2001','444')," +
    			"('meganfoxx@gmail.com','Wealthy Stardust','Personified gold','08-14-2000','3513')," +
    			"('harryballs@gmail.com','Misty Bat','If batman worked at a water park','08-17-2000','859'),"+
    			"('marymean@gmail.com','Good Oak','Bad City','09-26-1998','2562');"
    			)};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
