import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

  @Test
  void testValidDirectoryOnlyNoColor(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertFalse(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

  @Test
  void testValidDirectoryOnlyHidden(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertTrue(options.isUseColor());
  }

  @Test
  void testValidDirectoryNoArgs(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = { directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertFalse(options.isShowHidden());
    assertTrue(options.isUseColor());
  }

  @Test
  void testInalidDirectoryNoArgs(@TempDir File tempDir) throws IOException {
    // Arrange: Prepare the arguments with the temp directory
    File myFolder = new File(tempDir, "myFolder");
    assertTrue(myFolder.mkdir(), "myFolder should be created");

    // Create visible files in myFolder
    File apple = new File(myFolder, "Apple.txt");
    apple.createNewFile();
    String directoryPath = apple.getAbsolutePath();
    String[] args = {directoryPath};

    // Act: create throws
    FileNotFoundException exception = assertThrows(
            // need to use the lambda because otherwise the test program would stop due to the exception
            FileNotFoundException.class, () -> { TruffulaOptions options = new TruffulaOptions(args); }
        );
    

    // Assert: Check that exception is thrown
    assertEquals("Not a valid directory", exception.getMessage());
  }

  @Test
  void testBadFileNoArgs(@TempDir File tempDir) throws IOException {
    // Arrange: Prepare the arguments with the temp directory
    File myFolder = new File(tempDir, "myFolder");
    assertTrue(myFolder.mkdir(), "myFolder should be created");

    // Create visible files in myFolder
    File apple = new File(myFolder, "Apple.txt");
    apple.createNewFile();
    String directoryPath = "fakeApple.txt";
    String[] args = {directoryPath};

    // Act: create throws
    FileNotFoundException exception = assertThrows(
            // need to use the lambda because otherwise the test program would stop due to the exception
            FileNotFoundException.class, () -> { TruffulaOptions options = new TruffulaOptions(args); }
        );
    

    // Assert: Check that exception is thrown
    assertEquals("Not a valid directory", exception.getMessage());
  }

  @Test
  void testGoodFileBadArg(@TempDir File tempDir) throws IOException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-f", directoryPath};

    // Act: create throws
    IllegalArgumentException exception = assertThrows(
            // need to use the lambda because otherwise the test program would stop due to the exception
            IllegalArgumentException.class, () -> { TruffulaOptions options = new TruffulaOptions(args); }
        );
    

    // Assert: Check that exception is thrown
    assertEquals("Not a valid argument", exception.getMessage());
  }

  @Test
  void testGoodFileBadArgs(@TempDir File tempDir) throws IOException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-f", "f", directoryPath};

    // Act: create throws
    IllegalArgumentException exception = assertThrows(
            // need to use the lambda because otherwise the test program would stop due to the exception
            IllegalArgumentException.class, () -> { TruffulaOptions options = new TruffulaOptions(args); }
        );
    

    // Assert: Check that exception is thrown
    assertEquals("Not a valid argument", exception.getMessage());
  }

  @Test
  void testGoodFile_OneGoodArg_OneBadArg(@TempDir File tempDir) throws IOException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-nf", directoryPath};

    // Act: create throws
    IllegalArgumentException exception = assertThrows(
            // need to use the lambda because otherwise the test program would stop due to the exception
            IllegalArgumentException.class, () -> { TruffulaOptions options = new TruffulaOptions(args); }
        );
    

    // Assert: Check that exception is thrown
    assertEquals("Not a valid argument", exception.getMessage());
  }
}
