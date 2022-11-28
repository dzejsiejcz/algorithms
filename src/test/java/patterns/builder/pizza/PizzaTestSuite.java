package patterns.builder.pizza;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PizzaTestSuite {

    @Test
    void testPizzaNew() {
       //Given
       Pizza pizza = new Pizza.PizzaBuilder()
             .ingredient("Onion")
             .bottom("Thin")
             .sauce("Spicy")
             .ingredient("Ham")
             .ingredient("Mushrooms")
             .build();
       System.out.println(pizza);
       //When
       int howManyIngredients = pizza.getIngredients().size();
       //Then
       assertEquals(3, howManyIngredients);
    } 
 
}
