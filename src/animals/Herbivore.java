package animals;

import foods.Food;
import foods.Grass;
import foods.WrongFoodException;

public abstract class Herbivore extends Animal {
    public Herbivore() {}

    public Herbivore(final String name) { super(name); }

    public Herbivore(final String name, final int prettiness, final int satiety) {
        super(name, prettiness, satiety);
    }

    @Override
    public void eat(final Food food) throws WrongFoodException {
        if (food instanceof Grass) {
            addSatiety(food.getCalorie());
            System.out.println("Животное " + getName() + " полакомилось " + food.getName() + ", сытость = " + getSatiety());
        }
        else {
            throw new WrongFoodException(getName() + ". Травоядное не употребляет мясо.");
        }
    }
}