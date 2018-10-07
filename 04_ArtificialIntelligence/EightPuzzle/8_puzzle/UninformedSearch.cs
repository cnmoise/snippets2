using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _8_puzzle
{
    class UninformedSearch
    {
        //default constructor, but we have no use for it so we leave it blank
        public UninformedSearch()
        {

        }

        //polymorphing constructor//not really
        public List<Node> BreadthFirstSearch(Node root)
        {
            //just like declaring variables, we have to make the Node structures
            List<Node> PathToSolution = new List<Node>();
            //frontier, all nodes we can move forwards from
            List<Node> openList = new List<Node>();
            //elements which we have already explored
            List<Node> closedList = new List<Node>();

            openList.Add(root);
            bool goalFound = false;

            //Executes as long as:
                 //We still have elements we can expand (on the frontier)
                 //We have not reached the goal state

            while(openList.Count > 0 && !goalFound)
            {
                //start at the begining of the expolist
                Node currentNode = openList[0];
                //Mark current node as having been fully expanded
                closedList.Add(currentNode);
                //Take it off the expolist
                openList.RemoveAt(0);

                //What actually does the expanding
                //create a Node for each possible move
                //the methods we call within this method add themselves to the open list
                currentNode.ExpandMove();
                //debug
                currentNode.PrintPuzzle();


                for (int i = 0; i < currentNode.children.Count; i++)
                {
                    Node currentChild = currentNode.children[i];
                    if (currentChild.goalTest())
                    {
                        Console.WriteLine("Goal found.");
                        goalFound = true;
                        //trace path to root node
                        PathTrace(PathToSolution, currentChild);
                    }

                    //Duh, we'll only add a nodes children to the expansion que if
                        //hasn't been expanded already (for instance 1/3 children have been expanded, we don't want to rexpand child #1)
                        //the child hasn't already been marked as a deadend
                    if (!Contains(openList,currentChild) && !Contains(closedList, currentChild))
                    {
                        openList.Add(currentChild);
                    }
                }
            }
            return PathToSolution;
        }

        //Traces the move list from our initial puzzle state to the solved state
        public void PathTrace(List<Node> path, Node n)
        {
            Console.WriteLine("Tracing Path...");
            Node current = n;
            path.Add(current);

            while(current.parent != null)
            {
                current = current.parent;
                path.Add(current);
            }
        }

        //Look to see if the element we are currently looking at is the same as one we've seen before
        public static bool Contains(List<Node> list, Node c)
        {
            bool contains = false;

            for(int i = 0; i <list.Count; i++)
            {
                if (list[i].IsSamePuzzle(c.puzzle))
                    contains = true;
            }

            return contains;
        }

    }
}
