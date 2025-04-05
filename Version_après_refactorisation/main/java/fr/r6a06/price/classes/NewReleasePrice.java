package fr.r6a06.price.classes;

import fr.r6a06.price.Price;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return 1;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented* 3;
    }
}
