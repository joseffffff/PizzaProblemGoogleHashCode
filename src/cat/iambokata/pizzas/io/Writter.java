package cat.iambokata.pizzas.io;

import cat.iambokata.pizzas.models.Result;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class Writter {

    public boolean writeResult(Result result) {

        try {
            File file = new File("result.out");
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(result.getPizzaTypes().toString() + "\n");
            fileWriter.write(
                    result.getOrderingPizzasIndex()
                            .stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(" "))
            );
            fileWriter.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
