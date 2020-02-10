package cat.iambokata.pizzas.command;

import cat.iambokata.pizzas.models.DataSet;
import cat.iambokata.pizzas.models.Result;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PizzaSlicesCalculator {

    private final DataSet dataSet;

    Map<Integer, Long> bestValue;

    public PizzaSlicesCalculator(DataSet dataSet) {
        this.dataSet = dataSet;
        bestValue = new HashMap<>();
    }

    public Result calculateResult() {

        for (int i = 0; i < dataSet.getPizzas().size(); i++) {

            Map<Integer, Long> stack = new HashMap<>();

            List<Long> clonedPizzas = new ArrayList<>(dataSet.getPizzas());

            Map<Integer, Long> result = this.processStack(stack, clonedPizzas.subList(0, clonedPizzas.size() - i));

            if (getStackSum(result) > getStackSum(bestValue)) {
                this.bestValue = result;
            }

            if (getStackSum(bestValue).equals(this.dataSet.getSlices())) {
                break;
            }
        }

        return new Result((long)this.bestValue.size(), new ArrayList<Integer>(this.bestValue.keySet()));
    }

    private Map<Integer, Long> processStack(Map<Integer, Long> stack, List<Long> pizzas) {

        while (getStackSum(stack) < dataSet.getSlices() && pizzas.size() > 0) {
            Integer lastPizzaIndex = pizzas.size() - 1;
            Long lastPizzaSlices = pizzas.get(lastPizzaIndex);

            // System.out.println("-------------------------------------------------------------------------");
            // System.out.println("INDEX: " + lastPizzaIndex);
            // System.out.println("SLICES: " + lastPizzaSlices);
            // System.out.println(pizzas);

            pizzas.remove(lastPizzaIndex.intValue());

            if ((getStackSum(stack) + lastPizzaSlices) == dataSet.getSlices()) {
                stack.put(lastPizzaIndex, lastPizzaSlices);
                return stack;
            } else if ((getStackSum(stack) + lastPizzaSlices) < dataSet.getSlices()) {
                stack.put(lastPizzaIndex, lastPizzaSlices);
                // return this.processStack(stack, pizzas);
            }
        }

        return stack;
    }

    private Long getStackSum(Map<Integer, Long> stack) {
         return stack.values().stream().reduce(0l, Long::sum);
    }

}
