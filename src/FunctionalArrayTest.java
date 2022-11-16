import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class FunctionalArrayTest {
    @Test
    public void testGetIndexOutOfBounds(){
        FunctionalArray functionalArray = new FunctionalArray(6);
        functionalArray.set(0,3);
        functionalArray.set(3,5);
        functionalArray.set(4,10);
        functionalArray.set(5,3);
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> functionalArray.get(6));
    }

}
