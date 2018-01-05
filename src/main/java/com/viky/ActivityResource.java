package com.viky;


import com.viky.model.Activity;
import com.viky.model.User;
import com.viky.repository.ActivityRepository;
import com.viky.repository.ActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;


@Path("activities")
public class ActivityResource {
    private ActivityRepository activityRepository=new ActivityRepositoryStub();

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
    public Activity createActivity(MultivaluedMap<String, String> formParams){


        Activity activity=new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
        activityRepository.create(activity);

        return activity;
    }
    //All object retrieval
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Activity> getAllActivities(){
        return activityRepository.findAllActivities();

    }
    //Specific object retrieval
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}")
    public Activity getActivity(@PathParam ("id") String id){
        return activityRepository.findActivity(id);

    }

    //Nested object retrieval
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}/user")
    public User getActivityUser(@PathParam ("id") String id){
        Activity activity=activityRepository.findActivity(id);
        User user=activity.getUser();
        return user;
       // return activityRepository.findActivity(id).getUser();

    }

}
