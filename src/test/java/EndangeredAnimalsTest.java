import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.sql2o.*;

public class EndangeredAnimalsTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void endangeredAnimal_instantiatesCorrectly_true() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        assertEquals(true, testAnimal instanceof EndangeredAnimals);
//    }
//    @Test
//    public void endangeredAnimal_instantiatesWithName_String() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        assertEquals("cats", testAnimal.getName());
//    }
//    @Test
//    public void endangeredAnimal_instantiatesWithHealth_String() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        assertEquals("good", testAnimal.getHealth());
//    }
//    @Test
//    public void endangeredAnimal_instantiatesWithAnimalAge_int() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        assertEquals(2, testAnimal.getAge());
//    }
//    @Test
//    public void equals_returnsTrueIfAnimalIsSameWithOther_True() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        EndangeredAnimals anotherAnimal = new EndangeredAnimals("cats","good",2);
//        assertTrue(testAnimal.equals(anotherAnimal));
//    }
//    @Test
//    public void save_returnsTrueIfDescriptionsAreTheSame() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        testAnimal.save();
//        assertTrue(EndangeredAnimals.all().get(0).equals(testAnimal));
//    }
//    @Test
//    public void save_assignsIdToEndangeredAnimal() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        testAnimal.save();
//        EndangeredAnimals savedAnimal = EndangeredAnimals.all().get(0);
//        assertEquals(savedAnimal.getId(), testAnimal.getId());
//    }
//    @Test
//    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        testAnimal.save();
//        EndangeredAnimals secondAnimal = new EndangeredAnimals("dogs","good",2);
//        secondAnimal.save();
//        assertEquals(true, EndangeredAnimals.all().get(0).equals(testAnimal));
//        assertEquals(true, EndangeredAnimals.all().get(1).equals(secondAnimal));
//    }
//    @Test
//    public void find_returnsAnimalsWithSameId_secondAnimal() {
//        EndangeredAnimals testAnimal = new EndangeredAnimals("cats","good",2);
//        testAnimal.save();
//        EndangeredAnimals secondAnimal = new EndangeredAnimals("dogs","good",2);
//        secondAnimal.save();
//        assertEquals(EndangeredAnimals.find(secondAnimal.getId()), secondAnimal);
//    }
//    @Test
//    public void save_savesAnimalIdIntoDB_true() {
//        Animals testAnimal = new Animals("Henry");
//        testAnimal.save();
//        EndangeredAnimals testEndangeredAnimal = new EndangeredAnimals(testAnimal.getId(),"cats","good",2);
//        testEndangeredAnimal.save();
//        EndangeredAnimals savedEndangeredAnimal = EndangeredAnimals.find(testEndangeredAnimal.getId());
//        assertEquals(savedEndangeredAnimal.getAnimalId(), testAnimal.getId());
//    }
//    @Test
//    public void endangeredAnimal_instantiatesWithHalfFullHealthLevel(){
//        EndangeredAnimals testAnimal = new EndangeredAnimals(1,"dogs","good",2);
//        assertEquals(testAnimal.getHealthLevel(), (EndangeredAnimals.MAX_HEALTH_LEVEL / 2));
//    }
//    @Test
//    public void endangeredAnimal_instantiatesWithHalfFullAgeLevel(){
//        EndangeredAnimals testAnimal = new EndangeredAnimals(1,"dogs","good",2);
//        assertEquals(testAnimal.getAgeCalc(), (EndangeredAnimals.MAX_AGE_LEVEL / 2));
//    }
}