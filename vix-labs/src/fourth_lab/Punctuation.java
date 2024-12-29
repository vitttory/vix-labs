package fourth_lab;

/**
 * Представляє розділовий знак у реченні.
 */
public record Punctuation(char mark) {
    public Punctuation {
        if (!isPunctuation(mark)) {
            throw new IllegalArgumentException("Invalid punctuation mark: " + mark);
        }
    }

    private boolean isPunctuation(char c) {
        return ",.!?;:".indexOf(c) >= 0;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
