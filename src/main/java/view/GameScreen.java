package view;

import controller.GameController;
//import view.GridFX;
//import view.ResourcesMenu;
import model.Map;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//import javafx.geometry.Pos;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {

    private GridFX grid = GridFX.getInstance();
    private Map map = grid.getMap();

    private static ResourcesMenu resourceMenu = new ResourcesMenu();
    private HBox resourceBar = resourceMenu.getRootNode();

    private static MilitaryMenu militaryMenu = new MilitaryMenu();
    private static WorkerMenu workerMenu = new WorkerMenu();
    private static RecruitMenu recruitMenu = new RecruitMenu();
    private static BuildingMenu buildingMenu = new BuildingMenu();
    private static AbstractMenu statusMenu = new StatusMenu();

    private static VBox actionMenu = new VBox();




    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        actionMenu.getChildren().add(statusMenu.getRootNode());
        //                 //when click attack button
        // militaryMenu.attackButton.setOnAction(e -> {
        //         //lets game know attacking state
        //         GameController.attacking();

        //         //updates resource bar
        //         resourceMenu.update();


        //     });

        // //when click move button
        // militaryMenu.moveButton().setOnAction(e -> {
        //         //lets game know moving state
        //         GameController.moving();


        //     });

    }

    public Map getMap() {
        return map;
    }

    public GridFX getGrid() {
        return grid;
    }

    public VBox getActionMenu() {
        return actionMenu;
    }

    /**
     * This method should update the gridfx and the resource bar
     */
    public void update() {
        grid.update();
        resourceMenu.update();
    }

    /**
    * this method should return the resource menu
    * @return resource menu
    */
    public static ResourcesMenu getResources() {
        return resourceMenu;
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */


    //should be done. refer back to when finish making each menu
/////////////////////////////////////////
    public static void switchMenu(GameController.GameState state) {


        if (state == GameController.GameState.MILITARY) {
            //militaryMenu = new MilitaryMenu();
            actionMenu.getChildren().clear();
            actionMenu.getChildren().add(militaryMenu.getRootNode());
            //actionMenu = militaryMenu.getRootNode();

        } else if (state == GameController.GameState.WORKER) {
            //workerMenu = new WorkerMenu();
            actionMenu.getChildren().clear();
            actionMenu.getChildren().add(workerMenu.getRootNode());
            //actionMenu = workerMenu.getRootNode();

        } else if (state == GameController.GameState.RECRUITING) {
            //recruitMenu = new RecruitMenu();
            actionMenu.getChildren().clear();
            actionMenu.getChildren().add(recruitMenu.getRootNode());
            //actionMenu = recruitMenu.getRootNode();

        } else if (state == GameController.GameState.BUILDING) {
            //buildingMenu = new BuildingMenu();
            actionMenu.getChildren().clear();
            actionMenu.getChildren().add(buildingMenu.getRootNode());
            //actionMenu = buildingMenu.getRootNode();

        } else if (state == GameController.GameState.NEUTRAL) {
            //statusMenu = new StatusMenu();
            actionMenu.getChildren().clear();
            actionMenu.getChildren().add(statusMenu.getRootNode());
            //actionMenu = statusMenu.getRootNode();

        }
    }

}
