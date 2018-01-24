using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocalSearch
{
    public class Node
    {

        public int[,] chessboard = new int[8, 8];
        public int[] chromosome = new int[8];
        public List<Node> children = new List<Node>();

        public Node()
        {

        }

        public Node(int[] ch)
        {

        }

        public Node(int[,] b)
        {
            //each node has its own chessboard
            for(int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    chessboard[i, j] = b[i, j];
                }
            }
        }

        public void Accept(int[,] b)
        {
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    chessboard[i, j] = b[i, j];
                }
            }

        }

        //initiates a blank chess board
        public void PrintChessboard()
        {
            for (int i = 0; i < 8; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    Console.Write(chessboard[i, j] + " ");
                }
                Console.WriteLine();
            }
        }

        //made by prof
        public double Heuristic()
        {
            double horizontalAttacks = 0;

            for (int i = 0; i < 8; i++)
            {
                //if there are multiple queens on the same row, means they are attacking eachother
                //ideally row count should only be 1
                int rowQueenCount = 0;
                for (int j = 0; j < 8; j++)
                {
                    //is there a queen here?
                    if (chessboard[i, j] == 1)
                        rowQueenCount++;
                }
                horizontalAttacks += rowQueenCount * (rowQueenCount - 1) / 2;
            }

            double diagonalAttacks = 0;
            double diagonalQueens = 0;

            int rows = 8;
            int cols = 8;

            //checks for diagonal attacks
            for (int i = 0; i < rows; i++)
            {
                for (int r = i, c = 0; r >= 0 && c < cols; r--, c++)
                {
                    if (chessboard[r, c] == 1)
                        diagonalQueens++;
                }
                if (diagonalQueens > 0)
                    diagonalAttacks += (diagonalQueens - 1) * diagonalQueens / 2;
                diagonalQueens = 0;
            }

            //in all 4 directions?
            for (int i = 1; i < cols; i++)
            {
                for (int r = rows - 1, c = i; r >= 0 && c < cols; r--, c++)
                {
                    if (chessboard[r, c] == 1)
                        diagonalQueens++;
                }
                if (diagonalQueens > 0)
                    diagonalAttacks += (diagonalQueens - 1) * diagonalQueens / 2;
                diagonalQueens = 0;
            }

            for (int i = rows - 1; i >= 0; i--)
            {
                for (int r = i, c = 0; r < rows && c < cols; r++, c++)
                {
                    if (chessboard[r, c] == 1)
                        diagonalQueens++;
                }
                if (diagonalQueens > 0)
                    diagonalAttacks += (diagonalQueens - 1) * diagonalQueens / 2;
                diagonalQueens = 0;
            }

            for (int i = cols - 1; i >= 0; i--)
            {
                for (int r = 0, c = i; r < cols && c < cols; r++, c++)
                {
                    if (chessboard[r, c] == 1)
                        diagonalQueens++;
                }
                if (diagonalQueens > 0)
                    diagonalAttacks += (diagonalQueens - 1) * diagonalQueens / 2;
                diagonalQueens = 0;
            }
            return (28 - (horizontalAttacks + diagonalAttacks));
            //what happened to vertical attacks?
        }

        public void MoveQueen(int row, int col)
        {
            for (int i = 0; i < 8; i++)
            {
                chessboard[i, col] = 0;

            }
            chessboard[row, col] = 1;
        }

        /*public int[,] PlaceQueens()
        {
            //generates random numbers
            Random rand = new Random();
            Node child = new Node();

            //columns
            for (int j = 0; j < 8; j++)
            {
                /*
                //.Next specifies the number rand shall create
                //int queenIndex = rand.Next(8);
                int qii = rand.Next(8);
                //int qij = rand.Next(8);

                //place a queen in spot i,j
                if (Heuristic() != 0)//& j != 8
                    chessboard[qii, j] = 1;
                */


        //no other queens are on this row
        /*
        for (int i = 0; i < 8; i++)
        {
            if (chessboard[i, j] == 1)
            {
                chessboard[qii, j] = 0;
                break;
            }
        }*/



        //store state in node??? list is just 2 Nodes
        //children.Add(child); 



    //}

        //}
    }
}

