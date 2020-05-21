package com.example.sahyog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.github.appintro.AppIntro2;
import com.github.appintro.AppIntroFragment;

public class introactivity extends AppIntro2 {



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        int check = preferences.getInt("checkk",2);

            if(check == 1)
            {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }




            getSupportActionBar().hide();
        setWizardMode(true);
        setImmersive(true);
        addSlide(AppIntroFragment.newInstance(
                "",
                "",
                R.drawable.one,
                Color.WHITE
                ));
        addSlide(AppIntroFragment.newInstance(
                "",
                "",
                R.drawable.two,
                Color.WHITE
        ));addSlide(AppIntroFragment.newInstance(
                "",
                "",
                R.drawable.three,
                Color.WHITE
        ));
        addSlide(AppIntroFragment.newInstance(
                "",
                "",
                R.drawable.four,
                Color.WHITE

        ));

            setIndicatorColor(R.color.colorAccent,R.color.colorPrimary);

    }

    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("checkk",1);
        editor.commit();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

}
