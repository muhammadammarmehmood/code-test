import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ProjectTaskTest {
  @Test
  public void testGetUpperCase () {
    String input = "hello world";
    String expectedOutput = "HELLO WORLD";
    String actualOutput = ProjectTask.getUpperCase(input);
    Assertions.assertEquals(expectedOutput,actualOutput);
  }

  @Test
  public void testGetUpperCaseNumericInput() {
    String input = "123*&";
    String actualOutput = ProjectTask.getUpperCase(input);
    Assertions.assertEquals(input, actualOutput);
  }

  @Test
  public void testGetUpperCaseNullInput() {
    String input = null;
    Assertions.assertThrows(RuntimeException.class, () ->{
      ProjectTask.getUpperCase(input);
    });
  }

  @Test
  public void testGetAlternateCase () {
    String input = "hello world";
    String expectedOutput = "hElLO wOrLd";
    String actualOutput = ProjectTask.getUpperCase(input);
    Assertions.assertEquals(expectedOutput,actualOutput);
  }

  @Test
  public void testGetAlternateCaseWithFirstCapital () {
    String input = "Hello World";
    String expectedOutput = "hElLO wOrLd";
    String actualOutput = ProjectTask.getUpperCase(input);
    Assertions.assertEquals(expectedOutput,actualOutput);
  }

  @Test
  public void testGetAlternateCaseNumericInput() {
    String input = "123*&";
    String actualOutput = ProjectTask.getUpperCase(input);
    Assertions.assertEquals(input, actualOutput);
  }

  @Test
  public void testGetAlternateCaseNullInput() {
    String input = null;
    Assertions.assertThrows(RuntimeException.class, () ->{
      ProjectTask.getUpperCase(input);
    });
  }

  @Test
  public void testGetCsvForInput() throws FileNotFoundException {
    String input = "Hello World";
    String expectedOutput = "H,e,l,l,o, ,W,o,r,l,d";
    String actualOutput = ProjectTask.getCsvForInput(input);
    Assertions.assertEquals(expectedOutput, actualOutput);

  }

}
