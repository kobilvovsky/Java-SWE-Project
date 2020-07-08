package easybus.Model;

public class CollectionFactory {


    public Base getCollection(String collectionType){
        if(collectionType == null){
            return null;
        }

        if(collectionType.equalsIgnoreCase("CAR")){
            return new CarCollection("CAR");
        } else if(collectionType.equalsIgnoreCase("STATION")){
            return new StationCollection("STATION");
        } else if(collectionType.equalsIgnoreCase("PASSENGER")){
            return new PassengerCollection("PASSENGER");
        } else if(collectionType.equalsIgnoreCase("ROUTE")){
            return new RouteCollection("ROUTE");
        } else if(collectionType.equalsIgnoreCase("WORKER")){
            return new WorkerCollection("WORKER");
        }

        return null;
    }
}
