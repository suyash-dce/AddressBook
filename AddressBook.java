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

	public static ArrayList<AddressBook> edit(ArrayList<AddressBook> list, String name) {
		
		//method for edit
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		name.replaceAll("\\P{Print}","");
		String lower_name=name.toLowerCase();
		for (AddressBook obj:list) {
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
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		//Adding a record for all entries
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

		//editing an existing entry
		
		//asking user input
		System.out.println("Please enter First/Last name of entry to be edited.");
		String name=sc.next();
		record=edit(record,name);
		
		//displaying all entries
		entry1.display();
		entry2.display();
	}
}
