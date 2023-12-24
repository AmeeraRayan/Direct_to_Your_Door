import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

//the class GeneralDelivery
public class GeneralDelivery {
protected String address;
protected Integer numItems;
protected double price;
protected static Integer IDCOUNTER = 1;
protected Integer id;
protected boolean isDelivered;
//the constructor 
public GeneralDelivery(String address, int numItems, double price, boolean isDelivered) {
	super();
	this.address = address;
	this.numItems = numItems;
	this.price = price;
	this.id = IDCOUNTER++;
	this.isDelivered = isDelivered;
}
/********Getters and Setters******/
public GeneralDelivery(Integer id)
{
	this.id=id;
}	
public void save(FileWriter pw,Members member) throws IOException 
{
		  pw.write(this.getArea());
		  pw.write(" "+this.getNumItems());
		  pw.write(" "+this.getPrice());
		  pw.write(" "+this.isDelivered());
		  pw.write(" "+ member.getId());
		  pw.write(" "+"GeneralDelivery");
		  pw.write("\n");  
  }
public String getArea() {
	return address;
}
public void setArea(String area) {
	this.address = area;
}

public static int getIdCounter() {
	return IDCOUNTER;
}
public static void setIdCounter(Integer idCounter) {
	GeneralDelivery.IDCOUNTER = idCounter;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public boolean isDelivered() {
	return isDelivered;
}
public void setDelivered(boolean isDelivered) {
	this.isDelivered = isDelivered;
}

public Integer getNumItems() {
	return numItems;
}
public void setNumItems(Integer numItems) {
	this.numItems = numItems;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
/********Getters and Setters******/
//toString , returning a string thats contains a details about the class 
@Override
public String toString() {
	return "GeneralDelivery [address=" + address + ", numItems=" + numItems + ", price=" + price + ", id=" + id
			+ ", isDelivered=" + isDelivered + " ]"+"\n";
}
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	GeneralDelivery other = (GeneralDelivery) obj;
	return Objects.equals(id, other.id);
}


}
