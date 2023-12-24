import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/*======  Implementation =======*/
public class Main {

  public static void main(String[] args) throws IOException {
	  DataBase.Addmanagers();
	  String line=null;
	  String userName1,password1,name,numberPhone,area1;
	  Double salary,seniority; 
	  Managers manager=null;
	  try{
		  BufferedReader reader = new BufferedReader(new FileReader("dataManagers.txt"));
		  if(reader!=null) {
		  while((line = reader.readLine()) != null){
		  StringTokenizer st = new StringTokenizer(line);
		  if(st.countTokens() != 7) {
			  System.out.println("Error line1");}
		  else {
		   userName1 = st.nextToken();
		   password1 = st.nextToken();
		   name=st.nextToken();
		//אין צורך לבדוק האם יש חריגה פה כי כבר בהוספת מנהל דואגת שלא יכניס אלא מספר
		   salary=Double.parseDouble(st.nextToken());
		   seniority=Double.parseDouble(st.nextToken());
		   numberPhone = st.nextToken();
		   area1 = st.nextToken();
		   manager=new Managers(userName1,password1,name,salary,seniority,numberPhone,area1);
		   DataBase.addManagers(manager); 
		  }
		  }
		  reader.close();  
			  }
	  }
	  catch(FileNotFoundException e)
	  {
		 e.getStackTrace(); 
	  }
	  catch(IOException e)
	  {
		  e.getStackTrace();
	  }
	  catch(NullPointerException d)//בהתחלה אין שורות לקרוא בפעם בראשונה לפני שאכניס מנהל ואסויף פרטיו לקובץ ההדפסה
	  {
		  System.out.println(d.getStackTrace());
	  }
	  try{
		  BufferedReader  reader = new BufferedReader(new FileReader("datasubManagers.txt"));
		  if(reader!=null) {
			  while((line = reader.readLine()) != null){
			  StringTokenizer st = new StringTokenizer(line);
			  if(st.countTokens() != 9) {
				  System.out.println("Error line2");}
			  else { 
			   userName1 = st.nextToken();
			   password1 = st.nextToken();
			   name=st.nextToken();
			//אין צורך לבדוק האם יש חריגה פה כי כבר בהוספת מנהל דואגת שלא יכניס אלא מספר
			   salary=Double.parseDouble(st.nextToken());
			   seniority=Double.parseDouble(st.nextToken());
			   numberPhone = st.nextToken();
			   area1 = st.nextToken();
			   Integer deliveriesHandle=Integer.parseInt(st.nextToken());
			   Integer id_submanager=Integer.parseInt(st.nextToken());
			   SubManager subManager=new SubManager(userName1,password1,name,salary,seniority,numberPhone,area1,deliveriesHandle);
			   DataBase.addsubManagers(subManager);		   
		  }
			  }
			  reader.close();
		  }}catch(FileNotFoundException f)
	  {
				 f.getStackTrace(); 
			  }
			  catch(IOException f)
			  {
				  f.getStackTrace();
			  }
			  catch(NullPointerException d)//בהתחלה אין שורות לקרוא בפעם בראשונה לפני שאכניס מנהל ואסויף פרטיו לקובץ ההדפסה
			  {
				  System.out.println(d.getStackTrace());
			  }
	  Members member=null;
	  Managers managertempp=null;
	  try {
		  BufferedReader reader = new BufferedReader(new FileReader("dataMembers.txt"));
	  if(reader!=null) {
		  while((line = reader.readLine()) != null){
		  StringTokenizer st = new StringTokenizer(line);
			  if(st.countTokens() != 5) {
				  System.out.println("Error line3");}
			  else {
				  String f_name=st.nextToken();
				  String l_name=st.nextToken();
				   area1=st.nextToken();
				  Integer id_member=Integer.parseInt(st.nextToken());
				  Integer id_manager=Integer.parseInt(st.nextToken());
				   member=new Members(f_name,l_name,area1);
				   if(member.getId()!=id_member) 
				   {
				     member.setId(id_member);
				     Members.setGenerateCode(id_member+1);
				   }
				  for(int j=0;j<DataBase.managersSys.size();j++)
				  {
					  if(DataBase.managersSys.get(j).getArea().equals(area1)&&
							  DataBase.managersSys.get(j).getiD()==id_manager) {
						      DataBase.managersSys.get(j).addMmember(member);
						      managertempp=DataBase.managersSys.get(j);
						  
					  }
				  }
				 
			  }
		  }
		  reader.close();
		  }
	  }catch(FileNotFoundException s)
	  {
			 s.getStackTrace(); 
		  }
		  catch(IOException f)
		  {
			  f.getStackTrace();
		  }
		  catch(NullPointerException d)//בהתחלה אין שורות לקרוא בפעם בראשונה לפני שאכניס מנהל ואסויף פרטיו לקובץ ההדפסה
		  {
			  System.out.println(d.getStackTrace());
		  }
   		  
   try {
	   BufferedReader reader = new BufferedReader(new FileReader("deliveries.txt"));

		  if(reader!=null) {
			  while((line = reader.readLine()) != null){
			          StringTokenizer st = new StringTokenizer(line);
			          if(st.countTokens() != 6&&st.countTokens() != 7&&st.countTokens() != 9&&st.countTokens() != 20) {
						  System.out.println("Error line4");}
			          else {
			        	 if(st.countTokens() == 6) {
					  String address=st.nextToken();
					  Integer numItems=Integer.parseInt(st.nextToken());
					  Double price=Double.parseDouble(st.nextToken());
					  Boolean isDelivered=Boolean.parseBoolean(st.nextToken());
					  Integer id_member=Integer.parseInt(st.nextToken());
					  String type=st.nextToken();
			    	  GeneralDelivery deliver1=new GeneralDelivery(address,numItems,price,isDelivered);
					  for (Map.Entry<Integer, Members> m :managertempp.getMembers().entrySet())
						{
							if(m.getValue().getId()==id_member)
							{
								m.getValue().addNewDelivery(deliver1);
								DataBase.addLastDelivery(m.getValue(), deliver1);//added a member with his delivery and actually the last one added 
								DataBase.addourMembers(m.getValue());//all the members that have a delivery is in this DataBase
								DataBase.addourMembersAndDeluveries(deliver1);  	
							}
						}
			          }
			        	 else if(st.countTokens() == 7)
			        	 {
			        		 String address=st.nextToken();
							  Integer numItems=Integer.parseInt(st.nextToken());
							  Double price=Double.parseDouble(st.nextToken());
							  Boolean isDelivered=Boolean.parseBoolean(st.nextToken());
							   Double additionalPay =Double.parseDouble(st.nextToken());
							  Integer id_member=Integer.parseInt(st.nextToken());
							  String type=st.nextToken();
							  ExpressDelivery deliver1=new ExpressDelivery(address,numItems,price,isDelivered,additionalPay);
							  for (Map.Entry<Integer, Members> m :managertempp.getMembers().entrySet())
								{
									if(m.getValue().getId()==id_member)
									{
										m.getValue().addNewDelivery(deliver1);
										DataBase.addLastDelivery(m.getValue(), deliver1);//added a member with his delivery and actually the last one added 
										DataBase.addourMembers(m.getValue());//all the members that have a delivery is in this DataBase
										DataBase.addourMembersAndDeluveries(deliver1);  

									}
								} 
			        	 }
			        	 else if(st.countTokens() == 9)
			        	 {
			        		  String address=st.nextToken();
							  Integer numItems=Integer.parseInt(st.nextToken());
							  Double price=Double.parseDouble(st.nextToken());
							  Boolean isDelivered=Boolean.parseBoolean(st.nextToken());
							  String numPhone =st.nextToken();
							  String email =st.nextToken();
							  Double taxes=Double.parseDouble(st.nextToken());
							  Integer id_member=Integer.parseInt(st.nextToken());
							  String type=st.nextToken();
							  BusinessDelivery deliver1=new BusinessDelivery(address,numItems,price,isDelivered,numPhone,email,taxes);
							  for (Map.Entry<Integer, Members> m :managertempp.getMembers().entrySet())
								{
									if(m.getValue().getId()==id_member)
									{
										m.getValue().addNewDelivery(deliver1);
										DataBase.addLastDelivery(m.getValue(), deliver1);//added a member with his delivery and actually the last one added 
										DataBase.addourMembers(m.getValue());//all the members that have a delivery is in this DataBase
										DataBase.addourMembersAndDeluveries(deliver1);  

									}
								} 
			        	 }
			        	 else if(st.countTokens() ==20)
			        	 {
			        		 String address=st.nextToken();
							  Integer numItems=Integer.parseInt(st.nextToken());
							  Double price=Double.parseDouble(st.nextToken());
							  Boolean isDelivered=Boolean.parseBoolean(st.nextToken());
							  String s1=st.nextToken();
							  String month=st.nextToken();
							  if(month.equals("Jan"))
							  {
								  month="01";
							  }
							  else if(month.equals("Feb"))
							  {
								  month="02";  
							  }
							  else if(month.equals("Mar"))
							  {
								  month="03";  
							  } else if(month.equals("Apr"))
							  {
								  month="04";  
							  } else if(month.equals("May"))
							  {
								  month="05";  
							  } else if(month.equals("June"))
							  {
								  month="06";  
							  } else if(month.equals("July"))
							  {
								  month="07";  
							  } else if(month.equals("Aug"))
							  {
								  month="08";  
							  } else if(month.equals("Sep"))
							  {
								  month="09";  
							  } else if(month.equals("Oct"))
							  {
								  month="10";  
							  }else if(month.equals("Nov"))
							  {
								  month="11";  
							  } else if(month.equals("Dec"))
							  {
								  month="12";  
							  }
							  String day=st.nextToken();
							  String s4=st.nextToken();
							  String s5=st.nextToken();
							  String year=st.nextToken();
		                      String date=year+"/"+month+"/"+day;
							  Date deliverydate=new Date(date);
							  String startingPoint=st.nextToken();
							  String pointOfDisembarkation=st.nextToken();
							  Integer distination=Integer.parseInt(st.nextToken());
							  Double priceKm=Double.parseDouble(st.nextToken());
							  String f_name=st.nextToken();//member
							  String l_name=st.nextToken();
							   area1=st.nextToken();
							  Integer id_member=Integer.parseInt(st.nextToken());
							  String type=st.nextToken();
							  Integer id_subManager=Integer.parseInt(st.nextToken());
							  ShortDelivery shortDelivery=new ShortDelivery(address,numItems
									  ,price,isDelivered,deliverydate,startingPoint,pointOfDisembarkation,
									  distination,priceKm,managertempp.getMembers().get(id_member));
							  for(int z=0;z<DataBase.submanagersSys.size();z++)
							  {
								  if(DataBase.submanagersSys.get(z).getiD()== id_subManager)
								  {
									  for (Map.Entry<Integer, Members> m :managertempp.getMembers().entrySet())
										{
											if(m.getValue().getId()==id_member)
											{
												 DataBase.submanagersSys.get(z).addshortDelivery(shortDelivery);
												 m.getValue().addNewDelivery(shortDelivery);
												 DataBase.addLastDelivery(m.getValue(), shortDelivery);
												 DataBase.addourMembers(m.getValue());
												 DataBase.addourMembersAndDeluveries(shortDelivery);
												 DataBase.addalltheshortDeliveries(shortDelivery); 	
											}
										}
									  
								  }
							  } 
			        	 }
			  }

			  }
				  reader.close();
			  }
   }catch(FileNotFoundException s)
	  {
			 s.getStackTrace(); 
		  }
		  catch(IOException f)
		  {
			  f.getStackTrace();
		  }
		  catch(NullPointerException d)//בהתחלה אין שורות לקרוא בפעם בראשונה לפני שאכניס מנהל ואסויף פרטיו לקובץ ההדפסה
		  {
			  System.out.println(d.getStackTrace());
		  }	
  
	  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 ManagerForm frame = new ManagerForm();
						frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
  Scanner in=new Scanner(System.in);
  boolean flag=true,flag2=true;//to check if manager is exit in the system or not
  String userName,password;
  //DataBase.Addmanagers();//add managers
  Managers managerCheck=null;//tempManager to enter with him to menu
  Integer mode=7;//Infinite loop to keep the manger login again and again
  do {
	  
  while(flag2)//if the manager entered uncorrected UserName or password then should to enter details again
  {
	System.out.println("Enter your Username please:");
    userName=in.next();
    System.out.println("Enter your password:");
    password=in.next();
    for(int i=0;i<3;i++) 
    {
        if(DataBase.managersSys.get(i).getUserName().equals(userName)
        		&&DataBase.managersSys.get(i).getPassword().equals(password))
        {
        	System.out.println("welcome to our Company's menu");
    	    managerCheck=DataBase.managersSys.get(i);//saving the same reference to use soon
    	    flag2=false;//finding manager in the system so now the manager entered to his system
        }

    }
    if(flag2)//if we here as the manager entered a wrong  UserName or a wrong Password
	       System.out.println("Sorry your Username or Password is wrong!, try again:)");
 			
	}
     flag=true; //in case the manager is selected to exit,and in case the flag true then the manager keep choosing from the menu what he want 
     while(flag) //as long as the manager does not select 7 the loop while does not end
     { 
    	 //The menu of our system
    	   System.out.println("The Menu is: ");
	       System.out.println("Enter what you want to do:"
	       		+ "\n" +"1-->AddMember to the manager with the same area"
    	           +"\n"+"2-->DeleteMember from the manager that responsible of the area"+"\n"+"3-->add a new delivery to the member"
	                +"\n"+"4-->show the detalis of last delivery and the details of all the deliveres that the memeber ordered "+
    	           "\n"+"5-->show all the deliveiries about a specific area"+"\n"+"6-->show all the members and all the deliveries"+"\n"+"7-->End and exit!,and let another manager to login");
	    	int choice=in.nextInt();//choosing from the menu if 1 as adding member ,2 as deleting 3 adding delivery to member that exit in the system,4show details,5show deliveries to specific area,6show every thing in the system  and 7 exit
	    	//assuming the input is always  integer !
	    	boolean flag1=true;
	    	String fName,lName,area;
	    	String address;
	    	switch(choice)
	    	{
		      case 1:
		    	  System.out.println("Enter a member to add!");
		    	  System.out.println("Enter first name:");
		    	  fName=in.next();
		    	  System.out.println("Enter the last name:");
		    	  lName=in.next();
		    	  System.out.println("Enter from where the member:");
		    	  area=in.next();
		    		 if( managerCheck.getArea().equals(area))//checking if the member has a same area of manager's area
		    		 {
				    	   member=new Members(fName,lName,area);	  
		    	       	    boolean check=managerCheck.addMmember(member);//return true if succeeded to add
		    	       	   if(check)// if true if the member has a same area		    		 
		    	       	   {
				    	     System.out.println("The member was added successfully!");  
				    	     System.out.println("And his details: "+"\n"+ member.toString());
		    	       	   }
		    	       	   
				    	    else
				    	    {
				    	    	System.out.println(member.getFirstName()+" was not add successfully!"); 
	                            System.out.println("That's because the manager entered the same member or a different reason ,shoud to check it");
				    	    }
		    	       	   flag1=false; 
		    	    } 
		    	  if(flag1)//if we did not find member that's his area suitable to the area's manager to add
		    	  {
		    		 System.out.println("You have a problem ,or you entered an area that does not fit your area or ");
		    		 System.out.println("you selected an area that is not  north or south or central,try again and check your choice very well:)");  
		    	  }		    		  
		    	    break;	    
		      case 2:
		    	  System.out.println("you selected a choice to delete a member!");
		    	  System.out.println("Enter code Member to delete!");
		    	  int code=in.nextInt();//checking if the member is already exit in his system 
		    	  /*The function delMember returning true if succeeded to delete 
		    	   checking if there is a member thats already exits in system 
		    	   by code the member 
		    	   other it is returning false because there is nothing to delete if he is not exit
		    	    */	 
		    	   
		    	    if(managerCheck.delMember(code))//if we here is there is a member to delete
		    	    {
		    		  System.out.println("The member with code: "+ code +" was deleted successfully"); 
		    		  if(DataBase.ourMembers.containsValue(new Members(code)))//if deleted a member should to delete from all the DataBase that we have 
		    		   {
			    			for(Map.Entry<Integer, Members> mEntry :DataBase.ourMembers.entrySet())
			    			{
			    				if(mEntry.getKey()!=null)
			    				{
			    					if(((Members)mEntry.getValue()).getId().equals(code))//if there a member that make an order he the same member that deleted as should delete it also from this dataBase 
			    					{
			    						//removes a key value pair from the map
			    						DataBase.ourMembersAndDeluveries.remove(mEntry.getKey());			    						
			    					}
			    				}
			    			}

		    		  }
		    	    }
		    	   else
		    	   {
		    		  System.out.println("Sorry we cann't! find the member for the manager:" +managerCheck.getName()+ " to delete");
		    		  System.out.println("check if the member is already exit!!");
		    	   }
		    	    
		    	  break;
		      case 3:
		    	System.out.println("Enter a delivery to add:");
		    	System.out.println("choose if you want a General or Express or Buisness delivery! to add");
		    	String checkTypeDelivery=in.next();//checking the type of the delivery thats the manager will add 
		    	int numItems;
		    	Integer code1;
		    	double price,taxes,AdditionalPay;
		    	boolean isDelivered;
		    	String numPhone,email;
		    	flag1=true;//if the member is exit as adding delivery for him and exit from "for"
		    	if(checkTypeDelivery.equals("GeneralDelivery"))
		    	{
			    	System.out.println("Enter the id-member for which member wants to give him a delivery");
			         code1=in.nextInt();//entering a code to check if there a member suitable in system to add a delivery for him 
	    			for(int j=0;j<managerCheck.getMembers().size()&&flag1;j++)//checking a member in system's manager 
	    			{
	    				if(managerCheck.getMembers().containsKey(code1))//if already there is a member thats have a same code 
	    				{
	    					// if we here as the manager succeeded to add a delivery ,then entering what's the details's delivery 
	    		    		System.out.println("Enter for delivery: address,numItems,price,and if is delivered!");
	    		    		address=in.next();
	    		    		numItems=in.nextInt();
	    		    		price=in.nextDouble();
	    		    		isDelivered=in.nextBoolean();
	    		    		GeneralDelivery deliver1=new GeneralDelivery(address,numItems,price,isDelivered);
	    		    		//if we already succeeded to add a new delivery for member then check is true 
	    					boolean check1=managerCheck.getMembers().get(code1).addNewDelivery(deliver1);
	    					if(check1)//if we are here as succeeded to add a delivery
	    					{
	    						System.out.println("adding a new delivery is succeeded");
	    						DataBase.addLastDelivery(managerCheck.getMembers().get(code1), deliver1);//added a member with his delivery and actually the last one added 
	    						DataBase.addourMembers(managerCheck.getMembers().get(code1));//all the members that have a delivery is in this DataBase
	    						DataBase.addourMembersAndDeluveries(deliver1);//the database has all the deliveries that ordered the members , also if member ordered more than one  delivery , each order has a unique code 
	    						flag1=false;
	    					}
	    					else
	    					{
	    						System.out.println("sorry we didn't succeed! to add a Generaldelivery");
	    						flag1=false;

	    					}
	    				}
	    			}
	    			if(flag1)
	    			      System.out.println("We didn't find a member to add a delivery for him,it doesn't exit");

		    	}
		    	else if(checkTypeDelivery.equals("BusinessDelivery"))//Everything I said above about generalDelivery applies here as well
		    	{
			    	System.out.println("Enter the id-member for which member wants to give him a delivery");
			         code1=in.nextInt();//entering a code to check if there a member suitable in system to add a delivery for him 

		    			for(int j=0;j<managerCheck.getMembers().size()&&flag1;j++)
		    			{
		    				if(managerCheck.getMembers().containsKey(code1))
		    				{
		    		    		System.out.println("Enter for BusinessDelivery: address,numItems,price,and if is delivered! ");
		    		    		System.out.println("Also you have to add numPhone,email and taxes");
		    		    		area=in.next();
		    		    		numItems=in.nextInt();
		    		    		price=in.nextDouble();
		    		    		isDelivered=in.nextBoolean();
		    		    		numPhone=in.next();
		    		    		email=in.next();
		    		    		taxes=in.nextDouble();
		    		    		GeneralDelivery deliver1=new BusinessDelivery(area,numItems,price,isDelivered,numPhone,email,taxes);
		    					boolean check1=managerCheck.getMembers().get(code1).addNewDelivery(deliver1);
		    					if(check1)
		    					{
		    						System.out.println("adding a new delivery is succeeded");
		    						DataBase.addLastDelivery(managerCheck.getMembers().get(code1), deliver1);
		    						DataBase.addourMembers(managerCheck.getMembers().get(code1));
		    						DataBase.addourMembersAndDeluveries(deliver1);
		    						flag1=false;
		    					}
		    					else
		    					{
		    						System.out.println("sorry we didn't succeed! to add a businessDelivery");
		    						flag1=false;
		    					}
		    				}
		    			}
		    			if(flag1)
		    			      System.out.println("We didn't find a member to add a delivery for him,it doesn't exit");
		    	}
		    	else if(checkTypeDelivery.equals("ExpressDelivery"))//Everything I said above  about generalDelivery applies here as well
		    	{
			    	System.out.println("Enter the id-member for which member wants to give him a delivery");
			        code1=in.nextInt();
		    			for(int j=0;j<managerCheck.getMembers().size()&&flag1;j++)
		    			{
		    				if(managerCheck.getMembers().containsKey(code1))
		    				{
		    					System.out.println("Enter for ExpressDelivery: address,numItems,price,and if is delivered! ");
		    		    		System.out.println("Also you have to add AdditionalPay");
		    		    		area=in.next();
		    		    		numItems=in.nextInt();
		    		    		price=in.nextDouble();
		    		    		isDelivered=in.nextBoolean();
		    		    		AdditionalPay=in.nextDouble();
		    		    		GeneralDelivery deliver1=new ExpressDelivery(area,numItems,price,isDelivered,AdditionalPay);
		    					boolean check1=managerCheck.getMembers().get(code1).addNewDelivery(deliver1);
		    					if(check1)
		    					{
		    						System.out.println("adding a new delivery is succeeded");
		    						DataBase.addLastDelivery(managerCheck.getMembers().get(code1), deliver1);
		    						DataBase.addourMembers(managerCheck.getMembers().get(code1));
		    						DataBase.addourMembersAndDeluveries(deliver1);
		    						flag1=false;
		    					}
		    					else
		    					{
		    						System.out.println("sorry we didn't succeed! to add a ExpressDelivery");
		    						flag1=false;

		    					}
		    				}
		    		
		    			}
		    			if(flag1)
		    			      System.out.println("We didn't find a member to add a delivery for him,it doesn't exit");
		    	}
		    	else//if there is not type suitable for the delivery's area 
		    		System.out.println("You enterd a type of delivery that is not exit in our menu,try another type");
		    	  break;
		      case 4:
		    	  System.out.println("Enter a code member to show some details about member's delivery ");
		    	   Integer codee=in.nextInt();	
		    	   //get(code) returns the value to which the specified key is mapped.if key does not exist return null
		    	   if(managerCheck.getMembers().get(codee)==null)//if the member does not exit in the HashMap
		    	   {
		    		   System.out.println("There is no such code like this to show some detalis for it");
		    		   break;
		    	   }
		    	   if(DataBase.ourLastDeliveries.containsKey(managerCheck.getMembers().get(codee)))//if we here as there is a delivery to show 
		    	   {
			    	   System.out.println(DataBase.ourLastDeliveries.get(managerCheck.getMembers().get(codee)).toString());  
			    	   System.out.println("And his details about all the deliveries that he ordered");
			    	   System.out.println(managerCheck.getMembers().get(codee).getDeliveries());
		    	   }
		    	   else
		    		   System.out.println("The member which its code: "+ codee+" does not has order yet");//if member in the system and has no delivery yet
		    	  break;
		      case 5:
		    	  System.out.println("Enter an area please to show many detalis about all the deliveries in this area");
		    	  System.out.println("Select north , south or central :)");
		    	  area=in.next();
		    	  boolean flag3=true;//checking if the area appropriate for each manager  
		    	  boolean flag6=true;//if member was deleted as print a Appropriate message 
		    	  boolean check5=area.equals("north")||area.equals("central")||area.equals("south");
		    	  if(check5)
                  {
		    	  for(int i=0;i<DataBase.managersSys.size();i++)
		    	  {
		    		  if(DataBase.managersSys.get(i).getArea().equals(area))//if1
		    		  {
		    			for(Map.Entry<Integer, Members> mEntry :DataBase.ourMembers.entrySet())
		    			{
		    				if(mEntry.getKey()!=null)//if2
		    				{
		    					if(((Members)mEntry.getValue()).getArea().equals(area))//if3
		    					{
		    						if(DataBase.ourMembersAndDeluveries.get(mEntry.getKey())!=null)//if the member deleted as there is no key to map to the delivery there is no member that exit in the system now ,so he does not have a delivery
		    						{
		    					      System.out.println("Unique code for this delivery is " + mEntry.getKey()+" ,and the delivery's details:"+DataBase.ourMembersAndDeluveries.get(mEntry.getKey()));
				    			      flag3=false;
		    						}
		    						else
		    						{
		    							System.out.println("The member thats code "+ mEntry.getKey() +" was deleted so ,there is no deliveries to show");
		    							flag6=false;
		    						}
		    					}//if3
		    				}//if2
		    			}//for
		    		  }//if1		    
		    	  }	//for	    		  
		    	  if(flag3&&flag6) 
		    	  {
		    		System.out.println("This area : "+ area+" does not have an orderes yet!");  
		    	  }
		    	  }//check5
		    	  else
		    	  {
		    		  System.out.println("You entered an area thats does not exit in each manager");
		    	  }
		    	  
		    	  break;
		      case 6:
		    	  for(Integer j=0;j<DataBase.managersSys.size();j++)
		    	  {
		    		  if(DataBase.managersSys.get(j).getMembers().size()!=0) //if there at least one member then print the member and his deliveries 
		    		 {
                     System.out.println("The members for the manager "+ DataBase.managersSys.get(j).getName().toUpperCase()+" :");
                     System.out.println(DataBase.managersSys.get(j).getMembers());
                     }
		    		  else {System.out.println("The manager "+ DataBase.managersSys.get(j).getName().toUpperCase()+" dose not have members yet to show!");}
		    	  }
		    	  break;
		      case 7://exit!!!!!!!!!!!!!!and login
		    	  System.out.println("You selected to exit from the menu see you soon :))");
		    	  System.out.println("Another manager can login");
		    	  flag=false;//to exit from the loop while from the menu
		    	  flag2=true;//back to login to enter UserName and password for another manager or sample to login again
		    	  break;
		    	  default:
		    		  System.out.println("You selected a choice that does not exit in the menu!");
		    		  System.out.println("You should selecet a number between 1-7 , try again :)");
		    }
    }
  } while(mode==7);//infinite Loop
	}
}

    