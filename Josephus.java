import java.util.*;

public class Josephus {

  Scanner userInput = new Scanner(System.in);
 
  public void josephusFlaviusProblem() {
    String[] array = null;
    Queue<Integer> queue = new LinkedList<Integer>();

    // get the number of soldiers
    System.out.print("How many soldiers?: ");
    int size = userInput.nextInt();

    array = new String[size + 1];

    // get the names of soldiers
    System.out.println("Enter " + size + " soldier names: ");
    // add the names in a queue
    for (int i = 0; i <= size; i++) {
      String names = userInput.nextLine();
      array[i] = names;
      queue.add(i);
    }
    queue.remove();

    // get the eliminating position
    System.out.print("Enter the position: ");
    int position = userInput.nextInt();

    System.out.println("Eliminating order: ");
    while (!queue.isEmpty()) {
      // remove elements before position and add them to the end of the queue
      for (int i = 0; i < position - 1; i++) {
        int temp = queue.remove();
        queue.add(temp);
      }
      // remove element at position
      int eliminated = queue.remove();
      if (!queue.isEmpty())
        System.out.println(array[eliminated] + " (" + eliminated + ")");
      else
        // when the queue becomes empty, the last element removed is the survivor
        System.out.println("The survivor is " + array[eliminated] + " (" + eliminated + ")");
    }
  }
}
