//21428070
//Naidoo.K
import javax.swing.JOptionPane;



public class SalonReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Service[]Arr = new Service[10];
      
       input(Arr);display(Arr);
      System.out.println("Lowest Cost : "+Cheapest(Arr));
       belowAverage(Arr);
       System.out.println("Service Codes");
       System.out.println("=============");
       System.out.println(ServiceCode(Arr));
       delete(Arr);
       
	}
	public static void input(Service[]Array){
		for(int i=0;i<6;i++)
		{
			String Des = JOptionPane.showInputDialog(null,"Enter Description");
			double price = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Price per hour"));
			int time = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Time"));

			Array[i] = new Service(Des,price,time);
		}
	}
	public static void display(Service[]Array)
	{
		System.out.println("Service Description    Price(R) per hour    Time(Minutes)");
		for(int i =0;i<6;i++){
		System.out.println(Array[i].getSdescrip()+"               "+Array[i].getPrice()+"                "+Array[i].getMin());
	}}
	
	public static String Cheapest(Service[]Array){
		double low = Array[0].cost();
		String temp=Array[0].getSdescrip();
		for(int i =0;i<6;i++){
	          if(Array[i].cost()<low)
	          {
	        	  temp = Array[i].getSdescrip();
	          }
		}
		return temp;
	}
	
	public static void belowAverage(Service[]Array){
		double total=0;
		for(int i =0;i<6;i++){
	       total = total + Array[i].getPrice();
		}
		double av = total/6;
		boolean flag=false;
		int j=0;
		String Low =Array[0].getSdescrip();
	while(flag==false && j<6)
	{
		if(Array[j].getPrice()<av)
		{
			Low = Array[j].getSdescrip();
			flag = true;
		}
		j++;
	}
	
	System.out.println("Below Average : "+Low);
	}
	
	public static String ServiceCode(Service[]Array){
		String temp="";
		for(int k =0;k<6;k++){
	               	String des = Array[k].getSdescrip();
	           	if(des.length()%2==0)
	           	{
	             		temp  = temp + des.substring(1,des.length()-1) + "\n";
	          	}
	        	else
         		{
	           		String reverse = "";
	             		int len = des.length();
	         		for ( int i =len-1; i >=0; i-- ){
	           			reverse = reverse + des.charAt(i);
	          		}
	         		temp = temp + reverse +"\n";
			       
      			
          		}
	           	
		}
		return temp;
	}
	
	public static void delete(Service[]Array)
	{
		boolean found= false;
		String Des = JOptionPane.showInputDialog(null,"Enter Service to delete");
		 Service [] ArrNew = new Service[10];
		 int count = 0;
		for(int i =0;i<6;i++)
		{
			if(!Array[i].getSdescrip().equalsIgnoreCase(Des))
			{
				ArrNew[count] = new Service(Array[i].getSdescrip(),Array[i].getPrice(),Array[i].getMin());
				count ++;
			}
			else
			{
				found = true;
			}
		}
		System.out.println("Service Description    Price(R) per hour    Time(Minutes)");
		for(int i =0;i<5;i++){
			System.out.println(ArrNew[i].getSdescrip()+"               "+ArrNew[i].getPrice()+"                "+ArrNew[i].getMin());
		}
		if(found == true){
			
		System.out.println(Des + " has been deleted");}
		else{
			System.out.println("None deleted");
		}
	}

}
