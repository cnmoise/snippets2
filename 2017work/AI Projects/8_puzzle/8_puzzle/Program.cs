using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/* Author: Claudiu Moise
 * CS335 - AI - Oguzcan Adabuk
 * 
 * Description:
 * This program uses Breadth First Search to solve an 8 puzzle. An 8 puzzle is solved when it is in the following order:
 * 
 * 0 1 2
 * 3 4 5
 * 6 7 8
 * 
 * 0 represents the empty space which numbers can be shifted into, or in our caee, we shift the blank space into the numbered spot.
 * 
 */


namespace _8_puzzle
{
    class Program
    {
        static void Main(string[] args)
        {
            // initial puzzle state
            // puzzle is represented as a 1d array (more eff than a 2d array)
            int[] puzzle = {1, 2, 4,
                            3, 0, 5,
                            7, 6, 8};
            
            /*int[] goal =   {0, 1, 2,
                            3, 4, 5,
                            6, 7, 8};
            int goalnum;
            int goalloc;*/

            //States are represented using nodes
            Node root = new Node(puzzle); //1st elem in list
            UninformedSearch ui = new UninformedSearch();

            List<Node> solution = ui.BreadthFirstSearch(root);

            //prints the solution we found
            if(solution.Count > 0)
            {
                for (int i = 0; i < solution.Count; i++)
                    solution[i].PrintPuzzle();
            }
            //so we don't auto quit
            Console.ReadLine();

            //h(n)
            //compare current node w goal state
                //goal arr

            /*
            //outer loop compares # to see if its in the right place
            //check vertically and horizontally?
            for (int i = 0; i < puzzle.Length; i++)
            {
                //in order to find dist from goalint we must first find where the goalint is supposed to be
                //search goal array
                for (int j = puzzle[i]; i < 9; i++)
                {

                    if (goal[i] == goalint)
                        goalloc = i;
                    else
                        {
                        //calc dist?
                        };
                }

                if (puzzle[i] != goal[i])
                {
                    goalloc = i;
                    //calculate distance
                    while(puzzle[j] != goal[i])
                    {

                    }
                }*/
            }

        }
    }
}
