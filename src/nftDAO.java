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
    

    public List<nft> listAllNfts() throws SQLException {
        List<nft> listNft = new ArrayList<nft>();        
        String sql = "SELECT * FROM NFT";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        try {
        	while (resultSet.next()) {
        		String nftid = resultSet.getString("nftid");
        		String unique_name = resultSet.getString("unique_name");
        		String description = resultSet.getString("description");
        		String created_date = resultSet.getString("created_date");
        		String nft_image = resultSet.getString("nft_image");
        		String owner = resultSet.getString("owner");
        		String creator = resultSet.getString("creator");
        		
        		
        		nft nfts = new nft(nftid, unique_name, description, created_date, nft_image, owner, creator);
        		listNft.add(nfts);
        	}        
        } catch(Exception e) {
        	throw new SQLException(e);
        }

        resultSet.close();
        disconnect();        
        return listNft;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(nft nfts) throws SQLException {
    	connect_func();         
		String sql = "insert into NFT(nftid, unique_name, description, created_date, nft_image, owner, creator) values (?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, nfts.getNftid());
		preparedStatement.setString(2, nfts.getUnique_name());
		preparedStatement.setString(3, nfts.getDescription());
		preparedStatement.setString(4, nfts.getCreated_date());
		preparedStatement.setString(5, nfts.getNft_image());	
		preparedStatement.setString(6, nfts.getOwner());	
		preparedStatement.setString(7, nfts.getCreator());	
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
     
    public boolean update(nft nfts) throws SQLException {
        String sql = "update NFT set unique_name = ?, description = ?, created_date = ?, nft_image= ?, owner = ?, creator = ? where nftid = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, nfts.getNftid());
		preparedStatement.setString(2, nfts.getUnique_name());
		preparedStatement.setString(3, nfts.getDescription());
		preparedStatement.setString(4, nfts.getCreated_date());
		preparedStatement.setString(5, nfts.getNft_image());	
		preparedStatement.setString(6, nfts.getOwner());	
		preparedStatement.setString(7, nfts.getCreator());	
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public nft getNft(String nftid) throws SQLException {
    	nft nft = null;
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
            String owner = resultSet.getString("owner");
            String creator = resultSet.getString("creator");
            nft = new nft(nftid, unique_name, description, created_date, nft_image, owner, creator);
        }
         
        resultSet.close();
        statement.close();
         
        return nft;
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
    
    // Removed the check for password function. Not applicable in this DAO -Oke
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"use NFTdb; ",
        		"drop table if exists NFT; ",
		        ("CREATE TABLE if not exists NFT( " +
                    "nftid VARCHAR(50) NOT NULL, " +
		            "unique_name VARCHAR(50) NOT NULL, " +
		            "description VARCHAR(100) NOT NULL, " +
		            "created_date VARCHAR(11) NOT NULL, " +
		            "nft_image VARCHAR(15) NOT NULL, " +
		            "owner VARCHAR(50) NOT NULL, " +
		            "creator VARCHAR(50) NOT NULL, " +
		            "PRIMARY KEY (nftid) "+"); ")
				};
String[] TUPLES = {("insert into NFT(nftid, unique_name, description, created_date, nft_image, owner, creator)" +
		"values ('O6OMWOTYPX', 'Mushroom Hat', 'Lots of homies','00-00-0000', 'photovalhold', 'To Can', 'Lolli')," +
    		 	"('CB0379JEUX','Tinted Frostbite','Cooler than a cat','01-31-2001','3959', 'Xharles', 'Eric')," +
    	 	 	"('T6IC4F9H02','Enraged Master','Entitled man is upset over small deal', '04-12-2001','1485', 'Pam', 'Beasley')," +
    		 	"('1XHOZKT9DM','Gleam Steam','Shiny steam cakes air and catches attention','09-12-2000','3780', 'Jared', 'Sombra')," +
    		 	"('8SE9Z9IX70','Corrupt Rose','The baddest of all roses','04-18-2002','3921', 'Mike', 'Ilitch')," +
    		 	"('HIU0X084SW','Fancy Unicorn','You know hes fly with his little hat','09-15-1999','426', 'Steve', 'Poser')," +
    			"('UY9WX9K7QF','Murky Dragonfly','This guys been flying through the desert','04-10-2001','444', 'Carrel', 'Williams')," +
    			"('PD6UEFDP9A','Wealthy Stardust','Personified gold','08-14-2000','3513', 'MAster', 'Splinter')," +
    			"('FRHIKC1D59','Misty Bat','If batman worked at a water park','08-17-2000','859', 'Noah', 'Boat'),"+
    			"('KTDDWZS4WR','Good Oak','Bad City','09-26-1998','2562', 'No', 'Ideas');"
    			)};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
