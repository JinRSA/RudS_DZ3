import animals.Animal;
import animals.Voice;
import foods.Food;
import foods.WrongFoodException;

public class Worker {
    public void feed(Animal animal, Food food) throws WrongFoodException { animal.eat(food); }

    public String getVoice(Voice voiceableAnimal) { return voiceableAnimal.voice(); }
}