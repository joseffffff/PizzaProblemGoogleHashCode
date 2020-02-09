package cat.iambokata.pizzas.models;

import javax.xml.crypto.Data;
import java.util.List;

public class DataSet {

    private Long slices;
    private Long pizzaTypes;
    private List<Long> pizzas;

    public DataSet() {

    }

    public DataSet(Long slices, Long pizzaTypes, List<Long> pizzas) {
        this.slices = slices;
        this.pizzaTypes = pizzaTypes;
        this.pizzas = pizzas;
    }

    public Long getSlices() {
        return slices;
    }

    public void setSlices(Long slices) {
        this.slices = slices;
    }

    public Long getPizzaTypes() {
        return pizzaTypes;
    }

    public void setPizzaTypes(Long pizzaTypes) {
        this.pizzaTypes = pizzaTypes;
    }

    public List<Long> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Long> pizzas) {
        this.pizzas = pizzas;
    }

    public Boolean isSumEqualToResult() {
        return this.slices.equals(this.getPizzasSum());
    }

    public Boolean isSumLowerThanResult() {
        return this.slices < this.getPizzasSum();
    }

    @Override
    public String toString() {
        return "DataSet{" +
                "slices=" + slices +
                ", pizzaTypes=" + pizzaTypes +
                ", pizzas=" + pizzas +
                '}';
    }

    public Long getPizzasSum() {
        return this.pizzas.stream().reduce(0l, Long::sum);
    }
}
