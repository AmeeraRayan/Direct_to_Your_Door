import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//the class Members
public class Members implements Comparable<Members> {
private String firstName;
private String lastName;
private Integer id;
private static Integer GENERATECODE=1;
private String area;
private ArrayList<GeneralDelivery> deliveries;
//the constructor of the class
public Members(String firstName, String lastName,String area)
{
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.area = area;
	this.deliveries =new ArrayList<GeneralDelivery>();
	this.id=GENERATECODE++;	
}
public void save(FileWriter pw,Managers manager) throws IOException 
{
	  pw.write(this.getFirstName());	
	  pw.write(" "+this.getLastName());
	  pw.write(" "+this.getArea());
	  pw.write(" "+this.getId());
	  pw.write(" "+manager.getiD());//מכניסה פרטים המנהל שהכניס אותו
	  pw.write("\n"); 
	  
}

//Another constructor
public Members(Integer id)
{
	super();
	this.id=id;
}
/*********Getters and Setters**********/
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}


public static Integer getGENERATECODE() {
	return GENERATECODE;
}
public static void setGENERATECODE(Integer gENERATECODE) {
	GENERATECODE = gENERATECODE;
}
public ArrayList<GeneralDelivery> getDeliveries() {
	return deliveries;
}
public void setDeliveries(ArrayList<GeneralDelivery> deliveries) {
	this.deliveries = deliveries;
}
public static  Integer getGenerateCode() {
	return GENERATECODE;
}
public static void setGenerateCode(Integer generateCode) {
	Members.GENERATECODE = generateCode;
}
/*********Getters and Setters**********/


@Override
public boolean equals(Object obj) {//returning true if the two have a same id else false 
	if(obj==null)
		return false;
	if(this==obj)
		return true;
	if(this.getClass()!=obj.getClass())
		return false;
	Members member=(Members)obj;
	if(this.id!= member.id)
		return false;
	return true;

	}
//adding a delivery to member already exit in system if succeeded as the function returning true else false 
	public boolean addNewDelivery(GeneralDelivery delivery)
	 {
         if (delivery==null||deliveries.contains(delivery))
        	 return false;
         deliveries.add(delivery);
         return true;	 
	 }
	

@Override
	public String toString() {
		return "Members [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", area=" + area
				+ ", deliveries=" + deliveries.toString() + "]";
	}
	@Override
	public int compareTo(Members member) {
			return this.getLastName().compareTo(member.getLastName());

	}
	


	
}