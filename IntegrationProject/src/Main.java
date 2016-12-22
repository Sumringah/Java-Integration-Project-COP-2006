
/*Edgar Meruvia Garron Integration Project
imports the scanner utility*/
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/*DEFINITIONS:
 * A variable is a value that can change, depending on conditions or on
 information passed to the program.
 * Data Types:
 * byte: The byte data type is an 8-bit signed two's complement integer.
 it has a minimum value of -128 and a maximum value of 127(Inclusive).
 * shot: The short data type is an 16-bit singed two's complement integer.
 It has a min. value of -32,768 and a max value of 32,767(Inclusive).
 * int: The int data type is an 64-bit singed two's complement integer.
 It has a min. value of -2^31 and a max value of 2^31(-1).
 * long: The long data type is a 64-bit two's complement integer.
 The signed long has a min. value of -2^63 and a max value of 2^63(-1). 
 * float: The float data type is a single-precision 32-bit IEEE 754 floating
 point. It range of values is beyond the scope of this discussion, but is 
 specified in the Floating-Point Types, Formats, and Values section of the Java 
 Language Specification.
 * double: The double data type is a double-precision 64-bit IEEE 754 floating 
 point.Its range of values is beyond the scope of this discussion, but it is 
 specified in the Floating-Point Types, Formats, and Values section of the Java 
 Language Specification.
 * boolean: The boolean data type has only two possible values: true and false.
 Use this data type for simple flags that track true\false conditions. This
 data type represents one bit of information, but its "size" isn't something 
 that's precisely defined.
 * char: The char data type is a single 16-bit Unicode character. It has a min.
 value of "/u000" (or 0) and a maximum value of "/uffff" (or 65,535 inclusive)
 *Relational Operators: It is an operator that compares two numbers and returns
 boolean value; they are < (less than) , > (greater than), <= (less or equal to)
 , >= (greater or equal to), == (equal too), and != (not equal too)
 *Conditional Operator: It performs the conditional-AND (&&) and conditional-OR
 (||) on two boolean operators.
 public void method(parameter){....}
 user.method(argument)
 */

/**
 * @author Edgar Meruvia Garron.
 * This program is designed to show everything I have learned in the COP 2006
 * Intro to Programming class. 
 * The program starts with a welcome message, followed by a menu which contains
 * different utilities the user can use in a daily basis or to know more about 
 * me.
 */
public class Main {
  
  // This allows the scanner to be only declared once.
  public static final Scanner input = new Scanner(System.in);
  public static final Random rand = new Random();
  public static final Calendar now = Calendar.getInstance();
  
  /**
   * Main method, where the call of the other methods is located.
   * @param args main class that calls all.
   */
  public static void main(String[] args) {
    
    // get the current year
    int year = now.get(Calendar.YEAR);
    // print an intro to the screen
    System.out.println("Hello World!!!");
    System.out.println("Welcome to my integration project!");
    // call method welcome;
    welcome();
    Boolean endProgram = false;
    // menu option variable
    int menuOption = 0;
    // Controls when the program is going to end.
    while (endProgram != true) {
      System.out.println(
          "\nMain Menu:" + "\n1. Age Guesser Program." + "\n2. Array Example."
              + "\n3. Calculator Program." + "\n4. Creator Info."
              + "\n5. Queque Program." + "\n6. Two Dimension Array."
              + "\nPress any other number to exit the program");
      // Try-catch blocks. Handles the errors.
      
      try {
        menuOption = input.nextInt();
        System.out.println("");
        if (menuOption == 1) {
          System.out.println("Welcome to the age guesser program.");
          System.out.println("This program will guess the year you were born.");
          // call method AgeGuesser with argument year
          ageGuesser(year);
        } else if (menuOption == 2) {
          // call method calculator
          arrayExample();
        } else if (menuOption == 3) {
          calculator();
        } else if (menuOption == 4) {
          // call method creator with a argument
          creator(year);
        } else if (menuOption == 5) {
          queue();
        } else if (menuOption == 6) {
          twoDimensionArray();
        } else {
          System.out.println("Thanks for using my program. See you next time!");
          endProgram = true;
        }
      } catch (InputMismatchException ex) {
        // Handles wrong input.
        input.next();
      } catch (Exception ex) {
        System.out.println(ex);
      }

    }
  }

