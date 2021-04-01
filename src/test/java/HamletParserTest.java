import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        //When
        String actual = hamletParser.changeHamletToLeon();
        System.out.println(actual);
        //Then
        Assert.assertFalse(actual.contains("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        //When
        String actual = hamletParser.changeHoratioToTariq();
        System.out.println(actual);
        //Then
        Assert.assertFalse(actual.contains("Horatio"));
    }

    @Test
    public void testFindHoratio() {
        //Given
        //When
        String expected = "Horatio";
        String actual = hamletParser.findHoratio();
        System.out.println(actual);
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet() {
        //Act
        boolean returned = hamletParser.findHamlet();
        //Then
        Assert.assertTrue(returned);
    }
}