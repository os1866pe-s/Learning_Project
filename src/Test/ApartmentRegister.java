package Test;

import java.util.ArrayList;

public class ApartmentRegister {

    private ArrayList<Apartment> list;

    public ApartmentRegister(){
        list = new ArrayList<>();
    }

    ApartmentRegister(Apartment[] a){
        //list = a;
    }

    public void insert(Apartment apartment){
        list.add(apartment);
    }

    public int getNbrOfApartments(){
        return list.size();
    }

    public boolean remove(int nbr){
        if (nbr > -1 && nbr < list.size()){
            list.remove(nbr);
            return true;
        }
        return false;
    }

    public int getNbrOfFreeApartments(){
        int temp = 0;

        for (Apartment i : list) {
            if (i.hasNoOwner()){
                temp++;
            }
        }
        return temp;
    }

    public ArrayList<Apartment> freeApartments(){
        ArrayList<Apartment> a = new ArrayList<>();

        for (Apartment k : list){
            if (k.hasNoOwner()){
                a.add(k);
            }
        }
        return a;
    }
}
