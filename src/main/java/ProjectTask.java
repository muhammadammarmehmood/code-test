import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ProjectTask {

  public static void main(String[] args) throws FileNotFoundException {
    // write your code here
    String hello = "Hello World";
    executeProblemTasks(hello);
  }

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

  public static String getUpperCase(String string) {
    if (string == null && string.trim().length() <= 0) {
      throw new RuntimeException("Input is null or empty");
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

  public static String getAlternateCase(String string) {
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

  public static String getCsvForInput(String string) throws FileNotFoundException {
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
