package cs211;
import java.math.*;

public class DistanceMaynoothNewYork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		double q11=53.380;
		double q22=40.6891;
		double v11=-6.597;
		double v22=-74.0444;
		
		
		
		
		
		double result1 = haversin(q11,q22,v11,v22);
		
		System.out.println(result1);

	}
	
	
	public static double haversin(double q1,double q2,double v1,double v2 )
	{
		double thing=(Math.PI)/180;
		 q1=53.380*thing;
		 q2=40.6891*thing;
		 v1=-6.597*thing;
		 v2=-74.0444*thing;
		double r=6371;
		double a=Math.pow(Math.sin((q2-q1)/2), 2);
		
		double b=Math.pow(Math.sin((v2-v1)/2), 2);
		
		double result= a+(Math.cos(q1)*Math.cos(q2)*b);
		
		double distance = (2*r)*(Math.asin(Math.sqrt(result)));
		return distance;
	}

}
