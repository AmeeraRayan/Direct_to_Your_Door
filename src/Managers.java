import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
//the class Managers
public class Managers {
protected String userName;
protected String password;
protected String name;
protected Integer iD;
protected static Integer IDCOUNTER=1; //ייחודי וגם סידורי
protected double salary;
protected double seniority;
protected String numberPhone;
protected String area;
protected HashMap<Integer,Members> members;
//every manager has different id so we can not find manager or submanager thats has the same id so we did not need to do exception if entered manager because each one enter to system entering with different id 
//the constructor of the class
public Managers(String userName, String password, String name, double salary, double seniority,
		String numberPhone, String area) {
	super();
	this.userName = userName;
	this.password = password;
	this.name = name;
	this.iD = IDCOUNTER++; //to save the value
	this.salary = salary;
	this.seniority = seniority;
	this.numberPhone = numberPhone;
	this.area = area;
	this.members = new HashMap<Integer,Members>();
}
/*******Getters and Setters******/
public static Integer getIdCounter() {
	return IDCOUNTER;
}

public static void setIdCounter(Integer idCounter) {
	Managers.IDCOUNTER = idCounter;
}

public void save(FileWriter pw) throws IOException 
{
		  pw.write(this.getUserName());
		  pw.write(" "+this.getPassword());
		  pw.write(" "+this.getName());
		  pw.write(" "+this.getSalary());
		  pw.write(" "+this.getSeniority());
		  pw.write(" "+this.getNumberPhone());
		  pw.write(" "+this.getArea());
		  pw.write("\n");  
  }
public static Integer getIDCOUNTER() {
	return IDCOUNTER;
}
public static void setIDCOUNTER(Integer iDCOUNTER) {
	IDCOUNTER = iDCOUNTER;
}
public HashMap<Integer, Members> getMembers() {
	return members;
}
public void setMembers(HashMap<Integer, Members> members) {
	this.members = members;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public double getSeniority() {
	return seniority;
}
public void setSeniority(double seniority) {
	this.seniority = seniority;
}
public int getiD() {
	return iD;
}
public void setiD(Integer iD) {
	this.iD = iD;
}
public String getNumberPhone() {
	return numberPhone;
}
public void setNumberPhone(String numberPhone) {
	this.numberPhone = numberPhone;
}

public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
/*******Getters and Setters******/

//toString , returning a string thats contains a details about the class 
@Override
public String toString() {
	return "Managers [userName=" + userName + ", password=" + password + ", name=" + name + ", iD=" + iD + ", salary="
			+ salary + ", seniority=" + seniority + ", numberPhone=" + numberPhone + ", area=" + area ;
}
//this function returning true if succeeding to add a member ,else false
public boolean addMmember(Members member)
{

			if(member==null ||member.getId()==null)//if the member we adding is null  
			{
				return false;
			}          
            //adding to the member's array
			members.put(member.getId(), member);
            return true;	 
}
//the function returning true if succeeded to delete a member else false
public boolean delMember(Integer iD)
{

	   if(members.containsKey(iD))
	   {
		 members.remove(iD);
		 return true;
	   }
	return false;
}
public boolean equals(Object obj) {//returning true if the two have a same id else false 
	if(obj==null)
		return false;
	if(this==obj)
		return true;
	if(this.getClass()!=obj.getClass())
		return false;
	Managers manager=(Managers)obj;
	if(this.getUserName().equals(manager.getUserName())&&this.getPassword().equals(manager.getPassword()))
			return true;
	return false;
	}
}

