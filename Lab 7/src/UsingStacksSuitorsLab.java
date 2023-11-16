import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * UsingStacksSuitorsLab
 *
 * This class is mostly a driver for playing with Strings as palindromes,
 * both iteratively and recursively. The UsingStacksSuitorsLab class itself is
 * a runnable object, so it can be passed to a thread in our Queue demo
 */
public class UsingStacksSuitorsLab implements Runnable {
	private static int threadCount = 0;
	private String name;

	public UsingStacksSuitorsLab() {
		name = "#" + threadCount++ + "Thread";
	}

	public static void main(String[] args) {
		String s1 = "food";        // not a palindrome
		String s2 = "racecar";     // a palindrome

		System.out.println("String1 is \"" + s1 + "\"");
		System.out.println("String2 is \"" + s2 + "\"");

		System.out.println(s1 + " reversed is: ");
		printReverse(s1);
		System.out.println(s2 + " reversed is: ");
		printReverse(s2);

		recPrintReverse(s1);
		System.out.println();
		recPrintReverse(s2);
		System.out.println();

		System.out.println(s1 + " is a palindrome: " + isPalindrome(s1));
		System.out.println(s2 + " is a palindrome: " + isPalindrome(s2));

		System.out.println(s1 + " is a palindrome(recursively): " + isPalindromeRec(s1));
		System.out.println(s2 + " is a palindrome(recursively): " + isPalindromeRec(s2));

		System.out.println("Did we build a Queue of Threads and start them? " + buildThreadQueue());

		int n = 6;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));

		n = 10;
		System.out.println("For " + n + " suitors, stand in place:" + findPlaceToStand(n));
	}

	/**
	 * Prints the reverse of the input string using a linked stack.
	 *
	 * @param target The input string
	 */
	public static void printReverse(String target) {
		// Use a linked stack
		LLStack stack = new LLStack();

		// Push each character from the input string onto the stack
		for (int i = 0; i < target.length(); i++) {
			stack.addToStart(target.charAt(i));
		}

		// Pop off each character from the stack and print it
		System.out.println(target + " reversed is: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.deleteHead());
		}
		System.out.println(); // New line for better readability
	}

	/**
	 * Prints the reverse of the input string recursively.
	 *
	 * @param target The input string
	 */
	public static void recPrintReverse(String target) {
		if (target.isEmpty()) {
			return;
		}
		System.out.print(target.charAt(target.length() - 1));
		recPrintReverse(target.substring(0, target.length() - 1));
	}

	/**
	 * Checks if the input string is a palindrome using a stack.
	 *
	 * @param input The input string
	 * @return True if the input string is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(String input) {
		// Use a linked stack
		LLStack stack = new LLStack();

		// Push each character from the input string onto the stack
		for (int i = 0; i < input.length(); i++) {
			stack.addToStart(input.charAt(i));
		}

		// Check if the characters in reverse order match the original string
		StringBuilder reversed = new StringBuilder();
		while (!stack.isEmpty()) {
			reversed.append(stack.deleteHead());
		}

		return input.equals(reversed.toString());
	}

	/**
	 * Checks if the input string is a palindrome recursively.
	 *
	 * @param sentence The input string
	 * @return True if the input string is a palindrome, false otherwise
	 */
	public static boolean isPalindromeRec(String sentence) {
		// Base case 1: Empty or single-character string is implicitly a palindrome
		if (sentence.length() <= 1) {
			return true;
		}

		// Base case 2: If the first and last characters are different, it's not a palindrome
		if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
			return false;
		}

		// Recursive case: Chop off the first and last characters and check the substring
		return isPalindromeRec(sentence.substring(1, sentence.length() - 1));
	}

	/**
	 * Finds a place to stand for suitors in a circle using a queue.
	 *
	 * @param numSuitors The number of suitors
	 * @return The place to stand
	 */
	public static int findPlaceToStand(int numSuitors) {
		if (numSuitors <= 0) {
			return -1; // Invalid input
		}

		Queue<Integer> suitorQueue = new LinkedList<>();

		// Initialize the queue with suitors numbered from 1 to numSuitors
		for (int i = 1; i <= numSuitors; i++) {
			suitorQueue.add(i);
		}

		Stack<Integer> reverseStack = new Stack<>();

		// Continue the process until only one suitor is left
		while (suitorQueue.size() > 1) {
			// Remove and add the first two suitors to the back of the queue
			int suitor1 = suitorQueue.poll();
			int suitor2 = suitorQueue.poll();
			suitorQueue.add(suitor1);
			suitorQueue.add(suitor2);

			// Discard the third suitor (every third suitor is eliminated)
			int eliminatedSuitor = suitorQueue.poll();
			reverseStack.push(eliminatedSuitor);
		}

		// Process the remaining suitor
		int remainingSuitor = suitorQueue.poll();

		// Reverse the direction and count backward
		while (!reverseStack.isEmpty()) {
			suitorQueue.add(reverseStack.pop());
		}

		// Continue the process until only one suitor is left
		while (suitorQueue.size() > 1) {
			// Remove and add the first two suitors to the back of the queue
			int suitor1 = suitorQueue.poll();
			int suitor2 = suitorQueue.poll();
			suitorQueue.add(suitor1);
			suitorQueue.add(suitor2);

			// Discard the third suitor (every third suitor is eliminated)
			suitorQueue.poll();
		}

		// The remaining suitor is the winner
		return suitorQueue.poll();
	}

	/**
	 * Builds a queue of threads and starts them.
	 *
	 * @return True on successful start
	 */
	public static boolean buildThreadQueue() {
		Queue<Thread> q = new LinkedList<>();

		// when our program starts up, it might create multiple threads to use
		q.add(new Thread(new UsingStacksSuitorsLab()));
		q.add(new Thread(new UsingStacksSuitorsLab()));
		q.add(new Thread(new UsingStacksSuitorsLab()));

		System.out.println("Initial Thread order:");
		System.out.println(q);

		// We need to iterate over our pool of threads and call start() on each one
		// Make a loop that dequeues a thread, calls start on it, and //enqueues it again
		while (!q.isEmpty()) {
			Thread current = q.poll();
			current.start();
			q.add(current);
		}

		System.out.println("Thread order after start()ing:");
		System.out.println(q);

		return true; // on successful start
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(name + ": " + i + "th iteration");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// do nothing here
			}
		}
	}
}
