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
	    	this.nftid=nftid;
	    	this.start=start;
	    	this.end=end;
	    	this.price=price;
	    }
	 
	    public Listing( String listid,String owner, String nftid, Timestamp start,Timestamp end, double price) {
	    	this.owner = owner;
	    	this.nftid = nftid;
	        this.start = start;
	        this.end = end;
	        this.price = price;
	        this.listid=listid;
	    }
	    
	   //getter and setter methods
        public String getListid() {
	        return listid;
	    }
	    public void setListid(String listid) {
	        this.listid = listid;
	    }

	    public String getOwner() {
	        return owner;
	    }
	    public void setOwner(String owner) {
	        this.owner = owner;
	    }
	    
	    public String getNFTid() {
	        return nftid;
	    }
	    public void setNFTid(String nftid) {
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