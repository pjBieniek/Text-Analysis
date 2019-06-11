import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class StatisticalAnalysisTest {
    private FileContent fileContent;
    private WordIterator iterator;
    private StatisticalAnalysis sa;

    @BeforeEach
    void setUp() {
        fileContent = new FileContent("test.txt");
        iterator = new WordIterator(fileContent);
        sa = new StatisticalAnalysis(iterator);
    }

    @Test
    void countOf() {
        assertThat(sa.countOf("love")).isEqualTo(1);
        assertThat(sa.countOf("hate")).isEqualTo(0);
        assertThat(sa.countOf("fun")).isEqualTo(0);
    }
}