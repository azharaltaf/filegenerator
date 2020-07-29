package com.azhar;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class FileGenerator {

    public String generate(int numLines) throws Exception {
        String osTempFolder = "java.io.tmpdir";
        // To get the temporary directory and print it.
        String tempDir = System.getProperty(osTempFolder);
        System.out.println("Your OS temporary directory is " + tempDir);

        int base = 2;
        int exponent = 30;
        int result = ((int) Math.pow(base, exponent) - 1);

        // Using string builder to generate string.
        if (numLines >= 1 && numLines <= result) {
            Random random = new Random();
            File file = new File(System.getProperty("java.io.tmpdir"), "StringGenerator.txt"); // Generating the file in temporary directory and print it.
            FileWriter writer = new FileWriter(file.getAbsoluteFile());
            int leftLimit = 97;
            int rightLimit = 122;

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < numLines; i++) {
                String generatedString = random.ints(leftLimit, rightLimit)
                        .limit(100)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                if (i > 0) {
                    builder.append("\n");
                }
                builder.append(generatedString);

                // Taking 1000 lines and print to a file.
                if (i % 1000 == 0) {
                    writer.write(builder.toString());
                    builder.setLength(0);
                }
            }

            if (builder.length() > 0) {
                writer.write(builder.toString());
                builder.setLength(0);
            }

            writer.close();

            return file.getPath();
        } else {
            throw new Exception(String.format("Number is out of bound. Please enter number between 1 and %d", result));
        }
    }
}
