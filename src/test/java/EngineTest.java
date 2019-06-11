import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EngineTest {

    private Engine engine;
    private OutputStream outputStream;

    @BeforeEach
    void before() {
        this.outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testDisplayResults(){
        String[] args = {"test.txt"};
        this.engine = new Engine(new View(new PrintStream(outputStream)));
        engine.run(args);

        System.out.println(outputStream.toString());
        assertThat(outputStream.toString()).contains(
                "FileName: test.txt",
                "Dict size: 141",
                "Amount of words: 268",
                "Amount of characters: 1031",
                "Words which occur more than 10 times: [and, it, the]",
                "'archers' count: 0",
                "'love' count: 1",
                "'hate' count: 0",
                "'fun' count: 0",
                "Execution time in nano seconds:");

        List<Integer> newList = new ArrayList<>();
        newList.stream().isParallel();
    }
}