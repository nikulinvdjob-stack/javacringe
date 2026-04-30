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

        String configOutFormat = "Test #%d: %s\n";
        String testStatus;
        boolean outIsEnabled;
        int criticalsNumber = 0;

        for (int i = 1; i <= configAutoTestNumber; i++) {
            outIsEnabled = true;
            testStatus = getTestStatus(i);

            //Шумоподавления
            if (configShowOnlyIssuesEnabled)
                if (!testStatus.equals(TestStatusNames.PASS.getName()))
                    outIsEnabled = false;

            if (outIsEnabled)
                System.out.printf(String.format(configOutFormat, i, getTestStatus(i)));

            //Стоп-сигнал
            if (configStopSignalEnabled) {
                if (testStatus.equals(TestStatusNames.CRITICAL.getName()))
                    criticalsNumber++;

                if (criticalsNumber == configStopSignalNumber)
                    break;
            }
        }

    }
}
