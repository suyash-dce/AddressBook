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
		
		//Creating first entry
		AddressBook entry1=new AddressBook("Suyash", "Jain",
				"Najafgarh", "New Delhi", "Delhi", 110043, "9810224035",
				"suyash.jain@capgemini.com");
		System.out.println(entry1);
		entry1.display();					//Method call to display details
		
		//Creating second entry
		AddressBook entry2=new AddressBook("Harshit", "Jain",
				"Mahaveer Nagar", "New Delhi", "Delhi", 110043, "8285683470",
				"harshit.jain@gmail.com");
		System.out.println(entry2);
		entry2.display();					//Method call to display details		
	}
}
