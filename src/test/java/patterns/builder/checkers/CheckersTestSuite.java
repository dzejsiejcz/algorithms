package patterns.builder.checkers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CheckersTestSuite {
    @Test
    void testCheckersBuilder() {
       //Given
       Checkers checkers = new Checkers.CheckersBuilder()          // [1]
          .playerOne("John")                                       // [2]
          .playerTwo("Theresa")                                    // [3]
          .figure(FigureFactory.PAWN, Figure.WHITE, 3, 0)          // [4]
          .figure(FigureFactory.PAWN, Figure.BLACK, 7, 9)          // [5]
          .figure(FigureFactory.QUEEN, Figure.WHITE, 2, 0)         // [6]
          .build();                                                // [7]
       System.out.println(checkers.getBoard());                    // [8]
 
       //When
       Figure figureOne = checkers.getBoard().getFigure(3, 0);    // [9]
       Figure figureTwo = checkers.getBoard().getFigure(7, 9);    // [10]
       Figure figureThree = checkers.getBoard().getFigure(2, 0);  // [11]
       Figure figureFour = checkers.getBoard().getFigure(1, 1);   // [12]
 
       //Then
       assertEquals(Figure.WHITE, figureOne.getColor());           // [13]
       assertEquals(Pawn.class, figureTwo.getClass());             // [14]
       assertEquals(Queen.class, figureThree.getClass());          // [15]
       assertNull(figureFour);                                     // [16]
    }
 
}
