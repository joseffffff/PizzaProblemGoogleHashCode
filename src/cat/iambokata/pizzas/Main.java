package cat.iambokata.pizzas;

import cat.iambokata.pizzas.command.PizzaSlicesCalculator;
import cat.iambokata.pizzas.io.Reader;
import cat.iambokata.pizzas.io.Writter;
import cat.iambokata.pizzas.models.DataSet;
import cat.iambokata.pizzas.models.Result;

import java.io.IOException;

public class Main {

    private static final String A_EXAMPLE = "a_example.in";
    private static final String B_SMALL = "b_small.in";
    private static final String C_MEDIUM = "c_medium.in";
    private static final String D_QUITE_BIG = "d_quite_big.in";
    private static final String E_ALSO_BIG = "e_also_big.in";

    public static void main(String[] args) throws IOException {

        Reader reader = new Reader();

        DataSet dataSet = reader.read(B_SMALL);

        System.out.println(dataSet.toString());

        PizzaSlicesCalculator pizzaSlicesCalculator = new PizzaSlicesCalculator(dataSet);

        Result result = pizzaSlicesCalculator.calculateResult();

        Writter writter = new Writter();
        writter.writeResult(result);

        printResult(dataSet, result);
    }

    private static void printResult(DataSet dataSet, Result result) {

        System.out.println(result.toString());

        Long sum = 0l;

        for (Integer l : result.getOrderingPizzasIndex()) {
            sum += dataSet.getPizzas().get(l);
        }

        System.out.println(sum);
    }
}
