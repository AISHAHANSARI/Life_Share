package com.ansari.lifeshare.DonorRecipient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ansari.lifeshare.Common.LoginSignup.BackToSignIn;
import com.ansari.lifeshare.Databases.SessionManager;
import com.ansari.lifeshare.Common.Database.DonorHelperClass;
import com.ansari.lifeshare.Common.Database.UserHelperClass;
import com.ansari.lifeshare.R;
import com.ansari.lifeshare.User.SignIn;
import com.ansari.lifeshare.User.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class DonorRegisteration extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String fname, lname, dob, gender, phoneNo, q1, q2, q3, q4, q5, q6;
    String bloodgroup="";
    DatePicker datePicker;
    CountryCodePicker countryCodePicker;
    Spinner spinnerBldGrp;

    TextInputLayout  phone, firstName, lastName;
    RadioButton selectedRadioButton, selectedRadioButton1, selectedRadioButton2, selectedRadioButton3, selectedRadioButton4, selectedRadioButton5, selectedRadioButton6;
    RadioGroup btnGender,btnQuest1,btnQuest2,btnQuest3,btnQuest4,btnQuest5,btnQuest6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_registeration);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        datePicker = findViewById(R.id.age_picker);
        btnGender = findViewById(R.id.btnGender);
        countryCodePicker = findViewById(R.id.country_code_picker);
        phone = findViewById(R.id.phoneNo);
        spinnerBldGrp = findViewById(R.id.spinner_bld_grp);

        btnQuest1 = findViewById(R.id.btnQuest1);
        btnQuest2 = findViewById(R.id.btnQuest2);
        btnQuest3 = findViewById(R.id.btnQuest3);
        btnQuest4 = findViewById(R.id.btnQuest4);
        btnQuest5 = findViewById(R.id.btnQuest5);
        btnQuest6 = findViewById(R.id.btnQuest6);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bloodgroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBldGrp.setAdapter(adapter);
        spinnerBldGrp.setOnItemSelectedListener(this);


    }

    public void storeNewDonorData(View view){
        fname = firstName.getEditText().getText().toString().trim();
        lname = lastName.getEditText().getText().toString().trim();
        //Get complete phone number
        String _getUserEnteredPhoneNumber = phone.getEditText().getText().toString().trim();
//Remove first zero if entered!
        if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
            _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
        }
//Complete phone number
        phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;


        int _dobday = datePicker.getDayOfMonth();
        int _dobmonth = datePicker.getMonth() + 1;
        int _dobyear = datePicker.getYear();
        dob = Integer.toString(_dobday) + "-" + Integer.toString(_dobmonth) + "-" + Integer.toString(_dobyear);
        selectedRadioButton  = (RadioButton)findViewById(btnGender.getCheckedRadioButtonId());
        //get RadioButton text
        gender = selectedRadioButton.getText().toString();


        selectedRadioButton1  = (RadioButton)findViewById(btnQuest1.getCheckedRadioButtonId());
        //get RadioButton text
        q1 = selectedRadioButton1.getText().toString();


        selectedRadioButton2  = (RadioButton)findViewById(btnQuest2.getCheckedRadioButtonId());
        //get RadioButton text
        q2 = selectedRadioButton2.getText().toString();


        selectedRadioButton3  = (RadioButton)findViewById(btnQuest3.getCheckedRadioButtonId());
        //get RadioButton text
        q3 = selectedRadioButton3.getText().toString();

        selectedRadioButton4  = (RadioButton)findViewById(btnQuest4.getCheckedRadioButtonId());
        //get RadioButton text
        q4 = selectedRadioButton4.getText().toString();


        selectedRadioButton5  = (RadioButton)findViewById(btnQuest5.getCheckedRadioButtonId());
        //get RadioButton text
        q5 = selectedRadioButton5.getText().toString();

        selectedRadioButton6  = (RadioButton)findViewById(btnQuest6.getCheckedRadioButtonId());
        //get RadioButton text
        q6 = selectedRadioButton6.getText().toString();



        newDonorData();
    }
    private void newDonorData() {
        SessionManager sessionManager = new SessionManager(DonorRegisteration.this, SessionManager.SESSION_REMEMMBERME);
      if (sessionManager.checkRememberMe()){

        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Donors");

        DonorHelperClass newUser = new DonorHelperClass(fname, lname, dob, gender, bloodgroup, phoneNo, q1, q2, q3, q4, q5, q6);
        reference.child(phoneNo).setValue(newUser);
        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
        startActivity(intent);
        finish();
    }else{
        Intent intent = new Intent(getApplicationContext(), BackToSignIn.class);
        startActivity(intent);
        finish();
      }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        bloodgroup = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), bloodgroup, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}