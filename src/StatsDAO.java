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
@WebServlet("/StatsDAO")
public class StatsDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public StatsDAO(){}
	
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
  
    public Stats getUserStats(String userid) {
    	Stats userStats = new Stats();
    	userStats.setUser(userid);
    	
    	String dbTotalBuys = "SELECT reciever, COUNT(*) AS Total From Transaction WHERE transType = 's' AND reciever = ?;";
    	
    	String dbTotalSells = "SELECT sender, COUNT(*) AS Total From Transaction " +
    			"WHERE transType = 's' AND sender = ?;";
    	
    	String dbTotalTransfers = "SELECT sender, COUNT(*) AS Total From Transaction " +
    			"WHERE transType = 't' AND sender = ?;";
    	
    	String dbOwnedNfts = "SELECT owner, COUNT(*) AS Total FROM NFT " +
    			"WHERE owner = ?;";
    	
    	System.out.println("Terminal: [DEBUGGING] Run SQL commands");
    	
    	System.out.println("Terminal: [DEBUGGING] This section before the Try block");
    	
    	try {    
    		System.out.println("Terminal: [DEBUGGING] Immediately inside try block");
    		preparedStatement = (PreparedStatement) connect.prepareStatement(dbTotalBuys);
    		System.out.println("Terminal: [DEBUGGING] preparedStatement = (PreparedStatement) connect.prepareStatement(dbTotalBuys);");
    		preparedStatement.setString(1, userid);
    		System.out.println("Terminal: [DEBUGGING] preparedStatement.setString(1, userid);");
    		ResultSet resultSet = preparedStatement.executeQuery();
    		System.out.println("Terminal: [DEBUGGING] ResultSet resultSet = preparedStatement.executeQuery();");

    		System.out.println("Terminal: [DEBUGGING] Prepared statement in try block");
    		
    		while (resultSet.next()) {
    			userStats.setTotalBuys(resultSet.getInt("Total"));
    		}
    		
    		resultSet.close();
    		
    	} catch (SQLException e) {
    		System.out.println(e.toString());
    	}
    	
//    	try {    		
//    		preparedStatement = (PreparedStatement) connect.prepareStatement(dbTotalSells);
//    		preparedStatement.setString(1, userid);
//    		ResultSet resultSet = preparedStatement.executeQuery();
//    		
//    		while (resultSet.next()) {
//    			userStats.setTotalSells(resultSet.getInt("Total"));
//    		}
//    		
//    		resultSet.close();
//    		
//    	} catch (SQLException e) {
//    		System.out.println(e.toString());
//    	}
//    	
//    	try {    		
//    		preparedStatement = (PreparedStatement) connect.prepareStatement(dbTotalTransfers);
//    		preparedStatement.setString(1, userid);
//    		ResultSet resultSet = preparedStatement.executeQuery();
//    		
//    		while (resultSet.next()) {
//    			userStats.setTotalTransfers(resultSet.getInt("Total"));
//    		}
//    		
//    		resultSet.close();
//    		
//    	} catch (SQLException e) {
//    		System.out.println(e.toString());
//    	}
//    	
//    	try {    		
//    		preparedStatement = (PreparedStatement) connect.prepareStatement(dbOwnedNfts);
//    		preparedStatement.setString(1, userid);
//    		ResultSet resultSet = preparedStatement.executeQuery();
//    		
//    		while (resultSet.next()) {
//    			userStats.setOwnedNfts(resultSet.getInt("Total"));
//    		}
//    		
//    		resultSet.close();
//    		
//    	} catch (SQLException e) {
//    		System.out.println(e.toString());
//    	}
    	
    	return userStats;
    }
     
}
