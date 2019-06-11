import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class EngineTest2 {

    private Engine engine;
    private OutputStream outputStream;

    @BeforeEach
    void before() {
        this.outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testDisplayResults(){
        String[] args = {"test2.txt"};
        this.engine = new Engine(new View(new PrintStream(outputStream)));
        engine.run(args);

        System.out.println(outputStream.toString());
        assertThat(outputStream.toString()).contains(
                "FileName: test2.txt",
                "Dict size: 151",
                "Amount of words: 235",
                "Amount of characters: 939",
                "Words which occur more than 10 times: []",
                "'archers' count: 0",
                "'love' count: 0",
                "'hate' count: 2",
                "'fun' count: 0",
                "Execution time in nano seconds:");
    }

}