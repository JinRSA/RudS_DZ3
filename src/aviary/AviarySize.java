package aviary;

public enum AviarySize {
    LITTLE(0), MEDIUM(1), LARGE(2), VERY_LARGE(3);

    private final int m_size;

    public int getSize() { return m_size; }

    AviarySize(int size) { m_size = size; }
}