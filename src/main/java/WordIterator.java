import java.util.*;

public class WordIterator implements Iterator<String> {
    private String fileData;
    private FileContent fileContent;
    private int i = 0;
    private List<String> words = new ArrayList<String>();

    public WordIterator(FileContent fileContent) {
        this.fileContent = fileContent;
        fileData = fileContent.data;
        addWords(fileData);
    }

    private void addWords(String data){
        words = Arrays.asList(data.trim().split("\\s+"));
    }

    public boolean hasNext() {
        return words.size() > i;
    }

    public String next() {
        if (this.hasNext()){
            return words.get(i++);
        } else{
            throw new NoSuchElementException();
        }
    }

    public void remove() {

    }
}
