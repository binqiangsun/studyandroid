package com.study.sunbinqiang.firstapp;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.study.sunbinqiang.firstapp.R.id.fragment_container;


public class FragmentTestActivity extends ActionBarActivity implements HeadlinesFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        //check the activity is using layout version
        if(findViewById(fragment_container) != null){
            if(savedInstanceState != null){
                return;
            }
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(fragment_container, firstFragment).commit();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fragment_test, menu);
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
    
    public void ChangeFragment(){
        ArticalFragment newFragment = new ArticalFragment();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, newFragment);

        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
