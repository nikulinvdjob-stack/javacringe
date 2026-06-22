package ru.alfabank.hw.hw10;

import java.util.ArrayList;
import java.util.List;

public class TaskTracker {

    private final List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public String toString() {
        return "TaskTracker{" +
                "taskList=" + taskList +
                '}';
    }

    public String getAllTasks() {
        return this.toString();
    }

    private Task taskFinder(String name) {
        for (Task t : taskList) {
            if (t.getName().equals(name)) {
                return t;
            }
        }

        return null;
    }

    public void markTaskAsDone(String name) {
        taskFinder(name).markAsDone();
    }

    public Boolean getTaskStatus(String name) {
        return taskFinder(name).getStatus();
    }

    public void printTaskInfo() {
        int doneTaskNumber = 0;

        for (Task t : taskList) {
            doneTaskNumber += t.getStatus() ? 1 : 0;
        }

        System.out.printf(String.format("Всего задач: %d Выполнено: %d Открыто %d",
                taskList.size(),
                doneTaskNumber,
                Math.abs(taskList.size() - doneTaskNumber)));
    }

}
