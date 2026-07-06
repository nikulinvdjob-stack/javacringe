package ru.alfabank.hw.hw11;

public class CoffeeMachine {

    static final int waterVolumeTrashhold = 200;

    public void makeCoffee(int waterVolume) {
        if (waterVolume <= waterVolumeTrashhold) {
            throw new NotEnoughWaterException("Недостаточно воды для ☕");
        } else {
            System.out.println("Ваш ☕ готов");
        }
    }

    public int calculateCups(int waterVolume, int cupVolume) {
        return waterVolume / cupVolume;
    }

    public void printCoffeeName(String coffeeName) {
        System.out.println(coffeeName.toUpperCase());
    }
}
