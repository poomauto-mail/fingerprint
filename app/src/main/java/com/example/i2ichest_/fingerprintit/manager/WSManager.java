package com.example.i2ichest_.fingerprintit.manager;

import android.content.Context;
import android.util.Log;
import com.example.i2ichest_.fingerprintit.R;
import com.example.i2ichest_.fingerprintit.model.PersonModel;
import com.example.i2ichest_.fingerprintit.task.WSTask;

public class WSManager {
    private static WSManager wsManager;
    private Context context;
    public interface WSManagerListener{
        void onComplete(Object response) ;
        void onError(String error);

    }

    public WSManager(Context context) {
        this.context = context;
    }

    public static WSManager getWsManager(Context context){
        if(wsManager == null)
            wsManager = new WSManager(context);
        return  wsManager;
    }

    public void doVerifyStudentParent(Object object,final WSManagerListener listener){
        if(!(object instanceof PersonModel)){
            return;
        }
        PersonModel personModel = (PersonModel)object;
        personModel.toJSONString();

        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response)  {
                PersonModel reg = new PersonModel(response);
                Log.d("res",reg.getPerson().getFirstName());
                listener.onComplete(reg);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);

            }
        });
        task.execute(context.getString(R.string.verify_student_parent),personModel.toString());

    }
































   /* public void doLogin(Object object,final WSManagerListener listener){
        if(!(object instanceof UserModel)){
            return;
        }

        UserModel userModel = (UserModel)object;
        userModel.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
               // UserModel userModel = new UserModel(response);
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {listener.onError(err);

            }
        });
        task.execute("/api/login", userModel.toJSONString());
    }

    public void doEditUserProfile(Object object,final WSManagerListener listener){
        if(!(object instanceof UserModel)){
            return;
        }

        UserModel userModel = (UserModel)object;
        userModel.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {listener.onError(err);

            }
        });
        task.execute("/api/user", userModel.toJSONString());
    }

    public void doBuddhistDay(Object object,final WSManagerListener listener){
        if(!(object instanceof BuddhistDayModel)){
            return;
        }

        BuddhistDayModel buddhistDayModel = (BuddhistDayModel) object;
        buddhistDayModel.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {
                listener.onError(err);
            }
        });
        task.execute("/api/days",buddhistDayModel.toJSONString());
    }

    public void addActivityOfDay(Object object,final WSManagerListener listener){
        if(!(object instanceof ActivityDayModel)){
            return;
        }
        ActivityDayModel dm = (ActivityDayModel)object;

        dm.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {

                Log.d("response get days ",response.toString());

                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {

            }
        });

        try {

            task.execute("/api/addactivity", dm.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //NEW*****************************
    public void findActivityOfDay(Object object,final WSManagerListener listener){
        if(!(object instanceof ActivityDayModel)){
            return;
        }
        ActivityDayModel ad = (ActivityDayModel)object;

        ad.toJSONString();
        WSTask task = new WSTask(this.context, new WSTask.WSTaskListener() {
            @Override
            public void onComplete(String response) {
                Log.d("response get days ",response.toString());
                listener.onComplete(response);
            }

            @Override
            public void onError(String err) {

            }
        });

        try {

            task.execute("/api/findactivity", ad.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
