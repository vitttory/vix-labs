package third_lab;

import config.LabConfig;
import core.Command;
import core.Runner;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас {@code ThirdLab} реалізує інтерфейс {@link Command} та представляє виконання
 * третього лабораторного завдання. Завдання полягає в сортуванні масиву предметів одягу за різними атрибутами
 * (ціна та бренд) у порядку зростання та спадання, а також включає функціональність для пошуку предметів одягу
 * за заданими атрибутами, такими як бренд, розмір та ціна.
 */
public class ThirdLab implements Command {
    // Configuration
    private static int VARIANT = LabConfig.VARIANT;
    private static int C5 = VARIANT % 11; // 4 -> [Визначити клас одяг, який складається як мінімум з 5-и полів.]

    /**
     * Виконує третє лабораторне завдання, запустивши основну логіку програми в окремому потоці.
     * Програма оброблятиме сортування предметів одягу за ціною та брендом у порядку зростання та спадання
     * і шукатиме предмети одягу, що відповідають заданим атрибутам.
     */
    @Override
    public void execute() {
        Runner.runZoned(ThirdLab::runApp, "LAB 3");
    }

    /**
     * Перелічення, що представляє два можливі порядки сортування: зростаючий та спадний.
     */
    private enum SORTING {
        ASCENDING, DESCENDING
    }

    /**
     * Виконує основну логіку програми для третього лабораторного завдання.
     * Створює масив предметів одягу, сортує їх за ціною та брендом в порядку зростання та спадання,
     * а також шукає предмети одягу, що відповідають заданим атрибутам.
     */
    private static void runApp() {
        Clothing[] clothes = {
                new Clothing("Nike", "M", "Red", "Cotton", 50.0),
                new Clothing("Adidas", "L", "Blue", "Polyester", 60.0),
                new Clothing("Puma", "S", "Green", "Cotton", 40.0),
                new Clothing("Reebok", "M", "Black", "Leather", 80.0)
        };

        final SORTING ascendingSorting = SORTING.ASCENDING;
        sortAndPrint(clothes, Clothing::compareByPrice, "Price " + "(" + ascendingSorting + ")", ascendingSorting);
        sortAndPrint(clothes, Clothing::compareByBrand, "Brand " + "(" + ascendingSorting + ")", ascendingSorting);

        final SORTING descendingSorting = SORTING.DESCENDING;
        sortAndPrint(clothes, Clothing::compareByPrice, "Price " + "(" + descendingSorting + ")", descendingSorting);
        sortAndPrint(clothes, Clothing::compareByBrand, "Brand " + "(" + descendingSorting + ")", descendingSorting);

        // Масив справжніх та підроблених предметів одягу для пошуку відповідностей
        Clothing[] realAndFakeClothing = {
                new Clothing("Puma", "S", "Green", "Cotton", 40.0),
                new Clothing("Puma", "S", "Yellow", "Cotton", 40.0)  // Неправильний колір
        };

        for (Clothing clothing : realAndFakeClothing) {
            findMatchingClothing(clothes, clothing);
        }
    }

    /**
     * Сортує масив одягу за допомогою заданого компаратора та порядку сортування (зростаючий чи спадний).
     * Потім виводить відсортовані предмети одягу.
     *
     * @param clothes масив {@link Clothing} для сортування
     * @param comparator компаратор, що використовується для сортування
     * @param sortBy опис поля, за яким здійснюється сортування, для виведення в результат
     * @param sorting порядок сортування (зростаючий або спадний)
     */
    private static void sortAndPrint(Clothing[] clothes, Comparator<Clothing> comparator, String sortBy, SORTING sorting) {
        // Визначення правильного компаратора на основі порядку сортування
        final Comparator<Clothing> actualComparator = sorting == SORTING.ASCENDING ? comparator : comparator.reversed();
        Arrays.sort(clothes, actualComparator);
        System.out.println("\nClothing sorted by " + sortBy + ": ");
        for (Clothing c : clothes) {
            System.out.println(c);
        }
    }

    /**
     * Шукає в масиві одягу предмет, який відповідає заданому таргету.
     * Якщо відповідність знайдена, виводить знайдений предмет. Якщо відповідності немає, виводить повідомлення про відсутність.
     *
     * @param clothes масив {@link Clothing}, в якому здійснюється пошук
     * @param target таргетний {@link Clothing} для пошуку в масиві
     */
    private static void findMatchingClothing(Clothing[] clothes, Clothing target) {
        boolean found = false;
        for (Clothing c : clothes) {
            if (c.equals(target)) {
                System.out.println("\nFound matching clothing: " + c);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nNo matching clothing found: " + target);
        }
    }
}
