package school.EDDA10.tenta190114;

public class Order {

    private int nbr;
    private String content;

    public Order(int nbr, String content){
        this.nbr = nbr;
        this.content = content;
    }

    public int getNbr(){
        return nbr;
    }

    public String getContent() {
        return content;
    }

    public boolean earlierThan(Order other){
        return nbr < other.nbr;
    }
}
