import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {

  @Test
  public void testEmptyString() {
    String input = "";
    Assertions.assertEquals(true, Util.emptyString(input));
  }

  @Test
  public void testEmptyStringWithSpace() {
    String input = " ";
    Assertions.assertEquals(true, Util.emptyString(input));
  }

  @Test
  public void testEmptyStringNull() {
    String input = null;
    Assertions.assertEquals(true, Util.emptyString(input));
  }

  @Test
  public void testEmptyStringWithActualString() {
    String input = "123";
    Assertions.assertEquals(false, Util.emptyString(input));
  }
}
