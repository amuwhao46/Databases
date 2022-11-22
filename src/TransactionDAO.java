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
@WebServlet("/TransactionDAO")
public class TransactionDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public TransactionDAO(){}
	
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
    
    public List<Transaction> getNftTransactions(int nftid) throws SQLException {
    	String sql = "SELECT * FROM Transaction WHERE nftID = ?";
    	List<Transaction> listAllTransactions = new ArrayList<Transaction>();
    	try {
			preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, nftid);
			ResultSet resultSet = preparedStatement.executeQuery();    		
    	} catch(SQLException e) {
    		e.toString();
    	}
    	
    	return listAllTransactions;
    }
    
    public void insert(Transaction trans) throws SQLException {
    	connect_func();         
		String sql = "insert into Transaction(transid, reciever, sender, transType, price, timeStamp) values (?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setInt(1, trans.getTransid());
		preparedStatement.setString(2, trans.getReciever());
		preparedStatement.setString(3, trans.getSender());
		
		String transType = trans.getTransType();
		
		if (transType.equals("sale")) {
			preparedStatement.setString(4, "s");
		} else {
			preparedStatement.setString(4, "t");
		}
		
		preparedStatement.setDouble(5, trans.getPrice());
		preparedStatement.setObject(6, trans.getTimeStamp());
		
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"use NFTdb; ",
        		"drop table if exists Transaction; ",
		        ("CREATE TABLE if not exists Transaction( " +
                    "transid int NOT NULL AUTO_INCREMENT, " +
		            "sender VARCHAR(100), " +
		            "reciever VARCHAR(100), " +
		            "transtype VARCHAR(1), " +
		            "price DOUBLE, " +
		            "timeStamp DATETIME, " +
		            "FOREIGN KEY (sender) REFERENCES User(userid)," +
		            "FOREIGN KEY (reciever) REFERENCES User(userid)," +
		            "PRIMARY KEY (transid) "+"); ")
				};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
    }

}
