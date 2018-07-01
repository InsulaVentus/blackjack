public class Launcher {
    public static void main(String[] args) {
        System.out.println("Launching a game of blackjack");
        if (args.length > 0) {
            System.out.println(String.format("With params: %s", args[0]));
        }
    }
}
