package order;

import java.util.Date;

public class StatePaid implements State {

    private FoodOrder order;

    public StatePaid(FoodOrder order) {
        this.order = order;
    }

    @Override
    public Date prepare(Restaurant restaurant) {
        System.out.println("food is being prepared");
        State preparation = new StatePreparation(this.order);
        this.order.changeState(preparation);

        boolean isExclusive = restaurant.isExclusiveUser(this.order.UserID);
        if (isExclusive) {
            return new Date();
        }

        return null; // longer duration
    }

    @Override
    public void cancelBy(Customer customer) {
        System.out.println("customer is canceling the order");
        State canceled = new StateCanceled(this.order);
        this.order.changeState(canceled);
    }

    @Override
    public void cancelBy(Restaurant restaurant) {
        System.out.println("restaurant is canceling the order");
        State canceled = new StateCanceled(this.order);
        this.order.changeState(canceled);
    }

    @Override
    public void ready(Restaurant restaurant) {
        System.out.println("food is ready to be picked up by driver");
        State readyForPickup = new StateReadyForPickup(this.order);
        this.order.changeState(readyForPickup);
    }

    @Override
    public void pickUp(Driver driver) {
        throw new IllegalStateException("please wait until the food is ready");
    }

    @Override
    public void deliver(Driver driver) {
        throw new IllegalStateException("unable to complete the order");
    }

    @Override
    public OrderStateEnum getState() {
        return OrderStateEnum.PAID;
    }
}
