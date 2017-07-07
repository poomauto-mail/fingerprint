package com.example.i2ichest_.fingerprintit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.i2ichest_.fingerprintit.manager.WSManager;
import com.example.i2ichest_.fingerprintit.model.StudentModel;

public class VerifyStudentParentActivity extends AppCompatActivity {
    String splitName[];
    StudentModel studentModelResponse;
    EditText name;
    EditText studenId;
    EditText phone;
    EditText email;
    WSManager manager;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_student_parent);
    }

    public void getPersonData(View view){
        name = (EditText)findViewById(R.id.nametxt);
        studenId = (EditText)findViewById(R.id.studentId);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.email);
        manager = WSManager.getWsManager(this);
        final StudentModel studentModel = new StudentModel();
        final ProgressDialog progress = ProgressDialog.show(VerifyStudentParentActivity.this,"Please Wait...","Please wait...",true);
        studentModel.getStudent().setStudentID(Long.parseLong(studenId.getText().toString()));
        studentModel.getStudent().setParentPhone(phone.getText().toString());

        manager.doVerifyStudentParent(studentModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {
                progress.dismiss();
                if(response.toString()!=null){
                    studentModelResponse = (StudentModel)response;
                    //Log.d("student response ",studentModelResponse.getStudent().getParentPhone());
                    result = (TextView) findViewById(R.id.result);
                    result.setText(studentModel.getStudent().checkStudentIdAndPhone(phone.getText().toString(),studentModelResponse.getStudent().getParentPhone()));
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
