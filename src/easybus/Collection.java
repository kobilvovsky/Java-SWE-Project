package easybus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection<T>
{
    private List<T> collection = new ArrayList<T>();

    public Collection() { System.out.println("A new List has been initialized!"); }
    public void insert(T t) { collection.add(t); }
    public void remove(T t) { collection.remove(t); }
    public void print() { System.out.println("List t:" + collection); }
    public int getSize() { return collection.size(); }
    public void remoteAll() { collection.clear(); }
    public int indexOf(T t) { return collection.indexOf(t); }
    public T getElement(int i) { return collection.get(i); }

    public Station getStation(int byIndex) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Station st = (Station) it.next();

            if(st.getStationId() == byIndex)
                return st;
        }

        return new Station(-1, -1);
    }
}
