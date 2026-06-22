package ru.alfabank.hw.hw10;

public class Main {

    static void main() {

        TaskTracker tt = new TaskTracker();

        for (int i = 0; i < 100; i++) {
            tt.addTask(new Task("Таска №" + i));

            if (i % 2 == 0) {
                tt.markTaskAsDone("Таска №" + i);
            }
        }

        tt.printTaskInfo();

    }

}
