package ru.alfabank.hw.hw11;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static final Scanner scanner = new Scanner(System.in);

    static void main() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int coffeeVolumeInput;

        System.out.println("Скок те ☕? а?");

        try {
            coffeeVolumeInput = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("🫸Нужно было ввести число");
        }

        try {
            coffeeMachine.makeCoffee(100);
        } catch (NotEnoughWaterException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        try {
            coffeeMachine.calculateCups(1000, 0);
        } catch (ArithmeticException e) {
            System.out.println("🫸Размер ☕ не может быть 0");
        }

        try {
            String str = null;
            coffeeMachine.printCoffeeName(str);
        } catch (NullPointerException e) {
            System.out.println("🫸Название ☕ отсутствует");
        }
    }
}
