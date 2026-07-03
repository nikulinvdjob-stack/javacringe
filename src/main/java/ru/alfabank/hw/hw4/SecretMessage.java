package ru.alfabank.hw.hw4;

import java.util.Scanner;

public class SecretMessage {
    //константы - настройки программы
    final static int  configIterationsCount = 5;
    final static String configMessageQuestion = "Введите часть закодированного сообщения!📜🖋️";
    final static String configMessageWarning = "Часть сообщения повреждена!🚫 Используем резервный фрагмент...📜🛟";
    final static String configMessageCurrentMessage = "Текущее зашифрованное сообщение📜: ";
    final static char configMessageSeparator = '#';

    static String triggerWarning() {
        System.out.println(configMessageWarning);
        return "XX";
    }

    static void main() {

        int i = 0;
        Scanner scanner = new Scanner(System.in);
        StringBuilder encryptedMessage = new StringBuilder();
        String userInput;

        while(i < configIterationsCount) {

            System.out.println(configMessageQuestion);

            userInput = scanner.nextLine();
            encryptedMessage.append(
                    userInput.equalsIgnoreCase("NULL") || userInput.isEmpty() ? triggerWarning() : userInput
            );//проверка на ввод null

            i++;

            if ( i < configIterationsCount)//чтобы в конце сообщения не было разделителя
                encryptedMessage.append(configMessageSeparator);
        }

        System.out.println(configMessageCurrentMessage + encryptedMessage);
    }
}
