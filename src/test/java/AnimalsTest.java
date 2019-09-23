import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals("Henry");
        assertEquals(true, testAnimal instanceof Animals);
    }

    @Test
    public void getName_animalInstantiatesWithName_String() {
        Animals testAnimal = new Animals("Henry");
        assertEquals("Henry", testAnimal.getName());
    }
    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        Animals firstAnimal = new Animals("Henry");
        Animals anotherAnimal = new Animals("Henry");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Animals() {
        Animals testAnimal = new Animals("Henry");
        testAnimal.save();
        assertTrue(Animals.all().get(0).equals(testAnimal));
    }
}