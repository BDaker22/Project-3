package project3;

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
    
    /* CONTROLS
    1 BorderPane
    6 HBox
    1 VBox
    5 TextFields
    5 Labels
    2 Radio Buttons
    1 Button
    */
    
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
    
    /* DRAWING
    
    ===DONE===
    * put both radio buttons inside an hbox
    * Make a toggle group for radio button controls
    * put that ^ HBox inside the top of the borderPane
    * put a label and text field inside h box 1 for the principal
    * put a label and text field inside h box 2 for the rate
    * put a label and text field inside h box 3 for the time
    * put a label and text field inside h box 4 for the number of compoundings
    * put a label and text field inside h box 5 for the amount
    * put h box 1-5 in v box
    * Put that ^ vbox inside the center of the borderPane
    * put button control in bottom of borderPane
    * initial values set to the values in handout
    
    */
    
    /* CODE
    
    * code a method to draw the visual interface from above
        - Have this method call other methods to draw different elements (Optional)
    * Code a method for future value (formula on handout)
        - read in appropriate values from text fields
        - write out appropriate value to the appropriate text field
    * code a method for present value
        - read in appropriate values from text fields
        - write out appropriate value to the appropriate text field
    * Code a listener for an action event of the button control
        - condition on whether the future value radio button is selected
            > call future value method if appropriate
            > call present value method if appropriate
    * Typical code to set the scene and show the stage in the start method
    * make use of module level variables to concentrate on the logic (Optional)
    
    */
    
    
    @Override
    public void start(Stage primaryStage) {
        
        drawVisualInterface();
        
        calculateBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(futureValue.isSelected()){
                    calculateFutureValue();
                }
                else{
                    calculatePresentValue();
                }
            }
        });
        
        
        
        primaryStage.setTitle("Financial App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawVisualInterface(){
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(setUpRadioButtons());
        borderPane.setCenter(setUpLabelsAndTextFields());
        calculateBtn = new Button("Calculate");
        calculateBtn.setPrefWidth(100);
        borderPane.setBottom(calculateBtn);
        scene = new Scene(borderPane, sceneWidth, sceneHeight);
    }
    
    //Set up radio buttons
    private HBox setUpRadioButtons(){
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
    private VBox setUpLabelsAndTextFields(){
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
    
    private HBox setUpPrincipal(){
        principalLabel = new Label("Principal");
        principalTF = new TextField(principalString);
        
        
        HBox principalHB = new HBox();
        principalHB.getChildren().add(principalLabel);
        principalHB.getChildren().add(principalTF);
        
        principalHB.setPadding(insets);
        principalHB.setSpacing(121);
        
        return principalHB;
    }
    
    private HBox setUpRate(){
        rateLabel = new Label("Rate");
        rateTF = new TextField(rateString);
        
        
        HBox rateHB = new HBox();
        rateHB.getChildren().add(rateLabel);
        rateHB.getChildren().add(rateTF);
        
        rateHB.setPadding(insets);
        rateHB.setSpacing(146);
        
        return rateHB;
    }
    
    private HBox setUpTime(){
        timeLabel = new Label("Time");
        timeTF = new TextField(timeString);
        
        
        HBox timeHB = new HBox();
        timeHB.getChildren().add(timeLabel);
        timeHB.getChildren().add(timeTF);
        
        timeHB.setPadding(insets);
        timeHB.setSpacing(143);
        
        return timeHB;
    }
    
    private HBox setUpNumberOfCompoundings(){
        numOfCompLabel = new Label("Number Of Compoundings");
        numOfCompTF = new TextField(numOfCompString);
        
        HBox numOfCompHB = new HBox();
        numOfCompHB.getChildren().add(numOfCompLabel);
        numOfCompHB.getChildren().add(numOfCompTF);
        
        numOfCompHB.setPadding(insets);
        numOfCompHB.setSpacing(10);
        
        return numOfCompHB;
    }
    
    private HBox setUpAmount(){
        amountLabel = new Label("Amount");
        amountTF = new TextField();
        
        HBox amountHB = new HBox();
        amountHB.getChildren().add(amountLabel);
        amountHB.getChildren().add(amountTF);
        
        amountHB.setPadding(insets);
        amountHB.setSpacing(126);
        
        return amountHB;
    }
    
    private void calculateFutureValue(){
        
            double principalValue = Double.parseDouble(principalTF.getText());
            double rateValue = Double.parseDouble(rateTF.getText());
            double numberOfCompoundingsValue = Double.parseDouble(numOfCompTF.getText());
            double timeValue = Double.parseDouble(timeTF.getText());
            
            double amountValue = principalValue * 
                    Math.pow(1 + rateValue / numberOfCompoundingsValue, 
                            numberOfCompoundingsValue * timeValue);
        
            
            String amountString = Double.toString(amountValue);
            
            amountTF.setText(amountString);
            
            
    }
    
        private void calculatePresentValue() {
            double principalValue = Double.parseDouble(principalTF.getText());
            double rateValue = Double.parseDouble(rateTF.getText());
            double numberOfCompoundingsValue = Double.parseDouble(numOfCompTF.getText());
            double timeValue = Double.parseDouble(timeTF.getText());
            
            double amountValue = principalValue * 
                    Math.pow(1 + rateValue / numberOfCompoundingsValue, 
                            numberOfCompoundingsValue * timeValue);
            
            double presentValue = amountValue * Math.pow(1 + rateValue / numberOfCompoundingsValue,
                    -numberOfCompoundingsValue * timeValue);
        }
    
    
    /*
    
     private void convertCurrency(double dollarsPerPound, double poundsPerDollar){
        if(poundsChoice.isSelected()){
            double dollars = Double.parseDouble(dollarsValue.getText());
            double pounds = poundsPerDollar * dollars;
            poundsValue.setText(String.valueOf(pounds));
        }
        else{
            double pounds = Double.parseDouble(poundsValue.getText());
            double dollars = dollarsPerPound * pounds;
            dollarsValue.setText(String.valueOf(dollars));
        }
    }
    
    
    */
    
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*

package currencyconverter;


public class CurrencyConverter extends Application {
    private Scene scene;
    private Button convert;
    private TextField poundsValue;
    private TextField dollarsValue;
    private RadioButton poundsChoice;
    
    private final int sceneWidth = 300;
    private final int sceneHeight = 200;
    private final String poundsString = "1";
    private final String dollarsString = "1.31";
    
    
    @Override
    public void start(Stage primaryStage) {
        final double dollarsPerPound = 1.31;
        final double poundsPerDollar = .76;
        
        drawVisualInterface();
        
        convert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                convertCurrency(dollarsPerPound, poundsPerDollar);
            }
        });
        
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
    private void drawVisualInterface(){
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(setUpCurrencyChoices());
        borderPane.setCenter(setUpCurrencyInformation());
        convert = new Button("Convert");
        borderPane.setBottom(convert);
        scene = new Scene(borderPane, sceneWidth, sceneHeight);
    }
    
    private HBox setUpCurrencyChoices(){
        poundsChoice = new RadioButton("Pounds");
        RadioButton dollarsChoice = new RadioButton("Dollars");
        poundsChoice.setSelected(true);
        
        ToggleGroup tg = new ToggleGroup();
        poundsChoice.setToggleGroup(tg);
        dollarsChoice.setToggleGroup(tg);
        
        HBox currencyChoices = new HBox();
        currencyChoices.getChildren().add(poundsChoice);
        currencyChoices.getChildren().add(dollarsChoice);
        
        return currencyChoices;
    }
    
    private VBox setUpCurrencyInformation(){
        VBox currencyInformation = new VBox();
        currencyInformation.getChildren().add(setUpPoundsInformation());
        currencyInformation.getChildren().add(setUpDollarsInformation());
        
        return currencyInformation;
    }
    
    private HBox setUpPoundsInformation(){
        Label poundsName = new Label("Pounds");
        poundsValue = new TextField(poundsString);
        //poundsName.setPadding(inset);
        
        HBox poundsInformation = new HBox();
        poundsInformation.getChildren().add(poundsName);
        poundsInformation.getChildren().add(poundsValue);
        
        return poundsInformation;
    }
    
    private HBox setUpDollarsInformation(){
        Label dollarsName = new Label("Dollars");
        dollarsValue = new TextField(dollarsString);
        //poundsName.setPadding(inset);
        
        HBox dollarsInformation = new HBox();
        dollarsInformation.getChildren().add(dollarsName);
        dollarsInformation.getChildren().add(dollarsValue);
        
        return dollarsInformation;
    }
    
    private void convertCurrency(double dollarsPerPound, double poundsPerDollar){
        if(poundsChoice.isSelected()){
            double dollars = Double.parseDouble(dollarsValue.getText());
            double pounds = poundsPerDollar * dollars;
            poundsValue.setText(String.valueOf(pounds));
        }
        else{
            double pounds = Double.parseDouble(poundsValue.getText());
            double dollars = dollarsPerPound * pounds;
            dollarsValue.setText(String.valueOf(dollars));
        }
    }
    
}


*/
