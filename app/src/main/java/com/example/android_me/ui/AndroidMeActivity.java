package com.example.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.android_me.R;
import com.example.android_me.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if(savedInstanceState == null) {

            int headIndex = getIntent().getIntExtra("headIndex", 0);
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            int legIndex = getIntent().getIntExtra("legIndex", 0);

            BodyPartFragment headFragment = new BodyPartFragment();

            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setListIndex(headIndex);

            BodyPartFragment bodyFragment = new BodyPartFragment();

            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(bodyIndex);

            BodyPartFragment legFragment = new BodyPartFragment();

            legFragment.setImageIds(AndroidImageAssets.getLegs());
            legFragment.setListIndex(legIndex);

            //Use a Fragment manager and transaction to add the fragment to the screen
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }
}