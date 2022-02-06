import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ProjectTask {

  public static final String INPUT_IS_NULL_OR_EMPTY = "Input is null or empty";

  public static void main(String[] args) throws FileNotFoundException {
    // write your code here
    String hello = "Hello World";
    executeProblemTasks(hello);
  }

  /**
   * Executes all the problem tasks.
   * @param string - input string to be manipulated.
   * @throws FileNotFoundException
   */
  public static void executeProblemTasks(String string) throws FileNotFoundException {
    if (Util.emptyString(string)) {
      throw new RuntimeException("Input is null or empty");
    }
    //Task 1
    System.out.println(getUpperCase(string));
    //Task 2
    System.out.println(getAlternateCase(string));
    //Task 3
    System.out.println(getCsvForInput(string));
  }

  /**
   * Converts each character of input string to uppercase.
   * @param string to be converted to uppercase.
   * @return uppercased version of original string.
   */
  public static String getUpperCase(String string) {
    if (string == null && string.trim().length() <= 0) {
      throw new RuntimeException(INPUT_IS_NULL_OR_EMPTY);
    }
    StringBuilder builder = new StringBuilder();
    for (int index = 0; index < string.length(); index++) {
      char character = string.charAt(index);
      if (97 <= character && character <= 122) {
        character = (char) ((character - 32));
      }
      builder.append(character);
    }
    return builder.toString();
  }

  /**
   * Starts with lowercase, this method converts input to alternate case.
   * First is lowercase, second is uppercase third is lowercase and so on.
   * @param string - input string to be manipulated.
   * @return alternate case version of the original string.
   */
  public static String getAlternateCase(String string) {
    if (string == null && string.trim().length() <= 0) {
      throw new RuntimeException(INPUT_IS_NULL_OR_EMPTY);
    }
    boolean isUpperCase = false;
    StringBuilder builder = new StringBuilder();
    for (int index = 0; index < string.length(); index++) {
      char character = string.charAt(index);
      if (isUpperCase) {
        builder.append(Character.toUpperCase(character));
      } else {
        builder.append(Character.toLowerCase(character));
      }
      isUpperCase = !isUpperCase;
    }
    return builder.toString();
  }

  /**
   * Manipulates the input and adds comma after each character.
   * Also creates a file in the root folder
   * @param string - input for the string to be converted.
   * @return comma separated string
   * @throws FileNotFoundException when it is unable to create file.
   */
  public static String getCsvForInput(String string) throws FileNotFoundException {
    if (string == null && string.trim().length() <= 0) {
      throw new RuntimeException(INPUT_IS_NULL_OR_EMPTY);
    }
    StringBuilder builder = new StringBuilder();
    for (int index = 0; index < string.length(); index++) {
      char character = string.charAt(index);
      builder.append(character);
      if (index < string.length() - 1) {
        builder.append(",");
      }
    }
    createFile("test", builder.toString());
    return builder.toString();
  }

  public static void createFile(String fileNameWithoutExtension, String contents) throws FileNotFoundException {
    if (Util.emptyString(fileNameWithoutExtension)) {
      throw new IllegalArgumentException("File Name is null or empty");
    }

    if (Util.emptyString(contents)) {
      throw new IllegalArgumentException("File contents is null or empty");
    }

    try (PrintWriter writer = new PrintWriter(fileNameWithoutExtension + ".csv")) {
      writer.write(contents);
    }
  }
}
