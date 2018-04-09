package fr.girouettecacahuete.metrominute;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class StationsListActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stations_list);
        setStationsListActivityListeners();

        Intent intent = getIntent();
        if(intent != null)
        {
            appelApi(intent.getStringExtra("CODE"));
        }
    }

    public void appelApi(final String code)
    {
        RatpServices Api = new RestAdapter.Builder().setEndpoint(RatpServices.ENDPOINT).build().create(RatpServices.class);
        // Appel Asynchrone bien lire

        Api.listStationsAsync(code, new Callback<ApiResult>() {
            @Override
            public void success(ApiResult Apiresult, Response response) {
                afficherStations(Apiresult.result.stations, code);
            }

            @Override
            public void failure(RetrofitError error) {
                TextView text = findViewById(R.id.Stations_list);
                text.setText(error.getMessage());
            }
        });
    }

    public void afficherStations (List<Station> stations, String code) {
        TextView titleView = findViewById(R.id.Stations_list);
        String title = "Ligne Metro " + code;
        titleView.setText(title);

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 0, 0, 75);


        for(int i = 0; i<stations.size(); i++)
        {
            TableRow row = new TableRow(this);
            TextView station = new TextView(this);

            station.setText(stations.get(i).getName());
            station.setTextColor(Color.BLACK);
            station.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
            station.setClickable(true);
            station.setTag("station_"+code+"_"+i);

            station.setOnClickListener(this);

            row.addView(station, layoutParams);
            TableLayout tbl = findViewById(R.id.Stations_Table_Layout);
            tbl.addView(row);
        }


    }

    public void setStationsListActivityListeners()
    {
        Button ReturnButton = findViewById(R.id.Return_Button);
        ReturnButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String tag = view.getTag().toString();
        String code = "";
        if(tag.contains("station_"))
        {
            code = "" + tag.charAt(8);
            if(tag.charAt(9) != '_')
            {
                code += tag.charAt(9);
                tag = tag.substring(0,10);
            }
            else
            {
                tag = tag.substring(0,9);
            }
        }

        switch (tag)
        {
            case "Return_Button":
                Intent intent = new Intent(StationsListActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
