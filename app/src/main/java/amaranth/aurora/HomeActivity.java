package amaranth.aurora;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.astuetz.PagerSlidingTabStrip;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;

import java.util.ArrayList;

import amaranth.aurora.Adaptors.Friend;
import amaranth.aurora.Adaptors.FriendsAdapter;
import amaranth.aurora.Tabs.TabFragmentPagerAdapter;


public class HomeActivity extends FragmentActivity {
    private static FriendsAdapter friendsAdapter;
    private ArrayList<Friend> friends;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    public static FriendsAdapter getFriendsAdapter() {
        return friendsAdapter;
    }

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


        friendRequest();
    }


    private void friendRequest() {
        GraphRequest request = GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONArrayCallback() {
            @Override
            public void onCompleted(JSONArray objects, GraphResponse response) {
                //creating a new friends adapter
                Log.i("FriendsAdapter", "requesting friends");
                friends = new ArrayList<>();
                friends.addAll(Friend.fromJson(objects));
                Log.i("Size of friends", "" + friends.size());
                friendsAdapter = new FriendsAdapter(getBaseContext(), friends);
            }
        });

        request.executeAsync();

    }
}
