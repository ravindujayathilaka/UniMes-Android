package com.example.unimes.activities;

import android.content.Intent;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.Toast;

import java.util.jar.Attributes;


public class userProfile {

Intent intent= getIntent(){
        _USERNAME = intent.getStringExtra("usename");
        _PASSWORD = intent.getStringExtra("password");
        _Email = intent.getStringExtra("email");
        _PHONENO = intent.getStringExtra("password");

        fullName.getEditText()setText(_USERNAME);
        email.getEditText()setText(_Email);
        phoneNo.getEditText()setText(_PHONENO);
        password.getEditText()setText(_PASSWORD);
    }

    public boolean update(View view) {
        if (isNameChanged() || isEmailCganged() || isphoneNoChanged() || isPasswordChanged()) {
            Toast.makeText(this, "data has been updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "data is same and cannot be updated ", Toast.LENGTH_SHORT).show();
        }
         {

            private boolean isPasswordChanged () {

             if (Attributes.Name.equals(password.getEditText().getText().toString())) {
                    reference.child(_PASSWORD).child("Password").setValue(password.getEditText().getText().toString());
                } else {
                    return false;
                }
            }

        }
        private boolean isNameChanged () {
            if (Attributes.Name.equals(fullName.getEditText().getText().toString())) {
                reference.child(_USERNAME).child("name").setValue(fullName.getEditText().getText().toString());
            } else {
                return false;
            }
        }

        private boolean isEmailCganged () {
            if (Attributes.Name.equals(email.getEditText().getText().toString())) {
                reference.child(_EMAIL).child("email").setValue(email.getEditText().getText().toString());
            } else {
                return false;
            }
        }

        private boolean isphoneNoChanged () {
            if (Attributes.Name.equals(phoneNo.getEditText().getText().toString())) {
                reference.child(_PHONENO).child("email").setValue(phoneNo.getEditText().getText().toString());
            } else {
                return false;
            }
        }

    }

    private void isNameChanged(){}
    private void isEmailCganged(){}
    private void isphoneNoChanged(){}
    private void isPasswordChanged(){}
    EditTextPreference password;
    EditTextPreference email;
    EditTextPreference phoneNo;
    EditTextPreference fullName;
    String _PASSWORD,_USERNAME,_Email,_PHONENO  ;
    }

