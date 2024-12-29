package fourth_lab;

import core.Command;
import core.Runner;
import second_lab.SecondLab;

import java.util.List;

public class FourthLab implements Command {
    /**
     * Виконує основну логіку лабораторної роботи 4.
     */
    @Override
    public void execute() {
        Runner.runZoned(FourthLab::runApp, "LAB 4");
    }

    /**
     * Основна логіка програми для лабораторної роботи 4.
     * Обробляє введений текст, очищує його та замінює слова вказаної довжини.
     */
    private static void runApp() {
        String inputText = "Lorem     ipsum dolor sit amet,    consectetur adipiscing elit.";
        int wordLength = 4;
        String replacement = "****";

        System.out.println("Original Text: " + inputText);

        Text text = new Text(inputText);
        System.out.println("Cleaned Text: " + text);

        String modifiedText = replaceWordsByLength(text, wordLength, replacement);
        System.out.println("Modified Text: " + modifiedText);

        compareToTheSecondLab(modifiedText, wordLength, replacement);
    }
    public static String replaceWordsByLength(Text text, int wordLength, String replacement) {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : text.getSentences()) {
            boolean addSpace = false;
            List<Object> components = sentence.getComponents();
            for (Object component : components) {
                if (addSpace) {
                    // Only add a space if the current component is not punctuation
                    if (!(component instanceof Punctuation)) {
                        result.append(" ");
                    }
                }
                if (component instanceof Word word) {
                    result.append(word.length() == wordLength ? replacement : word);
                } else if (component instanceof Punctuation punctuation) {
                    result.append(punctuation);
                }
                addSpace = true;
            }
            result.append(" ");
        }

        return result.toString().trim();
    }


    private static void compareToTheSecondLab(String input, int wordLength, String replacement) {
        final String expected = SecondLab.replaceWordsByLength(input, wordLength, replacement);
        System.out.println("\nIs equal result comparing to the SecondLab: " + input.equals(expected));
        System.out.println("[Expected:" + expected + " Actual:" + input + "]");
    }
}
