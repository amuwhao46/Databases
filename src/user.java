public class user {
        protected String password;
		protected String userid;
	    protected String firstName;
	    protected String lastName;
	    protected String address_street_num;
	    protected String address_street;
	    protected String address_city;
	    protected String address_state;
	    protected String address_zip_code;
	    protected String birthday;
	    protected int init_bal;
	 
	    //constructors
	    public user() {
	    }
	 
	    public user(String userid) {
	        this.userid = userid;
	    }
	    
	    public user(String userid, String firstName, String lastName, String password, String birthday, String address_street_num, String address_street, String address_city, String address_state, String address_zip_code, int init_bal) {
	    	this(firstName, lastName, password, birthday, address_street_num, address_street, address_city, address_state, address_zip_code, init_bal);
	    	this.userid = userid;
	    }
	 
	    public user(String firstName, String lastName, String password, String birthday, String address_street_num, String address_street, String address_city, String address_state,String address_zip_code, int init_bal) {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.password = password;
	        this.birthday = birthday;
	        this.address_street_num = address_street_num;
	        this.address_street = address_street;
	        this.address_city= address_city;
	        this.address_state = address_state;
	        this.address_zip_code = address_zip_code;
	        this.init_bal = init_bal;
	    }
	    
	   //getter and setter methods
        public String getuserid() {
	        return userid;
	    }
	    public void setuserid(String userid) {
	        this.userid = userid;
	    }

	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	  
	    public String getBirthday() {
	    	return birthday;
	    }
	    public void setBirthday(String birthday) {
	    	this.birthday = birthday;
	    }
	    public String getAddress_street_num() {
	        return address_street_num;
	    }
	    public void setAddress_street_num(String address_street_num) {
	        this.address_street_num = address_street_num;
	    }
	    public String getAddress_street() {
	        return address_street;
	    }
	    public void setAddress_street(String address_street) {
	        this.address_street = address_street;
	    }
	    public String getAddress_city() {
	        return address_city;
	    }
	    public void setAddress_city(String address_city) {
	        this.address_city = address_city;
	    }
	    public String getAddress_state() {
	        return address_state;
	    }
	    public void setAddress_state(String address_state) {
	        this.address_state = address_state;
	    }
	    public String getAddress_zip_code() {
	        return address_zip_code;
	    }
	    public void setAddress_zip_code(String address_zip_code) {
	        this.address_zip_code = address_zip_code;
	    }
	
	    public int getinit_bal() {
	    	return init_bal;
	    }
	    public void setinit_bal(int init_bal) {
	    	this.init_bal = init_bal;
	    }
	}