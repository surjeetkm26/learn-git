package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DishMenu {
	public static List<Dish> getListOfDish(){ 
	List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Type.MEAT),
			new Dish("beef", false, 700, Type.MEAT),
			new Dish("chicken", false, 400, Type.MEAT),
			new Dish("french fries", true, 530, Type.OTHER),
			new Dish("rice", true, 350, Type.OTHER),
			new Dish("season fruit", true, 120, Type.OTHER),
			new Dish("pizza", true, 550, Type.OTHER),
			new Dish("prawns", false, 300, Type.FISH),
			new Dish("salmon", false, 450, Type.FISH) );
	return menu;
	}
	
	public static void main(String[] args) {
		//Find out three high calorie dish name
		List<Dish> dishes=getListOfDish();
		
	List<String> list=dishes.stream().sorted(Comparator.comparingInt(Dish::getCalories).reversed()).limit(3).map(Dish::getName).collect(Collectors.toList());
		System.out.println(list);
	//Find all dishes which are vegeterian
		List<Dish> list2= dishes.stream().filter(Dish::isVegeterian).collect(Collectors.toList());
		System.out.println(list2);
		
		//Calculate sum of all calories
		Optional<Integer> op=dishes.stream().map(Dish::getCalories).reduce((a,b)->a+b );
		int val=dishes.stream().map(Dish::getCalories).reduce(0,(a,b)->a+b );
		
		System.out.println("Total Cal: "+ val);
		
		System.out.println("COUNT NUMBER OF DISHES??????????????????????");
		long count= dishes.stream().map(x->1).count(); //You can map each element to numeric 1
		System.out.println(count);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
