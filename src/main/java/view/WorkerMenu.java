package view;

import controller.TileType;
import controller.GameController;
import model.Convertable;
import javafx.scene.control.Button;
import model.Civilization;
import model.Building;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
//import javafx.util.Duration;

import java.io.File;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {

    private Button convertButton = new Button("Convert");
    private Button moveButton = new Button("Move");
    private Civilization civ = GameController.getCivilization();


    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        this.addMenuItem(moveButton);
        this.addMenuItem(convertButton);


        convertButton.setOnAction(e -> {

                Media hodor = new Media(new File("src/main/java/view/hodor.mp3").toURI().toString());
                MediaPlayer play = new MediaPlayer(hodor);
                play.play();



                TerrainTileFX lastTerrain = GameController.getLastClicked();

                TileType lastTile = lastTerrain.getTile().getType();


                if (GameController.getLastClicked().getTile().
                        getOccupant().isWorker()) {
                    Convertable occupant = (Convertable) GameController.
                        getLastClicked().getTile().getOccupant();

                    //canConvert(lastTile);
                    Building b = occupant.convert();
                    GameController.getLastClicked().getTile().
                        setOccupant(null);
                    GameController.getLastClicked().getTile().setOccupant(b);

                    //needs to update tile view???
                    lastTerrain.updateTileView();

                } else {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("There was a convert error!");
                    a.setContentText("Uh oh, you cannot convert.");

                    a.showAndWait();
                }


                //updates resource bar
                GameController.updateResourcesBar();

            });

        //when click move button
        moveButton.setOnAction(e -> {
                //lets game know moving state
                GameController.moving();

                Media move = new Media(new File("src/main/java/view/move.mp3").toURI().toString());
                MediaPlayer play = new MediaPlayer(move);
                play.play();


            });
    }
}
