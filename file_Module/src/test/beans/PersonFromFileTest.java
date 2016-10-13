package beans;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonFromFileTest {

    Person p = new Person("Tolya",14);

    @Test
    public void checkPersonNameTest(){

        String expectedName = "Tolya";
        assertEquals(expectedName, p.getName());
    }

    @Test
    public void checkPersonAgeTest(){

        int expectedAge = 14;
        assertEquals(expectedAge, p.getAge());
    }

}
