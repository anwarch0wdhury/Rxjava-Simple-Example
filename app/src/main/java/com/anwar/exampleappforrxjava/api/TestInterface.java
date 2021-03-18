package com.anwar.exampleappforrxjava.api;


import com.anwar.exampleappforrxjava.model.TeststoryModel;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TestInterface {
    @GET("shortstory.json")
    Observable<List<TeststoryModel>> getStories();
}
