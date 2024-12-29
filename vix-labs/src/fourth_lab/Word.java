package fourth_lab;

/**
 * Представляє слово, що складається з масиву об'єктів {@link Letter}.
 */
public class Word {
    private final Letter[] letters;

    public Word(String word) {
        letters = word.chars().mapToObj(c -> new Letter((char) c)).toArray(Letter[]::new);
    }

    public int length() {
        return letters.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Letter letter : letters) {
            builder.append(letter);
        }
        return builder.toString();
    }
}
