package animals;

import foods.Food;
import foods.Meat;
import foods.WrongFoodException;

public abstract class Carnivorous extends Animal {
    public Carnivorous() {}

    public Carnivorous(final String name) { super(name); }

    public Carnivorous(final String name, final int prettiness, final int satiety) {
        super(name, prettiness, satiety);
    }

    @Override
    public void eat(final Food food) throws WrongFoodException {
        if (food instanceof Meat) {
            addSatiety(food.getCalorie());
            System.out.println("Животное " + getName() + " съело " + food.getName() + ", сытость = " + getSatiety());
        }
        else {
            throw new WrongFoodException(getName() + ". Плотоядный не употребляет травку.");
        }
    }
}