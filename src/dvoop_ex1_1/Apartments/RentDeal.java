package dvoop_ex1_1.Apartments;

import dvoop_ex1_1.Renter;

public class RentDeal {
	private Apartment apartment;
	
	private Renter renter;
	
	public RentDeal(Apartment apartment ,Renter renter) {
		this.apartment = apartment;
		this.renter = renter;
		
		apartment.SetStatus(ApartmentStatus.Given);
	}
	
	public String getApartment() {
		return apartment.getAddress();
	}
	
	public void returnToOwner() {
		apartment.SetStatus(ApartmentStatus.Stock);
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", renter, getApartment());
	}
}
