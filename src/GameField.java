import java.util.Scanner;
public class GameField {
    public static final String title = "Маленький герой";
    public static String name;
    public static Scanner consoleIn = new Scanner(System.in);
    public static int action;
    public static void stars() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
    }
    public static void title() {
        stars();
        System.out.print("\n" + "  " + title + "\n");
        stars();
        System.out.println();
    }
    public static String nameOfTheHero() {
        System.out.println("Введите имя Вашего персонажа - ");
        name = new Scanner(System.in).nextLine();
        switch (userInput("Имя Вашего персонажа " + name + "? 1 - Да, 2 - Нет.", 2)) {
            case 1 -> {
                System.out.println("В добрый путь " + name + "!");
                System.out.println();
            }
            case 2 -> {
                System.out.println();
                nameOfTheHero();
            }
        }
        return name;
    }
    public static int userInput(String offer, int userChoices) {
        do {
            System.out.println("\n" + offer);
            try {
                action = Integer.parseInt(consoleIn.next());
            } catch (Exception e) {
                action = -1;
                System.out.println("Введите один из указанных вариантов");
            }
        } while (action < 1 || action > userChoices);
        return action;
    }

    public static void choiceOfLocation() {
        switch (userInput("Вы в начальном городе. Куда вы хотите пойти? 1 - к торговцу, 2 - в темный лес, 3 - выйти из игры", 3)) {
            case 1 -> Dealer.trade();
            case 2 -> DarkForest.duel();
            case 3 -> {
                System.out.println();
                System.out.println("Вы покинули игру");
                System.exit(0);
            }
        }
    }
    public static void startGame(){
        title();
        System.out.println(Player.player.getFullStatus());
        choiceOfLocation();
    }
}