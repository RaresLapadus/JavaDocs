package exercise.exercise0;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        ArrayList<Integer> c = new  ArrayList();
        for(int i=0;i<10;i++) {
            c.add(i);
        }
        // TODO Exercise #0 a) Hint: Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator it = c.listIterator();
        System.out.print("Lista afisata cu ListIterator: ");
        while(it.hasNext()){;
            System.out.print(it.next());
        }

        System.out.println(" ");
        System.out.print("Lista afisata cu for clasic:  ");
        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        for(int i=0;i<c.size();i++) {
            System.out.print(c.get(i));
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.println(" ");
        System.out.print("Lista afisata cu foreach:  ");
        for(int i : c){
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 a = new Exercise0();
        a.iterateThroughList();

    }
}
