import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ShortDelivery extends GeneralDelivery {
    private Date deliverydate;
    private String startingPoint;
    private String pointOfDisembarkation;
	private Integer distination;
    private Double priceKm;
    private Members member;
    public ShortDelivery(String address, int numItems, double price, boolean isDelivered, Date deliverydate,
			String startingPoint, String pointOfDisembarkation, Integer distination, Double priceKm, Members member) {
		super(address, numItems, price, isDelivered);
		this.deliverydate = deliverydate;
		this.startingPoint = startingPoint;
		this.pointOfDisembarkation = pointOfDisembarkation;
		this.distination = distination;
		this.priceKm = priceKm;
		this.member = member;
	}
	
    public void save(FileWriter pw,SubManager submanagerCheck) throws IOException 
    {
    		  pw.write(this.getArea());
    		  pw.write(" "+this.getNumItems());
    		  pw.write(" "+this.getPrice());
    		  pw.write(" "+this.isDelivered());
    		  pw.write(" "+this.getDeliverydate());
    		  pw.write(" "+this.getStartingPoint());
    		  pw.write(" "+this.getPointOfDisembarkation());
    		  pw.write(" "+this.getDistination());
    		  pw.write(" "+this.getPriceKm());
    		  pw.write(" "+this.getMember().getFirstName());
    		  pw.write(" "+this.getMember().getLastName());
    		  pw.write(" "+this.getMember().getArea());
    		  pw.write(" "+this.getMember().getId());
    		  pw.write(" "+"ShortDelivery");
    		  pw.write(" "+submanagerCheck.getiD());//to know for me the delivery 
    		  pw.write("\n");  
      }
	public Date getDeliverydate() {
		return deliverydate;
	}
	
	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}
	public String getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public String getPointOfDisembarkation() {
		return pointOfDisembarkation;
	}
	public void setPointOfDisembarkation(String pointOfDisembarkation) {
		this.pointOfDisembarkation = pointOfDisembarkation;
	}
	public Integer getDistination() {
		return distination;
	}
	public void setDistination(Integer distination) {
		this.distination = distination;
	}
	public Double getPriceKm() {
		return priceKm;
	}
	public void setPriceKm(Double priceKm) {
		this.priceKm = priceKm;
	}
	public Members getMember() {
		return member;
	}
	public void setMember(Members member) {
		this.member = member;
	}
	
	@Override
	public String toString() {
		return "ShortDelivery [deliverydate=" + deliverydate + ", startingPoint=" + startingPoint
				+ ", pointOfDisembarkation=" + pointOfDisembarkation + ", distination=" + distination + ", priceKm="
				+ priceKm +"Members [Firstname is : "+member.getFirstName()+" ,lastName is: "+ member.getLastName()+" id is: "+ member.getId()+" And his area: "+member.getArea()+"]";
						
	}



    
	


}
