package animals;

import aviary.AviarySize;

public class Horse extends Herbivore implements Run, Swim, Voice {
    public Horse(final String name) {
        super(name);
        m_aviarySize = AviarySize.LARGE;
    }

    public Horse(final String name, final int prettiness, final int satiety) {
        super(name, prettiness, satiety);
        m_aviarySize = AviarySize.LARGE;
    }

    @Override
    public void run() {
        System.out.println("Лошадка " + getName() + " бежит.");
        spendEnergy(10);
    }

    @Override
    public void swim() {
        System.out.println("Лошадка " + getName() + " плывёт.");
        spendEnergy(12);
    }

    @Override
    public String voice() {
        spendEnergy(2);
        return "Лошадка " + getName() + " говорит и-го-го.";
    }
}