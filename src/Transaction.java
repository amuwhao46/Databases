import java.sql.Timestamp;

public class Transaction {
		protected int transid;
		protected int nftid;
	    protected String sender;
	    protected String reciever;
	    protected double price; 
	    protected String transType;
	    protected java.sql.Timestamp timeStamp;
	    
	    //constructors
	    public Transaction() {
	    }
	 
	    public Transaction(int transid) {
	        this.transid = transid;
	    }
	    
	    public Transaction(int transid, int nftid, String sender, String reciever, java.sql.Timestamp timeStamp, double price, String transType) {
	    	this(nftid, sender, reciever, timeStamp, price, transType);
	    	this.transid = transid;
	    }
	 
	    public Transaction(int nftid, String sender, String reciever, java.sql.Timestamp timeStamp, double price, String transType) {
	    	this.nftid = nftid;
	    	this.sender = sender;
	    	this.reciever = reciever;
	        this.timeStamp = timeStamp;
	        this.price = price;
	        this.transType = transType;
	    }
	    
	   //getter and setter methods
        public int getTransid() {
	        return transid;
	    }
	    public void setTransid(int transid) {
	        this.transid = transid;
	    }
	    
	    public int getNftid() {
	    	return nftid;
	    }
	    public void setNftid(int nftid) {
	    	this.nftid = nftid;
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
	    
	    public java.sql.Timestamp getTimeStamp() {
	        return timeStamp;
	    }
	    public void setTimeStamp(java.sql.Timestamp timeStamp) {
	        this.timeStamp = timeStamp;
	    }
	    public double getPrice() {
	        return price;
	    }
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    public String getTransType() {
	        return transType;
	    }
	    // possibility for issue in future
	    public void setTransType(String transType) {
	        this.transType = transType;
	    }
	    
	}