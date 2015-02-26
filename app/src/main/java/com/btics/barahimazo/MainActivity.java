package com.btics.barahimazo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "gPJS6gHqIvZOHmdSNn8qU2jzarQRnP7zWKGNFtxJ", "hM70tOcV9wbEIlp1tpbesjyuYbssqJeGmCBWDXBV");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Prueba parse connect
        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "Jesus");
        testObject.saveInBackground();*/

        ParseQuery<ParseObject> query = ParseQuery.getQuery("tragos");
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
                if (e == null) {

                    for(ParseObject obj:parseObjects){

                        Log.i("Tragos" , "tragos : " + obj.get("nombre") + " descripcion : " + obj.get("descripcion") + " Lat/Long : " + obj.get("latitud") + obj.get("longitud"));
                    }

                } else {
                    Log.d("Tragos", "Error: " + e.getMessage());
                }
            }
        });


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
