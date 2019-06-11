import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Iterator;

public class FileContent implements IterableText {

    String fileName;
    String data;
    private WordIterator wordIterator;
    private CharIterator charIterator;

    public FileContent(String fileName) {
        this.fileName = fileName;
        data = readFile(fileName);
    }

    public Iterator<String> charIterator() {
        charIterator = new CharIterator(this);
        return charIterator;
    }

    public Iterator<String> wordIterator() {
        wordIterator = new WordIterator(this);
        return wordIterator;
    }

    public String getFileName() {
        return fileName;
    }

    private String readFile(String fileName) {
        String content = "";
        try {
            content = Files.readString(Paths.get("/home/pawel/Dokumenty/codecool/Java/SI - 5 week/text-analyser-pjBieniek/src/main/resources/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
