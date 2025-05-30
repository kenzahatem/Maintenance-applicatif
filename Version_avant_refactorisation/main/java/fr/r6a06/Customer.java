package fr.r6a06;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;

    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public double amountForCurrentRental(Rental rental) {
        double thisAmount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount = 2;
                if (rental.getDaysRented() > 2) {
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount = rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount = 1.5;
                if (rental.getDaysRented() > 3) {
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }

        return thisAmount;
    }


    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration rentals = _rentals.elements();

        String result = "Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            //determine amounts for each line
            double amount =amountForCurrentRental(each) ;
            thisAmount += amount;
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints++;
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return result;
    }
}
