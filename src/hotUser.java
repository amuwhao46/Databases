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

public class hotUser {
	
	String hotUserResult;
	int resultItem;
	
	
	public hotUser(String hotUserResult, int resultItem){
				
		this.hotUserResult = hotUserResult;
		this.resultItem = resultItem;
		
	}
	
	
public void setHotUserResult(String hotUserResult) {
		
		this.hotUserResult = hotUserResult;
		
	}
	
	
	
	public String getHotUserResult() {
		
		return hotUserResult;
		
		
	}
	
	
public void setResultItem(int resultem) {
		
		this.resultItem = resultItem;
		
		
	}
	
public int getResultItem() {
	
	return resultItem;
	
	}
	
}
