public class Transaction {
		protected String transid;
	    protected String sender;
	    protected String reciever;
	    protected String timestamp;
	    protected double price; 
	    protected char transtype;
	    
	    //constructors
	    public Transaction() {
	    }
	 
	    public Transaction(String transid) {
	        this.transid = transid;
	    }
	    
	    public Transaction(String transid, String sender, String reciever, String timestamp, double price, char transtype) {
	    	this(sender, reciever, timestamp, price, transtype);
	    	this.transid = transid;
	    }
	 
	    public Transaction(String sender, String reciever, String timestamp, double price, char transtype) {
	    	this.sender = sender;
	    	this.reciever = reciever;
	        this.timestamp = timestamp;
	        this.price = price;
	        this.transtype=transtype;
	    }
	    
	   //getter and setter methods
        public String getTransid() {
	        return transid;
	    }
	    public void setTransid(String transid) {
	        this.transid = transid;
	    }

	    public String getSender() {
	        return sender;
	    }
	    public void setSender(String sender) {
	        this.sender = sender;
	    }
	    
	    public String getReciever() {
	        return reciever;
	    }
	    public void setReciever(String reciever) {
	        this.reciever = reciever;
	    }
	    
	    public String getTimestamp() {
	        return timestamp;
	    }
	    public void setTimestamp(String timestamp) {
	        this.timestamp = timestamp;
	    }
	    public double getPrice() {
	        return price;
	    }
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    public char getTranstype() {
	        return transtype;
	    }
	    // possibility for issue in future
	    public void setTranstype(char transtype) {
	        this.transtype = transtype;
	    }
	    
	}