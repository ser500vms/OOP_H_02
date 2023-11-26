
public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human h1 = new Human("Bob");
        Human h2 = new Human("Masha");
        Human h3 = new Human("Peter");

        market.acceptToMarket(h1);
        market.update();
        market.acceptToMarket(h2);
        market.acceptToMarket(h3);
        market.update();
       


    }

}
