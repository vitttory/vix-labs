package fourth_lab;

import java.util.ArrayList;
import java.util.List;

/**
 * Представляє речення, що складається з масиву об'єктів {@link Word} та {@link Punctuation}.
 */
public class Sentence {
    private final List<Object> components; // Words and punctuation

    public Sentence(String sentence) {
        components = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                wordBuilder.append(c);
            } else if (",.!?;:".indexOf(c) >= 0) {
                if (wordBuilder.length() > 0) {
                    components.add(new Word(wordBuilder.toString()));
                    wordBuilder.setLength(0);
                }
                components.add(new Punctuation(c)); // Add punctuation as a Punctuation object
            } else {
                if (wordBuilder.length() > 0) {
                    components.add(new Word(wordBuilder.toString()));
                    wordBuilder.setLength(0);
                }
            }
        }
        if (wordBuilder.length() > 0) {
            components.add(new Word(wordBuilder.toString()));
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object component : components) {
            if (component instanceof Word && builder.length() > 0) {
                builder.append(" "); // Додаємо пробіл перед словом, якщо це не початок
            }
            builder.append(component);
        }
        return builder.toString();
    }

    public List<Object> getComponents() {
        return components;
    }
}
