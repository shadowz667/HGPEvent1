import java.util.Scanner;
public class FullCourseMeal {
	public static void main(String[] args){
		/*int howMany;
		Scanner reader = new Scanner(System.in);
		//System.out.println("How many does this dish feed?");
		howMany = reader.nextInt();*/
		Dish dinner = new Dish();
		System.out.println("Dish: " + dinner.getName());
		System.out.println("Feeds " + dinner.getNumberServed());
		System.out.println("Requires: ");
		dinner.shoppingList(20);
		
		System.out.println("This is how you make it: ");
		dinner.procedure();
	}
}
