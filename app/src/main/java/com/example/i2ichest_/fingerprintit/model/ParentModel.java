package com.example.i2ichest_.fingerprintit.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ParentModel {
    private Parent parent;
    Gson gson = new GsonBuilder().create();

    public ParentModel(){
        parent = new Parent();
    }

    public ParentModel(String jsonResponse){
        parent = gson.fromJson(jsonResponse,Parent.class);
    }

    public Parent getPerson(){
        return parent;
    }

    public String toJSONString(){
        return gson.toJson(this.parent);
    }


    public class Parent extends PersonModel {
        private String phoneNo;
        private String email;

        public Parent() {
        }

        public Parent(String phoneNo, String email) {

            this.phoneNo = phoneNo;
            this.email = email;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
