package model;

public class Inca extends Civilization {
    private Desert desert = new Desert();

    /**
     * Public constructor.
     */
    public Inca() {
        super("Inca");
    }

    @Override
    public String explore() {
        int gold = desert.findTreasure();
        getTreasury().earn(gold);
        return "You explore the desert and find " + gold + " gold!";
    }

    /**
     * @return this civilization's Desert.
     */
    public Desert getDesert() {
        return desert;
    }

    // @Override
    // public MeleeUnit MeleeUnit() {
    //     return new MeleeUnit(this);
    // }

    @Override
    public Landmark getLandmark() {
        return new MachuPicchu(this);
    }
}