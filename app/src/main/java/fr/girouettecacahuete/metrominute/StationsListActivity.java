package fr.girouettecacahuete.metrominute;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class StationsListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stations_list);

        RatpServices Api = new RestAdapter.Builder().setEndpoint(RatpServices.ENDPOINT).build().create(RatpServices.class);
        // Appel Asynchrone bien lire

        Api.listStationsAsync("7", new Callback<List<Station>>() {
            @Override
            public void success(List<Station> stations, Response response) {
                afficherStations(stations);
            }

            @Override
            public void failure(RetrofitError error) {
                TextView text = findViewById(R.id.textView2);
                text.setText(error.getMessage());
            }
        });
    }

    public void afficherStations (List<Station> stations) {
        //Toast.makeText(this, "Nombre de stations: " + stations.size(), Toast.LENGTH_SHORT).show();
        TextView text = findViewById(R.id.textView2);
        text.setText("Frites");
    }

}
