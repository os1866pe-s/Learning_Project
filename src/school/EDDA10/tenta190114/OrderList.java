package school.EDDA10.tenta190114;

import java.util.ArrayList;
import java.util.List;

public class OrderList {

    List<Order> orders;

    public OrderList(){
        orders = new ArrayList<>();

    }

    public void add(Order ord){
        orders.add(ord);
    }

    public Order remove(int nbr){
        //set it to null.
        Order temp = null;
        for (Order o : orders){
            if (o.getNbr() == nbr){
                temp = o;
                break;
            }
        }
        orders.remove(temp);
        return temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        //Have to create a new list
        List<Order> leftOrders = new ArrayList<>(orders);
        for (Order o : orders){
            Order lowest = new Order(Integer.MAX_VALUE, "");
            for (Order i : leftOrders){
                if (i.earlierThan(lowest)){
                    lowest = i;
                }
            }
            leftOrders.remove(lowest);
            sb.append(lowest.getNbr()).append(' ');
        }
        return sb.toString();
    }
}


