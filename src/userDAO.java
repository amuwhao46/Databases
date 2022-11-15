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
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
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
    

    public List<user> listAllUsers() throws SQLException {
        List<user> listUser = new ArrayList<user>();        
        String sql = "SELECT * FROM User";      
        try {
        	connect_func();   
            statement = (Statement) connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        	while (resultSet.next()) {
                String userid = resultSet.getString("userid");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String password = resultSet.getString("password");
                String birthday = resultSet.getString("birthday");
                String address_street_num = resultSet.getString("address_street_num"); 
                String address_street = resultSet.getString("address_street"); 
                String address_city = resultSet.getString("address_city"); 
                String address_state = resultSet.getString("address_state"); 
                String address_zip_code = resultSet.getString("address_zip_code"); 
                int init_bal = resultSet.getInt("init_bal");

                 
                user users = new user(userid,firstName, lastName, password, birthday, address_street_num,  address_street,  address_city,  address_state,  address_zip_code, init_bal);
                listUser.add(users);
            }        
            resultSet.close();
        } catch (SQLException e) {
        	System.out.println(e.toString()+ ", that is the error");
        }
       
        return listUser;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(user users) throws SQLException {
    	connect_func();         
		String sql = "insert into User(userid, firstName, lastName, password, birthday,address_street_num, address_street,address_city,address_state,address_zip_code,init_bal) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, users.getUserid());
			preparedStatement.setString(2, users.getFirstName());
			preparedStatement.setString(3, users.getLastName());
			preparedStatement.setString(4, users.getPassword());
			preparedStatement.setString(5, users.getBirthday());
			preparedStatement.setString(6, users.getAddress_street_num());		
			preparedStatement.setString(7, users.getAddress_street());		
			preparedStatement.setString(8, users.getAddress_city());		
			preparedStatement.setString(9, users.getAddress_state());		
			preparedStatement.setString(10, users.getAddress_zip_code());		
			preparedStatement.setInt(11, users.getinit_bal());		
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String userid) throws SQLException {
        String sql = "DELETE FROM User WHERE userid = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, userid);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
        String sql = "update User set firstName=?, lastName =?,password = ?,birthday=?,address_street_num =?, address_street=?,address_city=?,address_state=?,address_zip_code=?, init_bal=? where userid = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getUserid());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getBirthday());
		preparedStatement.setString(6, users.getAddress_street_num());		
		preparedStatement.setString(7, users.getAddress_street());		
		preparedStatement.setString(8, users.getAddress_city());		
		preparedStatement.setString(9, users.getAddress_state());		
		preparedStatement.setString(10, users.getAddress_zip_code());		
		preparedStatement.setInt(11, users.getinit_bal());		
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public user getUser(String userid) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE userid = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, userid);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String birthday = resultSet.getString("birthday");
            String address_street_num = resultSet.getString("address_street_num"); 
            String address_street = resultSet.getString("address_street"); 
            String address_city = resultSet.getString("address_city"); 
            String address_state = resultSet.getString("address_state"); 
            String address_zip_code = resultSet.getString("address_zip_code"); 
            int init_bal = resultSet.getInt("init_bal");
            user = new user(userid, firstName, lastName, password, birthday, address_street_num,  address_street,  address_city,  address_state,  address_zip_code, init_bal);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public boolean checkuserid(String userid) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE userid = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, userid);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String userid, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("userid").equals(userid) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    
    public boolean increaseBal(String userid, double amount) throws SQLException {
        String sql = "update User set init_bal=? where userID = ?";
        user currentUser = getUser(userid);
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setDouble(1, currentUser.getinit_bal() + amount);
        preparedStatement.setString(2, userid);
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public boolean decreaseBal(String userid, double amount) throws SQLException {
        String sql = "update User set init_bal=? where userID = ?";
        user currentUser = getUser(userid);
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setDouble(1, currentUser.getinit_bal() - amount);
        preparedStatement.setString(2, userid);
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"drop database if exists NFTdb; ",
		        "create database NFTdb; ",
		        "use NFTdb; ",
		        "drop table if exists User; ",
		        ("CREATE TABLE if not exists User( " +
                    "userid VARCHAR(50) NOT NULL, " +
		            "firstName VARCHAR(10) NOT NULL, " +
		            "lastName VARCHAR(10) NOT NULL, " +
		            "password VARCHAR(10) NOT NULL, " +
		            "birthday DATE NOT NULL, " +
		            "address_street_num VARCHAR(4) , " + 
		            "address_street VARCHAR(26) , " + 
		            "address_city VARCHAR(20)," + 
		            "address_state VARCHAR(2)," + 
		            "address_zip_code VARCHAR(5)," + 
		            "init_bal DECIMAL(13,2) DEFAULT 100," + 
		            "PRIMARY KEY (userid) "+"); ")
				};
String[] TUPLES = {("insert into User(userid, firstName, lastName, password, birthday, address_street_num, address_street, address_city, address_state, address_zip_code, init_bal)" +
		"values ('root', 'default', 'default', 'pass1234', '0001-01-01', '0000', 'default', 'default', 'DE', '00000', '100')," +
    		 	"('jondoe@gmail.com', 'Jon', 'Doe', 'tVp7@MR59q', '2001-01-31', '3959', 'Pickens Way', 'Whitewright', 'TX', '75491', '100')," +
    	 	 	"('jackenoff@gmail.com', 'Jack', 'Enoff', '99C2*iXAn3', '2001-04-12', '1485', 'Tator Patch Road', 'Chicago', 'IL', '60605', '100')," +
    		 	"('bendover@gmail.com', 'Ben', 'Dover', '77@Z!G54pa', '2000-09-12', '3780', 'Green Acres Road', 'Greenville', 'NC', '27834', '100')," +
    		 	"('erinmoore@gmail.com', 'Erin', 'Moore', 'f5eO#24Z4@', '2002-04-18', '3921', 'Junior Avenue', 'Atlanta', 'GA', '30309', '100')," +
    		 	"('mikehunt@gmail.com', 'Mike', 'Hunt', 'RxS4k0$u30', '1999-09-15', '426', 'Farnum Road', 'New York City', 'NY', '10004', '100')," +
    			"('jessicacole@gmail.com', 'Jessica', 'Cole', 'G@078D*k3x', '2001-04-10', '444', 'Five Points', 'Easton', 'MD', '21601', '100')," +
    			"('meganfoxx@gmail.com', 'Megan', 'Foxx', '%nXtVh264c', '2000-08-14', '3513', 'Palmer Road', 'Worthington', 'OH', '43085', '100')," +
    			"('harryballs@gmail.com', 'Harry', 'Balls', '*x^Z9%me40', '2000-08-17', '859', 'Bassel Street', 'Metairie', 'LA', '70001', '100'),"+
    			"('test@gmail.com', 'Test', 'Testing', 'Test1234', '2000-08-17', '859', 'Bassel Street', 'Metairie', 'LA', '70001', '100'),"+
    			"('marymean@gmail.com', 'Mary', 'Mean', 'd^F3!s39$%', '1998-09-26', '2562', 'Gateway Avenue', 'Bakersfield', 'CA', '93301', '100');"
    			)};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
        for (int i = 0; i < TUPLES.length; i++)	
        	statement.execute(TUPLES[i]);
        disconnect();
    }
    
    
   
    
    
    
    
    
	
	

}
