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
import java.sql.Timestamp;
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
@WebServlet("/hotUserDAO")
public class hotUserDAO {

	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private nftDAO conversion=null;
	public hotUserDAO(){
		
		
		
	}
	
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

    
    
    
    
    
    //=====================================================================================
    // get big creators
    public List<hotUser> getBigCreators() throws SQLException {
    	String sql = "SELECT * from UserMinted WHERE count = (SELECT MAX(count) FROM UserMinted);";

        List<hotUser> bigCreators = new ArrayList<hotUser>();
    		try {
            statement = (Statement) connect.createStatement();
            statement.execute("drop view if exists UserMinted;");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            statement.execute("CREATE VIEW UserMinted(creator, count)\n"
                    + "AS (\n"
                    + "SELECT creator, COUNT(*) as Num\n"
                    + "FROM NFT\n"
                    + "GROUP BY creator);");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String hotUserResult = resultSet.getString("creator");
                int resultItem = resultSet.getInt("count");

                bigCreators.add(new hotUser(hotUserResult, resultItem));
            }

            resultSet.close();
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
            return bigCreators;
    }
    
    //=====================================================================================
    // get BigBuyers
    List<hotUser> getBigBuyers() throws SQLException {
    	String sql = "SELECT * from PurchasedAmt;\n"
                + "WHERE count = (SELECT MAX(count) FROM PurchasedAmt);";
    	List<hotUser> getBigBuyers = new ArrayList<hotUser>();
    	try {
            statement = (Statement) connect.createStatement();
            statement.execute("drop view if exists PurchaseAmt;");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            statement.execute("CREATE VIEW PurchaseAmt(sender, count)\n"
                    + "AS (\n"
                    + "SELECT reciever, COUNT(*) as Num\n"
                    + "FROM Transaction\n"
                    + "WHERE transType = 's'\n"
                    + "GROUP BY reciever);");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String hotUserResult = resultSet.getString("sender");
                int resultItem = resultSet.getInt("count");

                getBigBuyers.add(new hotUser(hotUserResult, resultItem));
            }

            resultSet.close();
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
    	
    	return getBigBuyers;
    }
    
    
    //=====================================================================================
    // get big sellers
    public List<hotUser> getBigSellers() throws SQLException {
    	String sql = "SELECT * FROM NftSeller WHERE count=(SELECT MAX(count)FROM NftSeller)";
    	List<hotUser> getBigSellers = new ArrayList<hotUser>();
    	try {
            statement = (Statement) connect.createStatement();
            statement.execute("drop view if exists NftSeller;");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            statement.execute("CREATE VIEW NftSeller(sender, count)\n"
                    + "AS (\n"
                    + "SELECT sender, COUNT(*) as Num\n"
                    + "FROM Transaction\n"
                    + "WHERE transType = 's'\n"
                    + "GROUP BY sender);");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String hotUserResult = resultSet.getString("sender");
                int resultItem = resultSet.getInt("count");

                getBigSellers.add(new hotUser(hotUserResult, resultItem));
            }

            resultSet.close();
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
    	
    	return getBigSellers;
    }
	
    //=====================================================================================
    
 // get good buyers
    public List<hotUser> getGoodBuyers() throws SQLException {
    	String sql = "SELECT * FROM PurchasedAmt WHERE count >=3";
    	List<hotUser> getGoodBuyers  = new ArrayList<hotUser>();
    	try {
            statement = (Statement) connect.createStatement();
            statement.execute("drop view if exists PurchasedAmt;");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            statement.execute("CREATE VIEW PurchasedAmt(reciever, count)\n"
                    + "AS (\n"
                    + "SELECT reciever, COUNT(*) as Num\n"
                    + "FROM Transaction\n"
                    + "WHERE transType = 's'\n"
                    + "GROUP BY reciever);");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String hotUserResult = resultSet.getString("reciever");
                int resultItem = resultSet.getInt("count");

                getGoodBuyers.add(new hotUser(hotUserResult, resultItem));
            }

            resultSet.close();
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
    	
    	return getGoodBuyers;
    }
	
    //=====================================================================================
    
    // get hotNFTs
       public List<hotUser> getHotNFTs() throws SQLException {
       	String sql = "SELECT * FROM OwnedNfts WHERE count = (SELECT MAX(count) FROM OwnedNfts)";
       	List<hotUser> getHotNFTs  = new ArrayList<hotUser>();
       	try {
            statement = (Statement) connect.createStatement();
            statement.execute("drop view if exists OwnedNfts;");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            statement.execute("CREATE VIEW OwnedNfts(nftid, count)\n"
                    + "AS (\n"
                    + "SELECT creator, COUNT(*) as Num\n"
                    + "FROM (SELECT DISTINCT reciever,nftid FROM Transaction)as T\n"
                    + "GROUP BY nftid);");
        } catch(SQLException e) {
            System.out.println(e.toString());
        }

    		try {
            statement = (Statement) connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int result = resultSet.getInt("nftid");
                int resultItem = resultSet.getInt("count");

                String hotUserResult= conversion.getNft(result).getUnique_name();
                
                getHotNFTs.add(new hotUser(hotUserResult, resultItem));
            }

            resultSet.close();
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
       	
       	return getHotNFTs;
       }
    
    
    
}
