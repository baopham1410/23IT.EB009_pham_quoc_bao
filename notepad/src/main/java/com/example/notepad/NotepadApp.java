package com.example.notepad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NotepadApp extends Application {
    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setCenter(textArea);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Notepad");
        primaryStage.setScene(scene);
        primaryStage.show();

        FileChooser fileChooser = new FileChooser();

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");

        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    String content = Files.readString(file.toPath());
                    textArea.setText(content);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        MenuItem saveItem = new MenuItem("Save");
        saveItem.setOnAction(e -> {
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file != null) {
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(textArea.getText());
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        fileMenu.getItems().addAll(openItem, saveItem);
        menuBar.getMenus().add(fileMenu);

        root.setTop(menuBar);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
