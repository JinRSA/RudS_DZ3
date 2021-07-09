package animals;

public class Wolf extends Carnivorous implements Run, Swim, Voice {
    public Wolf(final String name) { super(name); }

    public Wolf(final String name, final int prettiness, final int satiety) { super(name, prettiness, satiety); }

    @Override
    public void run() {
        System.out.println("Волк " + getName() + " бежит.");
        spendEnergy(9);
    }

    @Override
    public void swim() {
        System.out.println("Волк " + getName() + " плывёт.");
        spendEnergy(10);
    }

    @Override
    public String voice() {
        spendEnergy(2);
        return "Волк " + getName() + " воет.";
    }
}