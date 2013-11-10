package calendar;
import java.io.*;
import java.util.*;
import day.*;
import Dish.*;
import reservations.*;

public class comingWeeks {
	private Scanner reader;
	private ArrayList<EventDay> upcoming;
	private File storage;
	public comingWeeks(){
		storage = fileCheck();
		reader = new Scanner(storage);
		ArrayList<EventDay> = read();
	}
	private File fileCheck() throws IOException{
		File file = new File("filename.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		return file;
	}
	private ArrayList<EventDay> read(){
		ArrayList<EventDay> calendar = new ArrayList<EventDay>();
		
		
		
		
		return calendar;
	}
	public boolean add(EventDay next){
		
	}
}
