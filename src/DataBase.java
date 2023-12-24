import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DataBase {
public static Integer countTree=95;
public static ArrayList<Managers> managersSys=new ArrayList<Managers>();
public static Map<Members,GeneralDelivery> ourLastDeliveries=new TreeMap<Members,GeneralDelivery>();
public static Map<Integer,Members> ourMembers=new TreeMap<Integer, Members >();
public static Map<Integer,GeneralDelivery> ourMembersAndDeluveries=new TreeMap<Integer, GeneralDelivery >();
public static ArrayList<SubManager> submanagersSys=new ArrayList<SubManager>();
public static ArrayList<ShortDelivery> alltheshortDeliveries=new ArrayList<ShortDelivery>();

public static boolean addalltheshortDeliveries(ShortDelivery delivery)
{
	 if(delivery==null)
		 return false;

	 else
	 {
		 alltheshortDeliveries.add(delivery);
		 return true;
	 }
}

public static boolean addLastDelivery(Members member,GeneralDelivery delivery)
 {	
	if(member==null|| delivery==null)
		return false;
	 if(DataBase.ourLastDeliveries.put(member, delivery)==null)
		 return false;
	 else
	 {
		 DataBase.ourLastDeliveries.put(member, delivery);
		 return true;
	 }		  
 }
public static boolean addManagers(Managers manager)
{	
	if(manager==null)
		return false;
	DataBase.managersSys.add(manager);
	return true;
}
public static boolean addsubManagers(SubManager submanager)
{
	if(submanager==null)
		return false;
	DataBase.submanagersSys.add(submanager);
	return true;
}
 public static boolean addourMembers(Members member)
 {
	 countTree=countTree+5;
	 if(countTree==null||member==null)
		 return false;	 
	 if(DataBase.ourMembers.put(countTree, member)==null)
		 return false;
	 else
	 {
		 DataBase.ourMembers.put(countTree, member);
	     return true; 
	 }
		
	 
 }
 public static void Addmanagers()
 {
 	 Managers manager1=new Managers("Ameera","1010","ameera",10000,7.5,"054626111","north");
     Managers manager2=new Managers("Lariiin","1111","larin",10500,6,"052326111","south");
     Managers manager3=new Managers("Rameee","0000","rame",9000,10,"050329811","central");
     DataBase.managersSys.add(manager1);
     DataBase.managersSys.add(manager2);
     DataBase.managersSys.add(manager3);
 }

 public static boolean addourMembersAndDeluveries(GeneralDelivery delivery)
 {
	 if(countTree==null||delivery==null)
		 return false;
	 if(DataBase.ourMembersAndDeluveries.put(countTree, delivery)==null)
		 return false;
	 else
	 {
		 DataBase.ourMembersAndDeluveries.put(countTree, delivery);
	     return true; 
	 }
	 
 }


}
