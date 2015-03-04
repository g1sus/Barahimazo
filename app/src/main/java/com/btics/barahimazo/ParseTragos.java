package com.btics.barahimazo;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by Gisus on 26/02/15.
 */
public class ParseTragos extends Application {

    public void onCreate(){
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "gPJS6gHqIvZOHmdSNn8qU2jzarQRnP7zWKGNFtxJ", "hM70tOcV9wbEIlp1tpbesjyuYbssqJeGmCBWDXBV");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

    }

}
