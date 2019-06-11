import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CharIteratorTest {

    private CharIterator charIterator;

    @BeforeEach
    void before() {
        FileContent fileContent = new FileContent("test.txt");
        this.charIterator = new CharIterator(fileContent);
    }

    @Test
    void testHasNextUpTo1031Times() {
        boolean[] result = new boolean[1031];
        for (int i = 0; i < 1031; i++) {
            result[i] = charIterator.hasNext();
            charIterator.next();
        }
        assertThat(result).doesNotContain(false);
    }


    @Test
    void testNextMoreThan1031Times() {
        for (int i = 0; i < 1031; i++) {
            charIterator.hasNext();
            charIterator.next();
        }
        assertThat(charIterator.hasNext()).isFalse();
    }

}