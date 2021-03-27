package com.example.roaddefect.splashScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.airbnb.lottie.LottieAnimationView;
import com.example.roaddefect.R;
import com.example.roaddefect.onBoardingFragment.OnBoardingFragment1;
import com.example.roaddefect.onBoardingFragment.OnBoardingFragment2;
import com.example.roaddefect.onBoardingFragment.OnBoardingFragment3;
import com.example.roaddefect.socialMediaButtonOnLogInSignup.LoginActivity;

public class IntroductoryActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;

    private static final int NUM_PAGES = 3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;
    Animation anim;

    private static int SPLASH_TIME_OUT = 4000;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        lottieAnimationView = findViewById(R.id.lottie);
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        anim = AnimationUtils.loadAnimation(this, R.anim.o_b_anim);
        viewPager.startAnimation(anim);

        lottieAnimationView.animate().translationY(1400).setDuration(2400).setStartDelay(4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPreferences = getSharedPreferences("SharedPref", MODE_PRIVATE);
                boolean isFirstTime = sharedPreferences.getBoolean("firstTime", true);

                if (isFirstTime) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                } else {
                    Intent intent = new Intent(IntroductoryActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                    return tab1;
                case 1:
                    OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                    return tab2;
                case 2:
                    OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}