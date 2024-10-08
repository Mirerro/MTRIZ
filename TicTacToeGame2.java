
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// Клас, що описує базу даних
class Db {

    // Зберігаємо логіни та паролі у хеш-таблиці
    private Map<String, String> users = new HashMap<>();

    // Метод для додавання нового користувача
    public void addUser(String username, String password) {
        users.put(username, password);
    }

    // Метод для перевірки логіна та пароля
    public boolean checkCredentials(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

// Основний клас для запуску гри
public class TicTacToeGame2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Створення бази даних
        Db db = new Db();
        // Додаємо користувачів для прикладу
        db.addUser("player1", "password1");
        db.addUser("player2", "password2");

        // Запит логіна та пароля для гравця 1
        Player player1 = loginPlayer(db, reader);
        // Запит логіна та пароля для гравця 2
        Player player2 = loginPlayer(db, reader);

        // Ігрове поле
        TicTacToeBoard board = new TicTacToeBoard();
        Player currentPlayer = player1;
        boolean gameWon = false;

        while (!board.isBoardFull()) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") робить хід.");

            // Отримання ходу від поточного гравця
            int[] move = currentPlayer.getMove();
            boolean moveValid = board.updateBoard(move[0], move[1], currentPlayer.getSymbol());

            if (!moveValid) {
                System.out.println("Недійсний хід, спробуйте ще раз.");
                continue;
            }

            // Перевірка на перемогу
            if (board.checkWinner(currentPlayer.getSymbol())) {
                board.displayBoard();
                System.out.println("Вітаємо! " + currentPlayer.getName() + " виграв гру!");
                gameWon = true;
                break;
            }

            // Перемикання гравця
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        if (!gameWon) {
            board.displayBoard();
            System.out.println("Гра закінчилася нічиєю!");
        }
    }

    private static Player loginPlayer(Db db, BufferedReader reader) throws IOException {
        String username;
        String password;

        while (true) {
            System.out.println("Введіть логін:");
            username = reader.readLine();
            System.out.println("Введіть пароль:");
            password = reader.readLine();

            if (db.checkCredentials(username, password)) {
                System.out.println("Логін успішно пройдений!");
                System.out.println("Введіть символ гравця (X або O): ");
                char symbol = reader.readLine().charAt(0);
                return new Player(username, symbol);
            } else {
                System.out.println("Неправильний логін або пароль. Спробуйте ще раз.");
            }
        }
    }
}

// Клас, що описує гравця
class Player {

    private String name;
    private char symbol;

    // Конструктор для гравця
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    // Метод для отримання ходу гравця
    public int[] getMove() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(name + ", введіть рядок (1, 2 або 3): ");
        int row = Integer.parseInt(reader.readLine()) - 1;  // Преобразуем в индексацию с 0
        System.out.println(name + ", введіть стовпчик (1, 2 або 3): ");
        int col = Integer.parseInt(reader.readLine()) - 1;  // Преобразуем в индексацию с 0
        return new int[]{row, col};
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}

// Клас, що описує ігрове поле
class TicTacToeBoard {

    private char[][] board;

    // Конструктор для створення пустого ігрового поля
    public TicTacToeBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Метод для відображення ігрового поля на екрані
    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для зміни стану ігрового поля
    public boolean updateBoard(int row, int col, char symbol) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    // Метод для перевірки на перемогу одного із гравців
    public boolean checkWinner(char symbol) {
        // Перевірка рядків
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }

        // Перевірка стовпців
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }

        // Перевірка діагоналей
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    // Метод для перевірки на заповненість поля
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
