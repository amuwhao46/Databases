public class Stats {
	String user;
	int totalBuys = 0;
	int totalSells = 0;
	int totalTransfers = 0;
	int ownedNfts = 0;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public int getTotalBuys() {
		return totalBuys;
	}
	
	public void setTotalBuys(int totalBuys) {
		this.totalBuys = totalBuys;
	}
	
	public int getTotalSells() {
		return totalSells;
	}
	
	public void setTotalSells(int totalSells) {
		this.totalSells = totalSells;
	}
	
	public int getTotalTransfers() {
		return totalTransfers;
	}
	
	public void setTotalTransfers(int totalTransfers) {
		this.totalTransfers = totalTransfers;
	}
	
	public int getOwnedNfts() {
		return ownedNfts;
	}
	
	public void setOwnedNfts(int ownedNfts) {
		this.ownedNfts = ownedNfts;
	}
}