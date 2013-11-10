// The amount 1 dish serves (howManyServedByDish)
// The steps you take to prepare a dish [createProcedure()]
// (Display) Take in from the day class the number of people attending(done) then divide that by the amount served by a single dish (done) to
// calc the number of dishes needed, and apply that to the ingredients(Done)
import java.util.ArrayList;
import java.util.Scanner;
public class Dish {
	private String myDishName;
	private ArrayList<Ingredient> myIngredients;
	private ArrayList<String> mySteps;
	private int myNumServed;
	//private int myNumSteps;
	
	public Dish(){
		myDishName = nameDish();
		myNumServed = howManyServedByDish();
		myIngredients = addIngredients();
		mySteps = createProcedure();
	}
	
	public String getName(){
		return myDishName;
	}
	
	public int getNumberServed(){
		return myNumServed;
	}
	
	private int howManyServedByDish(){
		int numServed;
		Scanner reader = new Scanner(System.in);
		System.out.println("How many does this dish serve?");
		numServed = reader.nextInt();
		
		return numServed;
	}
	private String nameDish(){
		String name;
		Scanner reader = new Scanner(System.in);
		System.out.println("What is the name of your dish?");
		name = reader.nextLine();
		
		return name;
	}
	
	private ArrayList<String> createProcedure(){
		String directions;
		int i = 1;
		boolean another = true;
		
		ArrayList<String> procedure = new ArrayList<String>();
		Scanner reader = new Scanner(System.in);
		System.out.println("Here, I ask that you describe the steps for making your dish.");
		while(another){
			System.out.println("Please describe Step " + i + ".");
			directions = reader.nextLine();
			
			procedure.add(directions);
			i++;
			another = another();
		}
		return procedure;
	}
	
	public boolean shoppingList(int numAttending){
		int numSteps = myIngredients.size();
		double howMuchOf;
		String name, units;
		
		System.out.println("Ingredients: ");
		for(int i = 0; i<numSteps; i++){
			Ingredient thyme = myIngredients.get(i);
			howMuchOf = thyme.amountPerServing() * (double)(numAttending/myNumServed);
			name = thyme.nameOfIngredient();
			units = thyme.measuredIn();
			System.out.println(howMuchOf + " " + units + " of " + name);
		}
		System.out.println();
		return true;
	}
	
	public boolean procedure(){
		System.out.println("Follow these steps for a perfect dish of " + myDishName);
		System.out.println("Ingredients: ");
		for(int i = 0; i <mySteps.size(); i++){
			System.out.print("Step " +(i+1)+": ");
			System.out.println(mySteps.get(i));
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
		System.out.println("What is the name of your first ingredient?");
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
			another = another();
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
