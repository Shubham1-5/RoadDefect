package com.example.roaddefect.loginSignupAuth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.roaddefect.R;
import com.example.roaddefect.bottomNavBar.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;

public class LoginTabFragment extends Fragment {

    TextInputLayout email, password;
    CheckBox remember;
    Button forgotPass, loginButton;
    float v = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        remember = root.findViewById(R.id.remember);
        forgotPass = root.findViewById(R.id.forgotPass);
        loginButton = root.findViewById(R.id.loginButton);

        email.setTranslationX(800);
        password.setTranslationX(800);
        remember.setTranslationX(800);
        forgotPass.setTranslationX(800);
        loginButton.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        remember.setAlpha(v);
        forgotPass.setAlpha(v);
        loginButton.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        remember.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
        forgotPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
        loginButton.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Option still not enabled in this version!", Toast.LENGTH_SHORT).show();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserDashboard.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
