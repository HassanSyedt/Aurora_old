package amaranth.aurora.Settings;


import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import amaranth.aurora.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragment {


    public SettingsFragment() {
        // Required empty public constructor
    }


   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);

       addPreferencesFromResource(R.xml.settings);
   }


}
