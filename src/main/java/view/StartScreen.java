package view;


import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListView;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;


/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {

    private ListView<CivEnum> civList = new ListView<CivEnum>();
    private Label theLabel = new Label("Select a Civilization to begin");
    private Button startButton = new Button("Start!");


    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {

        theLabel.setTextFill(Color.web("#ff0000"));

        civList.setMaxWidth(150);
        civList.setMaxHeight(154);
        civList.getItems().setAll(CivEnum.values());

        String url = "File:./src/main/java/view/civ_background.png";
        Image image = new Image(url);
        ImageView imageView = new ImageView(image);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView, theLabel, civList);

        VBox box = new VBox();
        box.getChildren().add(getStartButton());

        vbox.setTranslateX(335);
        vbox.setTranslateY(410);
        box.setTranslateX(380);
        box.setTranslateY(600);


        this.getChildren().addAll(imageView, vbox, box);

    }

    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return startButton;

    }


    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return civList;
    }
}