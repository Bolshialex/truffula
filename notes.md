# Truffula Notes

As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java

Main implementation for truffula. Gives users options to customize the way their information is being output. Options like colored folders, showing hidden folder or not, and the file location the app would start.

## ConsoleColor.java

Allows for coloring text on the console. Provides a number of ANSI codes that correspond to colored values. Provides
methods getting color codes and getting color codes as a string.

## ColorPrinter.java / ColorPrinterTest.java

ColorPrinter.java is a class used to print different text colors to a PrintStream. Keeps track of different variables like the currentColor and allows you to set the current color, while also resetting the current color or saving it for the next output. lastly, it can print those string out into the terminal.

ColorPrinterTest.java is used to test that the colors being printed are expected and if the reset or save options are being used properly.

## TruffulaOptions.java / TruffulaOptionsTest.java

Constructs the truffula options object for the various cmd arguments. Provides methods for getting the options.

TruffulaOptionsTest.java run tests on its functionlity. Will need to look into test argument tempDir.

## TruffulaPrinter.java / TruffulaPrinterTest.java

TruffulaPrinter.java is a class that is used to print the file structure with the given options by the user. It also sorts files for the user and color codes them accordingly if colors are requested.

TruffulaPrinterTest.java tests that os is windows (maybe add check for mac) the output for printing methods are displaying files correctly given a directory in the test params

## AlphabeticalFileSorter.java

Sorts files shown in the terminal to be displayed in alphabetical order
