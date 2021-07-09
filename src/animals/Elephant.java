package animals;

import aviary.AviarySize;

public class Elephant extends Herbivore implements Run, Swim, Voice {
    public Elephant(final String name) {
        super(name);
        m_aviarySize = AviarySize.VERY_LARGE;
    }

    public Elephant(final String name, final int prettiness, final int satiety) {
        super(name, prettiness, satiety);
        m_aviarySize = AviarySize.VERY_LARGE;
    }

    @Override
    public void run() {
        System.out.println("Слон " + getName() + " бежит.");
        spendEnergy(16);
    }

    @Override
    public void swim() {
        System.out.println("Слон " + getName() + " плывёт.");
        spendEnergy(10);
    }

    @Override
    public String voice() {
        spendEnergy(2);
        return "Слон " + getName() + " трубит.";
    }
}