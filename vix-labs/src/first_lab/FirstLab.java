package first_lab;

import config.LabConfig;
import core.Command;
import core.Runner;

public class FirstLab implements Command {
    // Config
    private static int VARIANT = LabConfig.VARIANT;
    private static int C5 = VARIANT % 5; // 0 -> [C = a * B, where a == const]
    private static int C7 = VARIANT % 7; // 1 -> matrix type == [byte]
    private static int C11 = VARIANT % 11; // 4 -> [Обчислити суму найбільших елементів в рядках матриці з парними
                                           // номерами та найменших елементів в рядках матриці з непарними номерами]
    @Override
    public void execute() {
        Runner.runZoned(FirstLab::runApp, "LAB 1");

    }

    private static void runApp() {
        try {
            // Вхідні дані
            byte[][] matrixB = {
                    {3, 5, 1},
                    {8, 2, 6},
                    {7, 4, 9},
                    {1, 3, 5}
            };
            byte a = 2;

            System.out.println("Початкова матриця:");
            printMatrix(matrixB);

            // Обчислення C = a * B
            byte[][] matrixC = multiplyMatrixByConstant(matrixB, a);
            System.out.println("Матриця, помножена на константу:");
            printMatrix(matrixC);

            // Обчислення суми
            int resultSum = calculateSpecialSum(matrixC);
            System.out.println("Сума найбільших і найменших елементів: " + resultSum);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Множить матрицю на константу.
     *
     * @param matrix Матриця типу byte[][]
     * @param constant Константа множення
     * @return Нова матриця після множення
     */
    public static byte[][] multiplyMatrixByConstant(byte[][] matrix, byte constant) {
        validateMatrix(matrix);

        int rows = matrix.length;
        int columns = matrix[0].length;
        byte[][] result = new byte[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = (byte) (matrix[i][j] * constant);
            }
        }

        return result;
    }

    public static int calculateSpecialSum(byte[][] matrix) {
        validateMatrix(matrix);

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            byte[] row = matrix[i];
            byte specialValue;
            specialValue = findInRow(row, i % 2 == 0);
            sum += specialValue;
        }

        return sum;
    }

    private static void validateMatrix(byte[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матриця не може бути порожньою.");
        }
    }


    /**
     * Виводить матрицю на екран.
     *
     * @param matrix Матриця типу byte[][]
     */
    public static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            for (byte value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Знаходить мінімальний елемент у рядку.
     *
     * @param row Рядок матриці
     * @param isMaxValueFound Флаг, який вказує на шукане значення (максимальне чи мінімальне)
     * @return Мінімальний елемент
     */
    public static byte findInRow(byte[] row, boolean isMaxValueFound) {
        if (row == null || row.length == 0) {
            throw new IllegalArgumentException("Рядок не може бути порожнім.");
        }

        byte result = row[0];
        for (byte value : row) {
            if (isMaxValueFound ? value > result : value < result) {
                result = value;
            }
        }
        return result;
    }
}
