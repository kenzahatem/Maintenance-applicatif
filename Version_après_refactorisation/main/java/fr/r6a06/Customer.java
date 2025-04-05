package fr.r6a06;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;

    private Vector<Rental> _rentals = new Vector<Rental>();


    public Customer(String name) {
        _name = name;
    }

    public double getTotalCharge() {
        double totalAmount = 0;
        for (Rental rental : this._rentals) {
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }


    public int getTotalFrequentRenterPoints() {
        int points = 0;
        for (Rental rental : this._rentals) {
            points += rental.getFrequentRenterPoints();
        }
        return points;
    }



    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }


    public String statement() {


        Enumeration rentals = _rentals.elements();

        String result = "Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //determine amounts for each line
            double amount = each.getCharge();


            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(amount) + "\n";
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(this.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }
}
