package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderApp {

	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario","Milan");
	Trader alan = new Trader("Alan","Cambridge");
	Trader brian = new Trader("Brian","Cambridge");
	List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
			);
	public List<Transaction> getTransactionHistory(){
		return transactions;
	}
	public static void main(String[] args) {
		List<Transaction> list=new TraderApp().getTransactionHistory();
		
		//Find all Transaction in 2011 and sort by value??
		List<Transaction> allTransaction=list.stream().filter(trans->trans.getYear()==2011).sorted(Comparator.comparingInt(Transaction::getValue)).collect(Collectors.toList());
		
		System.out.println(allTransaction);
		
		System.out.println("What are the unique cities where trader works????");
		
		List<String> uniqueCity=list.stream().map(trans->trans.getTrader().getCity()).distinct().collect(Collectors.toList());
		System.out.println(uniqueCity);
		System.out.println("Find all Traders from Cambridge and sort them by name");
		List<Trader> allTradersFromCam=list.stream().map(trans->trans.getTrader()).filter(trader->trader.getCity().equalsIgnoreCase("Cambridge")).sorted(Comparator.comparing(Trader::getName)).distinct().collect(Collectors.toList());
		System.out.println(allTradersFromCam);
		System.out.println("Return a string of all traders name sorted");
		String allTradersName=list.stream().map(trans->trans.getTrader().getName()).sorted().collect(Collectors.joining(","));
		System.out.println(allTradersName);
		System.out.println("Are any Trader based on Milan");
		boolean isMilan=list.stream().map(trans->trans.getTrader().getCity()).anyMatch(name->name.equalsIgnoreCase("Milan"));
		System.out.println(isMilan);
		System.out.println("Print all Transaction Value from the traders living in Cambridge");
	    List<Integer> printAllValue=	list.stream().filter(trans->trans.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(t->t.getValue()).collect(Collectors.toList());
		System.out.println(printAllValue);
		System.out.println("Highest Value of all Transction?????");
		Optional<Integer> op= list.stream().map(trans->trans.getValue()).max(Comparator.naturalOrder());
		op.ifPresentOrElse(System.out::print, ()->{System.out.println("No Max Present");} );
		//2nd way using mapToInt
		int maxValue=list.stream().mapToInt(trans->trans.getValue()).max().getAsInt();
		System.out.println(maxValue);
		//3rd way using reduce method
		int firstHighest=list.stream().mapToInt(trans->trans.getValue()).reduce(Integer::max).getAsInt();
		System.out.println(firstHighest);
		System.out.println("Find the Transaction with the smallest value?????????");
		
		Transaction findSmallestTransaction=list.stream().sorted(Comparator.comparingInt(Transaction::getValue)).findFirst().get();
		System.out.println(findSmallestTransaction);
		//2nd way
		Transaction tt=list.stream().min(Comparator.comparing(Transaction::getValue)).get();
		System.out.println(tt);
		System.out.println("Find Max Transaction Value???????????????");
		Transaction firstTran= list.stream().max(Comparator.comparing(Transaction::getValue)).get();
		System.out.println(firstTran);
		
		System.out.println("Find Fibonacci series using Stream API....................");
		
		
		
		
		
	}

}
