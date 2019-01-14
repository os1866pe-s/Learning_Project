package school.EDDA10.tenta190114;

public class Main {

    public static void main(String[] args) {
        OrderList ol = new OrderList();
        ol.add(new Order(1,"Hamburger"));
        ol.add(new Order(4,"Hamburger1"));
        ol.add(new Order(3,"Hamburger2"));
        ol.add(new Order(5,"Hamburger3"));
        ol.add(new Order(7,"Hamburger4"));
        ol.add(new Order(6,"Hamburger5"));
        ol.add(new Order(2,"Hamburger6"));

        System.out.println(ol.toString());

        OrderManager om = new OrderManager();
        om.newOrder("Hamburger");
        om.newOrder("Hamburger1");
        om.newOrder("Hamburger2");
        om.newOrder("Hamburger300");
        om.newOrder("Hamburger4");
        om.newOrder("Hamburger5");

        om.readyOrder(1002);
        om.readyOrder(1003);
        om.readyOrder(1005);
        om.pickedUpOrder(1002);
        System.out.println(om.longestOrder().getContent());
        om.pickedUpOrder(1003);
    }
}
