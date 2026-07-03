package ru.alfabank.hw.hw3;

import java.util.Random;

public class HomeWork_32 {

    public static int configPasswordNumber = 3;

    public static String getRandomString(int length) {
        String characters = "qwertyuiop[asdfghjkl;'zxcvbnm,./QWERTYUIOP{}ASDFGHJKL:ZXCVBNM<>?";
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int substringIndex = random.nextInt(characters.length());
            result.append(characters.charAt(substringIndex));
        }

        return result.toString();
    }

    public static Boolean IsPasswordValid(String password) {
        boolean result = false;
        int passwordRequiredLength = 8;
        char passwordIlligalFirstChar = '1';
        char passwordIlligalLastChar = 'z';
        String[] passwordIlligalSubstring = {"1234", "qwerty"};

        if (password.length() > passwordRequiredLength) {
            if (password.charAt(0) != passwordIlligalFirstChar) {
                if (password.charAt(password.length() - 1) != passwordIlligalLastChar) {
                    for (var i = 0; i < passwordIlligalSubstring.length; i++) {
                        if (!password.contains(passwordIlligalSubstring[i])) {
                            result = true;
                        }
                    }
                }
            }
        }

        return result;
    }

    static void main() {

        String[] passwords = new String[configPasswordNumber];
        Random random = new Random();
        int min = 1;
        int max = 20;

        for (var i = 0; i < passwords.length; i++) {
            passwords[i] = getRandomString(min + random.nextInt(max - min + 1));
            System.out.println("Пасворд №" + i + ": " + passwords[i]);
            System.out.println("Валиден ли пароль?" +
                    (IsPasswordValid(passwords[i]) ? "Еще как! ✅" : "Нет, переделывай! ❌"));
        }

    }
}
