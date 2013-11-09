import java.util.ArrayList;
import java.util.Scanner;
public class Dish {
	private ArrayList<Ingredient> myIngredients;
//	private int myNumServing;
	
	public Dish(){
		//myNumServing = numToServe;
		myIngredients = addIngredients();
	}
	
	public boolean displayProcedure(int numToServe){
		int numSteps = myIngredients.size();
		double howMuchOf;
		String name, units;
		for(int i = 0; i <numSteps; i++){
			Ingredient thyme = myIngredients.get(i);
			howMuchOf = thyme.amountPerServing() * numToServe;
			name = thyme.nameOfIngredient();
			units = thyme.measuredIn();
			System.out.print("Step " + i + ": ");
			System.out.println(howMuchOf + " " + units + " of " + name);
		}
		return true;
	}
	
	private ArrayList<Ingredient> addIngredients(){
		//variables I need
		double howMuchPerServing;
		String nameOfIngredient, howItsMeasured;
		boolean another;
		//objects I need, 2 Scanners because String does weird things sometimes
		Scanner reader = new Scanner(System.in);
		Scanner reader2 = new Scanner(System.in);
		Scanner reader3 = new Scanner(System.in);
		
		//ArrayList of Ingredients to be produced for the Dish
		ArrayList<Ingredient> procedure = new ArrayList<Ingredient>();
		
		//Get user input
		System.out.println("What is the name of your ingredient?");
		nameOfIngredient = reader.nextLine();
		
		System.out.println("What do you measure in?");
		howItsMeasured = reader2.nextLine();
		
		System.out.println("How many " + howItsMeasured + " do you need per serving?");
		howMuchPerServing = reader3.nextDouble();
		
		Ingredient food = new Ingredient(nameOfIngredient, howMuchPerServing, howItsMeasured);
		procedure.add(food);
		
		another = another();
		while(another){
			System.out.println("What is the name of your ingredient?");
			nameOfIngredient = reader.nextLine();
			
			System.out.println("What do you measure in?");
			howItsMeasured = reader2.nextLine();
			
			System.out.println("How many " + howItsMeasured + " do you need?");
			howMuchPerServing = reader3.nextDouble();
			
			Ingredient moreFood = new Ingredient(nameOfIngredient, howMuchPerServing, howItsMeasured);
			procedure.add(moreFood);
		}
		return procedure;
	}
	
	private boolean another(){
		String response;
		Scanner reader = new Scanner(System.in);
		System.out.println("Add another?");
		response = reader.nextLine();
		
		if(response.equalsIgnoreCase("No")){
			return false;
		} 
		return true;
	}
	
	
}
