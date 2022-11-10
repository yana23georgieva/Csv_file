import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(CSVReader reader = new CSVReader(new FileReader("src/main/resources/oscar_age_female.csv"))) {
            List<String[]> result = reader.readAll();

            List<Oscars> movies = new ArrayList<>();

            for (String[] item :
                    result) {
                String index = item[0];
                String year = item[1];
                String age = item[2];
                String name = item[3];
                String movie = item[4];
                Oscars oscars = new Oscars(index, year, age, name, movie);
                movies.add(oscars);
            }
            System.out.println(movies);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
