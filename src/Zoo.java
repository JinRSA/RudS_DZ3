import animals.*;
import aviary.Aviary;
import aviary.AviarySize;
import foods.*;

import java.util.HashMap;

public class Zoo {
    public static void main(String[] args) {
        Animal[] animals = {
                new Duck("Даки"),
                new Elephant("Джамбо"),
                new Fish("Золотая рыбка"),
                new Horse("Пегас"),
                new Tiger("Шерхан"),
                new Wolf("Фенрир")
        };
        Food[] foods = {
                new Fillet(40),
//                new RawMeat(56),
//                new Shrub(36),
//                new Steak(48),
//                new TreeLeaves(8),
                new Wormwood(10)
        };
        Worker acolyte = new Worker();
        for (Animal animal : animals) {
            for (Food food : foods) {
                try {
                    acolyte.feed(animal, food);
                } catch (WrongFoodException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println();
        Aviary<Carnivorous> animalsCarnivorous = new Aviary<>(AviarySize.MEDIUM);
        Aviary<Herbivore> animalsHerbivore = new Aviary<>(AviarySize.LARGE);

        System.out.println("\nДобавление животных в вольеры:");
        for (Animal animal : animals) {
            try {
                animalsCarnivorous.addAnimal((Carnivorous) animal);
            } catch (ClassCastException ignored) {}
            try {
                animalsHerbivore.addAnimal((Herbivore) animal);
            } catch (ClassCastException ignored) {}
        }

        System.out.println("\nПолучение ссылок на животных в вольере:");
        System.out.println(animalsCarnivorous.getAnimal(animals[3].hashCode()));
        System.out.println(animalsCarnivorous.getAnimal(animals[4].hashCode()));
        System.out.println(animalsCarnivorous.getAnimal(animals[5].hashCode()));

        System.out.println("\nУдаление животных из вольера:");
        System.out.println(animalsCarnivorous.deleteAnimal(animals[3].hashCode()) ? "Животное " + animals[0].getName() + " удалено." : "Животного " + animals[0].getName() + " нету в вольере для плотоядных.");
        System.out.println(animalsCarnivorous.deleteAnimal(animals[4].hashCode()) ? "Животное " + animals[1].getName() + " удалено." : "Животного " + animals[0].getName() + " нету в вольере для плотоядных.");
        System.out.println(animalsCarnivorous.deleteAnimal(animals[5].hashCode()) ? "Животное " + animals[2].getName() + " удалено." : "Животного " + animals[0].getName() + " нету в вольере для плотоядных.");
    }
}