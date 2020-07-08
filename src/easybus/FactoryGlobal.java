package easybus;

public class FactoryGlobal
{
    //use getShape method to get object of type shape 
    public Collection<? extends Object> getArray(String array){
        if(array == null)
        {
            return null;
        }
        else if(array.equalsIgnoreCase("vehicle"))
        {
            return new Collection <Car> ();
        }
        else if(array.equalsIgnoreCase("STATION"))
        {
            return new Collection <Station> ();

        } else if(array.equalsIgnoreCase("ROUTE"))
        {
            return new Collection<Lineroute>();
        }
        else if(array.equalsIgnoreCase("PASSENGER"))
        {
            return new Collection<Passenger>();
        }
        else if(array.equalsIgnoreCase("WORKER"))
        {
            return new Collection<Busdriver>();
        }

        return null;
    }
}
