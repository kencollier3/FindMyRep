package model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import util.Result;

public interface RepInterface {
    @GET("getall_reps_bystate.php?output=json")
    Call<Result> representativeListing(@Query("state") String state);
}
