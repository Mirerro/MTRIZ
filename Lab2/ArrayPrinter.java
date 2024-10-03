

import java.util.Scanner;

public class ArrayPrinter {

    // Метод для створення та виведення двовимірного масиву
    public void createAndPrintArray(int rows, int cols) {
        int[][] array = new int[rows][cols];
        int value = 0; // Початкове значення

        // Заповнюємо масив
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = value;
                value += 3; // Кожен наступний елемент на 3 більше
            }
        }

        // Виводимо масив на екран
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + "\t"); // Виводимо елементи масиву
            }
            System.out.println(); // Перехід на новий рядок
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayPrinter arrayPrinter = new ArrayPrinter();
            // Запит користувача на кількість рядків і стовпців
            System.out.print("Введіть кількість рядків: ");
            int rows = scanner.nextInt();
            System.out.print("Введіть кількість стовпців: ");
            int cols = scanner.nextInt();
            arrayPrinter.createAndPrintArray(rows, cols); // Викликаємо метод
            // Закриваємо сканер
        }
    }
}
