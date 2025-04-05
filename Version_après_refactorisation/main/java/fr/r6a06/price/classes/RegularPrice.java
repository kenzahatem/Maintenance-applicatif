package fr.r6a06.price.classes;

import fr.r6a06.price.Price;

public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return 0;
    }

    @Override
    public double getCharge(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount ;
    }
}
