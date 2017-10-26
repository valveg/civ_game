package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;
//import javafx.scene.control.Label;

public class ResourcesMenu {

    private Civilization civ = GameController.getCivilization();

    private HBox resourceMenu = new HBox();

    private Text s = new Text("Strat Level: "
         + civ.getStrategy().getStrategyLevel());
    private Text r = new Text("Resources: " + civ.getResources() + "    ");
    private Text set = new Text("Settlements: " + civ.getNumSettlements()
         + "    ");
    private Text m = new Text("Money: " + civ.getTreasury().getCoins()
         + "    ");
    private Text f = new Text("Food: " + civ.getFood() + "    ");
    private Text h = new Text("Happiness: " + civ.getHappiness() + "    ");


    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {

        //s.setText("Strat Level: " + civ.getStrategy().getStrategyLevel());
        // Text s = new Text("Strat Level: " + stratLevel);

        // Text r = new Text("Resources: " + resourceLevel);

        // Text set = new Text("Settlements: " + numSettlement);

        // Text m = new Text("Money: " + money);

        // Text f = new Text("Food: " + foodLevel);

        // Text h = new Text("Happiness: " + happinessLevel);

        resourceMenu.getChildren().addAll(s, r, set, m, f, h);




    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {


        //moneyText.setText("Gold: " + playerCiv.getTreasury().getCoins());
        //clears the hbox of any children
        resourceMenu.getChildren().clear();

        s = new Text("Strat Level: "
             + civ.getStrategy().getStrategyLevel() + "    ");

        r = new Text("Resources: " + civ.getResources() + "    ");

        set = new Text("Settlements: " + civ.getNumSettlements()
             + "    ");

        m = new Text("Money: " + civ.getTreasury().getCoins() + "    ");

        f = new Text("Food: " + civ.getFood() + "    ");

        h = new Text("Happiness: " + civ.getHappiness() + "    ");

        resourceMenu.getChildren().addAll(s, r, set, m, f, h);


    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        return resourceMenu;

    }
}