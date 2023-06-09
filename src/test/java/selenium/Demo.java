package selenium;

public interface Demo 
{
	public void m1();
	
	public default void m2()
	{
		System.out.println("Hi");
	}
	
	public static void main(String[] args) 
	{
		
	}
}
