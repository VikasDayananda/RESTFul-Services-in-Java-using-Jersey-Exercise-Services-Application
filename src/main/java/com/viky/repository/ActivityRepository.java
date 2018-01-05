package com.viky.repository;

import com.viky.model.Activity;

import java.util.List;

public interface ActivityRepository {
    //create a method
    List<Activity> findAllActivities();
    Activity findActivity(String id);
    void create(Activity activity);
}
