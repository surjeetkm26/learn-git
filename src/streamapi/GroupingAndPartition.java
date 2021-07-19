package streamapi;

abstract class AbstractTest{
	public AbstractTest() {
		m();
	}
	abstract public void m();
}
class World extends AbstractTest{
	private final int val=getvalue();
	int v=val;
	@Override
	public void m() {
		v++;
		
		System.out.println("Myabsjnjkn");
	}
	public int getvalue() {
		return 1;
	}
}
interface Test{
	public default void m() {
		System.out.println("Default!");
	}
	public static void m2() {
		System.out.println("static");
	}
}
class Base{
	public void m() {
		System.out.println("Base");
	}
}
public class GroupingAndPartition extends Base implements Test {
	public void m() {
		System.out.println("Group");
	}
	public static void main(String[] args) {
		Test o=new GroupingAndPartition();
		Test.m2();
		
		o.m();
		int x=10;
		long y=20;
		x +=y;
		System.out.println(1/0.0);
		int m=8000;
		byte b=(byte)m;
		System.out.println(b);
		double d=10.00;
		long l=(long)d;
		if(5*0*1==0.5) {
			System.out.println("Equal");
		}else {
			System.out.println("nope"+ (5*0.5==0.5));
		}
		
		AbstractTest o2=new World();
	}
}
