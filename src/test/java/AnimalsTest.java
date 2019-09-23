import org.junit.*;
import static org.junit.Assert.*;

public class AnimalsTest {
    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals('1', "Henry");
        assertEquals(true, testAnimal instanceof Animals);
    }
    @Test
    public void getId_animalInstantiatesWithId_Number() {
        Animals testAnimal = new Animals('1', "henry");
        assertEquals('1', testAnimal.getId());
    }

    @Test
    public void getName_animalInstantiatesWithName_String() {
        Animals testAnimal = new Animals('1', "Henry");
        assertEquals("Henry", testAnimal.getName());
    }
}