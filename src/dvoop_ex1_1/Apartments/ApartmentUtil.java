package dvoop_ex1_1.Apartments;

import java.util.ArrayList;
import java.util.List;

public class ApartmentUtil {
	private static int lastId = 0;
	
	public static final float PRICE_PER_SIZE = 10;
	
	public static int giveId() {
		lastId++;
		return lastId;
	}
	
	public static List<Apartment> getAvailables(List<Apartment> apartments){
		List<Apartment> result = new ArrayList<Apartment>();
		
		for (Apartment ap : apartments) {
			if (ap.isAvailable())
				result.add(ap);
		}
		
		return result;
	}
	
	public static List<Apartment> getAvailables(List<Apartment> apartments, String address){
		List<Apartment> result = new ArrayList<Apartment>();
		
		for (var ap : apartments) {
			if (ap.isAvailable() == false)
				continue;
			
			if (ap.getAddress().contains(address))
				result.add(ap);
		}
		
		return result;
	}
	
}
