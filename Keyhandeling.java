package theoryjava;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Keyhandeling extends Application implements EventHandler<KeyEvent>
{

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage)
    {
      // Create a pane and set its properties
      Pane pane = new Pane();
      Text text = new Text(20, 20, "A");
      pane.getChildren().add(text);
  
      // Create a scene and place the pane in the stage
      Scene scene = new Scene(pane ,200,200);
      primaryStage.setTitle("KeyEventDemo"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
  
      text.setOnKeyPressed(e -> {
        switch (e.getCode()) {
          case DOWN: text.setY(text.getY() + 10); break;
          case UP:  text.setY(text.getY() - 10); break;
          case LEFT: text.setX(text.getX() - 10); break;
          case RIGHT: text.setX(text.getX() + 10); break;
          default:
            if (e.getText().length() > 0)
              text.setText(e.getText());
        }
      });
  
      text.requestFocus(); // text is focused to receive key input
    }
  
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
      launch(args);
    }

    @Override
    public void handle(KeyEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }
  }