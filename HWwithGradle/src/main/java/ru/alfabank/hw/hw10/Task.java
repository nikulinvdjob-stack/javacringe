package ru.alfabank.hw.hw10;

public class Task {

    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public boolean getStatus() {
        return isDone;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return isDone ? "[] Проверить авторизацию" : "[] Проверить регистрацию";
    }

}
