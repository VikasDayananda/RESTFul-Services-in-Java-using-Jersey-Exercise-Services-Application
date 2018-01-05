package com.viky.repository;

import com.viky.model.Activity;
import com.viky.model.User;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepositoryStub implements ActivityRepository {
    //create a method

    @Override
    public void create(Activity activity){

    }
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity a1 = new Activity();
        a1.setDescription("Swimming");
        a1.setDuration(55);

        Activity a2 = new Activity();
        a2.setDescription("Cycling");
        a2.setDuration(100);

        activities.add(a1);
        activities.add(a2);

        return activities;
    }
    public Activity findActivity(String id){
        Activity a1 = new Activity();
        a1.setId("1234");
        a1.setDescription("Swimming");
        a1.setDuration(55);
        User user=new User();
        user.setId("5678");
        user.setName("Vikas");
        a1.setUser(user);

        return a1;

    }

}
