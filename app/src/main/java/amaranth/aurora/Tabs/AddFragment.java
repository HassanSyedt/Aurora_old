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

import java.util.ArrayList;

import amaranth.aurora.Adaptors.Friend;
import amaranth.aurora.Adaptors.FriendsAdapter;
import amaranth.aurora.HomeActivity;
import amaranth.aurora.LoginActivity;
import amaranth.aurora.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends android.support.v4.app.Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public AddFragment() {
    }

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("On create", "entering request friends");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_add, container, false);


        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        Log.i("ListView", "Got listView is it = to null " + (listView == null));
        if (listView != null) {
            Log.i("ListView Success", "Attaching adapter to a not null list view");
            listView.setAdapter(HomeActivity.getFriendsAdapter());
        } else {
            Log.i("ListView", "ListView is = to null so adaptor wasn't attached");
        }
        return rootView;
    }


}
