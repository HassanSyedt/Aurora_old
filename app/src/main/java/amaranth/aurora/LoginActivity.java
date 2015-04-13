package amaranth.aurora;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends FragmentActivity {


    //Values for temp username
    LoginButton loginButton;

    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_login);

        Log.i("LOGIN  CREATE VIEW", "Inflated activity login");

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions( "user_friends");


        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //do something on successful login
                //loginresult holds the AccessToken
               //Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                AccessToken.getCurrentAccessToken();
                //Log.i("SUCCESSFUL LOGIN", "logging in");
                Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCancel() {
                Log.i("CANCELLED LOGIN", "CANCELLED");
            }

            @Override
            public void onError(FacebookException error) {
                error.printStackTrace();
            }
        });
        Log.i("SUCCESSFUL LOGIN", "returning the view");



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
        switch (item.getItemId()) {
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        callbackManager.onActivityResult(requestCode,resultCode,intent);
    }

}

