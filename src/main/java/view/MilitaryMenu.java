package view;

import controller.GameController;
import javafx.scene.control.Button;
import model.Civilization;
//import model.MapObject;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

/**
 * Created by William on 11/11/2016.
 */

//able to move or attack
public class MilitaryMenu extends AbstractMenu {

    private Button attackButton = new Button("Attack");
    private Button moveButton = new Button("Move");
    private Civilization civ = GameController.getCivilization();

    /**
    * Implement the buttons and actions associated with
    * the buttons for the military menu
    */
    public MilitaryMenu() {
        this.addMenuItem(attackButton);
        this.addMenuItem(moveButton);


         //when click attack button
        attackButton.setOnAction(e -> {
                //lets game know attacking state
                GameController.attacking();

                Media fighting = new Media(new File("src/main/java/view/fighting.mp3").toURI().toString());
                MediaPlayer plays = new MediaPlayer(fighting);
                plays.play();


                plays.setStopTime(Duration.seconds(8));

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

    public Button getAttackButton() {
        return attackButton;
    }

    public Button getMoveButton() {
        return moveButton;
    }
}
