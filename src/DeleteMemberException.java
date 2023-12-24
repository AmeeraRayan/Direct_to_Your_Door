
public class DeleteMemberException extends Exception {

	public DeleteMemberException(String s)
	{
		super("Sorry we cann't! find the member for the manager:"+s+" to delete"
  				+"\n"+"check if the member is already exit!!");
	}
}
