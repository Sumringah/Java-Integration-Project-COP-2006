
/**
 * @author Edgar Meruvia Garron.
 * {@docRoot} Guest.
 */
public class User {
  
  // private strings belong only to the class User.
  private String name = "Edgar";
  private int age = 20;
  private int graduation = 2019;

  /**
   * Welcome message, uses polymorphism.
   */
  void welcome() {
    System.out.println("Hello, my name is " + name);
  }

  /**
   * Display creator's name in binary code.
   * @param name takes name string.
   */
  void toBinary(String name) {
    System.out.println("This is my name in Binary: "
        + "01000101 01100100 01100111 01100001 01110010 ");
  }

  /**
   * Display age.
   */
  public void info() {
    System.out.println("I am currently " + age + " years old.");
  }

  /**
   * Display graduation year.
   */
  public void graduationYear() {
    System.out.println("I will graduate in " + graduation);
  }

  /**
   * Gives information on when the creator is going to be graduating.
   * @param currentYear takes current year and runs the respective code of block
     assigned.
   */
  public void yearsToGraduate(int currentYear) {
    int graduate = graduation - currentYear;
    if (graduate > 0) {
      System.out.println("I will be graduating in " + graduate + " years.");
    } else if (graduate == 0) {
      System.out.println("I'm graduating this year!");
    } else {
      System.out.println("I already graduated!");
    }
  }

  /**
   * age getter.
   * @return age.
   */
  public int getAge() {
    return age;
  }

  /**
   * Age setter 
   * @param age takes age.
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * name getter.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * name setter 
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }
}
