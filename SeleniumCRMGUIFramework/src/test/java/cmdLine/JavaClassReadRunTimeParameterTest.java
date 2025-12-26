package cmdLine;

public class JavaClassReadRunTimeParameterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Variable of String array -- it will give the length of the array== result is zero bcz this java programm not receive any command from cmd line
		System.out.println(args.length);
		
		for(String var : args)
		{
			System.out.println(var);
		}
		
		

	}

}
