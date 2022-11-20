package patterns.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class LoggerTestSuite {
    
    private static Logger logger;

    @BeforeAll
    public static void makeLog() {
        logger = Logger.INSTANCE;
        logger.log("new adnotation");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String expectedLog = "new adnotation";

        //Then

        assertEquals(expectedLog, logger.getLastLog());

    }
}
