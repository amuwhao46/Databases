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
    	String sql = "SELECT * FROM Transaction WHERE nftid = ?";
    	List<Transaction> listAllTransactions = new ArrayList<Transaction>();
    	try {
			preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, nftid);
			ResultSet resultSet = preparedStatement.executeQuery(); 
			
			while (resultSet.next()) {
				String sender = resultSet.getString("sender");
				String reciever = resultSet.getString("reciever");
				String transType;
				
				if (resultSet.getString("transType").equals("s"))
					transType = "sale";
				else
					transType = "transfer";
				
				double price = resultSet.getDouble("price");
				Timestamp timeStamp = resultSet.getTimestamp("timeStamp");
				listAllTransactions.add(new Transaction(nftid, sender, reciever, timeStamp, price, transType));
			}
			
			resultSet.close();
			
    	} catch(SQLException e) {
    		e.toString();
    	}
    	
    	return listAllTransactions;
    }
    
    //=====================================================================================
    // get BigBuyers
    List<hotUser> getBigBuyers() throws SQLException {
    	String sql = "SELECT * FROM Transaction WHERE nftid = ?";
    	List<Transaction> listAllTransactions = new ArrayList<Transaction>();
    	try {
			preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, nftid);
			ResultSet resultSet = preparedStatement.executeQuery(); 
			
			while (resultSet.next()) {
				String sender = resultSet.getString("sender");
				String reciever = resultSet.getString("reciever");
				String transType;
				
				if (resultSet.getString("transType").equals("s"))
					transType = "sale";
				else
					transType = "transfer";
				
				double price = resultSet.getDouble("price");
				Timestamp timeStamp = resultSet.getTimestamp("timeStamp");
				listAllTransactions.add(new Transaction(nftid, sender, reciever, timeStamp, price, transType));
			}
			
			resultSet.close();
			
    	} catch(SQLException e) {
    		e.toString();
    	}
    	
    	return listAllTransactions;
    }
    
    
    //=====================================================================================
    // get big sellers
    public List<hotUser> getBigSellers() throws SQLException {
    	String sql = "SELECT * FROM Transaction WHERE nftid = ?";
    	List<Transaction> listAllTransactions = new ArrayList<Transaction>();
    	try {
			preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, nftid);
			ResultSet resultSet = preparedStatement.executeQuery(); 
			
			while (resultSet.next()) {
				String sender = resultSet.getString("sender");
				String reciever = resultSet.getString("reciever");
				String transType;
				
				if (resultSet.getString("transType").equals("s"))
					transType = "sale";
				else
					transType = "transfer";
				
				double price = resultSet.getDouble("price");
				Timestamp timeStamp = resultSet.getTimestamp("timeStamp");
				listAllTransactions.add(new Transaction(nftid, sender, reciever, timeStamp, price, transType));
			}
			
			resultSet.close();
			
    	} catch(SQLException e) {
    		e.toString();
    	}
    	
    	return listAllTransactions;
    }
	
    //=====================================================================================
    
 // get big buyers
    public List<hotUser> getGoodBuyers() throws SQLException {
    	String sql = "SELECT * FROM Transaction WHERE nftid = ?";
    	List<Transaction> listAllTransactions = new ArrayList<Transaction>();
    	try {
			preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, nftid);
			ResultSet resultSet = preparedStatement.executeQuery(); 
			
			while (resultSet.next()) {
				String sender = resultSet.getString("sender");
				String reciever = resultSet.getString("reciever");
				String transType;
				
				if (resultSet.getString("transType").equals("s"))
					transType = "sale";
				else
					transType = "transfer";
				
				double price = resultSet.getDouble("price");
				Timestamp timeStamp = resultSet.getTimestamp("timeStamp");
				listAllTransactions.add(new Transaction(nftid, sender, reciever, timeStamp, price, transType));
			}
			
			resultSet.close();
			
    	} catch(SQLException e) {
    		e.toString();
    	}
    	
    	return listAllTransactions;
    }
	
}
