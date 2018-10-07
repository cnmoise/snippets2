import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

/*Sources

https://java2blog.com/depth-first-search-in-java/
https://java2blog.com/breadth-first-search-in-java/

*/

public class MyGraphTraversal
{
   private Queue<MyGraphNode> queue;
   static ArrayList<MyGraphNode> queueNodes=new ArrayList<MyGraphNode>();
 
	static class MyGraphNode
	{
		int data;
		boolean visited;
      //Each graph node stores a list of its neighbors
		List<MyGraphNode> neighbours;
 
		MyGraphNode(int data)
		{
			this.data=data;
			this.neighbours=new ArrayList<>();
 
		}
      //Like addEdge
		public void addneighbours(MyGraphNode neighbourMyGraphNode)
		{
			this.neighbours.add(neighbourMyGraphNode);
		}
		public List<MyGraphNode> getNeighbours() {
			return neighbours;
		}
		public void setNeighbours(List<MyGraphNode> neighbours) {
			this.neighbours = neighbours;
		}
	}
 
	// Recursive DFS
	public  void dfs(MyGraphNode MyGraphNode)
	{
		System.out.print(MyGraphNode.data + " ");
		List<MyGraphNode> neighbours=MyGraphNode.getNeighbours();
      MyGraphNode.visited=true;
		for (int i = 0; i < neighbours.size(); i++) {
			MyGraphNode n=neighbours.get(i);
			if(n!=null && !n.visited)
			{
				dfs(n);
			}
		}
	}
	// Iterative DFS using stack
	public  void dfsUsingStack(MyGraphNode MyGraphNode)
	{
		Stack<MyGraphNode> stack=new  Stack<MyGraphNode>();
		stack.add(MyGraphNode);
		MyGraphNode.visited=true;
		while (!stack.isEmpty())
		{
			MyGraphNode element=stack.pop();
			System.out.print(element.data + " ");
 
			List<MyGraphNode> neighbours=element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				MyGraphNode n=neighbours.get(i);
				if(n!=null && !n.visited)
				{
					stack.add(n);
					n.visited=true;
 
				}
			}
		}
      
      
	}

	//BFS Using a Que
   public void bfs(MyGraphNode node)
	{
   	queue = new LinkedList<MyGraphNode>();

		queue.add(node);
		node.visited=true;
		while (!queue.isEmpty())
		{
 
			MyGraphNode element=queue.remove();
			System.out.print(element.data + " ");
			List<MyGraphNode> neighbours=element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				MyGraphNode n=neighbours.get(i);
				if(n!=null && !n.visited)
				{
					queue.add(n);
					n.visited=true;
 
				}
			}
 
		}
	}
	
 
	public static void main(String arg[])
	{
 
		MyGraphNode node40 =new MyGraphNode(40);
		MyGraphNode node10 =new MyGraphNode(10);
		MyGraphNode node20 =new MyGraphNode(20);
		MyGraphNode node30 =new MyGraphNode(30);
		MyGraphNode node60 =new MyGraphNode(60);
		MyGraphNode node50 =new MyGraphNode(50);
		MyGraphNode node70 =new MyGraphNode(70);
      
      //Creates an edge between Node40 and Node10
		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);      
      
 
		MyGraphTraversal dfsExample = new MyGraphTraversal();
      MyGraphTraversal BFSExample = new MyGraphTraversal();
      
      System.out.println("The BFS traversal of the graph using stack ");
      BFSExample.bfs(node40);
 
		//  System.out.println("\nThe DFS traversal of the graph using stack ");
//       //Node 40 is the node we searching for
// 		dfsExample.dfsUsingStack(node40);
 
		System.out.println();
 
		// Resetting the visited flag for MyGraphNodes
		// MyGraphNode40.visited=false;
// 		MyGraphNode10.visited=false;
// 		MyGraphNode20.visited=false;
// 		MyGraphNode30.visited=false;
// 		MyGraphNode60.visited=false;
// 		MyGraphNode50.visited=false;
// 		MyGraphNode70.visited=false;
//  
//  
// 		System.out.println("The DFS traversal of the graph using recursion ");
// 		dfsExample.dfs(MyGraphNode40);
	}
}