package amaranth.aurora;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphObject;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.http.RequestAsyncTask;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;

import org.json.JSONObject;

import java.net.MalformedURLException;


public class LoginActivity extends FragmentActivity {
    private LoginFragment loginFragment;

    //Values for temp username
    private String userName;

    //
    private MobileServiceClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            loginFragment = new LoginFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, loginFragment)
                    .commit();
        } else {
            // Or set the fragment from restored state info
            loginFragment = (LoginFragment) getSupportFragmentManager()
                    .findFragmentById(android.R.id.content);
        }


        try {
            // Create the Mobile Service Client instance, using the provided
            // Mobile service URL and key
            mClient = new MobileServiceClient(
                    "https://amaranth.azure-mobile.net/",
                    "rdOXGrAPEwiqjjIyXUePkwRMbuywVT70",
                    this
            );
        }


        catch (MalformedURLException e) {
            //createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
            e.printStackTrace();
        }
/*        Item item = new Item();
        item.Text = "Awesome item";
        mClient.getTable(Item.class).insert(item, new TableOperationCallback<Item>() {
            public void onCompleted(Item entity, Exception exception, ServiceFilterResponse response) {
                if (exception == null) {
                    // Insert succeeded
                } else {
                    // Insert failed
                }
            }
        });*/
        Session session = Session.getActiveSession();
       // Bundle params= new Bundle();
        com.facebook.RequestAsyncTask request = new Request(
                session,
                "/{user-id}",
                null,
                HttpMethod.GET,
                new Request.Callback() {

                    @Override
                    public void onCompleted(Response response) {
                        /* handle the result */
                        try {
                            JSONObject res = response.getGraphObject().getInnerJSONObject().getJSONArray("data").getJSONObject(0);
                            final String name = (String) res.get("name");
                            Log.i("The name: ", name);
                        } catch (Exception e) {
                          }
                    }
                }).executeAsync();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //Steven: Handle presses on the action bar items
        Intent intent = null;
        switch(item.getItemId()){
            case R.id.action_settings: //Settings menu item press
                return true;
            //case R.id.action_;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

