package cat.iambokata.pizzas.models;

import java.util.List;

public class Result {

    private Long pizzaTypes;
    private List<Integer> orderingPizzasIndex;

    public Result() {}

    public Result(Long pizzaTypes, List<Integer> orderingPizzasIndex) {
        this.pizzaTypes = pizzaTypes;
        this.orderingPizzasIndex = orderingPizzasIndex;
    }

    public Long getPizzaTypes() {
        return pizzaTypes;
    }

    public void setPizzaTypes(Long pizzaTypes) {
        this.pizzaTypes = pizzaTypes;
    }

    public List<Integer> getOrderingPizzasIndex() {
        return orderingPizzasIndex;
    }

    public void setOrderingPizzasIndex(List<Integer> orderingPizzasIndex) {
        this.orderingPizzasIndex = orderingPizzasIndex;
    }

    @Override
    public String toString() {
        return "Result{" +
                "pizzaTypes=" + pizzaTypes +
                ", orderingPizzasIndex=" + orderingPizzasIndex +
                '}';
    }
}
