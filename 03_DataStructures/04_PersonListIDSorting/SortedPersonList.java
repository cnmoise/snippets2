// Claudiu Moise

public class SortedPersonList 
{
    //instance vars
    private PersonNode m_first;
    private int m_numElements; 

    //NC //cst
    public SortedPersonList()
    {
        m_first = null;
        m_numElements = 0;
    }

    //NC //check whether the list is empty
    boolean isEmpty()
    {
        if (m_first == null)
            return true;
        else
            return false;
    }

    //NC //return the size of the list (# of Person nodes)
    public int size()
    {
        return m_numElements;
    }

    //Target //check whether a PersonNode associated with the given ID is in the list
    //helper method //do I have to use prev?
    public boolean contains(int ID)
    {
        PersonNode current = m_first;//temp node to go through list
        
        while (current != null)
        {
            if (current.getID() == ID)//found in node class
                return true;
            else
                current = current.getLink();
                //advances us in the list
        }
        
        return false;
    }

    //Target //search for and return the PersonNode associated with the given ID
    //return the reference to the node, otherwise, return null
    public PersonNode get(int ID)
    {
        PersonNode current = m_first;//temp node to go through list
        PersonNode previous = null;
        
        //if(contains(ID))
        while (current != null)
        {
            if (current.getID() == ID)//found ID
            {
                current = current.getLink();
                return previous.getLink();
            }
            else
                {
                previous = current;
                current = current.getLink();
                }
                //advances us in the list
                
        }
        
        return null; //replace
    }

    //Target //add a new PersonNode to the list with the given ID and name
    //If add is successful, return true. If the node already exists in the list, return false.
    public boolean add(int ID, String name)
    {
        PersonNode newNode = new PersonNode(ID, name);

        //In case this is the first element we are adding to the list
       
        
        PersonNode current = m_first;   // set up a temp reference to iterate over the list
        PersonNode previous = null;     // set up a reference that allows the access to the previous node
        boolean executed = false;
        
        while (current != null)//we will reach null when we are at the end of the list
        {
            // compare the new value with the value of each node
            if (current.getID() < ID)//is what sorts our ID values//
            {
                previous = current;
                current = current.getLink();
            }
            else
                break;//how would I do it without break?
        }
        
        //if we are inserting into the first node of the list
        if (previous == null)
        {
            newNode.setLink(m_first);
            m_first= newNode;
            executed = true;
        }
        else
        {
            newNode.setLink(current);
            previous.setLink(newNode);
            executed = true;
        }
        
        m_numElements++;
        
        //If the node already exists in the list, return false.
        //how do i know?
        
        return executed; //replace
    }

    //Target //remove a PersonNode associated with the given ID from the list
    //If remove is successful, return true. If the node already exists in the list, return false.
    public boolean remove(int ID)
    {
        PersonNode current = m_first;
        PersonNode previous = null;
        boolean found = false;
        
        while (current != null)
        {
            // compare the given value with the value of each node
            if (current.getID() < ID)
            {
                previous = current;
                current = current.getLink();
            }
            else if (current.getID() == ID)
            {
                found = true;
                current = current.getLink();
                m_numElements--;
                
                //if we are removing 
                if (previous == null)
                    m_first = current;
                else
                    previous.setLink(current);
            }
            else
                return found;
        }
        
        return found;
        
        //return false; //replace
    }
    
    //NC //return a string representation of the list
    public String toString()
    {
        String listContent = "";
        PersonNode current = m_first;
        
        while (current != null)
        {
            listContent += "[" + current.getID() + " | " + current.getName() + "] ";
            current = current.getLink();
        }

        return listContent;
    }    
}