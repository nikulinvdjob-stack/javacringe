package ru.alfabank.hw.hw13;

import java.util.LinkedList;

public class AssaultQueue {
    private LinkedList<String> queue = new LinkedList<>();

    public void addRecruit(String name) {
        queue.addLast(name);
    }

    public String retreatCoward() {
        return queue.removeFirst();
    }

    public void printQueue() {
        System.out.println(queue);
    }

    @Override
    public String toString() {
        return "AssaultQueue{" +
                "queue=" + queue +
                '}';
    }
}
