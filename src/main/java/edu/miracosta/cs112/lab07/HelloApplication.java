package edu.miracosta.cs112.lab07;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class HelloApplication extends Application {
    private Label label1;
    private Label label2;
    private Button button1;
    private Button button2;
    private TextField textField;
    private int buttonPressCount = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello GUI: Your Name");

        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);

        label1 = new Label();
        label1.setText("Hello GUI World");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBottomAnchor(label1, 0.0);
        anchorPane.setRightAnchor(label1, 0.0);
        anchorPane.getChildren().add(label1);
        layout.getChildren().add(anchorPane);

        button1 = new Button("Change Text");
        button2 = new Button("Count Button Presses");

        button1.setLayoutX(50);
        button1.setLayoutY(250);
        button2.setLayoutX(200);
        button2.setLayoutY(250);

        layout.getChildren().addAll(button1, button2);

        label2 = new Label("Button pressed 0 times");
        label2.setLayoutX(100);
        label2.setLayoutY(50);
        layout.getChildren().add(label2);

        textField = new TextField();
        textField.setPrefWidth(200);
        layout.getChildren().add(textField);

        StackPane.setAlignment(textField, javafx.geometry.Pos.CENTER);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label1.setText(textField.getText());
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonPressCount++;
                label2.setText("Button pressed " + buttonPressCount + " times");
            }
        });

        primaryStage.show();
    }
}
