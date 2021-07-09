package foods;

public abstract class Food {
    private final String m_name;
    private final int m_calorie;
//region Getters and setters.
    public String getName() { return m_name; }

    public int getCalorie() { return m_calorie; }
//endregion
    public Food(final String name, final int calorie) {
        m_name = name;
        m_calorie = calorie;
    }
}