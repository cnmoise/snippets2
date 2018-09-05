// The Card class that represents cards
// Do not make any changes to this file!
// Xiwei Wang

import java.io.*;

public class Card implements Serializable
{
    // instance variables
    private int m_suit;
    private int m_rank;
    
    // constructor
    public Card(int suit, int rank)
    {
        m_suit = suit;
        m_rank = rank;
    }
    
    // getters
    public int getSuit()
    {
        return m_suit;
    }
    
    public int getRank()
    {
        return m_rank;
    }   

    // return a string representation of the card
    public String toString()
    {
        String[] suitChars = {"C", "D", "H", "S"};//0 Clubs, 1 Diamonds, 2 Hearts, 3 Spades
        String[] rankChars = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        //no need to use special methods for comparing letters to numbers, since all ranks are repped by #'s
        //A = 1, J = 11, Q = 12, K = 13
        //you sure its not
        //A = 0, J = 11, Q = 11, K = 12?
        
        return suitChars[m_suit] + rankChars[m_rank];//selects vals from arrays
    }
}
