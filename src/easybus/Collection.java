package easybus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection<T>
{
    List<T> collection = new ArrayList<T>();

    public Collection()
    {
        System.out.println("A new List has been initialized!");
    }

    public void insert(T t) {
        collection.add(t);
    }
    public void remove(T t) {
        collection.remove(t);
    }
    public void print() {
        System.out.println("List t:" + collection);
    }
    public int getSize() { return collection.size(); }
    public void remoteAll() { collection.clear(); }
    public int indexOf(Person p) { return collection.indexOf(p); }

    /*
    ListIterator<T> iterator = collection.listIterator();
    while (iterator.hasNext()) { System.out.println("Value is : "+ iterator.next()); }
     */
}
