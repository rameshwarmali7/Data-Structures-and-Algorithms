import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Graph {
	
	private static class Node {
		final int id;
		final LinkedList<Node> adjecencyList= new LinkedList<>();
		private Node(final int id) {
			this.id = id;
		}
	}
	
	final private HashMap<Integer, Node> nodeLookUp = new HashMap<>();
	
	public void addNode(final int id) {
		final Node nodeToAdd = new Node(id);
		nodeLookUp.put(id, nodeToAdd);
	}
	
	public Node getNode(final int id) {
		
		return nodeLookUp.get(id);		
	}
	
	public void addEdge(final int sourceId, final int destinationId) {
		final Node sourceNode = getNode(sourceId);
		final Node destinationNode = getNode(destinationId);
		
		sourceNode.adjecencyList.add(destinationNode);
		destinationNode.adjecencyList.add(sourceNode);
	}
	
	public boolean hasPathDFS(final int sourceId, final int destinationId) {
		final HashSet<Integer> visitedId = new HashSet<>();
		
		return hasPathDFS(getNode(sourceId), getNode(destinationId), visitedId);		
	}
	
	private boolean hasPathDFS(final Node sourceNode, final Node destinationNode, final HashSet<Integer> visitedId) {
		if(visitedId.contains(sourceNode.id)) return false;
		
		visitedId.add(sourceNode.id);
		
		if(sourceNode.id == destinationNode.id) return true;
		
		for(final Node nextNode : sourceNode.adjecencyList) {
			if(hasPathDFS(nextNode, destinationNode, visitedId)) return true;
		}
		
		return false;		
	}
	
	public boolean hasPathBFS(final int sourceId, final int destinationId) {
		final Node sourceNode = getNode(sourceId);
		
		final LinkedList<Node> nodeToVisit = new LinkedList<>();
		final HashSet<Integer> visited = new HashSet<>();
		
		nodeToVisit.add(sourceNode);
		
		while(!nodeToVisit.isEmpty()) {
			final Node currNode = nodeToVisit.remove();

			if(currNode.id == destinationId) return true;
			
			if(visited.contains(currNode.id)) continue;
			
			visited.add(currNode.id);
			
			for(Node nextNode : currNode.adjecencyList) {
				nodeToVisit.add(nextNode);
			}
		}
		
		return false;
	}
	
	public void show() {
		
		for(Integer id : nodeLookUp.keySet()) {
			final Node node = nodeLookUp.get(id);
			System.out.print("id=" + id + " edge=");
			for(Node eachNode : node.adjecencyList) {
				System.out.print(eachNode.id + " ");
			}
			System.out.println();
		}
	}
}

public class DFS_BFS_Main {
	
	public static void main(String[] args) {
		final Graph g = new Graph();
		g.addNode(0); g.addNode(1); g.addNode(2); g.addNode(3); g.addNode(4); g.addNode(5);
//		g.show();
		System.out.println();
		g.addEdge(0, 1); g.addEdge(0, 2); g.addEdge(0, 5); g.addEdge(1, 3); g.addEdge(1, 4); g.addEdge(3, 4); g.addEdge(4, 5);
		g.show();
		
		System.out.println(g.hasPathBFS(0, 4));
		System.out.println(g.hasPathDFS(0, 4));
	}
}
