public class nft {
		protected String nftid;
	    protected String unique_name;
	    protected String description;
	    protected String created_date;
	    protected String nft_image; 
	    //constructors
	    public nft() {
	    }
	 
	    public nft(String nftid) {
	        this.nftid = nftid;
	    }
	    
	    public nft(String nftid, String unique_name, String description, String created_date, String nft_image) {
	    	this(unique_name, description, created_date, nft_image);
	    	this.nftid = nftid;
	    }
	 
	    public nft(String unique_name, String description, String created_date, String nft_image) {
	    	this.unique_name = unique_name;
	    	this.description = description;
	        this.created_date = created_date;
	        this.nft_image = nft_image;
	    }
	    
	   //getter and setter methods
        public String getnftid() {
	        return nftid;
	    }
	    public void setnftid(String nftid) {
	        this.nftid = nftid;
	    }

	    public String getunique_name() {
	        return unique_name;
	    }
	    public void setunique_name(String unique_name) {
	        this.unique_name = unique_name;
	    }
	    
	    public String getdescription() {
	        return description;
	    }
	    public void setdescription(String description) {
	        this.description = description;
	    }
	    
	    public String getcreated_date() {
	        return created_date;
	    }
	    public void setcreated_date(String created_date) {
	        this.created_date = created_date;
	    }
	    public String getnft_image() {
	        return nft_image;
	    }
	    public void setnft_image(String nft_image) {
	        this.nft_image = nft_image;
	    }
	}