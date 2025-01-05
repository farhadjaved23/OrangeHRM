
package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int generateRandomNumber() {
        return random.nextInt(6) + 1;
    }

    public static String generateRandomFirstName() {
        Random random = new Random();
        String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "Chris", "Sarah"};
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        return firstName;
    }

    public static String generateRandomLastName() {
        Random random = new Random();
        String[] LAST_NAMES = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown"};
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return lastName;
    }

    public static String generatePostalCode() {
        Random random = new Random();
        return String.format("%05d", random.nextInt(100000));
    }

    public static List<Integer> generateUniqueRandomNumbers(int count, int max) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < count) {
            int number = random.nextInt(max) + 1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }


    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public String getFormattedDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
        return today.format(formatter);
    }
}
