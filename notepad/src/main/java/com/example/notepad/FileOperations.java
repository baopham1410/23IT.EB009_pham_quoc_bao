package com.example.notepad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {
    public static void main(String[] args) {
        String fileName = "test.txt";
        String content = "Hello, World!";

        createFile(fileName);
        saveFile(fileName, content);
        writeFile(fileName, content);
        readFile(fileName);
        getPath(fileName);
        deleteFile(fileName);
        createDirectory("testDir");
    }

    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void saveFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Successfully saved file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("\n" + content);
            writer.close();
            System.out.println("Successfully wrote to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            String content = Files.readString(path);
            System.out.println("File content:\n" + content);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void getPath(String fileName) {
        Path path = Paths.get(fileName);
        System.out.println("File path: " + path.toAbsolutePath());
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void createDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (directory.mkdir()) {
            System.out.println("Directory created: " + directory.getName());
        } else {
            System.out.println("Failed to create directory.");
        }
    }
}
