package amaranth.aurora;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class test_fragment extends Fragment {
    public final String ARG_NUMBER="test_number";

    public test_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView=inflater.inflate(R.layout.test_frag,container,false);
        int i=getArguments().getInt(ARG_NUMBER);

        String s= getResources().getStringArray(R.array.test_name)[i];


        return rootView;
    }


}
