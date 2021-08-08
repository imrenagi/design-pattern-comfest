package order;

import java.util.Date;

public class FoodOrder {

    private OrderStateEnum stateEnum;
    private State state;
    public int UserID;

    public FoodOrder() {
        this.stateEnum = OrderStateEnum.PAID;

        this.state = new StatePaid(this);
    }

    public OrderStateEnum getStateEnum() {
        return this.stateEnum;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public boolean canBeCanceled() {
        return this.stateEnum == OrderStateEnum.PAID;
    }

    public void prepare(Restaurant restaurant) {
        Date doneAt = this.state.prepare(restaurant);

        // if doneAt is in sunday
        //  setPrice(0)
    }

    public void cancelBy(Customer customer) {
        this.state.cancelBy(customer);
    }

    public void cancelBy(Restaurant restaurant) {
        this.state.cancelBy(restaurant);
    }

    public void ready(Restaurant restaurant) {
        this.state.ready(restaurant);
    }

    public void pickUp(Driver driver) {
        this.state.pickUp(driver);
    }

    public void Deliver(Driver driver) {
        this.state.deliver(driver);
    }
}
