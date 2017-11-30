package com.miguel.a05_tabnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    f = new AwariaFragment();
                    break;
                case R.id.navigation_dashboard:
                    break;
                case R.id.navigation_notifications:
                    break;
            }

            if(f!=null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,f)
                        .commit();
                return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Fragment f = new AwariaFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,f)
                .commit();
    }

}
