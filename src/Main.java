import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Graph myGraph = new Graph(8);
		
		myGraph.addEdge(6, 5, 26);
		myGraph.addEdge(6, 3, 13);
		myGraph.addEdge(3, 4, 27);
		myGraph.addEdge(3, 5, 28);
		myGraph.addEdge(3, 1, 35);
		myGraph.addEdge(5, 1, 19);
		myGraph.addEdge(4, 1, 11);
		myGraph.addEdge(1, 2, 38);
		
		//System.out.println("Connection: " + myGraph.isConnected(1, 4));
		
		//myGraph.toString();
				
		//ArrayList used to enter path
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(6);
		arr.add(3);
		arr.add(1);
		arr.add(2);
		
		System.out.println("Path: " + arr.get(0) + " --> " + arr.get(1) + " --> " + arr.get(2) + " --> "
							+ arr.get(3) + "\n");
		
		System.out.println("Total distance: " + myGraph.calculateTravelTime(arr));
	}

}
