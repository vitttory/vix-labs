package sixth_lab;

import config.LabConfig;
import core.Command;
import core.Runner;

import java.util.Arrays;
import java.util.HashSet;

public class SixthLab implements Command {
    private static int VARIANT = LabConfig.VARIANT;
    private static int C2 = VARIANT % 2; // 1 -> [Set]
    private static int C3 = VARIANT % 3; // 0 -> [Масив із початковою кількістю елементів 15 та збільшенням кількості
                                         // елементів на 30%]
    @Override
    public void execute() {
        Runner.runZoned(SixthLab::runApp, "LAB 6");
    }

    private static void runApp() {
        // 1. Створення порожньої колекції
        final MySet<Integer> set1 = new MySet<>();
        System.out.println("Set1 (is empty): " + set1);

        for (int i = 0; i <= 20; i++) {
            set1.add(i);
        }

        System.out.println("Set1 after adding elements: " + set1);
        System.out.println("Set size after elements adding:: " + set1.size());

        // Створення колекції на основі іншої колекції
        final MySet<Integer> set2 = new MySet<>(set1);
        System.out.println("Set2 (copy of Set1): " + set2);

        // Створення колекції з переданої стандартної колекції
        final HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(5, 6, 7, 8));
        final MySet<Integer> set3 = new MySet<>(hashSet);
        System.out.println("Set3 (with HashSet): " + set3);

        // Перевірка чи містить set1 певний елемент
        System.out.println("Set1 contains 3: " + set1.contains(3)); // true
        System.out.println("Set1 contains 99: " + set1.contains(99)); // false

        // Видалення елемента з set1
        set1.remove(2);
        System.out.println("Set1 after deleting 2: " + set1);

        // Перевірка на порожність
        System.out.println("Set1 is empty: " + set1.isEmpty()); // false
        set1.clear();
        System.out.println("Set1 after clearing: " + set1);
        System.out.println("Set1 is empty after clering: " + set1.isEmpty()); // true

        // Виведення всіх елементів у set3 за допомогою ітератора
        System.out.print("Set3: ");
        for (final Integer elem : set3) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
