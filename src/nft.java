public class nft {
		protected int nftid;
	    protected String unique_name;
	    protected String description;
	    protected String nft_image; 
	    protected String owner;
	    protected String creator;
	    protected java.sql.Timestamp mint_time;
	    
	    //constructors
	    public nft() {
	    }
	 
	    public nft(int nftid) {
	        this.nftid = nftid;
	    }
	    
	    public nft(int nftid, String unique_name, String description, String nft_image, 
	    		String owner, String creator, java.sql.Timestamp mint_time) {
	    	this(unique_name, description, nft_image, owner, creator, mint_time);
	    this.nftid=nftid;
	    }
	 
	    public nft(String unique_name, String description, String nft_image, 
	    		String owner, String creator, java.sql.Timestamp mint_time) {
	    	this.unique_name = unique_name;
	    	this.description = description;
	        this.nft_image = nft_image;
	        this.owner = owner;
	        this.creator = creator;
	        this.mint_time = mint_time;
	    }
	    
	   //getter and setter methods
        public int getNftid() {
	        return nftid;
	    }
	    public void setNftid(int nftid) {
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
	    public String getNft_image() {
	        return nft_image;
	    }
	    public void setNft_image(String nft_image) {
	        this.nft_image = nft_image;
	    }
	    public String getOwner() {
	        return owner;
	    }
	    public void setOwner(String owner) {
	        this.owner = owner;
	    }
	    public String getCreator() {
	        return creator;
	    }
	    public void setCreator(String creator) {
	        this.creator = creator;
	    }
	    public java.sql.Timestamp getMint_time() {
	    	return mint_time;
	    }
	    public void setMint_time(java.sql.Timestamp mint_time) {
	    	this.mint_time = mint_time;
	    }
	    
	}