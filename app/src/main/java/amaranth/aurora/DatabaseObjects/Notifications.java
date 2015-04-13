package amaranth.aurora.DatabaseObjects;

/**
 * Created by marc on 4/12/2015.
 */
public class Notifications {
    public int nid; //notificaiton id
    public int uid; //user's id
    public String nType; //   types of notifications (someone decides to attend
                         // your event vs. recieving an invite to an event
    public String nData; // name of person notification came from and time that could be a timestamp
    public boolean nRead; //if the notification was read
}
