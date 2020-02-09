package cat.iambokata.pizzas.models;

import java.util.List;

public class Result {

    private Integer pizzaTypes;
    private List<Integer> orderingPizzasIndex;

    public Result() {}

    public Result(Integer pizzaTypes, List<Integer> orderingPizzasIndex) {
        this.pizzaTypes = pizzaTypes;
        this.orderingPizzasIndex = orderingPizzasIndex;
    }

    public Integer getPizzaTypes() {
        return pizzaTypes;
    }

    public void setPizzaTypes(Integer pizzaTypes) {
        this.pizzaTypes = pizzaTypes;
    }

    public List<Integer> getOrderingPizzasIndex() {
        return orderingPizzasIndex;
    }

    public void setOrderingPizzasIndex(List<Integer> orderingPizzasIndex) {
        this.orderingPizzasIndex = orderingPizzasIndex;
    }
}
