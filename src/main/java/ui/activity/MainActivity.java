package ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import agency.rain.findmyrep.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.RepInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ui.adapter.RepresentativeListAdapter;
import util.Result;
import util.State;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.statesSpinner)
    Spinner stateSpinner;
    @BindView(R.id.displayRepRecyclerView)
    RecyclerView recyclerViewList;

    private Retrofit retrofit;
    private RepresentativeListAdapter repAdapter;
    private static final State[] STATES = new State[]{

            new State("Alabama", "AL"),
            new State("Alaska", "AK"),
            new State("American Samoa", "AS"),
            new State("Arizona", "AZ"),
            new State("Arkansas", "AR"),
            new State("California", "CA"),
            new State("Colorado", "CO"),
            new State("Connecticut", "CT"),
            new State("Delaware", "DE"),
            new State("District Of Columbia", "DC"),
            new State("Florida", "FL"),
            new State("Georgia", "GA"),
            new State("Guam", "GU"),
            new State("Hawaii", "HI"),
            new State("Idaho", "ID"),
            new State("Illinois", "IL"),
            new State("Indiana", "IN"),
            new State("Iowa", "IA"),
            new State("Kansas", "KS"),
            new State("Kentucky", "KY"),
            new State("Louisiana", "LA"),
            new State("Maine", "ME"),
            new State("Maryland", "MD"),
            new State("Massachusetts", "MA"),
            new State("Michigan", "MI"),
            new State("Minnesota", "MN"),
            new State("Mississippi", "MS"),
            new State("Missouri", "MO"),
            new State("Montana", "MT"),
            new State("Nebraska", "NE"),
            new State("Nevada", "NV"),
            new State("New Hampshire", "NH"),
            new State("New Jersey", "NJ"),
            new State("New Mexico", "NM"),
            new State("New York", "NY"),
            new State("North Carolina", "NC"),
            new State("North Dakota", "ND"),
            new State("Ohio", "OH"),
            new State("Oklahoma", "OK"),
            new State("Oregon", "OR"),
            new State("Pennsylvania", "PA"),
            new State("Puerto Rico", "PR"),
            new State("Rhode Island", "RI"),
            new State("South Carolina", "SC"),
            new State("South Dakota", "SD"),
            new State("Tennessee", "TN"),
            new State("Texas", "TX"),
            new State("Utah", "UT"),
            new State("Vermont", "VT"),
            new State("Virgin Islands", "VI"),
            new State("Virginia", "VA"),
            new State("Washington", "WA"),
            new State("West Virginia", "WV"),
            new State("Wisconsin", "WI"),
            new State("Wyoming", "WY"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        stateSpinner.setOnItemSelectedListener(this);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://whoismyrepresentative.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        ArrayAdapter<State> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, STATES);
        stateSpinner.setAdapter(adapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewList.setLayoutManager(layoutManager);
        repAdapter = new RepresentativeListAdapter(this);
        recyclerViewList.setAdapter(repAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        final State state = STATES[i];
        if (state != null) {
            RepInterface repInterface = retrofit.create(RepInterface.class);
            state.getmStateAbbrev();

            final Call<Result> call = repInterface.representativeListing(state.getmStateAbbrev());

            call.enqueue(new Callback<Result>() {
                @Override
                public void onResponse(Call<Result> call, Response<Result> response) {
                    if (response.isSuccessful()) {
                        repAdapter.set(response.body().getResults());
                    }
                }

                @Override
                public void onFailure(Call<Result> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
