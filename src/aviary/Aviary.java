package aviary;

import animals.Animal;

import java.util.HashMap;

public class Aviary<T extends Animal> {
    private final HashMap<Integer, T> m_aviary = new HashMap<>();
    private final int m_capacity;
    private final AviarySize m_aviarySize;

    public Aviary(AviarySize aviarySize, int capacity) {
        m_aviarySize = aviarySize;
        m_capacity = Math.abs(capacity);
    }

    public Aviary(AviarySize aviarySize, int capacity, T animal) {
        m_aviarySize = aviarySize;
        m_capacity = Math.abs(capacity);
        if (animal.getAviarySize().getSize() > m_aviarySize.getSize()) {
            System.out.println("Размер вольера не подходит для данного (" + animal.getName() +
                    ") животного. (Животное " + animal.getAviarySize() + "; вольер " + m_aviarySize + ").");
            return;
        }
        if (m_aviary.size() < m_capacity)
            m_aviary.put(animal.hashCode(), animal);
        else
            System.out.println("Вольер переполнен!");
    }

    public Aviary(AviarySize aviarySize, int capacity, T[] animals) {
        m_aviarySize = aviarySize;
        m_capacity = Math.abs(capacity);
        for (T animal : animals) {
            if (animal.getAviarySize().getSize() > m_aviarySize.getSize()) {
                System.out.println("Размер вольера не подходит для данного (" + animal.getName() +
                        ") животного. (Животное " + animal.getAviarySize() + "; вольер " + m_aviarySize + ").");
                continue;
            }
            if (m_aviary.size() < m_capacity)
                m_aviary.put(animal.hashCode(), animal);
            else {
                System.out.println("Вольер переполнен!");
                return;
            }
        }
    }

    public int getAnimalsCount() { return m_aviary.size(); }

    public int getCapacity() { return m_capacity; }
//region Methods.
    public boolean addAnimal(T animal) {
        if (animal.getAviarySize().getSize() > m_aviarySize.getSize()) {
            System.out.println("Размер вольера не подходит для данного (" + animal.getName() +
                    ") животного. (Животное " + animal.getAviarySize() + "; вольер " + m_aviarySize + ").");
            return false;
        }
        if (m_aviary.size() < m_capacity)
            return m_aviary.put(animal.hashCode(), animal) == null;
        else {
            System.out.println("Вольер переполнен!");
            return false;
        }
    }

    public boolean deleteAnimal(T animal) {
        return m_aviary.remove(animal.hashCode()) != null;
    }

    public boolean deleteAnimal(int hashCode) {
        return m_aviary.remove(hashCode) != null;
    }

    public T getAnimal(int key) { return m_aviary.get(key); }
//endregion
}