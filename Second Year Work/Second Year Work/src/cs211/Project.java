package cs211;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.math.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.net.*;
import java.io.*;


public class Project extends Applet{
    
     Brain mybrain = new Brain();

    static double north[] = {53.855,52.794,54.350,53.433,52.992,54.117,53.328,54.800,54.863,55.071,54.502,54.343,51.746,54.660,51.680,54.597,53.091,53.175,55.136,52.831,53.976,53.944,53.861,53.991,51.622,52.354,51.897,54.996,54.322,53.714,53.348,54.009,54.500,52.085,53.345,52.846,52.502,54.345,53.272,52.677,53.728,53.106,52.648,52.059,51.708,53.783,54.851,54.957,55.053,52.665,52.447,53.727,53.197,51.904,54.750,52.131,53.382,52.266,54.248,53.116,53.522,52.863,52.396,54.210,52.451,54.590,53.633,52.714,54.267,53.245,54.830,52.679,52.474,52.268,53.515,53.267,52.257,53.800,52.334,51.952};
    static double west[] = {-6.538,-6.165,-6.655,-7.950,-6.987,-9.167,-8.219,-7.790,-6.284,-6.508,-8.190,-6.260,-8.735,-5.670,-9.453,-5.930,-7.913,-6.525,-7.456,-6.932,-6.719,-8.095,-9.299,-7.360,-8.886,-7.712,-8.470,-7.307,-5.703,-6.350,-6.260,-6.405,-6.770,-7.640,-7.051,-8.981,-6.566,-7.640,-9.049,-6.292,-6.878,-6.065,-7.256,-9.507,-8.531,-8.917,-5.811,-7.720,-6.946,-8.624,-9.486,-7.800,-8.567,-8.957,-6.610,-8.642,-6.591,-8.270,-6.971,-7.324,-7.338,-8.200,-6.945,-5.882,-9.055,-7.290,-8.183,-8.869,-8.483,-9.306,-7.470,-7.814,-8.162,-9.696,-8.851,-7.500,-7.129,-9.533,-6.458,-7.846};
    boolean valid = true;
    int count = 0;
    double distance = 0;
    String names[] = {"Ardee","Arklow","Armagh","Athlone","Athy","Ballina","Ballinasloe","Ballybofe","Ballymena","Ballymoney","Ballyshannon","Banbridge","Bandon","Bangor","Bantry","Belfast","Birr","Blessington","Buncrana","Carlow","Carrickmacross","Carrick-On-Shannon","Castlebar","Cavan","Clonakilty","Clonmel","Cork","Derry","Downpatrick","Drogheda","Dublin","Dundalk","Dungannon","Dungarvan","Edenderry","Ennis","Enniscorthy","Enniskillen","Galway","Gorey","Kells","Kilcoole","Kilkenny","Killarney","Kinsale","Knock","Larne","Letterkenny","Limavady","Limerick","Listowel","Longford","Loughrea","Macroom","Magherafelt","Mallow","Maynooth","Mitchelstown","Monaghan","Mountmellick","Mullingar","Nenagh","New-Ross","Newcastle","Newcastle-West","Omagh","Roscommon","Shannon","Sligo","Spiddal","Strabane","Thurles","Tipperary","Tralee","Tuam","Tullamore","Waterford","Westport","Wexford","Youghal"};
    int[][] connections = new int[80][2];
    boolean[] connected = new boolean[80];
    static double[][] matrix = new double[80][80];
    Image ireland;
    Map themap;
    static boolean warning1=false;
    static boolean warning2=false;
    static Button submit;
    static TextField display;
    long startTime = 0;
    long runTime = 0;
     
