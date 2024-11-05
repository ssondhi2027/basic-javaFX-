package theoryjava;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Mouseevents extends Application implements EventHandler<MouseEvent>
{

    public void start (Stage primarystage)
    {
        Pane pane = new Pane();
        Scene scene = new Scene(pane,100,100);
        primarystage.setScene(scene);
        primarystage.setTitle("mouse event");
        primarystage.show();

        pane.setOnMouseClicked(this);
        pane.setOnMousePressed(this);
        pane.setOnMouseReleased(this);
        pane.setOnMouseEntered(this);
       pane.setOnMouseExited(this);
          pane.setOnMouseMoved(this);
    }
   
    public static void main(String[] args) 
    {
        launch(args);
    }
    @Override

    public void handle(MouseEvent mouseEvent)
    {
  
         if ( mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED )
               System.out.println("Mouse has been clicked");
  
      if ( mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED )
                        System.out.println("Mouse has been pressed");
  
       if ( mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED )
              System.out.println("Mouse has been released");
  
      if ( mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED )
                       System.out.println("Mouse has been entered");
  
      if ( mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED )
              System.out.println("Mouse has been exited");
  
      if ( mouseEvent.getEventType() == MouseEvent.MOUSE_MOVED )
                  System.out.println("Mouse has been moved");
  
//   	System.out.println(mouseEvent.getEventType() + "\n");
//   	System.out.println ("X : Y - " + mouseEvent.getX() + " : " + mouseEvent.getY() + "\n");
  
//   System.out.println ( "SceneX : SceneY - " + mouseEvent.getSceneX() + " : " + mouseEvent.getSceneY() + "\n");
//      System.out.println ( "ScreenX : ScreenY - " + mouseEvent.getScreenX() + " : " + mouseEvent.getScreenY() );
  
     }
   
}
