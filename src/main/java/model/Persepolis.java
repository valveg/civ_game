package model;

import javafx.scene.image.Image;

/**
 * Represents a Pyramid that can increase philosophy.
 *
 * @version 1.0
 * @author Jim Harris
 */
class Persepolis extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public Persepolis(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getTechnology().philosophize();
    }

    @Override
    public String toString() {
        return "Persepolis " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/pyramid_icon.PNG");
    }
}