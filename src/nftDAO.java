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
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**S
 * Servlet implementation class Connect
 */
@WebServlet("/nftDAO")
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
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NFTdb?allowPublicKeyRetrieval=true&useSSL=false"
            		+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
            		+ "&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    // list common NFT function -- unsure of implementation
    public List<nft> listCommonNfts(String userA, String userB) throws SQLException {
        List<nft> listCommonNft = new ArrayList<nft>();        
        String sql = "SELECT DISTINCT (nftid) FROM Transaction WHERE (sender = ? OR sender = ?) and (reciever = ? OR reciever = ?);";      
        
        try {
        	connect_func();      
        	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	preparedStatement.setString(1, userA);
        	preparedStatement.setString(2, userB);
        	preparedStatement.setString(3, userA);
        	preparedStatement.setString(4, userB);

        	ResultSet resultSet = preparedStatement.executeQuery();
        	

        	while (resultSet.next()) {
        		
        		int nftid = resultSet.getInt("nftid");
        		nft nftsInCommon = getNft(nftid);

        		listCommonNft.add(nftsInCommon);

        	}  
        	resultSet.close(); 


        	  
        } catch(Exception e) {
        	System.out.println(e.toString() + " Threw in NFTDAO on line 85");
        }

         
        return listCommonNft;
    }
    
    public List<nft> listAllNfts() throws SQLException {
        List<nft> listNft = new ArrayList<nft>();        
        String sql = "SELECT * FROM NFT";      
        
        
        try {
        	
        	connect_func();      
        	
        	statement = (Statement) connect.createStatement();
        	ResultSet resultSet = statement.executeQuery(sql);
        	
        	while (resultSet.next()) {
        		int nftid = resultSet.getInt("nftid");
        		String unique_name = resultSet.getString("unique_name");
        		String description = resultSet.getString("description");
        		String nft_image = resultSet.getString("nft_image");
        		String owner = resultSet.getString("owner");
        		String creator = resultSet.getString("creator");
        		java.sql.Timestamp mint_time = resultSet.getTimestamp("mint_time");
        		
        		
        		nft nfts = new nft(nftid, unique_name, description, nft_image, owner, creator, mint_time);
        		listNft.add(nfts);
        	}  
        	  resultSet.close(); 
        	
        } catch(Exception e) {
        	throw new SQLException(e);
        }

         
        return listNft;
    }
    

    public List<nft> listBoughtNfts(String userName) throws SQLException {
        List<nft> listBoughtNfts = new ArrayList<nft>();        
        String sql = "SELECT * FROM NFT WHERE nftid in (SELECT nftid FROM Transaction WHERE (transType = 's' AND reciever = ?));";      
          
        
           try {
        	 connect_func();   
        	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	preparedStatement.setString(1, userName);
        	ResultSet resultSet = preparedStatement.executeQuery();
        	
        	while (resultSet.next()) {
        		int nftid = resultSet.getInt("nftid");
        		String unique_name = resultSet.getString("unique_name");
        		String description = resultSet.getString("description");
        		String nft_image = resultSet.getString("nft_image");
        		String owner = resultSet.getString("owner");
        		String creator = resultSet.getString("creator");
        		java.sql.Timestamp mint_time = resultSet.getTimestamp("mint_time");
        		
        		
        		nft nfts = new nft(nftid, unique_name, description, nft_image, owner, creator, mint_time);
        		listBoughtNfts.add(nfts);
        	}   resultSet.close();     
        } catch(Exception e) {
        	throw new SQLException(e);
        }

    
             
        return listBoughtNfts;
    }
    
    
  
    public List<nft> listSoldNfts(String userName) throws SQLException {
        List<nft> listSoldNfts = new ArrayList<nft>();        
        String sql = "SELECT * FROM NFT WHERE nftid in (SELECT nftid FROM Transaction WHERE (transType = 's' AND sender = ?));";      
          
        
           try {
        	 connect_func();   
        	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	preparedStatement.setString(1, userName);
        	ResultSet resultSet = preparedStatement.executeQuery();
        	
        	while (resultSet.next()) {
        		int nftid = resultSet.getInt("nftid");
        		String unique_name = resultSet.getString("unique_name");
        		String description = resultSet.getString("description");
        		String nft_image = resultSet.getString("nft_image");
        		String owner = resultSet.getString("owner");
        		String creator = resultSet.getString("creator");
        		java.sql.Timestamp mint_time = resultSet.getTimestamp("mint_time");
        		
        		
        		nft nfts = new nft(nftid, unique_name, description, nft_image, owner, creator, mint_time);
        		listSoldNfts.add(nfts);
        	}   resultSet.close();     
        } catch(Exception e) {
        	throw new SQLException(e);
        }

    
             
        return listSoldNfts;
    }
    

    public List<nft> listMintedNfts(String userName) throws SQLException {
        List<nft> listOwnedNfts = new ArrayList<nft>();        
        String sql = "SELECT * FROM NFT where creator = ?";      
          
        
           try {
        	 connect_func();   
        	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	preparedStatement.setString(1, userName);
        	ResultSet resultSet = preparedStatement.executeQuery();
        	
        	while (resultSet.next()) {
        		int nftid = resultSet.getInt("nftid");
        		String unique_name = resultSet.getString("unique_name");
        		String description = resultSet.getString("description");
        		String nft_image = resultSet.getString("nft_image");
        		String owner = resultSet.getString("owner");
        		String creator = resultSet.getString("creator");
        		java.sql.Timestamp mint_time = resultSet.getTimestamp("mint_time");
        		
        		
        		nft nfts = new nft(nftid, unique_name, description, nft_image, owner, creator, mint_time);
        		listOwnedNfts.add(nfts);
        	}   resultSet.close();     
        } catch(Exception e) {
        	throw new SQLException(e);
        }

    
             
        return listOwnedNfts;
    }
    
    public List<nft> listOwnedNfts(String userName) throws SQLException {
        List<nft> listOwnedNfts = new ArrayList<nft>();        
        String sql = "SELECT * FROM NFT where owner = ?";      
          
        
           try {
        	 connect_func();   
        	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        	preparedStatement.setString(1, userName);
        	ResultSet resultSet = preparedStatement.executeQuery();
        	
        	while (resultSet.next()) {
        		int nftid = resultSet.getInt("nftid");
        		String unique_name = resultSet.getString("unique_name");
        		String description = resultSet.getString("description");
        		String nft_image = resultSet.getString("nft_image");
        		String owner = resultSet.getString("owner");
        		String creator = resultSet.getString("creator");
        		java.sql.Timestamp mint_time = resultSet.getTimestamp("mint_time");
        		
        		
        		nft nfts = new nft(nftid, unique_name, description, nft_image, owner, creator, mint_time);
        		listOwnedNfts.add(nfts);
        	}   resultSet.close();     
        } catch(Exception e) {
        	throw new SQLException(e);
        }

    
             
        return listOwnedNfts;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(nft nfts) throws SQLException {
    	connect_func();         
		String sql = "insert into NFT(unique_name, description, nft_image, owner, creator, mint_time) values (?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, nfts.getUnique_name());
		preparedStatement.setString(2, nfts.getDescription());
		preparedStatement.setString(3, nfts.getNft_image());	
		preparedStatement.setString(4, nfts.getOwner());	
		preparedStatement.setString(5, nfts.getCreator());	
		preparedStatement.setObject(6, nfts.getMint_time());	
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(int nftid) throws SQLException {
        String sql = "DELETE FROM NFT WHERE nftid = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, nftid);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(nft nfts) throws SQLException {
        String sql = "update NFT set unique_name = ?, description = ?, nft_image= ?, owner = ?, creator = ?, mint_time = ? where nftid = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, nfts.getUnique_name());
		preparedStatement.setString(2, nfts.getDescription());
		preparedStatement.setString(3, nfts.getNft_image());	
		preparedStatement.setString(4, nfts.getOwner());	
		preparedStatement.setString(5, nfts.getCreator());	
		preparedStatement.setObject(6, nfts.getMint_time());	
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public boolean updateOwner(int nftid, String newOwner) throws SQLException {
        String sql = "update NFT set owner = ? where nftID = ?";
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, newOwner);
        preparedStatement.setInt(2, nftid);
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public nft getNft(int nftid) throws SQLException {
    	nft nft = null;
        String sql = "SELECT * FROM NFT WHERE nftid = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, nftid);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String unique_name = resultSet.getString("unique_name");
            String description = resultSet.getString("description");
            String nft_image = resultSet.getString("nft_image");
            String owner = resultSet.getString("owner");
            String creator = resultSet.getString("creator");
            java.sql.Timestamp mint_time = resultSet.getTimestamp("mint_time");
            nft = new nft(nftid, unique_name, description, nft_image, owner, creator, mint_time);
        }
         
        resultSet.close();
         
        return nft;
    }
    
    public boolean checknftid(int nftid) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM NFT WHERE nftid = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, nftid);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        // Explicit cast object to string
        Date currentTime = new Date();
        java.sql.Timestamp obj = new java.sql.Timestamp(currentTime.getTime());
        String mint_time = obj.toString();
        
        String[] INITIAL = {"use NFTdb; ",
        		"drop table if exists NFT; ",
		        ("CREATE TABLE if not exists NFT( " +
                    "nftid INTEGER NOT NULL AUTO_INCREMENT, " +
		            "unique_name VARCHAR(100) NOT NULL, " +
		            "description VARCHAR(100) NOT NULL, " +
		            "nft_image VARCHAR(200) NOT NULL, " +
		            "owner VARCHAR(100), " +
		            "creator VARCHAR(100), " +
		            "mint_time DATETIME, " +
		            "PRIMARY KEY (nftid), "+
		            "FOREIGN KEY (owner) REFERENCES User(userid), " +
		            "FOREIGN KEY (creator) REFERENCES User(userid) " +
		           "); ")
				};
String[] TUPLES = {("insert into NFT(unique_name, description, nft_image, owner, creator, mint_time)" +
		"values ('Mushroom Hat', 'Lots of homies', 'photovalhold', 'bendover@gmail.com', 'bendover@gmail.com', '" + mint_time + "')," +
    		 	"('Tinted Frostbite','Cooler than a cat','3959', 'alf@gmail.com', 'bendover@gmail.com', '" + mint_time + "')," +
    	 	 	"('Enraged Master','Entitled man is upset over small deal','1485', 'oke@gmail.com', 'bendover@gmail.com', '" + mint_time + "')," +
    		 	"('Gleam Steam','Shiny steam cakes air and catches attention','3780', 'bendover@gmail.com', 'bendover@gmail.com', '" + mint_time + "')," +
    		 	"('Corrupt Rose','The baddest of all roses','3921', 'bendover@gmail.com', 'bendover@gmail.com', '" + mint_time + "')," +
    		 	"('Fancy Unicorn','You know hes fly with his little hat','426', 'bendover@gmail.com', 'oke@gmail.com', '" + mint_time + "')," +
    			"('Murky Dragonfly','This guys been flying through the desert','444', 'bendover@gmail.com', 'alf@gmail.com', '" + mint_time + "')," +
    			"('Wealthy Stardust','Personified gold','3513', 'bendover@gmail.com', 'bendover@gmail.com', '" + mint_time + "')," +
    			"('Misty Bat','If batman worked at a water park','859', 'bendover@gmail.com', 'bendover@gmail.com', '" + mint_time + "'),"+
    			"('Good Oak','Bad City','2562', 'bendover@gmail.com', 'bendover@gmail.com', '" + mint_time + "');"
    			)};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);

    }
    
    
   
    
    
    
    
    
	
	

}
