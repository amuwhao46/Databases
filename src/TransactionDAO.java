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
import java.util.Date;
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
    // to complete
    public List<Transaction> getNftTransactions(int nftid) throws SQLException {
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
    		System.out.println(e.toString() + ", Error threw in TransactionDAO at line:83");
    	}
    	
    	return listAllTransactions;
    }
    
    public void insert(Transaction trans) throws SQLException {
    	connect_func();         
		String sql = "insert into Transaction(nftid, sender, reciever, transType, price, timeStamp) values (?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setInt(1, trans.getNftid());
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
    	System.out.println("[CONSOLE LOG] Initializing Transaction Table");
        statement =  (Statement) connect.createStatement();
        Date currentTime = new Date();
        java.sql.Timestamp obj = new java.sql.Timestamp(currentTime.getTime());
        String timeStamp = obj.toString();
        
        String[] INITIAL = {"use NFTdb; ",
        		"drop table if exists Transaction; ",
		        ("CREATE TABLE if not exists Transaction( " +
                    "transid INTEGER NOT NULL AUTO_INCREMENT, " +
                    "nftid INTEGER NOT NULL, " +
		            "sender VARCHAR(100), " +
		            "reciever VARCHAR(100), " +
		            "transType VARCHAR(1), " +
		            "price DOUBLE, " +
		            "timeStamp DATETIME, " +
		            "PRIMARY KEY (transid), " +
		            "FOREIGN KEY (sender) REFERENCES User(userid)," +
		            "FOREIGN KEY (reciever) REFERENCES User(userid)," +
		            "FOREIGN KEY (nftid) REFERENCES NFT(nftid));" 
		            )
				};
        
        
        String[] TUPLES = {("insert into Transaction(nftid, sender, reciever, transType, price, timeStamp)"+
    			"values ('9','bendover@gmail.com','oke@gmail.com','t', '0', '" + timeStamp + "')," +
    					"('1','oke@gmail.com','bendover@gmail.com','s', '1', '" + timeStamp + "')," +
    					"('4','bendover@gmail.com','jessicacole@gmail.com','t', '0', '" + timeStamp + "')," +
    					"('5','bendover@gmail.com','erinmoore@gmail.com','s', '10', '" + timeStamp + "')," +
    					"('6','bendover@gmail.com','harryballs@gmail.com','s', '10', '" + timeStamp + "')," +
    					"('7','oke@gmail.com','alf@gmail.com','t', '0', '" + timeStamp + "')," +
    					"('1','oke@gmail.com','bendover@gmail.com','s', '1', '" + timeStamp + "')," +
    					"('1','bendover@gmail.com','oke@gmail.com','s', '1', '" + timeStamp + "')," +
    					"('1','oke@gmail.com','bendover@gmail.com','s', '10', '" + timeStamp + "')," +
    					"('3','bendover@gmail.com','harryballs@gmail.com','s', '10', '" + timeStamp + "')," +
    					"('3','bendover@gmail.com','test@gmail.com','t', '0', '" + timeStamp + "')," +
    					
    					"('1','bendover@gmail.com','alf@gmail.com','t', '0', '" + timeStamp + "');"
    				   )};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        
        
    }

}
