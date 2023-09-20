public class GameOverAnimation {
    public void runGameOverAnimation() throws InterruptedException {
        String gameOver = "Game Over";

        for (int i = 0; i < gameOver.length(); i++) {
            //clearConsole();
            for (int j = 0; j < i; j++) {
                System.out.print("   "); // Отступы перед текущей буквой
            }
            System.out.println(Character.toUpperCase(gameOver.charAt(i)));
            Thread.sleep(500); // Задержка для анимации (полсекунды)
        }
    }

    // Метод для очистки консоли
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // Для Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Для Linux/Unix/Mac OS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // Обработка ошибок
        }
    }
}
