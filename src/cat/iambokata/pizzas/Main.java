package cat.iambokata.pizzas;

import cat.iambokata.pizzas.models.DataSet;
import cat.iambokata.pizzas.models.Result;

import java.io.IOException;

public class Main {

    private static final String A_EXAMPLE = "a_example.in";
    private static final String B_SMALL = "b_small.in";
    private static final String E_ALSO_BIG = "e_also_big.in";

    public static void main(String[] args) throws IOException {

        Reader reader = new Reader();

        DataSet dataSet = reader.read(B_SMALL);

        System.out.println(dataSet.toString());

        PizzaSlicesCalculator pizzaSlicesCalculator = new PizzaSlicesCalculator(dataSet);

        Result result = pizzaSlicesCalculator.calculateResult();

    }

    private static void printResult(DataSet dataSet) {
        System.out.println("PIZZA TYPES: " + dataSet.getPizzaTypes());
        System.out.println("PIZZAS: " + dataSet.getPizzas());
        System.out.println("PIZZAS SLICES: " + dataSet.getPizzasSum());
    }
}
