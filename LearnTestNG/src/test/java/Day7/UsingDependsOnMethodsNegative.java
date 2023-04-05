package Day7;

import org.testng.annotations.Test;

public class UsingDependsOnMethodsNegative {

    /* Here TrackShipment and CancelShipment is depends upon CreateShipment, but in program if CreateShipment fails
    automatically remaining methods which are depending on CreateShipment will skip executing. In this way we can
    save our time by using dependsOnMethods
    */

    static String trackNum = null;
    @Test()
    public void CreateShipment(){
        System.out.println(5/0);
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
