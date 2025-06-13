
public class HotelA implements Sim {

	@Override
	public void calling() {
		System.out.println("This is Airtel calling ");
		
	}

	@Override
	public void message() {
		System.out.println("Airtel Message 200 SMS/day");
		
	}

	@Override
	public void Callnill() {
		System.out.println("Airtel Bill: ₹399/month");
		
	}

}
