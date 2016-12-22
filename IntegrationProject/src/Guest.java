
/**
 * @author Edgar Meruvia Garron.
 * @inheritDoc User
 */
public class Guest extends User {

  /**
   * Converts a name to binary code. This code is changed with the use of
   * polymorphism.
   */
  void welcome() {

    System.out.print("Thanks for using my program ");
  }

  /**
   * Converts string name to binary code. This code is changed with the use of
   * polymorphism.
   * 
   * @param name
   *          name of the new user.
   */
  void toBinary(String name) {
    // declare variable binary name
    String binaryName = name;
    byte[] bytes = binaryName.getBytes();
    StringBuilder binary = new StringBuilder();
    for (byte b : bytes) {
      int value = b;
      for (int i = 0; i < 8; i++) {
        binary.append((value & 128) == 0 ? 0 : 1);
        value <<= 1;
      }
      binary.append(' ');
    }
    System.out.println("Fun fact! Your name in binary is: ");
    System.out.println(binary);
  }

}
