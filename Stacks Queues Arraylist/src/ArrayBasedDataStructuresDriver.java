

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		arrayListTests();
		stackTests();
		queueTests();
	}

	private static void arrayListTests() {

		ArrayList randChar = new ArrayList();

		System.out.println("ArrayList Class Testing:");
		System.out.println();

		System.out.println("Insert Testing:");
		randChar.insert('a', 0);
		randChar.insert('B',0);
		randChar.insert('t',2);
		randChar.insert('3',1);
		randChar.insert('o', 0);
		randChar.insert('a',3);
		randChar.insert('s',2);
		System.out.println( randChar.toString());
		System.out.println();

		System.out.println("Remove and IsEmpty Testing:");

		while(!randChar.isEmpty()) {
			System.out.print("Object " + randChar.remove(0) + " removed : ");
			System.out.println(randChar.toString());
		}
		System.out.println();

		System.out.println("Add Testing:");
		randChar.add('D');
		randChar.add('O');
		randChar.add('G');
		randChar.add('S');
		System.out.println(randChar.toString());
		System.out.println();

		System.out.println("IndexOf Testing:");
		System.out.println("Object 'G' is in index " +randChar.indexOf('G'));
		System.out.println("Object 'K' is in index " +randChar.indexOf('K'));
		System.out.println(randChar.toString());
		System.out.println();

		System.out.println("Get (Object at Index) Testing:");
		System.out.println("Object at Index 2 is " + randChar.get(2));
		System.out.println("Object at Index 7 is " + randChar.get(7));
		System.out.println();

		System.out.println("Size and Remove Testing:");
		for(int i = 0; i <= randChar.size()+1; i++){
			System.out.print("Object " + randChar.remove(0) + " removed : ");
			System.out.println(randChar.toString());
		}
		System.out.println();
	}


	private static void stackTests() {

		Stack gamesOnTable = new Stack();

		System.out.println("Stack Class Testing:");
		System.out.println();

		System.out.println("Push Testing:");
		gamesOnTable.push("Mario Kart");
		gamesOnTable.push("FIFA");
		gamesOnTable.push("F1 Racing");
		gamesOnTable.push("GTA");
		gamesOnTable.push("NBA 2K");
		gamesOnTable.push("Forza");
		gamesOnTable.push("Halo");
		System.out.println(gamesOnTable.toString());
		System.out.println();

		System.out.println("Size Testing:");
		System.out.println("Number of games on table: " + gamesOnTable.size());
		System.out.println();

		System.out.println("Pop and IsEmpty Testing:");
		while(!gamesOnTable.isEmpty()) {
			System.out.print("Object " + gamesOnTable.pop() + " removed : ");
			System.out.println(gamesOnTable.toString());
		}
		System.out.println();
	}

	private static void queueTests() {

		Queue lineAtAverageWalgreens = new Queue();

		System.out.println("Queue Class Testing:");
		System.out.println();

		System.out.println("Enqueue Testing:");
		lineAtAverageWalgreens.enqueue("Brad");
		lineAtAverageWalgreens.enqueue("Chadison the VII");
		lineAtAverageWalgreens.enqueue("David");
		lineAtAverageWalgreens.enqueue("Dan");
		lineAtAverageWalgreens.enqueue("Paul");
		lineAtAverageWalgreens.enqueue("Cole");
		lineAtAverageWalgreens.enqueue("Jack");
		lineAtAverageWalgreens.enqueue("Ryan");
		lineAtAverageWalgreens.enqueue("Kareem Abdul-Jabbar");
		System.out.println(lineAtAverageWalgreens.toString());
		System.out.println();


		System.out.println("Size Testing:");
		System.out.println("Number of people in an average line at your local Walgreens Pharmacy: " + lineAtAverageWalgreens.size());
		System.out.println();

		System.out.println("Dequeue and IsEmpty Testing:");
		while(!lineAtAverageWalgreens.isEmpty()) {
			System.out.print("Object " + lineAtAverageWalgreens.dequeue() + " removed : ");
			System.out.println(lineAtAverageWalgreens.toString());
		}


	}


}
