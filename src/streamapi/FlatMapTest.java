package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {

	public static List<int[]> getPair(List<Integer> list1,List<Integer> list2){
		return list1.stream().flatMap(x->list2.stream().filter(a->(a+x)%3==0 ).map(y->new int[] {x,y})).collect(Collectors.toList());
		
		
	}
	public static void main(String[] args) {
		List<String> list=Arrays.asList("Hello","World");
		//Find Unique character
		System.out.println(list);
		List<String> ll= list.stream().map(word->word.split("")).flatMap(Stream::of).collect(Collectors.toList());
		
		System.out.println(ll);
		
		//Given a list of numbers, how would you return a list of the square of each number? For
		//example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25]
		List<Integer> numbers=Arrays.asList(1,2,3,4,5);
		List<Integer> ll3=numbers.stream().map(x->x*x).collect(Collectors.toList());
		System.out.println(ll3);
		
		//Given two lists of numbers, how would you return all pairs of numbers? For example, given a
			//	list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
				//simplicity, you can represent a pair as an array with two elements
		List<int[]> ll4=getPair(Arrays.asList(1,2,3), Arrays.asList(3,4));
		for(int[] arra:ll4) {
			System.out.println(Arrays.toString(arra));
		}
		//find the pair whose sum which is divisible by 3
	}

}
