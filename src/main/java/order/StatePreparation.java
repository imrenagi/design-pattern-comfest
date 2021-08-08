package order;

import java.util.Date;

public class StatePreparation implements State {

    private FoodOrder order;

    public StatePreparation(FoodOrder order) {
        this.order = order;
    }

    @Override
    public Date prepare(Restaurant restaurant) {
        throw new IllegalStateException("canceled order cant be prepared");
    }

    @Override
    public void cancelBy(Customer customer) {
        throw new IllegalStateException("food cant be canceled");
    }

    @Override
    public void cancelBy(Restaurant restaurant) {
        System.out.println("restaurant canceling the request due to some reasons");
        State canceled = new StateCanceled(this.order);
        this.order.changeState(canceled);
    }

    @Override
    public void ready(Restaurant restaurant) {
        int duration = restaurant.processFood();
        if (duration < 60) {
            restaurant.increasePoint();
        }

        System.out.println("food is ready to be picked up by driver");
        State readyForPickup = new StateReadyForPickup(this.order);
        this.order.changeState(readyForPickup);
    }

    @Override
    public void pickUp(Driver driver) {
        throw new IllegalStateException("cant pickup food that is in preparation");
    }

    @Override
    public void deliver(Driver driver) {
        throw new IllegalStateException("cant deliver food that is in preparation");
    }

    @Override
    public OrderStateEnum getState() {
        return OrderStateEnum.IN_PREPARATION;
    }
}
