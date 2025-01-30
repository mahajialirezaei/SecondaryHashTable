package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DoubleHashTableFX extends Application {
    private DoubleHashTable hashTable;
    private TextArea outputArea;
    private TextField sizeField, keyField, valueField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Double Hash Table");
        hashTable = new DoubleHashTable(10);

        sizeField = new TextField();
        keyField = new TextField();
        valueField = new TextField();

        Button buildButton = createStyledButton("Build Table");
        Button insertButton = createStyledButton("Insert");
        Button searchButton = createStyledButton("Search");
        Button deleteButton = createStyledButton("Delete");
        Button showButton = createStyledButton("Show");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setStyle("-fx-control-inner-background: #f4f4f4; -fx-font-size: 20px;");

        GridPane inputGrid = new GridPane();
        inputGrid.setHgap(10);
        inputGrid.setVgap(5);
        inputGrid.setPadding(new Insets(10));
        inputGrid.add(new Label("Size:"), 0, 0);
        inputGrid.add(sizeField, 1, 0);
        inputGrid.add(new Label("Key:"), 0, 1);
        inputGrid.add(keyField, 1, 1);
        inputGrid.add(new Label("Value:"), 0, 2);
        inputGrid.add(valueField, 1, 2);

        HBox buttonBox = new HBox(10, buildButton, insertButton, searchButton, deleteButton, showButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        VBox mainLayout = new VBox(10, inputGrid, buttonBox, new Label("Output:"), outputArea);
        mainLayout.setPadding(new Insets(10));
        mainLayout.setStyle("-fx-background-color: #e6f7ff;");

        buildButton.setOnAction(e -> buildTable());
        insertButton.setOnAction(e -> insert());
        searchButton.setOnAction(e -> search());
        deleteButton.setOnAction(e -> delete());
        showButton.setOnAction(e -> show());


        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8px 16px;");
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #45a049; -fx-text-fill: white;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"));
        return button;
    }

    private void buildTable() {
        try {
            int size = Integer.parseInt(sizeField.getText());
            hashTable = new DoubleHashTable(size);
            outputArea.appendText("Table built with size: " + size + "\n");
        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid size input.\n");
        }
    }

    private void insert() {
        try {
            int key = Integer.parseInt(keyField.getText());
            String value = valueField.getText();
            hashTable.addKey(key, value);
            outputArea.appendText("Inserted: Key=" + key + ", Value=" + value + "\n");


        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid key input.\n");
        }
    }

    private void search() {
        try {
            int key = Integer.parseInt(keyField.getText());
            ArrayList<DoubleSet> results = new ArrayList<>();
            int hash1 = hashTable.hash1(key);
            if (hashTable.hashTable.size() > hash1) {
                for (DoubleSet s : hashTable.hashTable.get(hash1)) {
                    if (s != null && s.key == key) {
                        results.add(s);
                    }
                }
            }
            if (results.isEmpty()) {
                outputArea.appendText("Key " + key + " not found.\n");
            } else {
                StringBuilder sb = new StringBuilder("Found values for key " + key + ": ");
                for (DoubleSet s : results) {
                    sb.append(s.value).append(" ");
                }
                outputArea.appendText(sb.toString().trim() + "\n");
            }

        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid key input.\n");
        }
    }

    private void delete() {
        try {
            int key = Integer.parseInt(keyField.getText());
            boolean deleted = hashTable.DeleteFirstTable(new String[]{"delete", String.valueOf(key)}) ||
                    hashTable.DeleteSecondaryTable(new String[]{"delete", String.valueOf(key)});
            if (deleted) {
                outputArea.appendText("Key " + key + " deleted.\n");
            } else {
                outputArea.appendText("Key " + key + " not found to delete.\n");
            }

        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid key input.\n");
        }
    }

    private void show() {
        outputArea.setText(hashTable.showBothLevelHelper());


    }
}
