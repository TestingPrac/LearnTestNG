package Day7;

import org.testng.annotations.Test;

public class UsingDependsOnMethodsPositive {
    static String trackNum = null;
    @Test()
    public void CreateShipment(){
        //System.out.println(5/0);
        System.out.println("Create Shipment");
        trackNum = "TN003AP39";
    }
    @Test(dependsOnMethods = {"CreateShipment"})
    public void TrackShipment() throws Exception {
        if(trackNum != null)
            System.out.println("Track Shipment");
        else
            throw new Exception("Invalid Tracking Number");
    }
    @Test(dependsOnMethods = {"CreateShipment","TrackShipment"})
    public void CancelShipment() throws Exception {
        if(trackNum != null)
            System.out.println("Cancel Shipment");
        else
            throw new Exception("Invalid Tracking Number");
    }
}
