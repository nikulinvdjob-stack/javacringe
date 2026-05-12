import java.time.Year;
import java.util.Random;

public class AlfaLab {

    static String generateAccessCode() {
        return Year.now().toString() + "-" + ((int) Math.pow(3, 7));
    }

    public static boolean isValidCode(String code, int minLength) {
        return code != null &&
                code.length() >= minLength &&
                code.contains("-");
    }

    private static void logEvent(String message) {
        System.out.printf(String.format("[INFO] {%s}\n", message));
    }

    public static void logEvent(String message, boolean isCritical) {
        if (isCritical)
            System.out.printf(String.format("[CRITICAL] {%s}\n", message));
        else
            logEvent(message);
    }

    public static String generateAgentId(String prefix, int seed) {
        Random random = new Random(seed);
        int min = 1000;
        int max = 9999;
        return String.format("{" + prefix + "}-{%s}",
                random.nextInt((max - min) + 1) + min);
    }

    static void main() {
        String code = generateAccessCode();
        int[] seeds = {42, 77, 13};

        logEvent(code);
        logEvent(String.format("Результат проверки кода: %b", isValidCode(code, 8)));
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);
        for (int i = 0; i < seeds.length; i++) {
            logEvent(generateAgentId("AGENT", seeds[i]));
        }

    }
}
