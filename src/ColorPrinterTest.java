import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorPrinterTest {

  // Red Color testing
  @Test
  void testPrintlnWithRedColorAndReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.RED);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message);


    String expectedOutput = ConsoleColor.RED + "I speak for the trees" + System.lineSeparator() + ConsoleColor.RESET;

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testPrintlnWithRedColorAndNoReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.RED);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message, false);


    String expectedOutput = ConsoleColor.RED + "I speak for the trees" + System.lineSeparator();

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }

  // Black Color Testing
  @Test
  void testPrintlnWithBlackColorAndReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.BLACK);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message);


    String expectedOutput = ConsoleColor.BLACK + "I speak for the trees" + System.lineSeparator() + ConsoleColor.RESET;

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testPrintlnWithBlackColorAndNoReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.BLACK);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message, false);


    String expectedOutput = ConsoleColor.BLACK + "I speak for the trees" + System.lineSeparator();

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }

  // Green color testing
    @Test
  void testPrintlnWithGreenColorAndReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.GREEN);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message);


    String expectedOutput = ConsoleColor.GREEN + "I speak for the trees" + System.lineSeparator() + ConsoleColor.RESET;

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testPrintlnWithGreenColorAndNoReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.GREEN);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message, false);


    String expectedOutput = ConsoleColor.GREEN + "I speak for the trees" + System.lineSeparator();

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }
}
