package dvoop_ex1_1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dvoop_ex1_1.Apartments.Apartment;
import dvoop_ex1_1.Apartments.ApartmentUtil;
import dvoop_ex1_1.Apartments.RentDeal;



class Program {
	
	private static List<Apartment> apartments = createDummyApartments();
	private static List<Renter> renters = createDummyRenters();
	private static List<RentDeal> rents = new ArrayList<RentDeal>();
	
	public static void main(String[] args) {
		String[] options = new String[] {"Rent", "Return", "Add apartment", "Show price", "Exit"};
		
		while (true) {
			showStockpile();
			String option = (String) JOptionPane.showInputDialog(null, "Choose action", "Menu", 0, null, options, "Rent");
			
			switch (option) {
				case "Rent":
					rentApartment();
					break;
				case "Return":
					returnApartment();
					break;
				case "Add apartment":
					addApartment();
					break;
				case "Show price":
					showPrice();
					break;
				case "Exit":
					return;
			}
		}
	}
	
	private static void rentApartment() {
		String address = (String) JOptionPane.showInputDialog("Enter apartment address");
		List<Apartment> availables = ApartmentUtil.getAvailables(apartments, address);
		
		if (availables.size() <= 0) {
			JOptionPane.showMessageDialog(null, "No avaible apartments");
			return;
		}
		
		rents.add(new RentDeal(availables.get(0), createRenter()));
	}
	
	private static void returnApartment() {
		String address = (String) JOptionPane.showInputDialog("Enter address");
		
		RentDeal wasFound = null;
		
		for (var rent : rents) {
			if (rent.getApartment().equals(address) == false)
				continue;
			
			rent.returnToOwner();
			JOptionPane.showMessageDialog(null, "Book returned");
			wasFound = rent;
			break;
		}
		
		if (wasFound != null)
			rents.remove(wasFound);
		else
			JOptionPane.showMessageDialog(null, "Not found");
	}
	
	private static void showStockpile() {
		var stocks = ApartmentUtil.getAvailables(apartments);
		
		String output = "";
		
		for (Apartment ap : stocks) {
			output += ap.toString() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, output);
	}
	
	private static Renter createRenter() {
		String dni = (String) JOptionPane.showInputDialog("Enter DNI");
		String name = (String) JOptionPane.showInputDialog("Enter name");
		String surname = (String) JOptionPane.showInputDialog("Enter surname");
		
		for (var r : renters) {
			if (r.compareDNI(dni))
				return r;
		}
		
		var renter = new Renter(dni, name, surname);
		
		return renter;
	}
	
	private static void addApartment() {
		String address = (String) JOptionPane.showInputDialog("Enter address");
		float size = Float.parseFloat((String) JOptionPane.showInputDialog("Enter size"));
		float price = Float.parseFloat((String) JOptionPane.showInputDialog("Enter base price"));
		
		Apartment ap = new Apartment(address, size, price);
		apartments.add(ap);
	}
	
	private static void showPrice() {
		String address = (String) JOptionPane.showInputDialog("Enter address");
		
		Apartment ap = null; 
		
		for (Apartment apartment : apartments) {
			if (apartment.getAddress().contains(address)) {
				ap = apartment;
				break;
			}
		}
		
		if (ap == null) {
			JOptionPane.showMessageDialog(null, "Not found");
			return;
		}
		
		JOptionPane.showMessageDialog(null, "price: " + ap.getPrice());
	}
	
	private static List<Apartment> createDummyApartments(){
		List<Apartment> result = new ArrayList<Apartment>();
		
		result.add(new Apartment("a1", 20f, 410f));
		result.add(new Apartment("a2", 22f, 420f));
		result.add(new Apartment("a3", 21f, 450f));
		result.add(new Apartment("a4", 17f, 300f));
		result.add(new Apartment("a5", 20f, 400f));
		result.add(new Apartment("a6", 25f, 450f));
		result.add(new Apartment("a7", 27f, 470f));
		result.add(new Apartment("a8", 21f, 450f));
		
		return result;
	}
	
	private static List<Renter> createDummyRenters(){
		List<Renter> result = new ArrayList<Renter>();
		
		result.add(new Renter("111" ,"Sam", "Washington"));
		result.add(new Renter("122","Billy", "Jean"));
		
		return result;
	}

}
