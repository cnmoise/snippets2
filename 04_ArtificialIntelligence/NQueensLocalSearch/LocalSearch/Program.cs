using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocalSearch
{
    class Program
    {
        static Random randGen = new Random();
        static void Main(string[] args)
        {

            //need to initialize a state list for children etc.
            
            int[,] initBoard = new int[8, 8];
            PlaceQueens(initBoard);
            Node current = new Node(initBoard);
            current.PrintChessboard();
            double initialScore = current.Heuristic();
            Console.WriteLine("Init Score is:" + initialScore);

            Console.Read();
            
            while(current.Heuristic() <= 28)
            {
                for (int i = 0; i < 8; i++)
                {
                    for (int j = 0; j < 8; j++)
                    {
                        Node next = new Node(current.chessboard);
                        next.MoveQueen(j,i);
                        if(next.Heuristic() > current.Heuristic())
                        {
                            current.Accept(next.chessboard);
                            current.PrintChessboard();
                            double currentScore = current.Heuristic();
                            Console.WriteLine("Initial Score: " + initialScore + "|| CurrentScore" + currentScore);
                        }
                    }
                    
                }
            }
            Console.WriteLine("Solution Found");
            //current
        }

        public static void PlaceQueens(int[,] b)
        {
            for (int i = 0; i < 8; i++)
            {
                int randomRowNumber = randGen.Next(0, 8);//3 method overloads
                b[randomRowNumber, i] = 1;

            }
        }

        
    }
}
