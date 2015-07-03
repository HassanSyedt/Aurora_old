package amaranth.aurora.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

import amaranth.aurora.R;

/**
 * Created by user on 6/29/2015.
 */
public class FriendsAdapter extends ArrayAdapter<Friend> {
    public FriendsAdapter(Context context, ArrayList<Friend> friends) {
        super(context, R.layout.activity_add, friends);
    }
    //super method that is needed because we are extending ArrayAdapter


    private static class ViewHolder{
        TextView name;
    }

    @Override
    public View getView(int position,View cView, ViewGroup parent){

    /*
    This uses a cached view pattern to help optimize

     */

        Friend friend = getItem(position);

        ViewHolder vh;
        //if something i no longer being seen we can recycle it for use
        if(cView==null){
            vh= new ViewHolder();
            LayoutInflater li= LayoutInflater.from(getContext());
            cView= li.inflate(R.layout.activity_add,parent,false);
            vh.name=(TextView)cView.findViewById(R.id.tvNames);
            cView.setTag(vh);
        }
        else{
            vh=(ViewHolder) cView.getTag();
        }
        vh.name.setText(friend.getName());
        return cView;
    }


}
