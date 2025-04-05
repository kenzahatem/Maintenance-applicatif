package fr.r6a06;

public class TestSortie {
    public static void main(String[] args) {
        Movie newrelaesed = new Movie("Spiderman" , 1);
        Movie chlidren = new Movie("Inside Out" , 2);
        Movie regular = new Movie("Titanic" , 0);
        Customer customer = new Customer("Samy") ;
        Rental rental1 = new Rental(chlidren,1) ;
        customer.addRental(rental1);
        Rental rental2 = new Rental(regular,1) ;
        customer.addRental(rental2);
        Rental rental3 = new Rental(newrelaesed,1) ;
        customer.addRental(rental3);
        System.out.println(customer.statement());
    }
}
