import java.util.ArrayList;
public class Reservations {
	private ArrayList<Checkin> reserved;
	private ArrayList<Checkin> waitlist;
	private int space;
	public Reservations(int space){
		this.space = space;
		reserved = new ArrayList<Checkin>(space);
		waitlist = new ArrayList<Checkin>();
	}
	public String add(Checkin name){
		if(reserved.size()!=space){
			reserved.add(name);
			return "Your reservation was succesful";
		}
		else{
			waitlist.add(name);
			return "You have been put on the waitlist";
		}
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}
	public ArrayList<Checkin> getReserved() {
		return reserved;
	}
	public ArrayList<Checkin> getWaitlist() {
		return waitlist;
	}
	
}
