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
        public String getNftid() {
	        return nftid;
	    }
	    public void setNftid(String nftid) {
	        this.nftid = nftid;
	    }

	    public String getUnique_name() {
	        return unique_name;
	    }
	    public void setUnique_name(String unique_name) {
	        this.unique_name = unique_name;
	    }
	    
	    public String getDescription() {
	        return description;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    
	    public String getCreated_date() {
	        return created_date;
	    }
	    public void setCreated_date(String created_date) {
	        this.created_date = created_date;
	    }
	    public String getNft_image() {
	        return nft_image;
	    }
	    public void setNft_image(String nft_image) {
	        this.nft_image = nft_image;
	    }
	}