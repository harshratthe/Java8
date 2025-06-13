

interface Sim {

    void calling();

    void message();

    void calBill();

}
 


class Vodafone implements Sim {
 
    public void calling() {

        System.out.println("Vodafone Calling...");

    }
 
    public void message() {

        System.out.println("Vodafone Message - Limit: 100 SMS/day");

    }
 
    public void calBill() {

        System.out.println("Vodafone Bill: ₹299/month");

    }

}
 


class Airtel implements Sim {
 
    public void calling() {

        System.out.println("Airtel Calling...");

    }
 
    public void message() {

        System.out.println("Airtel Message - Limit: 200 SMS/day");

    }
 
    public void calBill() {

        System.out.println("Airtel Bill: ₹399/month");

    }

}
 


public class Main {

    public static void main(String[] args) {

        Sim sim1 = new Vodafone();

        sim1.calling();

        sim1.message();

        sim1.calBill();
 
        Sim sim2 = new Airtel();

        sim2.calling();

        sim2.message();

        sim2.calBill();

    }

}

 