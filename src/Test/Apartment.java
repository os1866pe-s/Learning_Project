package Test;

public class Apartment {

    private int nbr;
    private double area;
    private double sqmRent;
    private String owner;

    public Apartment(int nbr, double area){
        this.nbr = nbr;
        this.area = area;
        sqmRent = 0;
    }

    public int getApartmentNbr(){
        return nbr;
    }

    public double getArea(){
        return area;
    }

    public void setSquareMetreRent(double sqmRent){
        this.sqmRent = sqmRent;
    }

    /**Returns the rent of the apartment*/
    public double computeRent(){
        return area * sqmRent;
    }

    /**Return true if this apartment's rent is less expensive than ap's rent*/
    public boolean lessExpensiveThan(Apartment ap){
        return this.computeRent() < ap.computeRent();
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner(){
        return owner;
    }

    /**Returns true if the apartment has no owner*/
    public boolean hasNoOwner(){
        return owner == null;
    }
}
