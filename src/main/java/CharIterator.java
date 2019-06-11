import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CharIterator implements Iterator<String> {
    private String fileData;
    private FileContent fileContent;
    private int i;
    private List<String> charList;

    public CharIterator(FileContent fileContent) {
        this.fileContent = fileContent;
        fileData = fileContent.data;
        this.charList = addToList(fileData);
    }

    public boolean hasNext() {
        return charList.size() > i;
    }

    public String next() {
//        if (this.hasNext()){
//            return charList.get(i++);
//        } else{
//            throw new NoSuchElementException();
//        }
        return this.hasNext() ? charList.get(i++) : null;
    }

    public void remove() {

    }

    private List<String> addToList(String data) {
        List<String> result = new ArrayList<>();
        for (Character nextChar : data.toCharArray()){
            if (Character.isLetterOrDigit(nextChar)){
                result.add(nextChar.toString().toLowerCase());
            }
        }
        return result;
    }
}
