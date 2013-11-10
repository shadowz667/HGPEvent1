package day;
import java.util.Scanner;
import reservations.*;
import Dish.*;

import java.util.ArrayList;
public class EventDay {
	private Reservations theGoodLittleBoys;
	private ArrayList<Dish> theStuff;
	private String ohCaptainMyCaptain;
	public EventDay(String leader){
		ohCaptainMyCaptain = leader;
		theStuff = dishGen();
		theGoodLittleBoys = reservationControl();
		reserve(leader, true);
	}

	private ArrayList<Dish> dishGen() {
		ArrayList<Dish> temp = new ArrayList<Dish>();
		Scanner reader = new Scanner(System.in);
		boolean control;
		control = true;
		System.out.println("Please enter your main dish");
		while(control){
			temp.add(new Dish());
			control = another();
		}
		return temp;
	}
	
	private Reservations reservationControl() {
		Dish main = theStuff.get(0);
		int scale = main.getNumberServed();
		scale *=3;
		//this can be changed if there is a specific limit
		if(scale>20)
			return new Reservations(20);
		return new Reservations(scale);
	}
	private boolean another(){
		String response;
		Scanner reader = new Scanner(System.in);
		System.out.println("Add a side?");
		response = reader.nextLine();
		
		if(response.equalsIgnoreCase("No")){
			return false;
		} 
		return true;
	}
	public boolean reserve(String name, boolean hasPaid){
		System.out.println(theGoodLittleBoys.add(name, hasPaid));
		return true;
	}
	public void displayShoppingList(){
		for(Dish stuff: theStuff){
			stuff.shoppingList();
		}
	}

	public String getOhCaptainMyCaptain() {
		return ohCaptainMyCaptain;
	}

	public void setOhCaptainMyCaptain(String ohCaptainMyCaptain) {
		this.ohCaptainMyCaptain = ohCaptainMyCaptain;
	}

	public Reservations getTheGoodLittleBoys() {
		return theGoodLittleBoys;
	}

	public ArrayList<Dish> getTheStuff() {
		return theStuff;
	}
}
