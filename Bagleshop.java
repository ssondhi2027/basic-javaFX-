package theoryjava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bagleshop extends Application implements EventHandler<ActionEvent>
{
     private ToggleGroup bagleGroup;
     private TextField whiTextArea;
     private TextField wholewheatTextArea;
     private TextField regular;
     private TextField cappacchinoTextArea;
     private TextField cafeTextArea;
     private Button resetButton;
     private Button exitButton;
     private TextArea resultArea;
     private Button totalButton;
     private CheckBox checkBox1;
     private CheckBox checkBox2;
     private CheckBox checkBox3;
     private CheckBox checkBox4;
     private CheckBox checkBox5;

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
       
        MenuBar mbar = new MenuBar();
        mbar.prefWidthProperty().bind(primaryStage.widthProperty());

        Menu fileMenu = new Menu("File");
        mbar.getMenus().add(fileMenu);
        MenuItem oneItem = new MenuItem("Print File");
        fileMenu.getItems().add(oneItem);
        oneItem.setOnAction(e -> files());
        MenuItem twoItem = new MenuItem("Print To Printer");
        twoItem.setOnAction(event -> printNode(mbar));
        fileMenu.getItems().add(twoItem);

        
        GridPane grid = new GridPane();
 
        grid.setVgap(5);
        grid.setHgap(5);

		Label myLabel = new Label("Pick A Bagle ");
        HBox hBox1 = new HBox(myLabel);
       

		RadioButton r1 = new RadioButton("None                          Qty:");
        
        HBox hBox2 = new HBox (r1);

		RadioButton r2 = new RadioButton("White ($1.25)            "); 
        r2.setOnAction(e -> {
            whiTextArea.setDisable(!r2.isSelected());
        });
        whiTextArea = new TextField("0");
        whiTextArea.setDisable(true);
        
        HBox hBox3 = new HBox (r2,whiTextArea);

		RadioButton r3 = new RadioButton("Whole Wheat ($1.50)"); 
        r3.setOnAction(e -> {
            wholewheatTextArea.setDisable(!r3.isSelected());
        });

         wholewheatTextArea = new TextField("0");
         wholewheatTextArea.setDisable(true);
       
        HBox hBox4 = new HBox (r3 , wholewheatTextArea);

        VBox vBox = new VBox(hBox1,hBox2,hBox3,hBox4);
        
        bagleGroup = new  ToggleGroup();
        r1.setToggleGroup(bagleGroup);
        r2.setToggleGroup(bagleGroup);
        r3.setToggleGroup(bagleGroup);
        Label toppingsLabel = new Label("Pick Your Toppings");
         checkBox1 = new CheckBox("Cream Cheese ($.50)");
         checkBox2 = new CheckBox("Butter ($.25)");
         checkBox3 = new CheckBox("Blueberry Jam ($.75)");
         checkBox4 = new CheckBox("Raspberry Jam ($.75)");
         checkBox5 = new CheckBox("Peach Jelly ($.75)");

        VBox vBox1 = new VBox(toppingsLabel,checkBox1, checkBox2 , checkBox3 , checkBox4 , checkBox5);

        Label coffeeLabel = new Label("Want Coffee with That ");
        HBox hBox5 = new HBox(coffeeLabel);

		// create radiobuttons
		RadioButton r4 = new RadioButton("None                      Qty:");
        HBox hBox6 = new HBox (r4);
        

		RadioButton r5 = new RadioButton("Regular ($1.25)      ");
        r5.setOnAction(e -> {
            regular.setDisable(!r5.isSelected());
         }); 
         regular = new TextField("0");
         regular.setDisable(true);
        HBox hBox7 = new HBox (r5,regular);

		RadioButton r6 = new RadioButton("Cappaccino ($2.00)"); 
        r6.setOnAction(e -> {
            cappacchinoTextArea.setDisable(!r6.isSelected());
         });
         cappacchinoTextArea = new TextField("0");
         cappacchinoTextArea.setDisable(true);
        HBox hBox8 = new HBox (r6,cappacchinoTextArea);

        RadioButton r7 = new RadioButton("Cafe Au Lait ($1.75)");
        r7.setOnAction(e -> {
            cafeTextArea.setDisable(!r7.isSelected());
         });
         cafeTextArea = new TextField("0");
         cafeTextArea.setDisable(true);
        HBox hBox9 = new HBox (r7,cafeTextArea);

        r4.setToggleGroup(bagleGroup);
        r5.setToggleGroup(bagleGroup);
        r6.setToggleGroup(bagleGroup);
        r7.setToggleGroup(bagleGroup);
        VBox vBox2 = new VBox(hBox5,hBox6,hBox7,hBox8,hBox9);

        
        Label summeryLabel = new Label("Price Summary");
 
        resultArea = new TextArea();
        resultArea.setDisable(true);
       resultArea.setPrefHeight(100);
       resultArea.setEditable(true);
       
        VBox vBox3 = new VBox(summeryLabel,resultArea);

        StackPane pane1 = new StackPane(vBox);
        StackPane pane2 = new StackPane(vBox1);
        StackPane pane3 = new StackPane(vBox2);
        StackPane pane4 = new StackPane(vBox3);

        grid.add(pane1, 0, 0);
        grid.add(pane2,0,1);
        grid.add(pane3, 1, 0);
        grid.add(pane4, 1, 1);

         totalButton = new Button("_Calculate Total");
         totalButton.setOnAction(this);
        
        resetButton = new Button("_Reset Button");
        resetButton.setOnAction(e -> clearFields());
        
        
        exitButton = new Button("E_xit System");
        exitButton.setOnAction(this);


        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(totalButton,resetButton,exitButton);
        flowPane.setAlignment(Pos.CENTER);
         
        
        primaryStage.setTitle("Sheridan Bagle Shop");  
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(mbar);
        borderPane.setBottom(flowPane);
        borderPane.setLeft(grid);
        BackgroundFill backgroundFill = new BackgroundFill(Color.WHITE, null, null);
        Background background = new Background(backgroundFill);
        pane1.setBackground(background);
        pane2.setBackground(background);
        pane3.setBackground(background);
        pane4.setBackground(background);
        BackgroundFill backgroundFill2 = new BackgroundFill(Color.WHITE, null, null);
        Background background2 = new Background(backgroundFill2);
        grid.setBackground(background2);
   
        Scene scene = new Scene(borderPane, 750, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    private void clearFields() 
        {
            whiTextArea.clear();
            wholewheatTextArea.clear();
            regular.clear();
            cappacchinoTextArea.clear();
            cafeTextArea.clear();

        }
        private void files ()
        {
             double whiText = Double.parseDouble(whiTextArea.getText());
                double wholewheatText = Double.parseDouble(wholewheatTextArea.getText());
                double regularText = Double.parseDouble(regular.getText());
                double cappacchinoText = Double.parseDouble(cappacchinoTextArea.getText());
                double cafeText = Double.parseDouble(cafeTextArea.getText());
                File myfile = new File("receipt.txt");
                try {
                   
                      myfile.createNewFile();
                      {
                        System.out.println("File created: " + myfile.getName());
                    } 
                }
                  catch (IOException e) 
                  {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }
               
                  try (FileWriter myFileWriter = new FileWriter("receipt.txt")) 
                  {
                    myFileWriter.write("*************SHERIDAN BAGEL SHOP*************" 
                                            +"\n Mon Apr 02 15:18:52 EDT 2018 "
                                            +"\n Item:           Qty       Amount"
                                            +"\n White Bagel    "+whiText+"          "+whiText*1.25+""
                                            +"\n Whole Wheat    "+wholewheatText+"          "+wholewheatText*1.50+""
                                            +"\n regular        "+regularText+"          "+regularText*1.25+""
                                            +"\n cappacchino    "+cappacchinoText+"          "+cappacchinoText*2.00+""
                                            +"\n cafe Au lait   "+cafeText+"          "+cafeText*1.75+""
                                            +"\n                          ---------------"
                                            +"\n            Pre Tax total : "+( whiText*1.25 + wholewheatText*1.50 + regularText*1.25 + cappacchinoText*2.00 + cafeText*1.75 + 0.75 )+""
                                            +"\n            Total Tax     : " +(( ( whiText*1.25 + wholewheatText*1.50 + regularText*1.25 + cappacchinoText*2.00 + cafeText*1.75  + 0.75) *0.13) )+""
                                            +"\n            Sub Total     : "+(( whiText*1.25 + wholewheatText*1.50 + regularText*1.25 + cappacchinoText*2.00 + cafeText*1.75  + 0.75)+( ( whiText*1.25 + wholewheatText*1.50 + regularText*1.25 + cappacchinoText*2.00 + cafeText*1.75 + 0.75) *0.13))+""
                                            +"\n *********THANK YOU FOR YOUR ORDER*********\r\n" + //
                                                                                                "");
                    myFileWriter.close();
                    } 

                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
             private void printNode(Node node) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(node.getScene().getWindow())) 
        {
            boolean success = job.printPage(node);
            if (success) {
                job.endJob();
            }
        }
    }
        @Override
        public void handle(ActionEvent e) 
        {

                   if (exitButton == e.getSource())
                  System.exit(0); 

                    double whiText = Double.parseDouble(whiTextArea.getText());
                    double wholewheatText = Double.parseDouble(wholewheatTextArea.getText());
                    double regularText = Double.parseDouble(regular.getText());
                    double cappacchinoText = Double.parseDouble(cappacchinoTextArea.getText());
                    double cafeText = Double.parseDouble(cafeTextArea.getText());
                 
                    if (totalButton == e.getSource())
                    resultArea.setText ("Sub Total : " +( whiText*1.25 + wholewheatText*1.50 + regularText*1.25 + cappacchinoText*2.00 + cafeText*1.75  + 0.75)+ "\n Sale Tax : " +(( ( whiText*1.25 + wholewheatText*1.50 + regularText*1.25 + cappacchinoText*2.00 + cafeText*1.75 + 0.75) *0.13) ) + "\n Total Sale : " +(( whiText*1.25 + wholewheatText*1.50 + regularText*1.25 + cappacchinoText*2.00 + cafeText*1.75  + 0.75)+( ( whiText*1.25 + wholewheatText*1.50 + regularText*1.25 + cappacchinoText*2.00 + cafeText*1.75 + 0.75) *0.13)));
                    
                    
        }
          
            public static void main(String[] args) 
    {
        launch(args);
    }

    
}
