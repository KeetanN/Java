//21428070
//Naidoo.K

public class Service {
private String Sdescrip;
private double Price;
private int Min;
public Service(String Servicedes,double SPrice,int Stime){
	Sdescrip = Servicedes;
	Price = SPrice;
	Min = Stime;
}
public String getSdescrip(){
	return Sdescrip;
	
}
public double getPrice(){
	return Price;
}
public int getMin(){
	return Min;
}
public double cost(){
	return Price * Min;
}
}

