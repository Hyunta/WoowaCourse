package game;

public class App {
    public static void main(String[] args) {
        Settings settings1 = new Settings();
        Settings settings2 = new Settings();

        System.out.println(settings1);
        System.out.println(settings2);
        System.out.println(settings1 == settings2);
    }
}
