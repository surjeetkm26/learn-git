package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@FunctionalInterface
interface Foo {
	public void method1();	
}
@FunctionalInterface
interface Bar{// extends Foo{
	public void method1();
	public default void defaultMethod() {System.out.println("Default Method!");}
	public static void staticMethod() {System.out.println("Static Method!");}
	@Override
	public abstract String toString();
	@Override
	public abstract boolean equals(Object obj);
	
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
	private int id;
	private String name;
}

public class FunctionalITest {
	public void test(Predicate<String> pre) {
		Predicate<Integer> pre1=x->x>5;
		Predicate<String> pre3=str->str.isEmpty();
		Function<String, Boolean> func= word->word.isBlank();
		BiFunction<Integer, Integer, Boolean> bi= (x,y)->x>y;
		Supplier<FunctionalITest> o=FunctionalITest::new;
	List<Person> list=Arrays.asList(new Person(101, "Surjeet"),new Person(202, "mohanty"));
	list.stream().map(Person::getName);
	}
}
