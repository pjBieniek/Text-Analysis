import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WordIteratorTest {

    private WordIterator wordIterator;

    @BeforeEach
    void setUp() {
        FileContent fileContent = new FileContent("test.txt");
        this.wordIterator = new WordIterator(fileContent);
    }

    @Test
    void testHasNext() {
        boolean[] result = new boolean[268];
        for (int i = 0; i < 268; i++) {
            result[i] = wordIterator.hasNext();
            wordIterator.next();
        }
        assertThat(result).doesNotContain(false);
    }


    @Test
    void next() {
        for (int i = 0; i < 268; i++) {
            wordIterator.hasNext();
            wordIterator.next();
        }
        assertThat(wordIterator.hasNext()).isFalse();
    }
}