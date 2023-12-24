import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SubManager extends Managers {
	private Integer DeliveriesHandle;
	private ArrayList<ShortDelivery> shortDeliveries;

	public SubManager(String userName, String password, String name, double salary, double seniority,
			String numberPhone, String area ,Integer DeliveriesHandle) 
	{
		super(userName, password, name, salary, seniority, numberPhone, area);
		this.DeliveriesHandle=DeliveriesHandle;
		this.shortDeliveries=new ArrayList<ShortDelivery>();
	}
	@Override
	public void save(FileWriter pw) throws IOException 
	{
			  pw.write(this.getUserName());
			  pw.write(" "+this.getPassword());
			  pw.write(" "+this.getName());
			  pw.write(" "+this.getSalary());
			  pw.write(" "+this.getSeniority());
			  pw.write(" "+this.getNumberPhone());
			  pw.write(" "+this.getArea());
			  pw.write(" "+this.getDeliveriesHandle());
			  pw.write(" "+this.getiD());
			  pw.write("\n");  
	  }
	public boolean addshortDelivery(ShortDelivery delivery)
	 {
        if (delivery==null||shortDeliveries.contains(delivery))//זאת פקודה מיותרת כי כל פעם שמייצרים הזמנה אז אוטומטי יש לה id שונה
       	 return false;
        shortDeliveries.add(delivery);
        return true;	 
	 }
	public ArrayList<ShortDelivery> getShortDeliveries() {
		return shortDeliveries;
	}

	public void setShortDeliveries(ArrayList<ShortDelivery> shortDeliveries) {
		this.shortDeliveries = shortDeliveries;
	}

	public Integer getDeliveriesHandle() {
		return DeliveriesHandle;
	}

	public void setDeliveriesHandle(Integer deliveriesHandle) {
		DeliveriesHandle = deliveriesHandle;
	}

	@Override
	public String toString() {
		return super.toString()+"subManager [DeliveriesHandle=" + DeliveriesHandle + "]";
	}
	
	

}