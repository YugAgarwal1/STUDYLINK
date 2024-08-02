import java.util.List;
public class MobilePhoneDemo{
	public static void main(String[] args) {
		Contact c = Contact.createContact("Bot","9820098200");
		Contact c1 = Contact.createContact("John","981009800");
		Contact c2 = Contact.createContact("Bot","9820098200");
		
		MobilePhone mp = new MobilePhone("9819098190");
		int status;
		mp.addContact(c);
		mp.addContact(c1);
		mp.addContact("Jane","9820098200");
		List<Contact> contacts = mp.getContacts();
		printContacts(contacts);
		Contact oldContact = Contact.createContact("John","9810098100");
		status = mp.removeContact(oldContact);
		displayMessageAccordingToContactStatus(status,"Deletion");
		contacts = mp.getContacts();
		printContacts(contacts);
		// status = mp.addContact("Robot","9820098200");
		// displayMessageAccordingToContactStatus(status,"Creation");
	}
	private static void printContacts(List<Contact> contacts){
		System.out.println("Contact List:");
		for(Contact contact : contacts){
			System.out.println("Name:"+contact.getName()+" Phone:"+contact.getPhoneNumber());
		}
	}
	private static void displayMessageAccordingToContactStatus(int status,String operation){
		switch(status){
		case ContactConstants.PHONE_NUMBER_ALREADY_EXISTS;
			System.out.println("Phone number already Exists! Could not Perform "+operation+".");
	        break;
	     case ContactConstants.NAME_ALREADY_EXISTS;
			System.out.println("Phone number already Exists! Could not Perform "+operation+".");
	        break;
	        case ContactConstants.PHONE_NUMBER_ALREADY_EXISTS;
			System.out.println("name already Exists! Could not Perform "+operation+".");
	        break;
	        case ContactConstants.CREATED;
			System.out.println("Contact created successfully");
	        break;

	        case ContactConstants.UPDATED;
			System.out.println("Contact updated successfully");
	        break;
	        case ContactConstants.DELETED;
			System.out.println("Contact deleted successfully");
	        break;
            case ContactConstants.CONTACT_DOES_NOT_EXISTS;
			System.out.println("Contact does not exists");
	        break;	        
		}
	}
}