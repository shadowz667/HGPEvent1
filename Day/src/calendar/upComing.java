package calendar;
import java.util.ArrayList;
import day.*;
import java.io.Serializable;

import Dish.Input;
public class upComing implements Serializable{
	/**
	 * random generated
	 */
	private static final long serialVersionUID = 6656263667918851453L;
	private ArrayList<EventDay> upcome;
	public upComing(){
		upcome = generation();
	}
	private ArrayList<EventDay> generation(){
		ArrayList<EventDay> temp = new ArrayList<EventDay>();
		Input output = new Input();
		boolean control = true;
		while(control){
			String s = output.getString("Who will lead this meal: ");
			String d = output.getString("When will we have this meal (ddmmyyyy format): ");
			temp.add(new EventDay(s,d));
			control = another();
		}
		return temp;
	}
	
	
	private boolean another() {
		Input take = new Input();
		boolean isYes = take.getBoolean("Another?");
		return isYes;
	}
	public ArrayList<EventDay> getUpcome() {
		return upcome;
	}
}

