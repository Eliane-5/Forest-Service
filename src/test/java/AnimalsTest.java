import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

import java.util.Arrays;

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
    @Test
    public void all_returnsAllInstancesOfPerson_true() {
        Animals firstAnimal = new Animals("Henry");
        firstAnimal.save();
        Animals secondAnimal = new Animals("Henry");
        secondAnimal.save();
        assertEquals(true, Animals.all().get(0).equals(firstAnimal));
        assertEquals(true, Animals.all().get(1).equals(secondAnimal));
    }
    @Test
    public void save_assignsIdToObject() {
        Animals testAnimal = new Animals("Henry");
        testAnimal.save();
        Animals savedAnimal = Animals.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animals firstAnimal = new Animals("Henry");
        firstAnimal.save();
        Animals secondAnimal = new Animals("Henry");
        secondAnimal.save();
        assertEquals(Animals.find(secondAnimal.getId()), secondAnimal);
    }
//    @Test
//    public void getEndangeredAnimals_retrievesAllEndangeredAnimalsFromDatabase_EndangeredAnimalsList() {
//        Animals testAnimal = new Animals("Henry");
//        testAnimal.save();
//        EndangeredAnimals firstEndangeredAnimal = new EndangeredAnimals(testAnimal.getId(),"cats","good",2);
//        firstEndangeredAnimal.save();
//        EndangeredAnimals secondEndangeredAnimal = new EndangeredAnimals(testAnimal.getId(),"cats","good",2);
//        secondEndangeredAnimal.save();
//        EndangeredAnimals[] endangeredAnimals = new EndangeredAnimals[] { firstEndangeredAnimal, secondEndangeredAnimal };
//        assertTrue(testAnimal.getEndangeredAnimals().containsAll(Arrays.asList(endangeredAnimals)));
//    }
}