import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.PreparedStatement;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private userDAO userDAO = new userDAO();
	    private nftDAO nftDAO = new nftDAO();
	    private String currentUser;
	    private HttpSession session=null;
	    
	    public ControlServlet()
	    {
	    	
	    }
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	nftDAO = new nftDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
	    	// Routes
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/initialize":
        		userDAO.init();
        		nftDAO.init();
        		System.out.println("Database successfully initialized!");
        		rootPage(request,response,"");
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	case "/logout":
        		logout(request,response);
        		break;
        	 case "/list": 
                 System.out.println("The action is: list");
                 listUser(request, response);           	
                 break;
        	 case "/listNft": 
                 System.out.println("The action is: list");
                 listNft(request, response);           	
                 break;
         	case "/mint":
        		mint(request,response);
        		break;
         	case "/search":
         		listNft(request,response);
         		break;
         	case "/createListing":
         		System.out.println("The action is: Create Listing");
         		createListing(request,response);
         		break;
         	case "/transfer":
         		System.out.println("The action is: transfer");
         		createListing(request,response);
         		break;
         		
	    	}   
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
	    
	    private void createListing(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("Listings.jsp");
	    	int nftid= Integer.parseInt(request.getParameter("nftid"));
	    	int lengthoftime= Integer.parseInt(request.getParameter("lengthoftime"));
	    	double price= Double.parseDouble(request.getParameter("price"));
	    	ListingDAO listingDAO = new ListingDAO();
	    	
	    	if (price<=0) {
	    		request.setAttribute("userNFT", nftDAO.listOwnedNfts(currentUser));
	    		request.setAttribute("error!", "Price of lissting myst be greater than 0! ");
	    		dispatcher.forward(request, response);
	    	}
	    	else if(listingDAO.getListedNft(nftid)!=null) {
	    		request.setAttribute("userNFT", nftDAO.listOwnedNfts(currentUser));
	    		request.setAttribute("error!", "A listing for this NFT already exists! ");
	    		dispatcher.forward(request, response);
	    	}
	    	else {
	    		Calendar cvar= Calendar.getInstance();
	    		cvar.add(Calendar.MONTH, lengthoftime);
	    		Date start= new Date();
	    		Date end=cvar.getTime();
	    		Timestamp startTime=new Timestamp(start.getTime());
	    		Timestamp endTime= new Timestamp(end.getTime());
	    		
	    		listingDAO.insert(new Listing(currentUser,nftid,startTime, endTime, price));
	    		request.setAttribute("userNFT", nftDAO.listOwnedNfts(currentUser));
	    		request.setAttribute("success!", "Listing has been Created!");
	    		dispatcher = request.getRequestDispatcher("Listings.jsp"); 
	    		dispatcher.forward(request, response);
	    		
	    	}
	    }
	    
	    
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    
	    private void listNft(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	ListingDAO listingDAO = new ListingDAO();
	        System.out.println("listNFT started: 00000000000000000000000000000000000");

	     
	        List<nft> listNft = nftDAO.listAllNfts();
	        List<Listing> allListings = listingDAO.allListedNfts();
	        request.setAttribute("listNft", listNft);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("nftList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listNFTs finished: 111111111111111111111111111111111111");
	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
			request.setAttribute("listNft", nftDAO.listAllNfts());
	    	request.getRequestDispatcher("rootView.jsp").forward(request, response); //Root view to see how c:forEach is connected
	    }
	    
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String userid = request.getParameter("userid");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (userid.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("userid", userid);
				 rootPage(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(userid, password)) 
	    	 {
	    		 /*
	    		  * To show the name of the currently logged in user in activitypage.jsp
	    		  * */
			 	 user user = userDAO.getUser(userid);
			 	 
			 	 currentUser = userid;
			 	 session = request.getSession();
			 	 session.setAttribute("currentUser", user.getFirstName());
				 System.out.println("Login Successful! Redirecting");
				 request.setAttribute("listUser", userDAO.listAllUsers());
				 request.getRequestDispatcher("activitypage.jsp").forward(request, response); // Activity page here!!!!!!!!!
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String userid = request.getParameter("userid");
	   	 	String firstName = request.getParameter("firstName");
	   	 	String lastName = request.getParameter("lastName");
	   	 	String password = request.getParameter("password");
	   	 	String birthday = request.getParameter("birthday");
	   	 	String address_street_num = request.getParameter("address_street_num"); 
	   	 	String address_street = request.getParameter("address_street"); 
	   	 	String address_city = request.getParameter("address_city"); 
	   	 	String address_state = request.getParameter("address_state"); 
	   	 	String address_zip_code = request.getParameter("address_zip_code"); 
	   	 	
	   	 	String confirm = request.getParameter("confirmation");
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkuserid(userid)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(userid,firstName, lastName, password, birthday, address_street_num,  address_street,  address_city,  address_state,  address_zip_code, 100);
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }  
	    
	    private void mint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {	   	 	
	    	String unique_name = request.getParameter("unique_name");
	   	 	String description = request.getParameter("description");
	   	 	String nft_image = request.getParameter("nft_image");
	   	 	String owner = (String)session.getAttribute("userid");
	   	 	String creator = (String)session.getAttribute("userid");
	    	java.util.Date currentDate = new java.util.Date();
	    	Timestamp mint_time = new Timestamp(currentDate.getTime());
	    	
	   	 	nft nfts = new nft(unique_name, description, nft_image, owner, creator, mint_time);
	   	 	nftDAO.insert(nfts);
	   	 	
		    System.out.println("Saved to NFT database");
		   	response.sendRedirect("activitypage.jsp");
	    } 
	    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}	
}
