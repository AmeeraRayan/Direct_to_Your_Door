
public class MemberIsnotFoundexception extends Exception {
	public MemberIsnotFoundexception()
	{
		super("The member you selected is not in the system , so there is no delivery to  delete !!!");
	}
	public MemberIsnotFoundexception(String s)
	{
		super(s+"There is no members to do something like to delete shortdelivery or to add ,check it ");	
	}

}
