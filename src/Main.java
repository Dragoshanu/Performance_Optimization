import java.util.Scanner;

public class Main {
    private static final String UPDATE_CMD = "UPDATE";
    private static final String IS_PRIME_CMD = "PRIME?";
    private static final String IS_PERFECT_CMD = "PERFECT?";
    private static final String IS_MAGIC_CMD = "MAGIC?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initial_number = scanner.nextInt();
        scanner.nextLine();
        LazyNumberDetails lnd = new LazyNumberDetails(initial_number);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals(IS_PRIME_CMD)) {
                System.out.println(lnd.isPrime());
            } else if (line.equals(IS_PERFECT_CMD)) {
                System.out.println(lnd.isPerfect());
            } else if (line.equals(IS_MAGIC_CMD)) {
                System.out.println(lnd.isMagic());
            } else if (line.startsWith(UPDATE_CMD)) {
                int new_number = Integer.parseInt(line.substring(UPDATE_CMD.length() + 1));
                lnd.updateNumber(new_number);
            } else {
                System.out.println("INVALID OPERATION!");
            }
        }
    }
}