import java.io.PrintStream;
import java.time.Duration;

public class View {

    private PrintStream output;

    public View(PrintStream printStream){
        this.output = printStream;
    }

    public void showFileName(String filename) {
        output.println("FileName: " + filename);
    }

    public void showMessage(String message) {
        output.println(message);
    }

    public void showTimeDuration(Duration interval) {
        output.println("Execution time in nano seconds: " + interval.getNano());
    }


}
