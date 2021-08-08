package order;

public class FoodOrder {

    private OrderStateEnum state;

    public FoodOrder() {
        this.state = OrderStateEnum.PAID;
    }

    public OrderStateEnum getState() {
        return this.state;
    }

    public boolean canBeCanceled() {
        return this.state == OrderStateEnum.PAID;
    }

    public void prepare(Restaurant restaurant) {
        if (this.state == OrderStateEnum.PAID) {
            this.state = OrderStateEnum.IN_PREPARATION;
            System.out.println("food is being prepared");
        } else {
            throw new IllegalStateException("unable to prepare food that is not on created state");
        }
    }

    public void cancelBy(Customer customer) {
        if (this.state == OrderStateEnum.PAID) {
            this.state = OrderStateEnum.CANCELED;
            System.out.println("customer is canceling the order");
        } else {
            throw new IllegalStateException("food cant be canceled");
        }
    }

    public void cancelBy(Restaurant restaurant) {
        if (this.state == OrderStateEnum.PAID) {
            this.state = OrderStateEnum.CANCELED;
            System.out.println("restaurant is unable to process the food request");
        } else if (this.state == OrderStateEnum.IN_PREPARATION) {
            this.state = OrderStateEnum.CANCELED;
            System.out.println("restaurant canceling the request due to some reasons");
        } {
            throw new IllegalStateException("food cant be canceled");
        }
    }

    public void ready(Restaurant restaurant) {
        if (this.state == OrderStateEnum.PAID || this.state == OrderStateEnum.IN_PREPARATION) {
            this.state = OrderStateEnum.READY_FOR_PICKUP;
            System.out.println("food is ready to be picked up by driver");
        } else {
            throw new IllegalStateException("unable to set to ready for pickup");
        }
    }

    public void PickUp(Driver driver) {
        if (this.state == OrderStateEnum.READY_FOR_PICKUP) {
            this.state = OrderStateEnum.ON_DELIVERY;
        } else {
            throw new IllegalStateException("please wait until the food is ready");
        }
    }

    public void Deliver(Driver driver) {
        if (this.state == OrderStateEnum.ON_DELIVERY) {
            this.state = OrderStateEnum.COMPLETED;
        } else {
            throw new IllegalStateException("unable to complete the order");
        }
    }
}
