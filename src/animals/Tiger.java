package animals;

import aviary.AviarySize;

public class Tiger extends Carnivorous implements Run, Swim, Voice {
    public Tiger(final String name) {
        super(name);
        m_aviarySize = AviarySize.LARGE;
    }

    public Tiger(final String name, final int prettiness, final int satiety) {
        super(name, prettiness, satiety);
        m_aviarySize = AviarySize.LARGE;
    }

    @Override
    public void run() {
        System.out.println("Тигр " + getName() + " бежит.");
        spendEnergy(9);
    }

    @Override
    public void swim() {
        System.out.println("Тигр " + getName() + " ныряет.");
        spendEnergy(10);
    }

    @Override
    public String voice() {
        spendEnergy(2);
        return "Тигр " + getName() + " рычит.";
    }
}