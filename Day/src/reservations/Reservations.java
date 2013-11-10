package reservations;
//Makes reservations
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
	public String add(String name, boolean hasPaid){
		Checkin bigGuy = new Checkin(name, hasPaid);
		if(reserved.size()!=space){
			reserved.add(bigGuy);
			return "Your reservation was succesful";
		}
		else{
			waitlist.add(bigGuy);
			return "You have been put on the waitlist";
		}
	}
	public boolean paid(String name){
		Checkin temp = new Checkin(name, true);
		for(int i = 0; i<reserved.size(); i++){
			if(temp.getName() == (reserved.get(i).getName())){
				reserved.set(i, temp);
				return true;
			}
		}
		return false;
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
