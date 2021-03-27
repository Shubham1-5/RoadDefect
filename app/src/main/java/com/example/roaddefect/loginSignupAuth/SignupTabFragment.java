package com.example.roaddefect.loginSignupAuth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.roaddefect.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignupTabFragment extends Fragment {

    TextInputLayout name, email, mobile, password;
    Button signupButton;
    float v = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        name = root.findViewById(R.id.name);
        mobile = root.findViewById(R.id.mobileNo);
        signupButton = root.findViewById(R.id.signupButton);

        email.setTranslationX(800);
        password.setTranslationX(800);
        name.setTranslationX(800);
        mobile.setTranslationX(800);
        signupButton.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        name.setAlpha(v);
        mobile.setAlpha(v);
        signupButton.setAlpha(v);

        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        mobile.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
        signupButton.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;
    }
}
