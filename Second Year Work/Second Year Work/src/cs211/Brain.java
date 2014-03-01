package cs211;

public class Brain{

	//These are the names of the 80 towns and their north and west GPS co-ordinates

	    double north[] = {53.855,52.794,54.350,53.433,52.992,54.117,53.328,54.800,54.863,55.071,54.502,54.343,51.746,54.660,51.680,54.597,53.091,53.175,55.136,52.831,53.976,53.944,53.861,53.991,51.622,52.354,51.897,54.996,54.322,53.714,53.348,54.009,54.500,52.085,53.345,52.846,52.502,54.345,53.272,52.677,53.728,53.106,52.648,52.059,51.708,53.783,54.851,54.957,55.053,52.665,52.447,53.727,53.197,51.904,54.750,52.131,53.382,52.266,54.248,53.116,53.522,52.863,52.396,54.210,52.451,54.590,53.633,52.714,54.267,53.245,54.830,52.679,52.474,52.268,53.515,53.267,52.257,53.800,52.334,51.952};
	    double west[] = {-6.538,-6.165,-6.655,-7.950,-6.987,-9.167,-8.219,-7.790,-6.284,-6.508,-8.190,-6.260,-8.735,-5.670,-9.453,-5.930,-7.913,-6.525,-7.456,-6.932,-6.719,-8.095,-9.299,-7.360,-8.886,-7.712,-8.470,-7.307,-5.703,-6.350,-6.260,-6.405,-6.770,-7.640,-7.051,-8.981,-6.566,-7.640,-9.049,-6.292,-6.878,-6.065,-7.256,-9.507,-8.531,-8.917,-5.811,-7.720,-6.946,-8.624,-9.486,-7.800,-8.567,-8.957,-6.610,-8.642,-6.591,-8.270,-6.971,-7.324,-7.338,-8.200,-6.945,-5.882,-9.055,-7.290,-8.183,-8.869,-8.483,-9.306,-7.470,-7.814,-8.162,-9.696,-8.851,-7.500,-7.129,-9.533,-6.458,-7.846};
	    String names[] = {"Ardee","Arklow","Armagh","Athlone","Athy","Ballina","Ballinasloe","Ballybofe","Ballymena","Ballymoney","Ballyshannon","Banbridge","Bandon","Bangor","Bantry","Belfast","Birr","Blessington","Buncrana","Carlow","Carrickmacross","Carrick-On-Shannon","Castlebar","Cavan","Clonakilty","Clonmel","Cork","Derry","Downpatrick","Drogheda","Dublin","Dundalk","Dungannon","Dungarvan","Edenderry","Ennis","Enniscorthy","Enniskillen","Galway","Gorey","Kells","Kilcoole","Kilkenny","Killarney","Kinsale","Knock","Larne","Letterkenny","Limavady","Limerick","Listowel","Longford","Loughrea","Macroom","Magherafelt","Mallow","Maynooth","Mitchelstown","Monaghan","Mountmellick","Mullingar","Nenagh","New-Ross","Newcastle","Newcastle-West","Omagh","Roscommon","Shannon","Sligo","Spiddal","Strabane","Thurles","Tipperary","Tralee","Tuam","Tullamore","Waterford","Westport","Wexford","Youghal"};
	   
	    public String compute(){

	/* You have to write this compute method
	 * It should compute a tour that visits the 80 towns 
	 * The solution is encoded as a series of 80 characters, representing the sequence in which each town is visited
	 * Each town is encoded by a particular character: the ASCII character of its index + 40
	 * For example, the index of Athlone is 3, and ASCII character 43 is the symbol '+'
	 * Your compute method should return the 80 characters in the appropriate sequence
	 */        
	         
	        String solution ="";
	        for (int i=0;i<80;i++){
	            solution+=(char)(i+40);
	        }
	        solution+="Anything you add on after the 80 characters will be printed in the textbox (e.g. you can compute the distance)";
	        
	        
	        return solution;
	    }
	}