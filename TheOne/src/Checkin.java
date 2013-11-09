
public class Checkin {
	private String name;
	private boolean hasPaid;
	public Checkin(String name){
		this.name = name;
		hasPaid = false;
	}
	public boolean pay(){
		hasPaid = true;
		return hasPaid;
	}
	public String getName() {
		return name;
	}
	public boolean isHasPaid() {
		return hasPaid;
	}
	
}
