package cs211;
//myles cullen 10347613 the max loss is 81.80305131761443%.The intial share price was $36.05 and the final share price was $6.56

public class HashingApple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CS211Reader reader = new CS211Reader();
		String[] contents = reader.load("appleshares");
		Double[] shares = new Double[contents.length];
		
		for(int i=contents.length-1;i>=0;i--)
		{
			shares[i] =Double.parseDouble(contents[i]);
		}
		double div=0;
		double ex=0;
		
		double loss=100;
		
		
		
		
		for(int i=shares.length-1;i>0;i--)
		{
			
			for(int a=i-1;a>0;a--)
			{
				
				
				if(shares[a]/shares[i]*100<loss)
				{
					loss=shares[a]/shares[i]*100;
					div=shares[i];
					ex=shares[a];
				}
				
				
			}
		}
		System.out.println("the max loss is " + (100-loss) +"%.The intial share price was $"+ div +" and the final share price was $"+ ex);
		
	}
}
