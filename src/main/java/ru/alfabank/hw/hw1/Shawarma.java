package ru.alfabank.hw.hw1;
/*
Создай главный метод - точку входа в Java приложение.

В этом методе задай переменные

- имя сотрудника (строка)

- должность (строка)

- ставка за одну смену (число)

- количество смен (число)

- премия (число)

- штраф сотрудника за подгоревший лаваш (число)

- цена 1 шаурмы (число)

- количество штук проданной шаурмы (число)



В этом же методе напиши код, который выведет:

- данные о сотруднике (имя, должность)

- зарплату без премии (зарплата = количество смен умножить на ставку за одну смену)

- штраф, премию и итоговую зарплату с учетом премии и штрафом

- выручку (количество проданной шарумы умножить на стоимость шаурмы)



Пример консольного вывода:

Сотрудник: Глеб

Должность: Старший шаурма-инженер

Оплата за смены: 16000

Премия: 3000

Штраф: 500

Итоговая зарплата: 18500

Шаур-выручка: 900000
*/

import java.util.Random;
import java.io.IOException;

public class Shawarma {

    public static void main(String[] args) {

        //Кириллица
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c chcp 65001");
            process.waitFor();
            System.out.println("Кодировка изменена на UTF-8");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        //Инициализация перменных
        String[]  employeeName = {
            "Вася",
            "Петя",
            "Сеня",
            "Леня",
            "Добби"
        };

        String[]  employeePost = {
            "Шаурмэн",
            "Шармвумэн",
            "Дегустатор",
            "Ловец Кошек",
            "Кассир"
        };

        int size = 5;
        Random random = new Random();
        int min = 10;
        int max = 1000;

        double  shiftRate       = min + (max - min) * random.nextDouble();
        int     shiftNumber     = min + random.nextInt(max);
        double  shiftSalary     = shiftRate * shiftNumber;
        double  shiftBonus      = min + (max - min) * random.nextDouble();
        double  shiftFine       = -1 * (min + (max - min) * random.nextDouble()); 
        double  shawarmaPrice   = min + (max - min) * random.nextDouble();
        int     shawarmaSold    = min + random.nextInt(max);
        
        //Сообщение для вывода с подстановкой значений
        String message = String.format(
            "Сотрудник: %s\n" +
            "Должность: %s\n" + 
            "Количество смен: %d\n" +
            "Цена за одну смену: %.2f\n" +
            "Оплата за смены: %.2f\n" +
            "Премия: %.2f\n" +
            "Штраф: %.2f\n" +
            "Итоговая зарплата: %.2f\n" +
            "Продано шаурмы: %d\n" +
            "Цена за одну шаурму: %.2f\n" +
            "Шаур-выручка: %.2f",
            employeeName[random.nextInt(size)],
            employeePost[random.nextInt(size)],
            shiftNumber,
            shiftRate,
            shiftSalary,
            shiftBonus,
            shiftFine,
            shiftSalary + shiftBonus + shiftFine,
            shawarmaSold,
            shawarmaPrice,
            shawarmaSold * shawarmaPrice
            );

        //Вывод результата через абзац
        System.out.println("");
        System.out.println(message);
    }

}