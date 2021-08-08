package order;

import java.util.Date;

public interface State {
    Date prepare(Restaurant restaurant);
    void cancelBy(Customer customer);
    void cancelBy(Restaurant restaurant);
    void ready(Restaurant restaurant);
    void pickUp(Driver driver);
    void deliver(Driver driver);

    OrderStateEnum getState();
}
