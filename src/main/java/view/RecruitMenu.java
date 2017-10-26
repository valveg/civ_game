package view;

import controller.GameController;
import model.Civilization;
import model.Unit;

import javafx.scene.control.ListView;

import javafx.scene.control.Button;

import javafx.scene.control.TextInputDialog;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;



/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {

    private Civilization civ = GameController.getCivilization();

    private Button selectButton = new Button("Select");

    private ObservableList<String> recruit = FXCollections.observableArrayList(
        "Melee Unit", "Range Unit", "Hybrid Unit", "Siege Unit", "Settlers",
             "Farmers", "Coal Miners", "Anglers", "Master Builder");

    private ListView<String> listView = new ListView<>(recruit);

    //private MapObject occupant;

    private String settlementName;

    //helper method bc RecruitMenu is too long
    private void callSomeOfSelectButton() {
        listView.setPrefWidth(50);
        listView.setPrefHeight(400);
        this.addMenuItem(listView);
        this.addMenuItem(selectButton);
    }

    private void cantAfford() {
        Alert a = new Alert(AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText("The unit could not be recruited"
             + "!");
        a.setContentText("Uh oh, it is not affordable.");
        a.showAndWait();
    }

    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        callSomeOfSelectButton();
        selectButton.setOnAction(e -> {

                Media trumpet = new Media(new File("src/main/java/view/trumpet.mp3").toURI().toString());
                MediaPlayer plays = new MediaPlayer(trumpet);
                plays.play();

                // String trumpet = "File:./src/main/java/view/trumpet.mp3";
                // MediaPlayer plays = new MediaPlayer(new Media(trumpet));
                // plays.play();


                plays.setStopTime(Duration.seconds(8));
                TerrainTileFX terrainTile = GameController.getLastClicked();
                String recruitThis =
                     listView.getSelectionModel().getSelectedItem();
                if (terrainTile.getTile().isEmpty()) {
                    if (recruitThis.equals("Melee Unit")) {
                        Unit occupant = (Unit) civ.getMeleeUnit();
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getMeleeUnit());
                        } else {
                            cantAfford();
                        }
                    } else if (recruitThis.equals("Range Unit")) {
                        Unit occupant = (Unit) civ.getRangedUnit();
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getRangedUnit());
                        } else {
                            cantAfford();
                        }
                    } else if (recruitThis.equals("Hybrid Unit")) {
                        Unit occupant = (Unit) civ.getHybridUnit();
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getHybridUnit());
                        } else {
                            cantAfford();
                        }
                    } else if (recruitThis.equals("Siege Unit")) {
                        Unit occupant = (Unit) civ.getSiegeUnit();
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getSiegeUnit());
                        } else {
                            cantAfford();
                        }
                    } else if (recruitThis.equals("Settlers")) {
                        TextInputDialog dialog = new TextInputDialog("Westoro"
                             + "s");
                        dialog.setTitle("A New Settlement");
                        dialog.setHeaderText("You have built a Settlement!");
                        dialog.setContentText("Enter the name of your new town"
                             + ":");
                        Optional<String> result = dialog.showAndWait();
                        //returns false if user hits cancel
                        if (result.isPresent()) {
                            settlementName = result.get();
                        }
                        Unit occupant = (Unit) civ.getSettlerUnit(
                            settlementName);
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getSettlerUnit(settlementName));
                        } else {
                            cantAfford();
                        }
                    } else if (recruitThis.equals("Farmers")) {
                        Unit occupant = (Unit) civ.getFarmerUnit();
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getFarmerUnit());
                        } else {
                            cantAfford();
                        }
                    } else if (recruitThis.equals("Coal Miners")) {
                        Unit occupant = (Unit) civ.getCoalMinerUnit();
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getCoalMinerUnit());
                        } else {
                            cantAfford();
                        }
                    } else if (recruitThis.equals("Anglers")) {
                        Unit occupant = (Unit) civ.getAnglerUnit();
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getAnglerUnit());
                        } else {
                            cantAfford();
                        }
                    } else if (recruitThis.equals("Master Builder")) {
                        Unit occupant = (Unit) civ.getMasterBuilderUnit();
                        if (occupant.isAffordable()) {
                            occupant.applyInitialCosts();
                            terrainTile.getTile().setOccupant(
                                civ.getMasterBuilderUnit());
                        } else {
                            cantAfford();
                        }
                    }
                } else {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("The unit could not be recruited!");
                    a.setContentText("Uh oh, that tile is not empty.");
                    a.showAndWait();
                }
                terrainTile.updateTileView();
                GameController.updateResourcesBar();
            });
    }
}
