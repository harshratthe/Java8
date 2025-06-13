

public class main {
    public static void main(String[] args) {
    	 Sim sim1 = new Vodafone();

         sim1.calling();

         sim1.message();

         sim1.Callbill();
  
         Sim sim2 = new Airtel();

         sim2.calling();

         sim2.message();

         sim2.Callbill();

	}
}
