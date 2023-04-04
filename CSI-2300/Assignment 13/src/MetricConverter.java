import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MetricConverter extends Application {
  private TextField OriginalUnit = new TextField();
  private TextField ConvertedUnit = new TextField();
  private TextField OriginalAmnt = new TextField();
  private TextField ConvertedAmnt = new TextField();
  private Button btCalculate = new Button("Calculate");
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Original Unit (Abbreviated Form) "), 0, 0);
    gridPane.add(OriginalUnit, 1, 0);
    gridPane.add(new Label("Original Amount"), 0, 1);
    gridPane.add(OriginalAmnt, 1, 1);
    gridPane.add(new Label("Converted Unit"), 0, 2);
    gridPane.add(ConvertedUnit, 1, 2);
    gridPane.add(new Label("Converted Amount"), 0, 3);
    gridPane.add(ConvertedAmnt, 1, 3);
    gridPane.add(btCalculate, 1, 4);

    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    OriginalAmnt.setAlignment(Pos.BOTTOM_RIGHT);
    OriginalUnit.setAlignment(Pos.BOTTOM_RIGHT);
    ConvertedUnit.setAlignment(Pos.BOTTOM_RIGHT);
    ConvertedAmnt.setAlignment(Pos.BOTTOM_RIGHT);
    ConvertedUnit.setEditable(false);
    ConvertedAmnt.setEditable(false);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);

    // Process events
    btCalculate.setOnAction(e -> MetricConversion());

    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("MetricConverter"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  private void MetricConversion() {
    // Get values from text fields
    String Unit = OriginalUnit.getText().toLowerCase().strip();
    double Amnt = Double.parseDouble(OriginalAmnt.getText());

    // Create a Converter object
    Converter converted = new Converter(Amnt, Unit);
    
    // Display Converted Unit and Converted Value
    ConvertedUnit.setText(Converter.ConvertedOutput(converted).unit);
    ConvertedAmnt.setText(String.valueOf(Converter.ConvertedOutput(converted).value));
      
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
