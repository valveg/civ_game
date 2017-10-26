package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
//import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import model.Civilization;
import model.Persia;
import model.Mongol;
import model.Inca;

import javafx.scene.control.Button;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.scene.control.TextInputDialog;

import java.util.Optional;


//for music
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {

    private Civilization civilization;

    private StartScreen startScreen = new StartScreen();
    //private GameScreen gameScreen = new GameScreen();

    private boolean buttonClicked = false;

    private Scene startScene = new Scene(startScreen, 800, 800);
    //private Scene gameScene = new Scene(gameScreen, 800, 800);

    private Stage theStage;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        theStage = primaryStage;


        primaryStage.setTitle("CS 1331 Civilization Game");
        primaryStage.setScene(startScene);
        primaryStage.show();

        //adds game of thrones music to the background of start!!!!!!!!

        Media string = new Media(new File("src/main/java/view/music.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(string);
        player.play();

        Button button = startScreen.getStartButton();


        button.setOnAction(e -> {

                primaryStage.setTitle("CS 1331 Civilization Game");
                primaryStage.setScene(startGame());
                primaryStage.show();

                //stops game of thrones music from playing
                player.stop();

                //new sword clash sound

                Media sword = new Media(new File("src/main/java/view/sword.mp3").toURI().toString());
                MediaPlayer plays = new MediaPlayer(sword);
                plays.play();

            });
    }

    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);


    }

    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */
    public Scene startGame() {

        //works now
        CivEnum c =
             startScreen.getCivList().getSelectionModel().getSelectedItem();
        String civilizationName = c.toString();


        buttonClicked = true;

        TextInputDialog dialog = new TextInputDialog("Utopia");
        dialog.setTitle("A New Settlement");
        dialog.setHeaderText("You have built a Settlement!");
        dialog.setContentText("Enter the name of your first town:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        //returns false if user hits cancel
        if (result.isPresent()) {
            String settlementName = result.get();
            //civilization = new Civilization(civilizationName);

            if (civilizationName.equals("Ancient Egypt")) {
                civilization = new Egypt();
            } else if (civilizationName.equals("Qin Dynasty")) {
                civilization = new QinDynasty();
            } else if (civilizationName.equals("Roman Empire")) {
                civilization = new RomanEmpire();
            } else if (civilizationName.equals("Incan Empire")) {
                civilization = new Inca();
            } else if (civilizationName.equals("Persian Empire")) {
                civilization = new Persia();
            } else if (civilizationName.equals("Mongol Empire")) {
                civilization = new Mongol();
            }

            GameController.setCivilization(civilization);

            //creates gameScreen and gameScene from that gameScreen
            GameScreen gameScreen = new GameScreen();
            Scene gameScene = new Scene(gameScreen, 800, 800);


            //puts resource bar, grid, and actionmenu into gamescreen
            gameScreen.setTop(gameScreen.getResources().getRootNode());
            gameScreen.setCenter(gameScreen.getGrid());
            gameScreen.setLeft(gameScreen.getActionMenu());


            gameScreen.getMap().putSettlement(settlementName, civilization,
                 4, 4);
            gameScreen.getMap().addEnemies(new Bandit(), 3);
            gameScreen.update();

            return gameScene;
        }
        return null;
    }
}
