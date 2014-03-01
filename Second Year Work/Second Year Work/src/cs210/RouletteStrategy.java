package Cs210;

public class RouletteStrategy 
{
	public static void main (String[] args){
		int limit = 10000;
		int target = 1000;
		int winnings = 0;
		int currentbet = 5;
		double bust = 0;
		double runs = 10000;
		for(int i=0; i<runs; i++){
		        winnings=0;
		        currentbet=5;
		while(winnings<target){
		            int random = (int)(Math.random()*37 + 1);
		if(random<=18){
		                winnings+=5;
		currentbet=5;
		            }else{
		                currentbet=currentbet*2;
		            }
		if(currentbet>limit){
		                bust++;
		break;
		            }
		        }
		    }
		System.out.println("You went bust "+bust+" times out of "+runs);
		System.out.println("The odds of going bust are "+(100*bust/runs)+"%");
		  } 

}
