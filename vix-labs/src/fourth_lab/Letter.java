package fourth_lab;

/**
 * Представляє один символ (літеру) в тексті.
 */
public record Letter(char value) {

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}