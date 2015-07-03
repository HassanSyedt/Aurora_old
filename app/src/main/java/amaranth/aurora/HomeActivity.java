package amaranth.aurora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ListView;

import com.astuetz.PagerSlidingTabStrip;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;

import amaranth.aurora.Adaptors.Friend;
import amaranth.aurora.Adaptors.FriendsAdapter;
import amaranth.aurora.Tabs.TabFragmentPagerAdapter;


public class HomeActivity extends FragmentActivity {
    FriendsAdapter friendsAdapter;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */


    /**
     * The {@link ViewPager} that will host the section contents.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);



        //friendDisplay();
    }

    private void friendDisplay(){
        Log.i("FriendDisplay","In FriendDisplay");
        GraphRequest request= GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONArrayCallback() {
            @Override
            public void onCompleted(JSONArray objects, GraphResponse response) {
                //creating a new friends adapter
                Log.i("FriendsAdapter","Creating a new friends adapter");
                friendsAdapter= new FriendsAdapter(HomeActivity.this, Friend.fromJson(objects));
            }
        });

        request.executeAsync();
        Log.i("Executed request","Request has been executed");
        ListView listView = (ListView) findViewById(android.R.id.list);
        Log.i("ListView","Got listView is it = to null "+(listView==null));
        if(listView!=null) {
            Log.i("ListView Success", "Attaching adapter to a not null list view");
            listView.setAdapter(friendsAdapter);
        }
        else{
            Log.i("ListView","ListView is = to null so adaptor wasn't attached");
        }
    }

}