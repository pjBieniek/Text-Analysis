import java.io.PrintStream;

public class Application {

    public static void main(String[] args) {

        PrintStream printStream = new PrintStream(System.out);
        View view = new View(printStream);
        Engine engine = new Engine(view);
        engine.run(args);
        System.exit(0);
    }
}
