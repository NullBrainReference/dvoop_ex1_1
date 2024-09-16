package dvoop_ex1_1.Apartments;

public class Apartment {
	private int id;
	
	private String address;
	private float priceBase;
	private float size;
	
	private ApartmentStatus status;
	
	public Apartment(String address, float size, float price) {
		id = ApartmentUtil.giveId();
		
		this.address = address;
		this.priceBase = price;
		this.size = size;
		
		status = ApartmentStatus.Stock;
	}
	
	public String getAddress() {
		return address;
	}
	
	public float getPrice() {
		return priceBase + size * ApartmentUtil.PRICE_PER_SIZE;
	}
	
	public void SetStatus(ApartmentStatus status) {
		this.status = status;
	}
	
	public boolean isAvailable() {
		if (status == ApartmentStatus.Stock)
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s", address, size, getPrice());
	}
}
