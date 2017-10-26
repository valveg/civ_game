package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import model.Civilization;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {

    private Button investButton = new Button("Invest");
    private Button demolishButton = new Button("Demolish");

    private Civilization civ = GameController.getCivilization();

    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */

    public BuildingMenu() {
        this.addMenuItem(investButton);
        this.addMenuItem(demolishButton);

         //when click invest button
        investButton.setOnAction(e -> {


                Media register = new Media(new File("src/main/java/view/register.mp3").toURI().toString());
                MediaPlayer play = new MediaPlayer(register);
                play.play();

                // String register = "File:./src/main/java/view/register.mp3";
                // MediaPlayer play = new MediaPlayer(new Media(register));
                // play.play();

                if (GameController.getLastClicked().getTile().
                    getOccupant().isBuilding()) {
                    TerrainTileFX terrainTile = GameController.
                        getLastClicked();
                    Building occupant = (Building) GameController.
                        getLastClicked().getTile().getOccupant();
                    if (occupant.getOwner().getTreasury().getCoins() >= 25) {
                        occupant.invest();
                        occupant.getOwner().getTreasury().spend(25);
                    }

                } else {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("The unit could not be invested in"
                         + "!");
                    a.setContentText("Uh oh, it is not a building.");
                    a.showAndWait();
                }


                //updates resource bar
                GameController.updateResourcesBar();

            });

        //when click demolish button
        demolishButton.setOnAction(e -> {

                Media demolish = new Media(new File("src/main/java/view/demolish.mp3").toURI().toString());
                MediaPlayer playa = new MediaPlayer(demolish);
                playa.play();


                if (GameController.getLastClicked().getTile().
                    getOccupant() instanceof Settlement) {
                    if (GameController.getLastClicked().getTile().
                        getOccupant().getOwner().getNumSettlements() <= 1) {

                        Alert al = new Alert(AlertType.ERROR);
                        al.setTitle("Error");
                        al.setHeaderText("The unit could not be demolished"
                             + "!");
                        al.setContentText("You only have 1 settlement!");
                        al.showAndWait();
                    } else {
                        TerrainTileFX terrainT = GameController.
                            getLastClicked();
                        Building buildOccupant = (Building) terrainT.getTile().
                            getOccupant();
                        buildOccupant.demolish();
                        buildOccupant.getOwner().decrementNumSettlements();
                    //take it off map / grid?

                        GameController.getLastClicked().getTile().
                            setOccupant(null);
                    }

                } else if (GameController.getLastClicked().getTile().
                    getOccupant().isBuilding()) {
                    TerrainTileFX terrainT = GameController.
                        getLastClicked();
                    Building buildOccupant = (Building) terrainT.getTile().
                        getOccupant();

                    buildOccupant.demolish();


                    GameController.getLastClicked().getTile().
                        setOccupant(null);

                    terrainT.updateTileView();

                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("The unit could not be demolished"
                         + "!");
                    alert.setContentText("Uh oh, it is not a building!");
                    alert.showAndWait();
                }

                GameController.updateResourcesBar();
            });
    }
}
