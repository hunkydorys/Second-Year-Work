package cs210;
import java.io.*;
import java.util.Scanner;

public class SortFile 
{
	static int nElems;  //how many items do  you want to sort?
	static String[] array;

	public static void main (String[] args) throws IOException {
		File testFile = new File("words.txt");     //this is where the file to be sorted is loaded from
		File newFile = new File("sorted.txt");   //this is where the information is saved when it's been sorted

		//time the following for bubblesort, selection sort and insertion sort:
		//10,000 items, 20,000 items, 30,000 items, 40,000 items and 50,000 items
		//now draw all of this in an excel graph with items on the x axis and runtime on the y axis

		Scanner myscanner = new Scanner(System.in);
		System.out.println("How many items would you like to sort?");
		nElems = myscanner.nextInt();
		array = new String[nElems];
		getContents(testFile);	//loads the file
		System.out.println("Which sorting algorithm would you like to use?");
		System.out.println("1)Bubblesort \n2)Selectionsort \n3)Insertionsort   ");
		int in= myscanner.nextInt();
		switch(in)
		{
		case 1: bubblesort(); break;
		case 2: selectionsort(); break;
		case 3: insertionsort(); break;

		}

		//calls the sorting method

		setContents(newFile); //saves the sorted info

	}

	public static void bubblesort()
	{

		for(int out=nElems-1; out>0;out--)
		{
			for(int in=0;in<out; in++)
			{
				if(array[in].compareTo(array[in+1])>0)
				{
					swap(in,in+1);

				}

			}
		}


		//fill this in!!!

	}

	public static void swap(int num1, int num2){
		String temp =array[num1];
		array[num1]=array[num2];
		array[num2]=temp;
	}



	public static void selectionsort() {

		int min;
		for(int outer = 0; outer <array.length;outer++)
		{
			min = outer;
			for(int i = outer+1;i<array.length;i++)
			{
				if(array[i].compareTo(array[min])<0)
				{
					min =i;
				}
			}
			swap(outer,min);
		}

		//fill this in!!!

	}


	public static void insertionsort() 
	{
		for (int outer = 1; outer < array.length; outer++) 
		{
			String temp = array[outer];
			int inner = outer;
			while(inner>0 && array[inner-1].compareTo(temp)>0)
			{
				array[inner]=array[inner-1];
				inner--;
			}
			array[inner]=temp;


		}


		//fill this in!!!

	}


	public static void getContents(File aFile) {

		BufferedReader input = null;
		try {
			input = new BufferedReader( new FileReader(aFile) );
			String line = null;
			for(int i=0;i<nElems;i++){
				array[i]=input.readLine();
			}
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex){
			ex.printStackTrace();
		}finally {
			try {
				if (input!= null) {
					input.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
/*	public static void merge(String [] workspace, int lowerBound, int upperBound)
	{
		
			if(lowerBound == upperBound)
				// if range is 1,
				return;
			// no use sorting
			else{
				// find midpoint
				int mid = (lowerBound+upperBound) / 2;
				// sort low half
				merge(workspace, lowerBound, mid);
				// sort high half
				merge(workspace, mid+1, upperBound);
				// merge them
				merge(workspace, lowerBound, mid+1, upperBound);
			}
		

	}*/


	public static void setContents(File aFile) throws FileNotFoundException, IOException {

		Writer output = null;
		try {

			output = new BufferedWriter( new FileWriter(aFile) );
			for(int i=0;i<nElems;i++){
				output.write( array[i] );
				output.write(System.getProperty("line.separator"));
			}
		}finally {
			if (output != null) output.close();
		}
	}

}
