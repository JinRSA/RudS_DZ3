package animals;

import aviary.AviarySize;

public class Fish extends Carnivorous implements Swim {
    public Fish(final String name) {
        super(name);
        m_aviarySize = AviarySize.LITTLE;
    }

    public Fish(final String name, final int prettiness, final int satiety) {
        super(name, prettiness, satiety);
        m_aviarySize = AviarySize.LITTLE;
    }

    @Override
    public void swim() {
        System.out.println("Рыбка " + getName() + " плавает.");
        spendEnergy(3);
    }
}