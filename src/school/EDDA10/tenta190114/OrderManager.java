package school.EDDA10.tenta190114;

public class OrderManager {

    private OrderList newOrders, readyOrders;
    private Order longestOrder;
    private int orderNum;
    private Display newDisplay, readyDisplay;

    public OrderManager(){
        newOrders = new OrderList();
        readyOrders = new OrderList();
        orderNum = 1000;
        newDisplay = new Display(203);
        readyDisplay = new Display(475);
    }

    public void newOrder(String content){
        newOrders.add(new Order(orderNum, content));
        orderNum++;
    }

    public void readyOrder(int nbr){
        Order moveOrder = newOrders.remove(nbr);
        readyOrders.add(moveOrder);
        newDisplay.update(newOrders.toString());
        readyDisplay.update(readyOrders.toString());
        if (longestOrder == null || moveOrder.getContent().length() > longestOrder.getContent().length()){
            longestOrder = moveOrder;
        }

    }

    public void pickedUpOrder(int nbr){
        readyOrders.remove(nbr);
        readyDisplay.update(readyOrders.toString());
    }

    public Order longestOrder(){
        return longestOrder;
    }

    private class Display{

        private int monitor;
        private String orders;
        private Display(int monitor){
            this.monitor = monitor;
        }

        private void update(String s){
            orders = s;
            System.out.println(monitor + " " + s);
        }
    }
}
