import java.io.FileWriter;
import java.io.IOException;

//the class ExpressDelivery
//this class is the son of the class GeneralDelivery its extends from him 
public class ExpressDelivery extends GeneralDelivery {
private double AdditionalPay;


//the  constructor of the class 
public ExpressDelivery(String address, int numItems, double price, boolean isDelivered,
		double additionalPay) {
	super(address, numItems, price,isDelivered);
	AdditionalPay = additionalPay;
}
//getters and setters
public double getAdditionalPay() {
	return AdditionalPay;
}
public void save(FileWriter pw,Members member) throws IOException 
{
		  pw.write(this.getArea());
		  pw.write(" "+this.getNumItems());
		  pw.write(" "+this.getPrice());
		  pw.write(" "+this.isDelivered());
		  pw.write(" "+this.getAdditionalPay());
		  pw.write(" "+member.getId());
		  pw.write(" "+"ExpressDelivery");
		  pw.write("\n");  
  }
public void setAdditionalPay(double additionalPay) {
	AdditionalPay = additionalPay;
}
//getters and setters

//toString , returning a string thats contains a details about the class
@Override
public String toString() {
	return super.toString()+ " ,ExpressDelivery [AdditionalPay=" + AdditionalPay + "]";
}


}
