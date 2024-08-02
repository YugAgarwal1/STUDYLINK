import java.util.ArrayList;
import jva.util.List;

public class MobilePhone implements ContactConstants{
	private String myNumber;
	contacts = new ArrayLisr<>();
}
public MobilePhone(String myNumber){
	this.myNumber = myNumber;
	contacts = new ArrayList<>();
}
public int addContact(String name , String phoneNumber){
Contact contact = Contact.createContact(name,phoneNumber);
return this.addContact(contact);
}
public void addContact(Contact contact){
	if(findByName(contact.getName())!=null){
		return NAME_ALREADY_EXISTS
	}
	if(findByPhoneNumber(contact.getPhoneNumber())!=null){
		return PHONE_NUMBER_ALREADY_EXISTS;
	}
	contacts.add(contact);
	return CREATED;
}

public int updateContact(Contact oldContact, Contact newContact){
	int index = indexOf(oldContact);
	if(index<0){
		return CONTACT_DOES_NOT_EXISTS;
	}
	if(findByName(newContact.getName())!=null){
		return NAME_ALREADY_EXISTS
	}
	if(findByPhoneNumber(newContact.getPhoneNumber())!=null){
		return PHONE_NUMBER_ALREADY_EXISTS;
	}
	contact.set(index,newContact);
	return UPDATED;
}
publci void removeContact(Contact contact){
	int index = indexOf(contact);
	if(index<0){
		return CONTACT_DOES_NOT_EXISTS;
	}
	contacts.remove(index);
	return DELETED;
}
public Contact findByPhoneNumer(String phoneNumber){
	for(Contact contact : contacts){
		if(contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
			return contact;
		}
	}
	return null;
}
public Contact findByName(String name){
	for(Contact contact : contacts){
		if(contact.getName.equalsIgnoreCase(name)){
			return contact;
		}
	}
	return null;
}
public List<Contact> getContacts(){
	return contacts;
}
private int indexOf(Contact key){
	for(int i=0 ; i<contacts.size() ;i++){
		Contact contact = contacts.get(i);
		if(comparByName(contact,key)&&compareByPhoneNumber(contact.key)){
			return i;
		}
	}
	return -1;
}
private boolean compareByName(Contact contact1 , Contact contact2){
	return contact1.getName().equalsIgnoreCase(contact2.getName());
}
private boolean compareByPhoneNumber(Contact contact1 , Contact contact2){
	return contact1.getPhoneNumber().equalsIgnoreCase(contact2.getPhoneNumber());
}
