public class Contact{
	private String name ;
	private String phoneNumber;

	private Contact(String name , String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber ;
	}
	public String getName(){return thsi.name};
	public String getPhoneNumber(){return this.phoneNumber};
	public void setName(String name){this.name=name;}
	public void setPhoneNumbe(String phoneNumber){this.phoneNumber = phoneNumber;}

	public static Contact createContact(Strig name ,String phoneNumber){
		return new Contact(name,phoneNumber);
	}
	@Override
	public String toString(){
		return "["+this.name+","+this.phoneNumber+"]";
	}
	
}