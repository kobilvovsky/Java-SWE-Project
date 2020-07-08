package easybus.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Collection<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<T> collection = new ArrayList<T>();

    public Collection() { System.out.println("A new List has been initialized!"); }
    public void insert(T t) { collection.add(t); }
    public void remove(T t) { collection.remove(t); System.out.println("Object " + t + " removed!"); }
    public void print() { System.out.println("List t:" + collection); }
    public int getSize() { return collection.size(); }
    public void remoteAll() { collection.clear(); }
    public int indexOf(T t) { return collection.indexOf(t); }
    public T getElement(int i) { return collection.get(i); }

    public List<T> getCollection() { return collection; }
}