    public void init(){
        
        ireland = getImage(getCodeBase(), "IrelandWhite.jpg");
        setLayout(new BorderLayout());
        setSize(600,750);
        setBackground(Color.white);
        Panel  buttonpanel = new Panel();       
        buttonpanel.setLayout(new GridLayout());
        Panel  dual = new Panel();
        dual.setLayout(new BorderLayout());
        setFont(new Font("Calibri", Font.PLAIN, 24));

        Button reset = new Button("Reset");
        
        display = new TextField("");
        display.setEditable(false);
        display.setFont(new Font("Calibri", Font.PLAIN, 12));
        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                reset();
            }
        });     
        
        
        Button random = new Button("Run algorithm");
        
        random.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                runalgorithm();
            }
        });        
        
        submit = new Button("Submit");
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(valid){
                    int code = 0;
                    String solution="";
                    double dist=0;
                    int start=0;
                    for(int i=0;i<80;i++){
                        if(connected[i]){
                            start=i;
                            break;
                        }
                    }
 
                    int trail=start;
                    int previous= start;
                    int temp;
                    if (connections[start][0]>connections[start][1]){
                        trail=connections[start][1];
                    }else{
                        trail=connections[start][0];
                    }
                    solution+=(char)(start+40);
                    for(int i=0;i<79;i++){
                        code+=(i*trail);
                        solution+=(char)(trail+40);
                        if(connections[trail][0]==previous){
                            temp=connections[trail][1];
                        }else{
                            temp=connections[trail][0];
                        }
                        previous=trail;
                        trail=temp;
                    }
                    display.setText(solution+"           "+code%9973);
                }else{
                    warning1=true;
                    themap.repaint();
                }
            }
        });            
        
        submit.setForeground(Color.gray);
       
        buttonpanel.add(reset);
        buttonpanel.add(random);
        buttonpanel.add(submit);
        dual.add("North",buttonpanel);
        dual.add("South",display);
        add("South",dual);
        themap = new Map(this);
        reset();
        add("Center",themap);
        fillmatrix();
    }
    
    public void runalgorithm(){
        reset();
        startTime = System.currentTimeMillis();
        String solution = mybrain.compute();
        runTime = System.currentTimeMillis()-startTime;
        if(solution.length()>80){
             display.setText(solution.substring(80));
             solution=solution.substring(0,80);
         }

            connections[Math.abs(solution.charAt(solution.length()-1)-40)%solution.length()][0]=Math.abs(solution.charAt(0)-40)%solution.length();
            connections[Math.abs(solution.charAt(0)-40)%solution.length()][1]=Math.abs(solution.charAt(solution.length()-1)-40)%solution.length();

        
            for(int i=1;i<=solution.length()-1;i++){
                int town = Math.abs(solution.charAt(i)-40)%solution.length();
                int previous = Math.abs(solution.charAt(i-1)-40)%solution.length();
                if(!connected[town]){
                    connected[town]=true;
                    count++;
                }
                if(!connected[previous]){
                    connected[previous]=true;
                    count++;
                }
                connections[previous][0]=town;
                connections[town][1]=previous;
            }

        validity();
      
        if(!valid){

            warning2=true;
            display.setText("Defective: "+solution);
        }else{
            distance = compute(solution);
        }
        themap.repaint();
    }
        
      
    public void reset(){
        distance = 0;
        display.setText("");
        for(int i = 0; i<80; i++){
            connections[i][0]=-1;
            connections[i][1]=-1;
            connected[i]=false;
            count=0;
            valid=false;
        }
        submit.setForeground(Color.gray);
        themap.repaint();
    }   
    
    
    
    public void validity(){
        int counter=0;
        for(int i=0;i<80;i++){
            for(int j=0;j<2;j++){
                if(connections[i][j]>=0){
                    counter++;
                }
            }
        }
        if(counter==160&&count==80&&!valid){
            if(circuit()){
                valid=true;
                submit.setForeground(Color.black);
            }else{
                valid=false;
                submit.setForeground(Color.gray); 
            }
        }else if(valid){
           valid=false;
           submit.setForeground(Color.gray); 
        }    
    }
    
    
    public boolean circuit(){
        int start=0;
        for(int i=0;i<80;i++){
            if(connected[i]){
                start=i;
                break;
            }
        }
 
        int trail=start;
        int previous= start;
        int temp;

        trail=connections[start][1];
        for(int i=0;i<79;i++){

            if(connections[trail][0]==previous){
                temp=connections[trail][1];
            }else{
                temp=connections[trail][0];
            }
            previous=trail;
            trail=temp;
        }
        if (start==trail){
            return true;
        }
        return false;
     } 
    
     public static void fillmatrix(){
         for(int i=0;i<80;i++){
            for(int j=0;j<80;j++){
                matrix[i][j]=getDistance(north[i],west[i],north[j],west[j]);
            }
         }
      }
  
      public static double getDistance(double lat1, double lon1, double lat2, double lon2){
          double R = 6371;
          double dLat = Math.toRadians((lat2-lat1));
          double dLon = Math.toRadians((lon2-lon1)); 
          double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2); 
          double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
          double d = R * c;         
          return d;
      }
      
      public static double compute(String solution){
          double distance = 0;
          int current =solution.charAt(0)-40;
          for(int i=1;i<=solution.length();i++){
              int town=(int)solution.charAt(i%solution.length())-40;
              distance+=matrix[current][town];
              current=town;
           }
           return distance;
      }         
}   
    
