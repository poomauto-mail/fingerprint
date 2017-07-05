package com.example.i2ichest_.fingerprintit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.i2ichest_.fingerprintit.manager.WSManager;
import com.example.i2ichest_.fingerprintit.model.PersonModel;

public class VerifyStudentParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_student_parent);
    }

    public void getPersonData(View view){
        EditText name = (EditText)findViewById(R.id.nametxt);
        EditText studenId = (EditText)findViewById(R.id.studentId);
        EditText phone = (EditText)findViewById(R.id.phone);
        EditText email = (EditText)findViewById(R.id.email);




        final ProgressDialog progress = ProgressDialog.show(VerifyStudentParentActivity.this,"Please Wait...","Please wait...",true);
        WSManager manager = WSManager.getWsManager(this);
        PersonModel personmodel = new PersonModel();
        manager.doVerifyStudentParent(personmodel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {
                progress.dismiss();
                if(response.toString()!=null){

                }



            }

            @Override
            public void onError(String error) {
                progress.dismiss();
                Toast.makeText(VerifyStudentParentActivity.this,error,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
