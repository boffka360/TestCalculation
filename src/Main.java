import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        String input = in.nextLine();
        in.close();
        System.out.println("\nOutput:\n" +calc(input));
    }

    public static String calc(String input) throws Exception {

        List<String> numbers = Arrays.stream(input.split("\\+| |\\-|\\*|\\/")).filter(f -> f != "" && f != " ").toList();
        String output = "";

        if ( numbers.size() != 2)
            throw new Exception();

        String symbol = input.replaceAll("\\d", "").replaceAll(" ", "");

        if (symbol.length() != 1)
            throw new Exception();

        for (String number:numbers)
            if (Integer.parseInt(number) > 10 && Integer.parseInt(number) < 1)
                throw new Exception();

        switch (symbol) {
            case "+":
                output = String.valueOf(Integer.parseInt(numbers.get(0)) + Integer.parseInt(numbers.get(1)));
                break;
            case "-":
                output = String.valueOf(Integer.parseInt(numbers.get(0)) - Integer.parseInt(numbers.get(1)));
                break;
            case "*":
                output = String.valueOf(Integer.parseInt(numbers.get(0)) * Integer.parseInt(numbers.get(1)));
                break;
            case "/":
                output = String.valueOf(Integer.parseInt(numbers.get(0)) / Integer.parseInt(numbers.get(1)));
                break;
            default:
                throw new Exception();
        }


        return output;
    }
}