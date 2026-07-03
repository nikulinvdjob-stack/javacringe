package ru.alfabank.hw.hw4;

public class NightShift {
    //константы - настройки программы
    final static boolean configShowOnlyIssuesEnabled = false;//шумоподавление это ваше
    final static boolean configStopSignalEnabled = false;//стоп-сигнал этот ваш
    final static int configStopSignalNumber = 3;//стоп-сигнал этот ваш


    final static int configAutoTestNumber = 100;

    //энамчик для названий статусов
    enum TestStatusNames {
        FLAKY("Flaky🥴"),
        BUG("Bug🐞"),
        CRITICAL("Critical!🔥"),
        PASS("Pass✅");

        private final String name;

        TestStatusNames(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    //функция определения статуса по номеру теста
    static String getTestStatus(int testNumber) {
        boolean IsDividedByThree = (testNumber % 3 == 0);
        boolean IsDividedByFive = (testNumber % 5 == 0);
        String result = TestStatusNames.PASS.getName();

        if (IsDividedByThree && IsDividedByFive)
            result = TestStatusNames.CRITICAL.getName();
        else if (IsDividedByThree)
            result = TestStatusNames.FLAKY.getName();
        else if (IsDividedByFive)
            result = TestStatusNames.BUG.getName();

        return result;
    }

    static void main() {

        String statusOutFormat = "Test #%d: %s\n";
        String testStatus;
        boolean outIsEnabled;
        int[] statusNumber = new int[TestStatusNames.values().length];

        for (int i = 1; i <= configAutoTestNumber; i++) {
            outIsEnabled = true;
            testStatus = getTestStatus(i);

            //Шумоподавления
            if (configShowOnlyIssuesEnabled)
                if (!testStatus.equals(TestStatusNames.PASS.getName()))
                    outIsEnabled = false;

            if (outIsEnabled)
                System.out.printf(String.format(statusOutFormat, i, getTestStatus(i)));

            if (testStatus.equals(TestStatusNames.FLAKY.getName()))
                statusNumber[TestStatusNames.FLAKY.ordinal()]++;
            if (testStatus.equals(TestStatusNames.BUG.getName()))
                statusNumber[TestStatusNames.BUG.ordinal()]++;
            if (testStatus.equals(TestStatusNames.CRITICAL.getName()))
                statusNumber[TestStatusNames.CRITICAL.ordinal()]++;
            if (testStatus.equals(TestStatusNames.PASS.getName()))
                statusNumber[TestStatusNames.PASS.ordinal()]++;

            //Стоп-сигнал
            if (configStopSignalEnabled)
                if (statusNumber[TestStatusNames.CRITICAL.ordinal()] == configStopSignalNumber)
                    break;
        }

        String resultOutFormat =
                "===== ИТОГИ НОЧНОЙ СМЕНЫ =====\n" +
                        "Всего тестов: %d\n" +
                        "Pass: %d\n" +
                        "Flaky: %d\n" +
                        "Bug: %d\n" +
                        "Critical: %d";

        System.out.printf(String.format(resultOutFormat,
                configAutoTestNumber,
                statusNumber[TestStatusNames.PASS.ordinal()],
                statusNumber[TestStatusNames.FLAKY.ordinal()],
                statusNumber[TestStatusNames.BUG.ordinal()],
                statusNumber[TestStatusNames.CRITICAL.ordinal()]));

    }
}
