
import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehavior {

    private final List<Actor> marketQueue;


    public Market() {
        this.marketQueue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.name + " Зашел в магазин");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            if (actor.isTakeOrder) {
                System.out.println(actor.name + " Покинул магазин");
            }
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void giveOrders() {
        for (Actor actor : marketQueue) {
            if (actor.isMakeOrder) {
                System.out.println(actor.name + " Выдан заказ");
                actor.setTakeOrder(true);
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (Actor actor : marketQueue) {
            if (actor.isTakeOrder) {
                System.out.println(actor.name + " Удален из очереди");
                releaseActors.add(actor);
            }
        }
        releaseFromMarket(releaseActors);
    }

    @Override
    public void takeInQueue(Actor actor) {
        if (!actor.isMakeOrder) {
            System.out.println(actor.name + " Добавлен в очередь");
            marketQueue.add(actor);
        }
    }

    @Override
    public void takeOrders() {
        for (Actor actor : marketQueue) {
            if (!actor.isMakeOrder) {
                actor.setMakeOrder(true);
                System.out.println(actor.name + " Принят заказ");
            }
        }
    }
}
