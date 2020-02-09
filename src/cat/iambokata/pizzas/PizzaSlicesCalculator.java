package cat.iambokata.pizzas;

import cat.iambokata.pizzas.models.DataSet;
import cat.iambokata.pizzas.models.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PizzaSlicesCalculator {

    private final DataSet dataSet;

    public PizzaSlicesCalculator(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public Result calculateResult() {

        Map<Integer, Integer> stack = new HashMap<>();

        this.maxValue(stack, new ArrayList<>(dataSet.getPizzas()));
    }

    private Map<Integer, Integer> maxValue(Map<Integer, Integer> stack, List<Integer> pizzas) {

        Integer sum = this.getStackSum(stack);

        if (this.isResult(stack)) {
            return stack;
        }

        Integer lastPizzaIndex = pizzas.size() - 1;
        Integer lastPizzaSlices = pizzas.get(lastPizzaIndex);

        if ((lastPizzaSlices + sum) < this.dataSet.getSlices()) {
            stack.put(lastPizzaIndex, lastPizzaSlices);
            pizzas.remove(lastPizzaIndex);
            return this.maxValue(stack, pizzas);
        }


    }

    private Integer getStackSum(Map<Integer, Integer> stack) {
         return stack.values().stream().reduce(0, Integer::sum);
    }

    private boolean isResult(Map<Integer, Integer> stack) {

    }
}
