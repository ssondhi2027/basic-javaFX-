package labfive;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application 
{

    private TextField firstOperandField;
    private TextField secondOperandField;
    private TextField resultField;

    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // First operand lable 
        Label firstOperandLabel = new Label("First Operand");
        GridPane.setConstraints(firstOperandLabel, 0, 0);
        // fist operand text field
        firstOperandField = new TextField();
        GridPane.setConstraints(firstOperandField, 1, 0);
        // second operand label
        Label secondOperandLabel = new Label("Second Operand");
        GridPane.setConstraints(secondOperandLabel, 0, 1);
        // second operand text field
        secondOperandField = new TextField();
        GridPane.setConstraints(secondOperandField, 1, 1);
        // third result label
        Label resultLabel = new Label("Result");
        GridPane.setConstraints(resultLabel, 0, 2);
        // result text field
        resultField = new TextField();
        resultField.setEditable(false);
        GridPane.setConstraints(resultField, 1, 2);

        // ADD button
        Button addButton = new Button("Add");
        GridPane.setConstraints(addButton, 0, 3);
        addButton.setOnAction(e -> calculate('+'));

        // subtract button
        Button subtractButton = new Button("Subtract");
        GridPane.setConstraints(subtractButton, 1, 3);
        subtractButton.setOnAction(e -> calculate('-'));

        // clear button
        Button clearButton = new Button("Clear");
        GridPane.setConstraints(clearButton, 2, 3);
        clearButton.setOnAction(e -> clearFields());

        // Add everything to grid
        grid.getChildren().addAll(firstOperandLabel, firstOperandField, secondOperandLabel, secondOperandField, resultLabel, resultField, addButton, subtractButton, clearButton);

        // Set up scene and stage
        Scene scene = new Scene(grid, 311, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(char operator) 
    {
        // try and catch block is used to check either code throws any exception or not
        try {
            double firstOperand = Double.parseDouble(firstOperandField.getText());
            double secondOperand = Double.parseDouble(secondOperandField.getText());
            double result = 0;

            if (operator == '+') 
            {
                result = firstOperand + secondOperand;
            } 
            else if (operator == '-') 
            {
                result = firstOperand - secondOperand;
            }
            
            resultField.setText(String.valueOf(result));
      
        } catch (NumberFormatException e) {
            resultField.setText("Error");
        }
    }

    // clearField() method is used to clear the text field for both first operand and second operand 
    private void clearFields() 
    {
        firstOperandField.clear();
        secondOperandField.clear();
        resultField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

