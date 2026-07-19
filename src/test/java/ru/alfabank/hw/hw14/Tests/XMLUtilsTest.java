package ru.alfabank.hw.hw14.Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class XMLUtilsTest {

    @Test
    void validXml() {

        String tagName = "lox";
        String expected = "<lox></lox>";

        String actual = XMLUtils.createEmptyElement(tagName);

        assertEquals(expected, actual, "Должно быть <lox></lox>");
    }

    @Test
    void invalidXml_nullInput() {

        String tagName = null;
        String expected = "<invalid/>";

        String actual = XMLUtils.createEmptyElement(tagName);

        assertEquals(expected, actual, "Инвалид");
    }

    @Test
    void invalidXml_emptyInput() {

        String tagName = "";
        String expected = "<invalid/>";

        String actual = XMLUtils.createEmptyElement(tagName);

        assertEquals(expected, actual, "Инвалид");
    }
}
