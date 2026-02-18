/**
 * Test class for GenericStack.
 * Demonstrates correct behavior for both Integer and String stacks,
 * including normal use and error cases.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Integer Stack Test");

        GenericStack<Integer> numberStack = new GenericStack<Integer>(3);

        numberStack.push(10);
        numberStack.push(20);
        numberStack.push(30);

        System.out.println("List: " + numberStack.list()); // expected: 10;20;30

        System.out.println("Peek: " + numberStack.peek()); // expected: 30

        System.out.println("Pop: " + numberStack.pop());   // expected: 30
        System.out.println("List after pop: " + numberStack.list()); // expected: 10;20

        try {
            numberStack.push(40); // now: 10,20,40
            numberStack.push(50); // should fail
        } catch (StackFullException e) {
            System.out.println("Caught expected StackFullException: " + e.getMessage());
        }

        System.out.println("Pop: " + numberStack.pop()); // expected: 40
        System.out.println("Pop: " + numberStack.pop()); // expected: 20
        System.out.println("Pop: " + numberStack.pop()); // expected: 10

        try {
            numberStack.pop(); // should fail
        } catch (StackEmptyException e) {
            System.out.println("Caught expected StackEmptyException: " + e.getMessage());
        }

        System.out.println();

        System.out.println("String Stack Test");

        GenericStack<String> textStack = new GenericStack<String>(4);

        textStack.push("Hello");
        textStack.push("World");
        textStack.push("SEW");
        textStack.push("TGM");

        System.out.println("List: " + textStack.list()); // expected: Hello;World;SEW;TGM
        System.out.println("Peek: " + textStack.peek()); // expected: TGM

        // Pop a few elements
        System.out.println("Pop: " + textStack.pop()); // expected: TGM
        System.out.println("Pop: " + textStack.pop()); // expected: SEW
        System.out.println("List after pops: " + textStack.list()); // expected: Hello;World

        textStack.pop(); // removes World
        textStack.pop(); // removes Hello
        try {
            textStack.peek(); // should fail now
        } catch (StackEmptyException e) {
            System.out.println("Caught expected StackEmptyException: " + e.getMessage());
        }
    }
}
