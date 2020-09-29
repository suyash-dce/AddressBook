import java.io.*;
import java.util.*;

public class AddressBook {
	
	private HashMap<String, ArrayList<Collection>> addressBook;
	private static ArrayList<Collection> record;

	public AddressBook() {
		record=new ArrayList<Collection>();
		addressBook = new HashMap<String, ArrayList<Collection>>();
	}

	public void display() {
		for (Collection obj:record) {
			obj.display();
		}
	}

	
	public void addToRecord(Collection obj) {
		record.add(new Collection(obj.firstName, obj.lastName, obj.address,
				obj.city,obj.state, obj.zipCode, obj.phoneNo, obj.email));
	}

	public void addBookMap(String bookName) {
		addressBook.put(bookName, new ArrayList<Collection>());
	}
	
	public static Collection add() {
		
		//method for adding new entries.
		Scanner sc=new Scanner(System.in);
		String firstName;					//Attributes to be added
		String lastName;
		String address;
		String city;
		String state;
		long zipCode;
		String phoneNo;
		String email;
		
		//asking user input
		System.out.println("Please enter details to be added.");
		System.out.print("First Name: ");
		firstName=sc.next();
		System.out.print("Last Name: ");
		lastName=sc.next();
		System.out.print("Address: ");
		address=sc.next();
		System.out.print("City: ");
		city=sc.next();
		System.out.print("State: ");
		state=sc.next();
		System.out.print("ZipCode: ");
		zipCode=sc.nextLong();
		System.out.print("Phone No.: ");
		phoneNo=sc.next();
		System.out.print("Email: ");
		email=sc.next();
		
		//saving as new entry
		Collection entry=new Collection(firstName,lastName,
				address,city,state,zipCode,phoneNo,email);
		return entry;					//returning entry to main
	}
	
	public static ArrayList<Collection> edit(ArrayList<Collection> list, String name) {
		
		//method for edit
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		name.replaceAll("\\P{Print}","");
		String lower_name=name.toLowerCase();
		for (Collection obj:list) {
			String firstName=obj.firstName.toLowerCase();
			String lastName=obj.lastName.toLowerCase();
			if (firstName.equals(lower_name) ||
					lastName.equals(lower_name)) {
				flag=true;
				System.out.println("Please enter new details.");
				System.out.print("Address: ");
				obj.address=sc.next();
				System.out.print("City: ");
				obj.city=sc.next();
				System.out.print("State: ");
				obj.state=sc.next();
				System.out.print("ZipCode: ");
				obj.zipCode=sc.nextLong();
				System.out.print("Phone No.: ");
				obj.phoneNo=sc.next();
				System.out.print("Email: ");
				obj.email=sc.next();
				
				System.out.println("Record updated.");
				break;
			}
		}
		if (flag==false) {
			System.out.println("No entry found for "+name);
		}
		return list;
	}
	
	public static ArrayList<Collection> delete(ArrayList<Collection> list, String name) {
		
		//method for delete
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		name.replaceAll("\\P{Print}","");
		String lower_name=name.toLowerCase();
		
		try {
			for (Collection obj:list) {
				String firstName=obj.firstName.toLowerCase();
				String lastName=obj.lastName.toLowerCase();
				if (firstName.equals(lower_name) ||
						lastName.equals(lower_name)) {
					flag=true;
					
					System.out.println("Record deleted for "+obj.firstName+" "+obj.lastName);
					list.remove(obj);			//delete entry from record
					System.out.println("Record updated.");
				}
			}
		}catch(Exception e) {}
		if (flag==false) {
			System.out.println("No entry found for "+name);
		}
		return list;
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		AddressBook buildObj=new AddressBook();
		
		//Creating first entry
		Collection entry1=new Collection("Suyash", "Jain",
				"Najafgarh", "New Delhi", "Delhi", 110043, "9810224035",
				"suyash.jain@capgemini.com");
		buildObj.addToRecord(entry1);				//Adding entry to record
		System.out.println(entry1);
		
		//Creating second entry
		Collection entry2=new Collection("Harshit", "Jain",
				"Mahaveer Nagar", "New Delhi", "Delhi", 110043, "8285683470",
				"harshit.jain@gmail.com");
		buildObj.addToRecord(entry2);				//Adding entry to record
		System.out.println(entry2);
		
		buildObj.addBookMap("AddressBook1");
		
		//initiating user functions of entries
		
		String user_input="1";
		while((user_input.equals("1") || user_input.equals("2") || user_input.equals("3"))) {
			
			// Checking in address list is present in hashmap
			System.out.print("Enter the Name of the Address Book: ");
			String bookName = sc.next();
			if (buildObj.addressBook.containsKey(bookName)) {
				buildObj.record = buildObj.addressBook.get(bookName);
			}

			else {
				System.out.println("Address book with name " + bookName + " not found. Creating a new entry");
				buildObj.addBookMap(bookName);
			}
			
			System.out.println("Record "+bookName+" loaded.");
			
			System.out.println();				//Waiting for user input
			System.out.println("What now?");
			System.out.println("1. Add a new contact.");
			System.out.println("2. Edit an existing contact.");
			System.out.println("3. Delete an existing contact.");
			System.out.println("4. Switch Directory");
			System.out.println("Logout");
			user_input=sc.next();
			
			switch(user_input) {
			
			case "1": {
				Collection entry=buildObj.add();		//calling function to make new entry
				buildObj.addToRecord(entry);			//Adding entry to record
				System.out.println(entry);
				break;
			}
			case "2": {
				System.out.println("Please enter First/Last name of entry to be edited.");
				String name=sc.next();
				ArrayList<Collection> list = buildObj.edit(record,name);
				break;
			}
			case "3": {
				System.out.println("Please enter First/Last name of entry to be deleted.");
				String name=sc.next();
				record=delete(record,name);
				break;
			}
			case "4": {
				user_input="1";
				continue;
			}
			default:
				break;
			}
		}
		
		//displaying all entries
		buildObj.display();
	}
}
