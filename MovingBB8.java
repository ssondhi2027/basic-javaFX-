package labfive;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MovingBB8 extends Application 
{
    public static void main(String[] args) 
    {
        launch(args); // Launch the JavaFX application
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) 
    { 
        BB8Pane pane = new BB8Pane();
        pane.setOnKeyPressed(e -> 
                                    { 
                                        if (e.getCode() == KeyCode.LEFT) 
                                        {
                                            pane.moveLeft();
                                        } 
                                        else if (e.getCode() == KeyCode.RIGHT) 
                                        {
                                            pane.moveRight();
                                        }
                                    } );

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 120);
        primaryStage.setTitle("MovingBB8"); 
        primaryStage.setScene(scene); 
        primaryStage.show();

        pane.requestFocus();
    }
} 

class BB8Pane extends Pane 
{
    private Circle circle1 = new Circle(200, 50, 15);
    private Circle circle2 = new Circle(200, 70, 20);
    private Line line = new Line(200, 25, 200, 35);

    public BB8Pane() 
    {
        line.setStroke(Color.BLACK);
        circle1.setFill(Color.CORAL);
        circle2.setFill(Color.CORAL);

        getChildren().addAll(circle1, circle2, line);
    }

    public void moveLeft() 
    {
        double x = circle1.getCenterX() - 10; // Move left by 10 pixels
        if (x - circle1.getRadius() >= 0) 
        { // Prevent moving out of bounds
            circle1.setCenterX(x);
            circle2.setCenterX(x);
            line.setStartX(x);
            line.setEndX(x);
        }
    }

    public void moveRight() 
    {
        double x = circle1.getCenterX() + 10; // Move right by 10 pixels
        if (x + circle1.getRadius() <= getWidth()) 
        { // Prevent moving out of bounds
            circle1.setCenterX(x);
            circle2.setCenterX(x);
            line.setStartX(x);
            line.setEndX(x);
        }
    }
}

