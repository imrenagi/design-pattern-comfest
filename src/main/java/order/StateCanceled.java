package order;

import java.util.Date;

public class StateCanceled implements State {

    private FoodOrder order;

    public StateCanceled(FoodOrder order) {
        this.order = order;
    }


    @Override
    public Date prepare(Restaurant restaurant) {
        throw new IllegalStateException("canceled order cant be prepared");
    }

    @Override
    public void cancelBy(Customer customer) {

    }

    @Override
    public void cancelBy(Restaurant restaurant) {

    }

    @Override
    public void ready(Restaurant restaurant) {

    }

    @Override
    public void pickUp(Driver driver) {

    }

    @Override
    public void deliver(Driver driver) {

    }

    @Override
    public OrderStateEnum getState() {
        return OrderStateEnum.CANCELED;
    }
}
