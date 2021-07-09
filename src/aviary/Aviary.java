package aviary;

import animals.Animal;

import java.util.HashMap;

public class Aviary<T extends Animal> {
    private final HashMap<Integer, T> m_Aviary = new HashMap<>();
    private final AviarySize m_aviarySize;

    public Aviary(AviarySize aviarySize) { m_aviarySize = aviarySize; }

    public Aviary(AviarySize aviarySize, T animal) {
        m_aviarySize = aviarySize;
        if (animal.getAviarySize() != m_aviarySize) {
            System.out.println("Размер вольера не подходит для данного (" + animal.getName() +
                    ") животного. (Животное " + animal.getAviarySize() + " != вольер " + m_aviarySize + ").");
            return;
        }
        m_Aviary.put(animal.hashCode(), animal);
    }

    public Aviary(AviarySize aviarySize, T[] animals) {
        m_aviarySize = aviarySize;
        for (T animal : animals) {
            if (animal.getAviarySize() != m_aviarySize) {
                System.out.println("Размер вольера не подходит для данного (" + animal.getName() +
                        ") животного. (Животное " + animal.getAviarySize() + " != вольер " + m_aviarySize + ").");
                continue;
            }
            m_Aviary.put(animal.hashCode(), animal);
        }
    }
//region Methods.
    public boolean addAnimal(T animal) {
        if (animal.getAviarySize() != m_aviarySize) {
            System.out.println("Размер вольера не подходит для данного (" + animal.getName() +
                    ") животного. (Животное " + animal.getAviarySize() + " != вольер " + m_aviarySize + ").");
            return false;
        }
        return m_Aviary.put(animal.hashCode(), animal) == null;
    }

    public boolean deleteAnimal(T animal) {
        return m_Aviary.remove(animal.hashCode()) != null;
    }

    public boolean deleteAnimal(int hashCode) {
        return m_Aviary.remove(hashCode) != null;
    }

    public T getAnimal(int key) { return m_Aviary.get(key); }
//endregion
}