package com.azhar;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.*;

public class FileGenerationTest {
    @Test
    public void testZeroNumLines() {
        FileGenerator fileGenerator = new FileGenerator();
        try {
            fileGenerator.generate(0);
        } catch (Exception e) {
            assertEquals("Number is out of bound. Please enter number between 1 and 1073741823", e.getMessage());
        }
    }

    @Test
    public void testMoreThanMaxNumLines() {
        FileGenerator fileGenerator = new FileGenerator();
        try {
            fileGenerator.generate(1073741824);
        } catch (Exception e) {
            assertEquals("Number is out of bound. Please enter number between 1 and 1073741823", e.getMessage());
        }
    }

    @Test
    public void testCorrectMinNumLines() {
        FileGenerator fileGenerator = new FileGenerator();
        try {
            String filePath = fileGenerator.generate(1);
            System.err.println(filePath);

            // check if file has been created and exists.
            File file = new File(filePath);
            assertTrue(file.exists());

            // delete the file now.
            file.delete();

            assertFalse(file.exists());
        } catch (Exception e) {
            assertEquals("Number is out of bound. Please enter number between 1 and 1073741823", e.getMessage());
        }
    }

    @Test
    public void testCorrectNumLines() {
        FileGenerator fileGenerator = new FileGenerator();
        try {
            String filePath = fileGenerator.generate(100000);
            System.err.println(filePath);

            // check if file has been created and exists.
            File file = new File(filePath);
            assertTrue(file.exists());

            // delete the file now.
            file.delete();

            assertFalse(file.exists());
        } catch (Exception e) {
            assertEquals("Number is out of bound. Please enter number between 1 and 1073741823", e.getMessage());
        }
    }
}
