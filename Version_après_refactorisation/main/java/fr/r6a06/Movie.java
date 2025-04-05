package fr.r6a06;

import fr.r6a06.price.Price;
import fr.r6a06.price.classes.ChildrenPrice;
import fr.r6a06.price.classes.NewReleasePrice;
import fr.r6a06.price.classes.RegularPrice;

public  class Movie {
    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;

    private String _title;
    private Price _price ;

    public void setPriceCode(int _priceCode) {
        switch (_priceCode) {
            case REGULAR:
                this._price = new RegularPrice();
                break ;
            case NEW_RELEASE:
                this._price = new NewReleasePrice();
                break ;
            case CHILDRENS:
                this._price = new ChildrenPrice();
        }
    }

    public int getPriceCode() {
        return this._price.getPriceCode();
    }

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public double getCharge(int daysRented){
        return _price.getCharge(daysRented) ;

    }

    public String getTitle (){
        return _title;
    };

    public int getFrequentRenterPoints(int daysRented){
        int frequentRenterPoints=1 ;
        if ((this.getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1) frequentRenterPoints++;
        return frequentRenterPoints ;
    }
}