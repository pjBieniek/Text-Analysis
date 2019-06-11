import java.time.Duration;
import java.time.Instant;

public class Engine {
    private View view;

    public Engine(View view) {
        this.view = view;
    }


    public void run(String[] args) {
        Instant start = Instant.now();
        if (handleArguments(args)){
            for (String file : args) {
                IterableText iterableText = new FileContent(file);
                StatisticalAnalysis word = new StatisticalAnalysis(iterableText.wordIterator());
                StatisticalAnalysis character = new StatisticalAnalysis(iterableText.charIterator());
                displayResults(file, character, word);
                }
            }


        Instant end = Instant.now();
        Duration interval = Duration.between(start, end);
        view.showTimeDuration(interval);

    }

    private void displayResults(String args, StatisticalAnalysis character, StatisticalAnalysis word) {
        view.showFileName(args);
        displayDictSize(word);
        displayAmountOfWords(word);
        displayAmountOfChars(character);
        displayWordsThatOccurMoreThan10(word);
        displaySpecificWordCount(word, "archers");
        displaySpecificWordCount(word, "love");
        displaySpecificWordCount(word, "hate");
        displaySpecificWordCount(word, "fun");

    }

    private void displayDictSize(StatisticalAnalysis word) {
        view.showMessage("Dict size: " + word.dictionarySize());
    }

    private void displaySpecificWordCount(StatisticalAnalysis word, String target) {
        view.showMessage("'" + target + "'" + " count: " + word.countOf(target));
    }

    private void displayAmountOfWords(StatisticalAnalysis word) {
        view.showMessage("Amount of words: " + word.size());
    }

    private void displayAmountOfChars(StatisticalAnalysis character) {
        view.showMessage("Amount of characters: " + character.size());
    }

    private void displayWordsThatOccurMoreThan10(StatisticalAnalysis word) {
        view.showMessage("Words which occur more than 10 times: " + word.occurMoreThan(10));
    }



    private boolean handleArguments(String[] args){
        boolean result = false;
        if (args.length < 1) {
            view.showMessage("__________________________Type name of file to test, displayed below__________________________ \n");
            view.showMessage("output_test_test2.txt \ntest.txt \ntest2.txt \ntest_dickens_great.txt \ntest_malville_noby.txt");
            return result;
        } else {
            result = true;
            return result;
        }
    }
}
