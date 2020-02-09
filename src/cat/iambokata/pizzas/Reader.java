package cat.iambokata.pizzas;

import cat.iambokata.pizzas.models.DataSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

    public DataSet read(String filePath) throws IOException {

        DataSet dataSet = new DataSet();

        File file = new File(filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String firstLine = br.readLine();

        String[] splittedFirstLine = firstLine.split(" ");

        dataSet.setSlices(Long.parseLong(splittedFirstLine[0]));
        dataSet.setPizzaTypes(Long.parseLong(splittedFirstLine[1]));

        String secondLine = br.readLine();

        String[] splittedSecondLine = secondLine.split(" ");

        List<Long> pizzas = Arrays.stream(splittedSecondLine)
                .map(Long::parseLong)
                .collect(Collectors.toList());

        dataSet.setPizzas(pizzas);

        br.close();

        return dataSet;
    }

}