class Map extends Canvas{

    private Project main;
    int drag = -1;
    int hover = -1;
    int x =0;
    int y = 0;
    boolean painting=true;

    public Map(Project mainin){
        main=mainin;
        setFont(new Font("Calibri", Font.PLAIN, 30));
        
        
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                if(drag>=0){
                    x=e.getX();
                    y=e.getY();
                }
                hover=-1;
                for(int i=0;i<80;i++){
                    if(Math.sqrt((1122+(int)(main.west[i]*102)-e.getX())*(1122+(int)(main.west[i]*102)-e.getX())+(9520+(int)(main.north[i]*-172)-e.getY())*(9520+(int)(main.north[i]*-172)-e.getY()))<10){
                        
                            hover=i; 
                            break;
                        
                    }
                }                
                repaint();
            }
            
            public void mouseMoved(MouseEvent e){
                hover=-1;
                for(int i=0;i<80;i++){
                    if(Math.sqrt((1122+(int)(main.west[i]*102)-e.getX())*(1122+(int)(main.west[i]*102)-e.getX())+(9525+(int)(main.north[i]*-172)-e.getY())*(9525+(int)(main.north[i]*-172)-e.getY()))<10){

                            hover=i; 
                            break;

                    }
                }
                repaint();
            }
            
        });

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                for(int i=0;i<80;i++){
                    if(Math.sqrt((1122+(int)(main.west[i]*102)-e.getX())*(1122+(int)(main.west[i]*102)-e.getX())+(9525+(int)(main.north[i]*-172)-e.getY())*(9525+(int)(main.north[i]*-172)-e.getY()))<10){
                        drag=i;
                        x=e.getX();
                        y=e.getY();
                        repaint();
                        break;
                    }
                }
            }
        
        
            public void mouseReleased(MouseEvent e){
                if(drag>=0){
    
                    for(int i=0;i<80;i++){
                        if(Math.sqrt((1122+(int)(main.west[i]*102)-e.getX())*(1122+(int)(main.west[i]*102)-e.getX())+(9525+(int)(main.north[i]*-172)-e.getY())*(9525+(int)(main.north[i]*-172)-e.getY()))<10){
                            if(drag==i){
                                if(main.connected[drag]){
                                    main.connected[drag]=false;
                                    main.count--;
                                }
                                if(main.connections[drag][0]>=0){
                                    if(main.connections[main.connections[drag][0]][0]==drag){
                                        main.connections[main.connections[drag][0]][0]=-1;
                                        if(main.connections[main.connections[drag][0]][1]==-1){
                                            main.count--;
                                            main.connected[main.connections[drag][0]]=false;
                                        }
                                    }else {
                                        main.connections[main.connections[drag][0]][1]=-1;
                                        if(main.connections[main.connections[drag][0]][0]==-1){
                                            main.count--;
                                            main.connected[main.connections[drag][0]]=false;
                                        }
                                    }
                                    main.distance-=main.matrix[drag][main.connections[drag][0]];
                                    main.connections[drag][0]=-1;
                                    if(main.count==80||main.valid){
                                        main.validity();
                                    }       
                                }
                                if(main.connections[drag][1]>=0){
                                    if(main.connections[main.connections[drag][1]][0]==drag){
                                        main.connections[main.connections[drag][1]][0]=-1;
                                        if(main.connections[main.connections[drag][1]][1]==-1){
                                            main.count--;
                                            main.connected[main.connections[drag][1]]=false;
                                        }
                                    }else {
                                        
                                        main.connections[main.connections[drag][1]][1]=-1;
                                        if(main.connections[main.connections[drag][1]][0]==-1){
                                            main.count--;
                                            main.connected[main.connections[drag][1]]=false;
                                        }
                                    }
                                    main.distance-=main.matrix[drag][main.connections[drag][1]];
                                    main.connections[drag][1]=-1;
                                    if(main.count==80||main.valid){
                                        main.validity();
                                    }
                                }     
                            }else if(main.connections[drag][0]<0&&main.connections[i][0]<0){
                                if(!main.connected[drag]){
                                    main.count++;
                                }
                                if(!main.connected[i]){
                                    main.count++;
                                }
                                main.connections[drag][0]=i;
                                main.connections[i][0]=drag;
                                main.connected[drag]=true;
                                main.connected[i]=true;
                                main.distance+=main.matrix[drag][i];
                                break;
                            }else if(main.connections[drag][0]<0&&main.connections[i][1]<0){
                                if(!main.connected[drag]){
                                    main.count++;
                                }
                                if(!main.connected[i]){
                                    main.count++;
                                }
                                main.connections[drag][0]=i;
                                main.connections[i][1]=drag;                                
                                main.connected[drag]=true;
                                main.connected[i]=true;
                                main.distance+=main.matrix[drag][i];
                                break;
                            }else if(main.connections[drag][1]<0&&main.connections[i][0]<0){
                                if(!main.connected[drag]){
                                    main.count++;
                                }
                                if(!main.connected[i]){
                                    main.count++;
                                }
                                main.connections[drag][1]=i;
                                main.connections[i][0]=drag;                                
                                main.connected[drag]=true;
                                main.connected[i]=true;
                                main.distance+=main.matrix[drag][i];
                                break;
                            }else if(main.connections[drag][1]<0&&main.connections[i][1]<0){
                                if(!main.connected[drag]){
                                    main.count++;
                                }
                                if(!main.connected[i]){
                                    main.count++;
                                }
                                main.connections[drag][1]=i;
                                main.connections[i][1]=drag;                                
                                main.connected[drag]=true;
                                main.connected[i]=true;
                                main.distance+=main.matrix[drag][i];
                                break;
                            } 
                        }
                    }
                }
                drag=-1;
                repaint();
            }             
        });
    }
    
                   
    public void update(Graphics g){
        paint(g);
    }
        
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;

        BufferedImage image = // Create an off-screen image
        new BufferedImage(600, 700, BufferedImage.TYPE_INT_ARGB);
        Graphics2D offscreengraphics = image.createGraphics(); // Get its Graphics for drawing
        offscreengraphics.setStroke(new BasicStroke(1.0f)); // 2-pixel lines
        offscreengraphics.setFont(new Font("Calibri", Font.PLAIN, 30)); 
        offscreengraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        
        offscreengraphics.setColor(Color.white);
        offscreengraphics.fillRect(0,0,600,700);

        offscreengraphics.drawImage(main.ireland,37,0,this);
        offscreengraphics.setColor(Color.orange);
        offscreengraphics.fillOval(442,336,16,16);
        offscreengraphics.setColor(Color.black);
        offscreengraphics.drawString("Connected: "+main.count,350,675);

        if(hover>=0){
          offscreengraphics.drawString(""+main.names[hover],350,645);
        }
        offscreengraphics.setFont(new Font("Calibri", Font.PLAIN, 40));

        offscreengraphics.drawString(""+(int)main.distance+" km ",40,100);
        
        if(main.valid){  
            offscreengraphics.drawString(""+(int)(main.runTime/1000)+" s ",40,140);  
        }
        for(int i=0;i<80;i++){      
            if(main.connected[i]||i==drag||(i==hover&&drag>=0)){ 
                offscreengraphics.setColor(Color.red);
                if(main.valid){
                    offscreengraphics.setColor(Color.blue);
                }
            }else{
                offscreengraphics.setColor(new Color(44,191,25));
            }
            offscreengraphics.fillArc(1117+(int)(main.west[i]*102),9520+(int)(main.north[i]*-172),10,10,0,360);    
        }
        
        
        offscreengraphics.setColor(Color.red);
        
           
        if(main.valid){
            offscreengraphics.setColor(Color.blue);
        }        
        if(drag>=0){
            
            offscreengraphics.drawLine(x,y,1122+(int)(main.west[drag]*102),9525+(int)(main.north[drag]*-172));
        }
        for(int i=0;i<80;i++){
            if(main.connections[i][0]>-1){
                offscreengraphics.drawLine(1122+(int)(main.west[i]*102),9525+(int)(main.north[i]*-172),1122+(int)(main.west[main.connections[i][0]]*102),9525+(int)(main.north[main.connections[i][0]]*-172));
            }
            if(main.connections[i][1]>-1){
                offscreengraphics.drawLine(1122+(int)(main.west[i]*102),9525+(int)(main.north[i]*-172),1122+(int)(main.west[main.connections[i][1]]*102),9525+(int)(main.north[main.connections[i][1]]*-172));
            }
        }
        
        if(main.warning1){
            offscreengraphics.drawString("Run your algorithm",185,320);
            offscreengraphics.drawString("to find a solution",210,360);
        }
        if(main.warning2){
            offscreengraphics.drawString("Your solution",235,320);
            offscreengraphics.drawString("is defective",250,360);
        }

        g.drawImage(image,0,0,this);
        if(main.warning1||main.warning2){
            try{
                Thread.sleep(1000);
                main.warning1=false;
                main.warning2=false;
                this.repaint();
             }catch(InterruptedException ee){}
        }
    }   
}