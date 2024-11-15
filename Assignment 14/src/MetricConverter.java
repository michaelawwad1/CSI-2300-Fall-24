import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MetricConverter extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        // Create UI components
        Label selectLabel = new Label("Select a conversion:");
        ComboBox<String> conversionBox = new ComboBox<>();
        conversionBox.getItems().addAll(
                "1. kg to lb",
                "2. meter to feet",
                "3. mile to km",
                "4. inch to mm");

        Label inputLabel = new Label("Enter the value to convert:");
        TextField inputField = new TextField();
        Label resultLabel = new Label();

        Button convertButton = new Button("Convert");
        Button resetButton = new Button("Reset");

        // Layout setup
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(selectLabel, conversionBox, inputLabel, inputField, convertButton, resultLabel,
                resetButton);

        // Button actions
        convertButton.setOnAction(e -> {
            try {
                String selectedConversion = conversionBox.getValue();
                float inputValue = Float.parseFloat(inputField.getText());
                float result = 0;

                if (selectedConversion == null) {
                    resultLabel.setText("Please select a conversion option.");
                    return;
                }

                switch (conversionBox.getSelectionModel().getSelectedIndex()) {
                    case 0: // kg to lb
                        result = inputValue * 2.20462f;
                        resultLabel.setText(inputValue + " kg = " + result + " lb");
                        break;
                    case 1: // meter to feet
                        result = inputValue * 3.28084f;
                        resultLabel.setText(inputValue + " meters = " + result + " feet");
                        break;
                    case 2: // mile to km
                        result = inputValue * 1.60934f;
                        resultLabel.setText(inputValue + " miles = " + result + " km");
                        break;
                    case 3: // inch to mm
                        result = inputValue * 25.4f;
                        resultLabel.setText(inputValue + " inches = " + result + " mm");
                        break;
                    default:
                        resultLabel.setText("Invalid conversion.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        resetButton.setOnAction(e -> {
            conversionBox.setValue(null);
            inputField.clear();
            resultLabel.setText("");
        });

        // Display scene
        Scene scene = new Scene(root, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}