package cat.iambokata.pizzas.models;

import javax.xml.crypto.Data;
import java.util.List;

public class DataSet {

    private Integer slices;
    private Integer pizzaTypes;
    private List<Integer> pizzas;

    public DataSet() {

    }

    public DataSet(Integer slices, Integer pizzaTypes, List<Integer> pizzas) {
        this.slices = slices;
        this.pizzaTypes = pizzaTypes;
        this.pizzas = pizzas;
    }

    public Integer getSlices() {
        return slices;
    }

    public void setSlices(Integer slices) {
        this.slices = slices;
    }

    public Integer getPizzaTypes() {
        return pizzaTypes;
    }

    public void setPizzaTypes(Integer pizzaTypes) {
        this.pizzaTypes = pizzaTypes;
    }

    public List<Integer> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Integer> pizzas) {
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

    public Integer getPizzasSum() {
        return this.pizzas.stream().reduce(0, Integer::sum);
    }
}
