package second_lab;

import config.LabConfig;
import core.Command;
import core.Runner;

public class SecondLab implements Command {

    private static int VARIANT = LabConfig.VARIANT;
    private static int C3 = VARIANT % 3; // 0 -> [StringBuilder]
    private static int C17 = VARIANT % 17; // 15 -> [В заданому тексті замінити слова заданої довжини визначеним рядком.]
    @Override
    public void execute() {
        Runner.runZoned(SecondLab::runApp, "LAB 2");
    }

    private static void runApp() {
        // Вхідні дані
        String inputText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
        int wordLength = 4;
        String replacement = "****";

        System.out.println("Вхідний текст: " + inputText);

        try {
            String modifiedText = replaceWordsByLength(inputText, wordLength, replacement);
            System.out.println("Оновлений текст: " + modifiedText);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Виконує заміну слів заданої довжини на визначений рядок.
     *
     * @param inputText Текст, у якому будуть виконуватись заміни.
     * @param wordLength Довжина слів, які потрібно замінити.
     * @param replacement Рядок, на який будуть замінені слова.
     * @return Новий рядок з заміненими словами.
     * @throws IllegalArgumentException Якщо вхідний текст порожній або значення параметрів некоректні.
     */
    public static String replaceWordsByLength(String inputText, int wordLength, String replacement) {
        validateInputs(inputText, wordLength, replacement);

        StringBuilder result = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                wordBuilder.append(c);
            } else {
                if (wordBuilder.length() > 0) {
                    result.append(wordBuilder.length() == wordLength ? replacement : wordBuilder);
                    wordBuilder.setLength(0);
                }
                result.append(c);
            }
        }
        if (wordBuilder.length() > 0) {
            result.append(wordBuilder.length() == wordLength ? replacement : wordBuilder);
        }
        return result.toString();
    }


    private static void validateInputs(String inputText, int wordLength, String replacement) {
        if (inputText == null || inputText.isEmpty()) {
            throw new IllegalArgumentException("Вхідний текст не може бути порожнім.");
        }
        if (wordLength <= 0) {
            throw new IllegalArgumentException("Довжина слова повинна бути більшою за нуль.");
        }
        if (replacement == null) {
            throw new IllegalArgumentException("Рядок заміни не може бути порожнім.");
        }
    }
}
