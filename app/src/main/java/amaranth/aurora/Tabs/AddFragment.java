package amaranth.aurora.Tabs;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;

import amaranth.aurora.Adaptors.Friend;
import amaranth.aurora.Adaptors.FriendsAdapter;
import amaranth.aurora.HomeActivity;
import amaranth.aurora.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends android.support.v4.app.Fragment {
    FriendsAdapter friendsAdapter;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static AddFragment newInstance(int sectionNumber) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public AddFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_add, container, false);

        friendDisplay(rootView);

        return rootView;
    }



       //this method helps in getting and displaying the friendslist for the person. Right now this is extremely slow. But it works.
       //tried having this load on home activity but would have problems finding the view because the activity_add would not be inflated yet
        //possible solution might be to inflate the view? then try adding in HomeActivity
        //if you want to see the method in action use a test account from facebook it's in roles/test users on the website
    private void friendDisplay(View root){
        Log.i("FriendDisplay", "In FriendDisplay");
        GraphRequest request= GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONArrayCallback() {
            @Override
            public void onCompleted(JSONArray objects, GraphResponse response) {
                //creating a new friends adapter
                Log.i("FriendsAdapter","Creating a new friends adapter");
                friendsAdapter= new FriendsAdapter(getActivity(), Friend.fromJson(objects));
            }
        });

        request.executeAsync();
        Log.i("Executed request","Request has been executed");
        ListView listView = (ListView) root.findViewById(R.id.list_view);
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
