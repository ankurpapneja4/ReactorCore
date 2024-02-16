package example.reactor.core;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static example.reactor.core.Utils.await;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamLazyBehaviourTest {

    @Test
    /**
     *
     * Lazy behaviour of Stream : means that the intermediate operations on a stream are not executed until a terminal operation is invoked.
     *
     */
    void testStreamLazyBehaviour() {


        // Given: 5 Integers, And Time Required To Map Each Integer Value Is More Than 2 Sec.

        long beginTime = System.currentTimeMillis();

        // Then: Perform Mapping
        IntStream stream = IntStream.range( 1, 5).map( this::expensiveOperation ).map( this::expensiveOperation ).map( this::expensiveOperation );

        long executionTime = System.currentTimeMillis() - beginTime;

        // Should: Not Take More Than 10Ms.
        assertThat( executionTime ).isLessThan( 10 );

    }

    @Test
    void testStreamWithTerminalOperation() {


        // Given: 1 Integers, And Time Required To Map Each Integer Value Is More Than 2 Sec.

        long beginTime = System.currentTimeMillis();

        // Then: Perform Mapping And Add Terminal Operation
        IntStream stream = IntStream.of( 1 ).map( this::expensiveOperation );
        stream.max();

        long executionTime = System.currentTimeMillis() - beginTime;

        // Should: Take More Than 2000Ms.
        assertThat( executionTime ).isGreaterThan( 2000 );

    }



    public Integer expensiveOperation(Integer i){
        await( 2000 );
        return i * i;
    }

}
