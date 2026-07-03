import java.time.LocalDate;
import java.util.Random;

public class Homework5 {
    static void main(String[] args) {
        String codeAccess = generateAccessCode();
        isValidCode(codeAccess, 8);
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);
        int[] seeds = new int[]{42, 77, 13};
        for (int seed : seeds) {

            System.out.println(generateAgentId("AGENT", seed));
        }
    }

    public static String generateAccessCode() {
        return LocalDate.now().getYear() + "-" + (int) Math.pow(3, 7);
    }

    private static boolean isValidCode(String code, int minLength) {
        return code != null & code.length() >= minLength & code.contains("-");
    }

    public static void logEvent(String message) {
        System.out.printf("[INFO] %s%n", message);
    }

    public static void logEvent(String message, boolean isCritical) {
        if (isCritical) {
            System.out.printf("[CRITICAL] %s%n", message);
        } else {
            logEvent(message);
        }
    }

    public static String generateAgentId(String prefix, int seed) {
        Random random = new Random(seed);

        return prefix + "-" + random.nextInt(1000, 9999);
    }
}
