package com.example.roaddefect.loginSignupAuth;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
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

    private TextInputLayout email, password;
    CheckBox remember;
    Button forgotPass, loginButton;
    float v = 0;

    final String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    String passRegex = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[0-9]).{8,28}$";
    String noWhiteSpace = "\\A\\w{4,20}\\z";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        remember = root.findViewById(R.id.remember);
        forgotPass = root.findViewById(R.id.forgotPass);
        loginButton = root.findViewById(R.id.loginButton);

        animationAndLoginTranslation();

        password.setLongClickable(false);

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Option still not enabled in this version!", Toast.LENGTH_SHORT).show();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateEmail() | !validatePass())
                    return;
                else {
                    /* change this one after complete application*/
                    Intent intent = new Intent(getActivity(), UserDashboard.class);
                    startActivity(intent);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            email.getEditText().getText().clear();
                            password.getEditText().getText().clear();
                        }
                    }, 2000);

                }
            }
        });

        return root;
    }

    private void animationAndLoginTranslation() {
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

    }

    private Boolean validateEmail() {

        int a = emailValidateTextWatcher(email);

        if (a == 1)
            return false;
        else
            return true;
    }

    private int emailValidateTextWatcher(TextInputLayout email) {
        final int[] i = {0};

        if (!email.getEditText().getText().toString().trim().matches(emailRegex)) {
            email.setError("Please enter your Email-ID");
            i[0] = 1;
        }
        email.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    email.setError("Please enter Email-ID");
                    i[0] = 1;
                } else {
                    email.setError(null);
                    email.setErrorEnabled(false);
                    i[0] = 2;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        return i[0];

    }

    private Boolean validatePass() {

        int a = passwordValidateTextWatcher(password);
        if (a == 1)
            return false;
        else
            return true;
    }

    private int passwordValidateTextWatcher(TextInputLayout password) {
        final int[] i = {0};

        if (password.getEditText().getText().toString().trim().isEmpty()) {
            password.setError("Password can't be empty");
            i[0] = 1;
        }
        password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    password.setError("Please enter password");
                    i[0] = 1;
                } else {
                    password.setError(null);
                    password.setErrorEnabled(false);
                    i[0] = 2;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        return i[0];
    }

}

