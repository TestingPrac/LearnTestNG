package Day7;

import org.testng.annotations.Test;

public class WithOutUsingDependsOnMethods {

    /* Here TrackShipment and CancelShipment is depends upon CreateShipment, but in this program even if
     CreateShipment fails TrackShipment and CancelShipment are executing, but TrackShipment and CancelShipment
     also fails due to its dependency CreateShipment fails. To overcome this situation we are going to use
     dependsOnMethods in TestNG
    */
    static String trackNum = null;
    @Test(priority = 1)
    public void CreateShipment(){
        System.out.println(5/0);
        System.out.println("Create Shipment");
        trackNum = "TN003AP39";
    }
    @Test(priority = 2)
    public void TrackShipment() throws Exception {
        if(trackNum != null)
            System.out.println("Track Shipment");
        else
            throw new Exception("Invalid Tracking Number");
    }
    @Test(priority = 3)
    public void CancelShipment() throws Exception {
        if(trackNum != null)
            System.out.println("Cancel Shipment");
        else
            throw new Exception("Invalid Tracking Number");
    }
}
