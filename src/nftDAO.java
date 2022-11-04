import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

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
@WebServlet("/NFTDAO")
public class nftDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public nftDAO(){}
	
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
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NFTdb?allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&NFT=john&created_date=pass1234");
            System.out.println(connect);
        }
    }
    

    public List<NFT> listAllNFTs() throws SQLException {
        List<NFT> listNFT = new ArrayList<NFT>();        
        String sql = "SELECT * FROM NFT";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String nftid = resultSet.getString("nftid");
            String unique_name = resultSet.getString("unique_name");
            String description = resultSet.getString("description");
            String created_date = resultSet.getString("created_date");
            String nft_image = resultSet.getString("nft_image");

             
            NFT NFTs = new NFT(nftid,unique_name, description, created_date, nft_image);
            listNFT.add(NFTs);
        }        
        resultSet.close();
        disconnect();        
        return listNFT;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(NFT NFTs) throws SQLException {
    	connect_func();         
		String sql = "insert into NFT(nftid, unique_name, description, created_date, nft_image) values (?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, NFTs.getnftid());
			preparedStatement.setString(2, NFTs.getunique_name());
			preparedStatement.setString(3, NFTs.getdescription());
			preparedStatement.setString(4, NFTs.getcreated_date());
			preparedStatement.setString(5, NFTs.getnft_image());	
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String nftid) throws SQLException {
        String sql = "DELETE FROM NFT WHERE nftid = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, nftid);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(NFT NFTs) throws SQLException {
        String sql = "update NFT set unique_name=?, description =?,created_date = ?,nft_image=? where nftid = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, NFTs.getNftid());
		preparedStatement.setString(2, NFTs.getUnique_name());
		preparedStatement.setString(3, NFTs.getDescription());
		preparedStatement.setString(4, NFTs.getCreated_date());
		preparedStatement.setString(5, NFTs.getNft_image());	
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public NFT getNFT(String nftid) throws SQLException {
    	NFT NFT = null;
        String sql = "SELECT * FROM NFT WHERE nftid = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, nftid);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String unique_name = resultSet.getString("unique_name");
            String description = resultSet.getString("description");
            String created_date = resultSet.getString("created_date");
            String nft_image = resultSet.getString("nft_image");
            NFT = new NFT(nftid, unique_name, description, created_date, nft_image);
        }
         
        resultSet.close();
        statement.close();
         
        return NFT;
    }
    
    public boolean checknftid(String nftid) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM NFT WHERE nftid = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, nftid);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkcreated_date(String created_date) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM NFT WHERE created_date = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, created_date);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String nftid, String created_date) throws SQLException
    {
    	String sql = "SELECT * FROM NFT";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("nftid").equals(nftid) && resultSet.getString("created_date").equals(created_date)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists NFTdb; ",
		        "create database NFTdb; ",
		        "use NFTdb; ",
		        "drop table if exists NFT; ",
		        ("CREATE TABLE if not exists NFT( " +
                    "nftid VARCHAR(50) NOT NULL, " +
		            "unique_name VARCHAR(10) NOT NULL, " +
		            "description VARCHAR(10) NOT NULL, " +
		            "created_date VARCHAR(10) NOT NULL, " +
		            "nft_image DATE NOT NULL, " +
		            "PRIMARY KEY (nftid) "+"); ")
				};
String[] TUPLES = {("insert into NFT(nftid, unique_name, description, created_date, nft_image)" +
		"values ('root', 'default', 'default', 'pass1234', '0001-01-01')," +
    		 	"('jondoe@gmail.com', 'Jon', 'Doe', 'tVp7@MR59q', '2001-01-31')," +
    	 	 	"('jackenoff@gmail.com', 'Jack', 'Enoff', '99C2*iXAn3', '2001-04-12')," +
    		 	"('bendover@gmail.com', 'Ben', 'Dover', '77@Z!G54pa', '2000-09-12')," +
    		 	"('erinmoore@gmail.com', 'Erin', 'Moore', 'f5eO#24Z4@', '2002-04-18')," +
    		 	"('mikehunt@gmail.com', 'Mike', 'Hunt', 'RxS4k0$u30', '1999-09-15')," +
    			"('jessicacole@gmail.com', 'Jessica', 'Cole', 'G@078D*k3x', '2001-04-10')," +
    			"('meganfoxx@gmail.com', 'Megan', 'Foxx', '%nXtVh264c', '2000-08-14')," +
    			"('harrybules@gmail.com', 'Harry', 'Bules', '*x^Z9%me40', '2000-08-17'),"+
    			"('marymean@gmail.com', 'Mary', 'Mean', 'd^F3!s39$%', '1998-09-26');"
    			)};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
