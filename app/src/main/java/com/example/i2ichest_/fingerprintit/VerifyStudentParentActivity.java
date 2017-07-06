package com.example.i2ichest_.fingerprintit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.i2ichest_.fingerprintit.manager.WSManager;
import com.example.i2ichest_.fingerprintit.model.StudentModel;

public class VerifyStudentParentActivity extends AppCompatActivity {
    String splitName[];
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
        WSManager manager = WSManager.getWsManager(this);
        StudentModel studentModel = new StudentModel();
        final ProgressDialog progress = ProgressDialog.show(VerifyStudentParentActivity.this,"Please Wait...","Please wait...",true);

        splitName = name.getText().toString().split("");
      /*  studentModel.getPerson().setPersonID(12L);
        studentModel.getPerson().setFirstName(splitName[0]);
        studentModel.getPerson().setLastName(splitName[1]);*/
        studentModel.getStudent().setStudentID(Long.parseLong(studenId.getText().toString()));
        studentModel.getStudent().setParentPhone(phone.getText().toString());

        manager.doVerifyStudentParent(studentModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {
                progress.dismiss();
                if(response.toString()!=null){
                    Log.d("student response ",response.toString());
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
