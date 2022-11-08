public class Transaction {
		protected String transid;
	    protected String sender;
	    protected String reciever;
	    protected String timestamp;
	    protected String price; 
	    
	    //constructors
	    public Transaction() {
	    }
	 
	    public Transaction(String transid) {
	        this.transid = transid;
	    }
	    
	    public Transaction(String transid, String sender, String reciever, String timestamp, String price) {
	    	this(sender, reciever, timestamp, price);
	    	this.transid = transid;
	    }
	 
	    public Transaction(String sender, String reciever, String timestamp, String price) {
	    	this.sender = sender;
	    	this.reciever = reciever;
	        this.timestamp = timestamp;
	        this.price = price;
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
	    public String getPrice() {
	        return price;
	    }
	    public void setPrice(String price) {
	        this.price = price;
	    }
	}