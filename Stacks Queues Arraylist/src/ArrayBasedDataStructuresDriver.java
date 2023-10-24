import java.util.*;
/**
 * The ArrayBasedDataStructuresDriver class provides a driver program to test
 * various array-based data structures, including ArrayList, Stack, and Queue.
 *
 * By Veer Saini
 */
public class ArrayBasedDataStructuresDriver {

	// Instance Variables
	private static boolean failed = false;
	private static String[] allFailed = new String[100000];
	private static int numFailed = 0;

	/**
	 * The main method runs tests for ArrayList, Stack, and Queue data structures,
	 * and displays the test results.
	 *
	 * @param args The command-line arguments (not used in this program).
	 */
	public static void main(String[] args) {

		testArrayList();
		testStack();
		testQueue();

		System.out.println();

		if (failed) {
			System.out.println("Fail Report:");
			for (int i = 0; i < numFailed; i++) {
				System.out.println(allFailed[i]);
			}
		} else {
			System.out.println("All tests passed.");
		}
	}

	/**
	 * Tests the ArrayList data structure by performing insert, add, indexOf, get,
	 * size, remove, and equals operations.
	 */
	private static void testArrayList() {

		ArrayList charList = new ArrayList();

		charList.insert('b', 0);
		charList.insert('r', 0);
		charList.insert('6', 2);
		charList.insert('1', 1);
		charList.insert('W', 0);
		charList.insert('c', 3);
		charList.insert('G', 2);

		if (charList.toString().equals("W r G 1 c b 6 ")) {
			System.out.print(".");
		} else {
			failed = true;
			allFailed[numFailed] = "Insert Method Failed";
			numFailed++;
		}

		while (!charList.isEmpty()) {
			charList.remove(0);
		}

		for (int i = 0; i < charList.size(); i++) {
			if (charList.get(i) == null) {
				System.out.print(".");
			} else {
				failed = true;
				allFailed[numFailed] = "Remove and IsEmpty Method Failed";
				numFailed++;
			}
		}

		charList.add('P');
		charList.add('A');
		charList.add('R');
		charList.add('R');
		charList.add('O');
		charList.add('T');
		if (charList.toString().equals("P A R R O T ")) {
			System.out.println(".");
		} else {
			failed = true;
			allFailed[numFailed] = "Add Method Failed";
			numFailed++;
		}

		if ((charList.indexOf('T') == 5) && (charList.indexOf('E') == -1)) {
			System.out.println(".");
		} else {
			failed = true;
			allFailed[numFailed] = "IndexOf Method Failed";
			numFailed++;
		}

		if ((charList.get(5).equals('T'))) {
			System.out.println(".");
		} else {
			failed = true;
			allFailed[numFailed] = "Get Method Failed";
			numFailed++;
		}

		int size = charList.size();
		for (int i = 0; i < size; i++) {
			charList.remove(0);
		}

		for (int i = 0; i < charList.size(); i++) {
			if (charList.get(i) == null) {
				System.out.println(".");
			} else {
				failed = true;
				allFailed[numFailed] = "Size and Remove Method Failed";
				numFailed++;
			}
		}

		ArrayList ArrayList1 = new ArrayList();
		ArrayList ArrayList2 = new ArrayList();


		ArrayList1.add('P');
		ArrayList1.add('A');
		ArrayList1.add('R');
		ArrayList1.add('R');
		ArrayList1.add('O');
		ArrayList1.add('T');

		ArrayList2.add('P');
		ArrayList2.add('A');
		ArrayList2.add('R');
		ArrayList2.add('R');
		ArrayList2.add('O');
		ArrayList2.add('T');
		ArrayList2.add('S');



		if ((ArrayList1.equals(ArrayList2))) {
			System.out.print(".");
		} else {
			failed = true;
			allFailed[numFailed] = "Equals Method Failed";
			numFailed++;
		}
	}

	/**
	 * Tests the Stack data structure by performing push, size, pop, get, and isEmpty
	 * operations.
	 */
	private static void testStack() {

		Stack recentGames = new Stack();

		recentGames.push("Counter Strike");
		recentGames.push("Spider-Man 2");
		recentGames.push("League of Legends");
		recentGames.push("GTA V");
		recentGames.push("Arkham Asylum");
		recentGames.push("Forza Horizon 4");
		recentGames.push("Valorant");

		if (recentGames.toString().equals("Valorant Forza Horizon 4 Arkham Asylum GTA V League of Legends Spider-Man 2 Counter Strike ")) {
			System.out.print(".");
		} else {
			failed = true;
			allFailed[numFailed] = "Push Method Failed";
			numFailed++;
		}

		if (recentGames.size() == 7) {
			System.out.print(".");
		} else {
			failed = true;
			allFailed[numFailed] = "Size Method Failed";
			numFailed++;
		}

		while (!recentGames.isEmpty()) {
			recentGames.pop();
		}
		for (int i = 0; i <= recentGames.size(); i++) {
			if (recentGames.get(i) == null) {
				System.out.print(".");
			} else {
				failed = true;
				allFailed[numFailed] = "Remove and IsEmpty Method Failed";
				numFailed++;
			}
		}
	}

	/**
	 * Tests the Queue data structure by performing enqueue, size, dequeue, get, and
	 * isEmpty operations.
	 */
	private static void testQueue() {

		Queue lineAtCostco = new Queue();

		lineAtCostco.enqueue("DeMarcus Cousins III");
		lineAtCostco.enqueue("Stephen Curry");
		lineAtCostco.enqueue("Lebron James");
		lineAtCostco.enqueue("Jacques Webster II");
		lineAtCostco.enqueue("Chris Paul");
		lineAtCostco.enqueue("J Cole");
		lineAtCostco.enqueue("Apple Jack");
		lineAtCostco.enqueue("Ryan Reynolds");
		lineAtCostco.enqueue("Larry Bird");

		if (lineAtCostco.toString().equals("DeMarcus Cousins III Stephen Curry Lebron James Jacques Webster II Chris Paul J Cole Apple Jack Ryan Reynolds Larry Bird ")) {
			System.out.print(".");
		} else {
			failed = true;
			allFailed[numFailed] = "Push Method Failed";
			numFailed++;
		}

		if (lineAtCostco.size() == 9) {
			System.out.print(".");
		} else {
			failed = true;
			allFailed[numFailed] = "Size Method Failed";
			numFailed++;
		}
	}
}