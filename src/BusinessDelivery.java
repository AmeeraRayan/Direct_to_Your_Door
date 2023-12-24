import java.io.FileWriter;
import java.io.IOException;

//the class BusinessDelivery  also extends from the base from the "dad" GeneralDelivery
public class BusinessDelivery extends GeneralDelivery {
private String numPhone;
private String email;
private double taxes;


//the constructor of the class
public BusinessDelivery(String address, int numItems, double price, boolean isDelivered,
		String numPhone, String email, double taxes) {
	super(address, numItems, price, isDelivered);
	this.numPhone = numPhone;
	this.email = email;
	this.taxes = taxes;
}
//Getters and Setters
public String getNumPhone() {
	return numPhone;
}

public void save(FileWriter pw,Members member) throws IOException 
{
		  pw.write(this.getArea());
		  pw.write(" "+this.getNumItems());
		  pw.write(" "+this.getPrice());
		  pw.write(" "+this.isDelivered());
		  pw.write(" "+this.getNumPhone());
		  pw.write(" "+this.getEmail());
		  pw.write(" "+this.getTaxes());
		  pw.write(" "+member.getId());
		  pw.write(" "+"BusinessDelivery");
		  pw.write("\n");  
  }
public void setNumPhone(String numPhone) {
	this.numPhone = numPhone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public double getTaxes() {
	return taxes;
}

public void setTaxes(double taxes) {
	this.taxes = taxes;
}
//Getters and Setters

//toString , returning a string thats contains a details about the class
@Override
public String toString() {
	return super.toString()+ " ,BusinessDelivery [numPhone=" + numPhone + ", email=" + email + ", taxes=" + taxes + "]";
}



}
