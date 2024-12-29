package fourth_lab;

import java.util.Arrays;
import java.util.List;

/**
 * Представляє текст, що складається з масиву об'єктів {@link Sentence}.
 */
public class Text {
    private final List<Sentence> sentences;

    public Text(String text) {
        text = text.replaceAll("\\s+", " ").trim();
        final String regex = "(?<=[.!?])\"?\s+";
        sentences = Arrays.stream(text.split(regex))
                .map(Sentence::new)
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Sentence sentence : sentences) {
            builder.append(sentence).append(" ");
        }
        return builder.toString().trim();
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}