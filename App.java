package labfive;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class App extends Application 
{

    public void start(Stage primaryStage) throws Exception 
    {
       Pane root = new Pane();
       Scene scene = new Scene(root , 800 , 600);
       // create circle face
       Circle face = new Circle();
       face.setCenterX(250);
       face.setCenterY(250);
       face.setRadius(200);
       face.setStroke(Color.BLACK);
       face.setFill(Color.WHITE);
       face.setStrokeWidth(4);

       // nose
       Polygon polygon1 = new javafx.scene.shape.Polygon(200,270,305,270,250.5,200);
       polygon1.setStroke(Color.BLACK);
       polygon1.setFill(Color.WHITE);
       polygon1.setStrokeWidth(3);
   
       // circle left eye
       Circle lefteye = new Circle();
       lefteye.setCenterX(140);
       lefteye.setCenterY(140);
       lefteye.setRadius(20);
       lefteye.setStroke(Color.BLACK);
       lefteye.setFill(Color.BLACK);
       lefteye.setStrokeWidth(3);

       // left eye circle
       Circle lefteyecircle = new Circle();
       lefteyecircle.setCenterX(140);
       lefteyecircle.setCenterY(140);
       lefteyecircle.setRadius(25);
       lefteyecircle.setStroke(Color.BLACK);
       lefteyecircle.setFill(Color.WHITE);
       lefteyecircle.setStrokeWidth(3);

       // circle right eye
       Circle rightteye = new Circle();
       rightteye.setCenterX(360);
       rightteye.setCenterY(140);
       rightteye.setRadius(20);
       rightteye.setStroke(Color.BLACK);
       rightteye.setFill(Color.BLACK);
       rightteye.setStrokeWidth(3);
        
       // right eye circle
       Circle rightteyecCircle = new Circle();
       rightteyecCircle.setCenterX(360);
       rightteyecCircle.setCenterY(140);
       rightteyecCircle.setRadius(25);
       rightteyecCircle.setStroke(Color.BLACK);
       rightteyecCircle.setFill(Color.WHITE);
       rightteyecCircle.setStrokeWidth(3);

       // mouth
       Arc mouth = new Arc(250, 300, 100, 90, -140, 100);
       mouth.setFill(Color.WHITE);
       mouth.setType(ArcType.OPEN);
       mouth.setStroke(Color.BLACK);
       mouth.setStrokeWidth(3);

       // add components to pane
       root.getChildren().addAll(face,lefteyecircle,rightteyecCircle,lefteye,rightteye,mouth,polygon1);
       primaryStage.setTitle("Smile face");
       primaryStage.setScene(scene);
       primaryStage.show();
    }
    public static void main(String[] args) 
    {
        launch(args);
    }



}