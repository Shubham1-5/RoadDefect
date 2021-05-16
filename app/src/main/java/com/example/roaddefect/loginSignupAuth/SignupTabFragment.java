package com.example.roaddefect.loginSignupAuth;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.roaddefect.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignupTabFragment extends Fragment {

    private TextInputLayout name, email, mobile, password;
    Button signupButton;
    float v = 0;

    final String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    String passRegex = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[0-9]).{8,28}$";
    String noWhiteSpace = "\\A\\w{4,20}\\z";
    String mobileRegex = "([9876]{1})([0-9]{9})$";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        name = root.findViewById(R.id.name);
        mobile = root.findViewById(R.id.mobileNo);
        signupButton = root.findViewById(R.id.signupButton);

        animationAndSignupTranslation();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateName() | !validateEmail() | !validateMobile() | !validatePass()) {
                    //progressDialog.hide();
                    return;
                } else {
                    /* change this one after complete application
                    Intent intent = new Intent(getActivity(), LoginTabFragment.class);
                    Review above line*/
                    Toast.makeText(getActivity(), "Registration successful.", Toast.LENGTH_SHORT).show();
                    name.getEditText().getText().clear();
                    password.getEditText().getText().clear();
                    email.getEditText().getText().clear();
                    mobile.getEditText().getText().clear();
                    //startActivity(intent);
                }
            }
        });

        return root;
    }

    private void animationAndSignupTranslation() {
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

    }

    private Boolean validateName() {

        int a = nameValidateTextWatcher(name);

        if (a == 1)
            return false;
        else
            return true;

    }

    private int nameValidateTextWatcher(TextInputLayout name) {
        final int[] i = {0};

        if (name.getEditText().getText().toString().trim().isEmpty()) {
            name.setError("Please enter your name");
            i[0] = 1;
        }
        name.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    name.setError("Please enter your name");
                    i[0] = 1;
                } else {
                    name.setError(null);
                    name.setErrorEnabled(false);
                    i[0] = 2;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        return i[0];
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

        if (email.getEditText().getText().toString().trim().isEmpty()) {
            email.setError("Please enter your Email-ID");
            i[0] = 1;
        }
        if (!email.getEditText().getText().toString().trim().matches(emailRegex)) {
            email.setError("Please enter valid Email-ID");
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

    private Boolean validateMobile() {

        int a = mobileValidateTextWatcher(mobile);

        if (a == 1)
            return false;
        else
            return true;
    }

    private int mobileValidateTextWatcher(TextInputLayout mobile) {
        final int[] i = {0};

        if (mobile.getEditText().getText().toString().trim().isEmpty()) {
            mobile.setError("Please enter your mobile number");
            i[0] = 1;
        }
        if (!mobile.getEditText().getText().toString().trim().matches(mobileRegex)) {
            mobile.setError("Please enter correct mobile number");
            i[0] = 1;
        }
        mobile.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    mobile.setError("Please enter mobile number");
                    i[0] = 1;
                } else {
                    mobile.setError(null);
                    mobile.setErrorEnabled(false);
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
        } else if (password.getEditText().getText().toString().trim().length() < 8) {
            password.setError("Please enter atleast 8 character password");
            i[0] = 1;
        } else if (!password.getEditText().getText().toString().trim().matches(passRegex)) {
            password.setError("Use password with a mix of alphabets and numbers");
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
