//Всех приветствую, это


import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameOverAnimation gameOverAnimation = new GameOverAnimation(); // Создаем экземпляр класса
        CustomTextAnimation welcomeAnimation = new CustomTextAnimation();
        Quest quest = new Quest();


        final String HALLOW_TEXT = "Приветствую! Это небольшой квиз по JAVA,\nгде вы сможете узнать историю языка и его особенности!\n";



        welcomeAnimation.runCustomTextAnimation("Знакомство с Java");
        System.out.print(HALLOW_TEXT);

        quest.Game();

        gameOverAnimation.runGameOverAnimation();
    }

}
