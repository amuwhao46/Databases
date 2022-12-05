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
	int resultNum;
	
	
	public hotUser(String hotUserResult, int resultNum){
				
		this.hotUserResult= hotUserResult;
		this.resultNum=resultNum;
		
	}
	
	
public void setHotUser(String hotUserResult) {
		
		this.hotUserResult=hotUserResult;
		
		
	}
	
	
	
	public String getHotUser() {
		
		return hotUserResult;
		
		
	}
	
	
public void setResultNum(int resultNum) {
		
		this.resultNum=resultNum;
		
		
	}
	
public int getResultNum() {
	
	return resultNum;
	
	
	}
	
	
}
