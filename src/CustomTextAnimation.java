public class CustomTextAnimation {
    public void runCustomTextAnimation(String text) throws InterruptedException {
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("   "); // Отступы перед текущей буквой
            }
            System.out.println(Character.toUpperCase(text.charAt(i)));
            Thread.sleep(500); // Задержка для анимации (полсекунды)
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CustomTextAnimation customTextAnimation = new CustomTextAnimation(); // Создаем экземпляр класса
        String textToAnimate = "Hello, World!"; // Ваш текст для анимации
        customTextAnimation.runCustomTextAnimation(textToAnimate); // Вызываем метод анимации с передачей текста
    }
}
