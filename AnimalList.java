//Shashank Raghuraj
//Animal list main class with adding, removing, displaying, and getting total changes.
public class AnimalList
{
  private ListNode head;
  private int numAddRemove;
  //Adds animals alphabetically
  public AnimalList()
  {
    head = null;
    numAddRemove = 0;
  }
  public void addAnimal(Comparable addValue)
  {
    numAddRemove++;
    if(head != null)
    {
      ListNode prev = head;
      ListNode current = head.getNext();
      //checks the first one
      if(addValue.compareTo(head.getValue()) < 0)
      {
        head = new ListNode(addValue, head);
        return;//to exit out of statement
      }
      //Checks everything after the first value
      while(current != null)
      {
        //checks the middle
        if(addValue.compareTo(current.getValue()) < 0)
        {
          prev.setNext(new ListNode(addValue, current));
          return;//Return statement = god. it ends the method after this
        }
        //moves it to the next 
        prev = prev.getNext();
        current = current.getNext();
      }
      //Adds to end and knows that the rest aint it
      prev.setNext(new ListNode(addValue, null));
    }
    else
    {
      head = new ListNode(addValue, null);
    }
  }
  //removes the first instance of the animal search value
  public boolean removeAnimal(Comparable searchValue)
  {   
    if(head != null)
    {
      //Sets variables
      ListNode current = head.getNext();
      ListNode previous = head;
      //if its the first value in the sequence, then it will delete with fr method
      if(searchValue.equals(previous.getValue()))
      {
        head = head.getNext();
        numAddRemove++;
        return true;
      }
      //else it uses the cool method
      else
      {
        while(current != null)
        {
          //sets equal in the middle
          if(searchValue.equals(current.getValue()))
          {
            //same logic for end and beginning
            previous.setNext(current.getNext());
            numAddRemove++;
            return true;
          }
          //moves current
          previous = previous.getNext();
          current = current.getNext();
        }
      }
    }
    return false;
  }
  //displays the list of animal names
  public void displayList()
  {
    ListNode current = head;//set to head
    while(current != null)
    {
      System.out.println(current.getValue());//prints
      current = current.getNext();//gets the next, sets the next to current
    }
  }
  //returns the number of successful aditions/removals
  public int getnumAddRemove()
  {
    return numAddRemove;
  }
}
