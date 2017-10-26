package model;

/**
 * Represents the Qin Dynasty Civiization.
 *
 * @version 2.0
 * @author Angie Palm, Jim Harris
 */
public class Mongol extends Civilization {
    private Hills hills = new Hills();

    /**
     * Public constructor.
     */
    public Mongol() {
        super("Mongol");
    }

    @Override
    public String explore() {
        int food = hills.hunt().getHealth();
        hills.replenishGame();
        makeFood(food);
        return "You go hunting and get " + food + " food!";
    }

    /**
     * @return the Hills for this Civilization.
     */
    public Hills getHills() {
        return hills;
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GenghisKhan(this);
    }
}