  /**
   * Display a welcome screen to the user.
   * This method shows polymorphism.
   */
  static void welcome() {
    // User class that uses polymorphism in Guest class.
    User guest = new Guest();
    System.out.println("What is your name?");
    String name = input.nextLine();
    System.out.println();
    // name setter
    guest.setName(name);
    // welcome method that uses polymorphism in Guest Class.
    guest.welcome();
    System.out.print(name + "!\n");
    // Converts your name to Binary
    guest.toBinary(name);

  }

  /**
   * This method is designed to display a message depending on the age of the 
   * user, it will also give the year the user was born.
   * @param currentYear takes current year.
   * @exception inputMismatchException if input is wrong.
   * @exception Exception for other exceptions.
   */
  static void ageGuesser(int currentYear) {
    // calls class which inherits from User.
    Guest guest = new Guest();
    int age;
    try {
      System.out.println("How old are you?");
      age = input.nextInt();
      guest.setAge(age);
      System.out.println("So you are " + guest.getAge() + " years old...");
      if (guest.getAge() >= 50 && guest.getAge() <= 100) {
        System.out.println("Damn, you are old.");
      } else if (guest.getAge() < 50 && guest.getAge() >= 40) {
        System.out.println("You are almost half a decade old!");
      } else if (guest.getAge() < 40 && guest.getAge() >= 30) {
        System.out.println("These should be your golden years.");
      } else if (guest.getAge() > 20 && guest.getAge() < 30) {
        System.out.println("Welcome to the Adult world; "
            + "bills and responsibilities await you.");
      } else if (guest.getAge() <= 20 && guest.getAge() > 13) {
        System.out.println("You don't really know anything about life yet!");
      } else if (guest.getAge() <= 13 && guest.getAge() > 8) {
        System.out.println("Enjoy it while it lasts.");
      } else if (guest.getAge() <= 8 && guest.getAge() >= 0) {
        System.out.println("You liar, you aren't " + guest.getAge()
            + " years old." + " You shouldn't even be able to read!");
      } else {
        System.out
            .println("It is impossible that you are " + age + " years old.");
      }
      if (guest.getAge() > 0 && guest.getAge() <= 100) {
        System.out.println("");
        int yearBorn = currentYear - age;
        System.out.println("Were you born in the year " + yearBorn + "?(y/n)");
        String yearBornConfirmation = input.next();
        // String Processing. Transforms to lower case.
        if (yearBornConfirmation.toLowerCase().equals("yes")
            || yearBornConfirmation.toLowerCase().equals("y")) {
          System.out.println(
              "Great the Program guessed the year you were born correctly!");
        } else {
          System.out.println("Then you were born in " + (yearBorn - 1));
        }
      }
    } catch (InputMismatchException ex) {
      System.out.println("Please enter your age.");
      input.next();
      ageGuesser(currentYear);
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }

  /**
   * Method header ArrayExample.
   * This method provides an array and gives the user different options from
   * which the user will pick what to do next; find an element, sum of it's 
   * values, or the smallest value in the array.
   * @exception inputMismatchException if input is wrong.
   * @exception Exception for other exceptions.
   */
  static void arrayExample() {
    int[] arr = { 12, 23, 24, 53, 2 };
    System.out.println("This is our Array:");
    // print the array.
    for (int counter = 0; counter < arr.length; counter++) {
      System.out.print(arr[counter] + "\t");
    }
    System.out.println("");
    System.out.println("What do you want to do with the array?");
    System.out.println(
        "Arrays Examples Menu:" + "\n1. Find the smallest value in an array."
            + "\n2. Get the sum of the values in the array."
            + "\n3. Search for an array and its index.");
    int arrayOption;
    try {
      arrayOption = input.nextInt();
      System.out.println("");
      if (arrayOption == 1) {
        int smallest = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
          // Look for the smallest number in an array.
          if (arr[i] < smallest) {
            smallest = arr[i];
            index = i;
          }
        }
        System.out.println("The smallest number in the array is: " + smallest);
        System.out
            .println("It was found in the index " + index + " of the array");
      } else if (arrayOption == 2) {
        int sumTotal = 0;
        for (int i = 0; i < arr.length; i++) {
          sumTotal += arr[i];
        }
        System.out
            .println("The sum of the values inside the array is: " + sumTotal);
      } else if (arrayOption == 3) {
        System.out.println(
            "Whose array value do you want to find the" + " index of?");
        int arrValue = input.nextInt();
        boolean arrExists = false;
        for (int i = 0; i < arr.length; i++) {
          if (arrValue == arr[i]) {
            arrExists = true;
            System.out.println("You are looking for the array whose value"
                + " equals " + arrValue);
            System.out.println("Its index value is: " + i);
          }
        }
        if (arrExists != true) {
          System.out.println(
              "The value " + arrValue + "" + " is not part of the array.");
        }
      } else {
        System.out.println("Please select one of the options. \n");
        arrayExample();
      }
    } catch (InputMismatchException ex) {
      System.out.println("Please select one of the options. \n");
      input.next();
      arrayExample();
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }

  /**
   * Calculator method header.
   * This method is designed to do basic math functions, like summations, 
   * subtractions, multiplications and divisions. It also shows the proper use
   * of division in programing.
   * @exception inputMismatchException if input is wrong.
   * @exception Exception for other exceptions.
   */
  static void calculator() {
    System.out.println("Welcome to the calculator method."
        + "\nHow many times do you want to use the calculator?");
    int use;
    try {
      use = input.nextInt();
      for (int i = 0; i < use; i++) {
        System.out.println("\nCalculator menu:");
        System.out.println("1. Addition");
        System.out.println("2. Sustraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Remainder");
        System.out.println("6. Demonstration of proper use of division");

        int menuCalculator = 0;
        try {
          System.out.println("Please choose a menu option: ");
          menuCalculator = input.nextInt();
        } catch (InputMismatchException ex) {
          System.out.println("Please enter a number.");
          input.next();
        } catch (Exception ex) {
          System.out.println(ex);
        }
        double d1;
        double d2;
        double d3;
        switch (menuCalculator) {
          case 1:
            // addition
            System.out.println("Addition:");
            System.out.println("Choose 2 numbers you want to add.");
            System.out.println("Please enter your first number: ");
            d1 = input.nextDouble();
            System.out.println("Please enter your second number: ");
            d2 = input.nextDouble();
            d3 = d1 + d2;
            System.out.println();
            // the printf statement is for rounding. the %.2f is for
            // determining the amount of decimal places
            System.out.printf("The result is = %.2f", d3);
            System.out.println("");
            break;
          case 2:
            // subtraction
            System.out.println("Subtraction: ");
            System.out.println("Choose 2 numbers you want to subtract.");
            System.out.println("Please enter your first number: ");
            d1 = input.nextDouble();
            System.out.println("Please enter the number that you want to "
                + "subtract from the first number: ");
            d2 = input.nextDouble();
            d3 = d1 - d2;
            System.out.println();
            System.out.printf("The result is = %.2f", d3);
            System.out.println("");
            break;
          case 3:
            // multiplication
            System.out.println("Multiplication: ");
            System.out.println("Choose 2 numbers you want to multiply.");
            System.out.println("Please enter your first number: ");
            d1 = input.nextDouble();
            System.out.println("Please enter your second number: ");
            d2 = input.nextDouble();
            d3 = d1 * d2;
            System.out.println();
            System.out.printf(" The result is = %.2f", d3);
            System.out.println("");
            break;
          case 4:
            // division
            System.out.println("Division: ");
            System.out.println("Choose 2 numbers you want to divide.");
            System.out.println("Please enter your first number: ");
            d1 = input.nextDouble();
            System.out.println("Please enter the number that you want to "
                + "divide from the first number: ");
            d2 = input.nextDouble();
            d3 = d1 / d2;
            System.out.println();
            System.out.printf("The result is = %.2f", d3);
            System.out.println("");
            break;
          case 5:
            // modulus-remainder
            System.out.println("Remainer: ");
            System.out
                .println("Choose 2 numbers you want to find the remainer off.");
            System.out.println("Please enter your first number: ");
            d1 = input.nextDouble();
            System.out.println("Please enter the number that you want to "
                + "use find the remainer of the first number: ");
            d2 = input.nextDouble();
            d3 = d1 % d2;
            System.out.println();
            System.out.printf("The result is = %.2f", d3);
            System.out.println("");
            break;
          case 6:// proper use of integer division
            System.out.println("The following is a proper example of integer "
                + "divisions." + "\n");
            System.out.println("Proper division of 15 divided by 4: \n");
            double example1 = 15;
            double example2 = 4;
            System.out.printf("The result is = %.2f", example1 / example2);
            System.out.println("\nUnproper division of 15 divided by 4:\n");
            int example3 = 15;
            int example4 = 4;
            System.out.println("The result is = " + example3 / example4);
            System.out.println("");
            break;
          default:
            break;   
        }
      }
    } catch (InputMismatchException ex) {
      System.out.println("Please enter a number. \n");
      input.next();
      calculator();
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }

  /**
   * method header creator.
   * This method provides the creator's basic info, year of graduation, age,
   * name, name in binary.
   * @param currentYear takes current year.
     to binary takes null as a parameter because it doesn't modify anything.
   * @exception inputMismatchException if input is wrong.
   * @exception Exception for other exceptions.
   */
  static void creator(int currentYear) {
    System.out.println("This is the info of the program creator:\n");
    // define a new User.
    User userCreator = new User();
    // call method from user class
    userCreator.welcome();
    // call method from user class
    userCreator.info();
    // call method from user class with null argument
    userCreator.toBinary(null);
    // call method from user class
    userCreator.graduationYear();
    // call method with an argument currentYear
    userCreator.yearsToGraduate(currentYear);
  }

  /**
   * method header queue.
   * This method generates a queue and then lets the user interact with it's 
   * values, by removing an specific amount of elements from the list.
   * @exception inputMismatchException if input is wrong.
   * @exception Exception for other exceptions.
   */
  static void queue() {
    System.out.println("List of random generated numbers: \n");
    Queue<Integer> queue = new LinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
      // add random values to the queue.
      queue.add(rand.nextInt(100));
    }
    System.out.println(queue);
    int size = queue.size();
    System.out.println(
        "\nHow many values do you want to remove from the" + " queue?");
    // declare variables.
    int remove;
    try {
      remove = input.nextInt();
      if (remove <= size) {
        for (int i = 0; i < remove; i++) {
          // assign a variable to the values that have been removed
          int elements = queue.remove();
          System.out.println("You removed " + elements + " from the queue.");
        }
        System.out.println("The remaining values in the queue are:");
        System.out.println(queue);
      } else {
        System.out.println("You are exeding the number of values that you can"
            + " remove from the list.");
      }

    } catch (InputMismatchException ex) {
      System.out.println("Please enter a number.");
      input.next();
      queue();
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }

  /**
   * method header two dimension array.
   * This method provides the user with a 2-Dimension array. It will give the
   * user the options of looking for an specific value in the array and show
   * how many times and the location on which the array was found.
   * @exception inputMismatchException if input is wrong.
   * @exception Exception for other exceptions.
   */
  static void twoDimensionArray() {
    // display welcome message
    System.out.println("This is our 2-D Array: \n");
    // 2d array values
    int[][] twoArr = { { 8, 1, 3, 8, 4 }, { 15, 2, 46, 34, 87 },
        { 65, 45, 21, 32, 45 }, { 36, 20, 13, 32, 64 }, { 45, 7, 3, 1, 3 } };
    for (int i = 0; i < twoArr.length; i++) {
      for (int j = 0; j < twoArr[i].length; j++) {
        System.out.print(twoArr[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("Search the position of a value in the array:");
    int arrayValue;
    try {
      arrayValue = input.nextInt();
      int count = 0;
      for (int i = 0; i < twoArr.length; i++) {
        for (int j = 0; j < twoArr[i].length; j++) {
          if (arrayValue == twoArr[i][j]) {
            count++;

            System.out
                .println("Found at Row: " + (i + 1) + " Column: " + (j + 1));
            System.out.println();
          }
        }
      }
      System.out.println("You are looking for the value of: " + arrayValue);
      System.out.println("It was found " + count + " times");
    } catch (InputMismatchException ex) {
      System.out.println("Please enter a number.");
      input.next();
      twoDimensionArray();
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }

}
