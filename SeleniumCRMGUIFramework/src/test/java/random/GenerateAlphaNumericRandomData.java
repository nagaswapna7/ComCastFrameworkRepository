package random;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=20;
		
		//Choose a Character random from this String
		String AlphaNumericString = "ABDGJLAUFAUEBAU15418141ABYAAVEUVAVUA189484198184841AGAUGAYVFA";
		
		//Create StringBuffersize of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);
		
		for(int i=0;i<n;i++)
		{
			
			//Generate a random number between 0 to AplhaNumericString Variable Length
			
			int index = (int) (AlphaNumericString.length()* Math.random());
			
			//Add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		
		System.out.println(sb); 
		

	}

}
