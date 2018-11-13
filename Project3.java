package project3;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Project3 extends Application {

    private Scene scene;
    private final int sceneWidth = 500;
    private final int sceneHeight = 400;
    private final String principalString = "15000";
    private final String rateString = ".05";
    private final String timeString = "30";
    private final String numOfCompString = "12";
    private final Insets insets = new Insets(2, 0, 2, 5); //Top, Right, Bottom, Left
    private final Insets radioInsets = new Insets(12, 0, 15, 5);
    private final Insets btnInsets = new Insets(0, 0, 10, 5);

    
    //BorderPane
    BorderPane borderPane = new BorderPane();

    //Hboxes
    HBox hb1;
    HBox hb2;
    HBox hb3;
    HBox hb4;
    HBox hb5;
    HBox hb6;

    //VBox
    VBox vb;

    //Text Fields
    private TextField principalTF;
    private TextField rateTF;
    private TextField timeTF;
    private TextField numOfCompTF;
    private TextField amountTF;

    //Labels
    private Label principalLabel;
    private Label rateLabel;
    private Label timeLabel;
    private Label numOfCompLabel;
    private Label amountLabel;

    //Radio Buttons
    private RadioButton futureValue;
    private RadioButton presentValue;

    //Button
    private Button calculateBtn;

    
    
    
    
    @Override
    public void start(Stage primaryStage) {

        drawVisualInterface();

        calculateBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (futureValue.isSelected()) {
                    calculateFutureValue();
                } else {
                    calculatePresentValue();
                }
            }
        });

        primaryStage.setTitle("Financial App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawVisualInterface() {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(setUpRadioButtons());
        borderPane.setCenter(setUpLabelsAndTextFields());
        calculateBtn = new Button("Calculate");
        calculateBtn.setPrefWidth(100);
        borderPane.setBottom(calculateBtn);
        scene = new Scene(borderPane, sceneWidth, sceneHeight);
    }

    //Set up radio buttons
    private HBox setUpRadioButtons() {
        futureValue = new RadioButton("Future Value");
        presentValue = new RadioButton("Present Value");
        futureValue.setSelected(true);

        ToggleGroup tg = new ToggleGroup();
        futureValue.setToggleGroup(tg);
        presentValue.setToggleGroup(tg);

        HBox radioBtns = new HBox();
        radioBtns.getChildren().add(futureValue);
        radioBtns.getChildren().add(presentValue);

        radioBtns.setPadding(radioInsets);
        radioBtns.setPrefHeight(30);
        radioBtns.setSpacing(15);

        return radioBtns;
    }

    //Setup the labels and textfields
    private VBox setUpLabelsAndTextFields() {
        VBox labelsAndTextFields = new VBox();
        labelsAndTextFields.getChildren().add(setUpPrincipal());
        labelsAndTextFields.getChildren().add(setUpRate());
        labelsAndTextFields.getChildren().add(setUpTime());
        labelsAndTextFields.getChildren().add(setUpNumberOfCompoundings());
        labelsAndTextFields.getChildren().add(setUpAmount());

        //Padding
        labelsAndTextFields.setPadding(insets); //Top, Right, Bottom, Left

        return labelsAndTextFields;
    }

    private HBox setUpPrincipal() {
        principalLabel = new Label("Principal");
        principalTF = new TextField(principalString);

        HBox principalHB = new HBox();
        principalHB.getChildren().add(principalLabel);
        principalHB.getChildren().add(principalTF);

        principalHB.setPadding(insets);
        principalHB.setSpacing(121);

        return principalHB;
    }

    private HBox setUpRate() {
        rateLabel = new Label("Rate");
        rateTF = new TextField(rateString);

        HBox rateHB = new HBox();
        rateHB.getChildren().add(rateLabel);
        rateHB.getChildren().add(rateTF);

        rateHB.setPadding(insets);
        rateHB.setSpacing(146);

        return rateHB;
    }

    private HBox setUpTime() {
        timeLabel = new Label("Time");
        timeTF = new TextField(timeString);

        HBox timeHB = new HBox();
        timeHB.getChildren().add(timeLabel);
        timeHB.getChildren().add(timeTF);

        timeHB.setPadding(insets);
        timeHB.setSpacing(143);

        return timeHB;
    }

    private HBox setUpNumberOfCompoundings() {
        numOfCompLabel = new Label("Number Of Compoundings");
        numOfCompTF = new TextField(numOfCompString);

        HBox numOfCompHB = new HBox();
        numOfCompHB.getChildren().add(numOfCompLabel);
        numOfCompHB.getChildren().add(numOfCompTF);

        numOfCompHB.setPadding(insets);
        numOfCompHB.setSpacing(10);

        return numOfCompHB;
    }

    private HBox setUpAmount() {
        amountLabel = new Label("Amount");
        amountTF = new TextField();

        HBox amountHB = new HBox();
        amountHB.getChildren().add(amountLabel);
        amountHB.getChildren().add(amountTF);

        amountHB.setPadding(insets);
        amountHB.setSpacing(126);

        return amountHB;
    }

    private void calculateFutureValue() {

        /*
        
        P = Principal
        R = Interest Rate
        N = Number of compounding a year
        T = Total Number Of Years
        
         */
        
        double p = Double.parseDouble(principalTF.getText());
        double r = Double.parseDouble(rateTF.getText());
        double n = Double.parseDouble(numOfCompTF.getText());
        double t = Double.parseDouble(timeTF.getText());

        double amountValue = p * Math.pow(1 + r / n, n * t);
        
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        String amountString = df.format(amountValue);
        
        amountTF.setText(amountString);
    }

    private void calculatePresentValue() {
        /*
        
        P = Principal
        R = Interest Rate
        N = Number of compounding a year
        T = Total Number Of Years
        
         */
        
        double p = Double.parseDouble(principalTF.getText());
        double r = Double.parseDouble(rateTF.getText());
        double n = Double.parseDouble(numOfCompTF.getText());
        double t = Double.parseDouble(timeTF.getText());

        double amountValue = p * Math.pow(1 + r / n, n * t);

        double presentValue = amountValue * Math.pow(1 + r / n, -n * t);
        
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        String amountString = df.format(presentValue);
        
        amountTF.setText(amountString);
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}

