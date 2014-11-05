package com.ahmadnaser.settingsandroidapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    static boolean flag = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        if(flag)
            Log.d("ONCREATE", "flag is true");
        Toast.makeText(getApplicationContext(),"VVvv",Toast.LENGTH_LONG).show();
	}

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void onStart() {
        super.onStart();
        initializer();
    }

    private void initializer() {

        // Get the app's shared preferences
        SharedPreferences app_preferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        // Get the value for the first color
        String the_bk_color = app_preferences.getString("example_list_colors", "#FFFFFF");




        // Update the RelativeLayout
        RelativeLayout lay=(RelativeLayout)findViewById( R.id.mainActivityLayout);
        lay.setBackgroundColor(Color.parseColor(the_bk_color));


        // Increment the counter
        SharedPreferences.Editor editor = app_preferences.edit();
        editor.putString("example_list_colors", the_bk_color);
        editor.commit(); // Very important


    //    Toast.makeText(getApplicationContext(),the_bk_color,Toast.LENGTH_LONG).show();
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(R.id.action_settings==item.getItemId())
        {
            Intent in=new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(in);
        }

        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        Log.d("ONCONFIGCHANGE", "CALLED" );
        flag = false;
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_main);
       // initializer();
    }



}
