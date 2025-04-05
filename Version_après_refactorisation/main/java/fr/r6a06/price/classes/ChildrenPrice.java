package fr.r6a06.price.classes;

import fr.r6a06.price.Price;

public class ChildrenPrice extends Price {
    @Override
    public int getPriceCode() {
        return 2;
    }

    @Override
    public double getCharge(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount ;
    }
}
