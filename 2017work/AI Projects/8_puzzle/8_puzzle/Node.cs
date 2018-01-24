using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _8_puzzle
{
    class Node
    {
        //here we are creating a node structure to use for our problem
        //how do they work again?

        public int[] puzzle = new int[9];
        public List<Node> children = new List<Node>();
        //useful in tracing back stuff
        public Node parent;
        public int x = 0;
        //the num of columns in our puzzle
        public int col = 3;


        //logic: the blank square moves into the square
        //constuctor
        //initializes our first node, creates the puzzle
        public Node(int[] p)
        {
            SetPuzzle(p);
        }
        /* Visual representation
         * 
         * 0 1 2
         * 3 4 5
         * 6 7 8
         * 
         * 
         * 
         */
         public void SetPuzzle(int[] p)
        {
            for (int i = 0; i < puzzle.Length; i++)
            {
                this.puzzle[i] = p[i];
            }
        }

        public void CopyPuzzle(int[] a, int[] b)
        {
            for (int i = 0; i < b.Length; i++)
            {
                a[i] = b[i];
            }
        }

        public void MoveRight(int[] p, int i)
        {
            //checks if we're on the rightmost edge
            //function will execute
            int[] pc = new int[9];

            //if (col < col - 1)
            if (i % col < col - 1)
            {
                //Creates
                CopyPuzzle(pc, p);

                int temp = pc[i + 1];
                pc[i + 1] = pc[i];
                pc[i] = temp;

                //networks of the nodes we can expand
                Node child = new Node(pc);

                children.Add(child);
                child.parent = this;
            }
        }

        public void MoveLeft(int[] p, int i)
        {
            int[] pc = new int[9];

            if (i % col > 0)
            {
                //need to copy because atm were just presupposing actions
                CopyPuzzle(pc, p);

                int temp = pc[i - 1];
                pc[i - 1] = pc[i];
                pc[i] = temp;

                //Making a new node & creating the connection
                Node child = new Node(pc);

                children.Add(child);
                child.parent = this;

            }
        
        }

        //The square that is calling this method is trying to move up
        public void MoveUp(int[] p, int i)
        {
            //instead of comparing index to board locations, we compare it to its bounds
            //probably helps alot if we expand the puzzle
            if (i - col >= 0)
            {
                int[] pc = new int[9];
                CopyPuzzle(pc, p);

                int temp = pc[i - 3];
                pc[i - 3] = pc[i];
                pc[i] = temp;

                Node child = new Node(pc);

                children.Add(child);
                child.parent = this;

            }
        }

        public void MoveDown(int[] p, int i)
        {
            if (i + col < puzzle.Length)
            {
                int[] pc = new int[9];
                CopyPuzzle(pc, p);

                int temp = pc[i + 3];
                pc[i + 3] = pc[i];
                pc[i] = temp;

                Node child = new Node(pc);

                children.Add(child);
                //the node currently calling this method is the parent of the node we just made (duh)
                child.parent = this;

            }
        }

        public void ExpandMove()
        {
            //in order to move our blank square we must first locate it
            //we do this for each node that we Expand
            for (int i = 0; i < 9; i++)
            {

                if (puzzle[i] == 0)
                    x = i;
            }
            MoveLeft(puzzle, x);
            MoveRight(puzzle, x);
            MoveUp(puzzle, x);
            MoveDown(puzzle, x);
        }

        public void PrintPuzzle()
        {
            Console.WriteLine();
            int m = 0;
            for (int i = 0; i < col; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    System.Console.Write(puzzle[m] + " ");
                    m++;
                }
               
                //Mem
                //Write vs WriteLine
                Console.WriteLine();
            }
        }

        public bool IsSamePuzzle(int[] p)
        {
            bool same = true;
            for( int i = 0; i < puzzle.Length; i++)
            {
                if(puzzle[i] != p[i])
                {
                    same = false;
                }
            }
            return same;
        }

        //goal test check that all num in array are in order, for loop, compares neighbors, sort in asc order
        //is passing the array needed since its connected to the node already?
        public Boolean goalTest()
        {
            bool isGoal = true;
            int m = puzzle[0];

            for (int i = 1; i < puzzle.Length; i++)
            {
                //initial was a self reference in array
                if (m > puzzle[i])
                {
                    isGoal = false;
                }
                //allows us to check if next element is...
                m = puzzle[i];

            }
            return isGoal;
        }
    }

    

}
