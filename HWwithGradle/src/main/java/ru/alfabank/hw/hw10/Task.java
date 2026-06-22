package ru.alfabank.hw.hw10;

public class Task {

    private String name;
    private boolean isDone = false;

    public void markTaskAsDone() {
        isDone = true;
    }

    public boolean getTaskStatus() {
        return isDone;
    }

    public String getTaskName() {
        return name;
    }

    public String getTaskInfo() {
        return isDone ? "[] Проверить авторизацию" : "[] Проверить регистрацию";
    }

}
