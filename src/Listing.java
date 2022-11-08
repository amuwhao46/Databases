import java.sql.Timestamp;

public class Listing {
		protected String listid;
	    protected String owner;
	    protected String nftid;
	    protected java.sql.Timestamp start;
	    protected java.sql.Timestamp end;
	    protected double price; 
	    protected char transtype;
	    
	    //constructors
	    public Listing() {
	    }
	 
	    public Listing(String listid) {
	        this.listid = listid;
	    }
	    
	    public Listing(String owner, String nftid, Timestamp start,Timestamp end, double price) {
	    	this.owner=owner;
	    	this.start=start;
	    	this.nftid=nftid;
	    	this.start=start;
	    	this.end=end;
	    	this.price=price;
	    	
	    
	    }
	 
	    public Listing(String owner, String nftid, Timestamp start,Timestamp end, double price, String listid) {
	    	this.owner = owner;
	    	this.nftid = nftid;
	        this.start = start;
	        this.end = end;
	        this.price = price;
	        this.transtype=transtype;
	        this.listid=listid;
	    }
	    
	   //getter and setter methods
        public String getTransid() {
	        return listid;
	    }
	    public void setTransid(String listid) {
	        this.listid = listid;
	    }

	    public String getSender() {
	        return owner;
	    }
	    public void setSender(String owner) {
	        this.owner = owner;
	    }
	    
	    public String getReciever() {
	        return nftid;
	    }
	    public void setReciever(String nftid) {
	        this.nftid = nftid;
	    }
	    
	    public java.sql.Timestamp getStart() {
	        return start;
	    }
	    public void setStart(java.sql.Timestamp start) {
	        this.start = start;
	    }
	    
	    public java.sql.Timestamp getEnd() {
	        return end;
	    }
	    public void setTimestamp(java.sql.Timestamp end) {
	        this.end = end;
	    }
	    
	    public double getPrice() {
	        return price;
	    }
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    
	}