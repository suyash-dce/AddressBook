import java.io.*;
import java.util.*;
public class AddressBook {
	
	public String firstName;		//Obj Attributes
	public String lastName;
	public String address;
	public String city;
	public String state;
	public long zipCode;
	public String phoneNo;
	public String email;
	
	public AddressBook(String firstName, String lastName, String address,
			String city, String state, long zipCode,
			String phoneNo, String email) {
		this.firstName = firstName;				//Constructor
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public void display() {				//Method for displaying all details
		
		System.out.println("------------------------------------------------------");
		System.out.println("Name: "+firstName+" "+lastName);
		System.out.println("Address: "+address);
		System.out.println("City: "+city);
		System.out.println("State: "+state);
		System.out.println("Zip: "+zipCode);
		System.out.println("Phone No.: "+phoneNo);
		System.out.println("Email: "+email);
		System.out.println("------------------------------------------------------");
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Created object for "+firstName+" "+lastName;
	}

	public static void main(String[] args) {
		
		ArrayList<AddressBook> record=new ArrayList<AddressBook>();
		//Creating first entry
		AddressBook entry1=new AddressBook("Suyash", "Jain",
				"Najafgarh", "New Delhi", "Delhi", 110043, "9810224035",
				"suyash.jain@capgemini.com");
		record.add(entry1);					//Adding entry to record
		System.out.println(entry1);
		//Creating second entry
		AddressBook entry2=new AddressBook("Harshit", "Jain",
				"Mahaveer Nagar", "New Delhi", "Delhi", 110043, "8285683470",
				"harshit.jain@gmail.com");
		record.add(entry2);					//Adding entry to record
		System.out.println(entry2);
		
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
		AddressBook entry3=new AddressBook(firstName,lastName,
				address,city,state,zipCode,phoneNo,email);
		record.add(entry3);					//Adding entry to record
		System.out.println(entry3);
		
		//displaying all entries
		entry1.display();
		entry2.display();
		entry3.display();
	}
}
