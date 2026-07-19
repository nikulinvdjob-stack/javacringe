package ru.alfabank.hw.hw14.Tests;

public class XMLUtils {
    public static String createEmptyElement(String tagName) {
        return (tagName == null || tagName.isEmpty()) ? "<invalid/>" : String.format("<%s></%s>", tagName, tagName);
    }
}
