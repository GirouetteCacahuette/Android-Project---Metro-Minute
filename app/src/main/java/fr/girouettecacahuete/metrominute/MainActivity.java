package fr.girouettecacahuete.metrominute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {
    Button ReturnButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMainActivityListeners();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.Recherche_Button:

                break;

            case R.id.MlistButton:
                setContentView(R.layout.metro_list);
                setMetro_ListListeners();
                break;

            case R.id.logo_m1:
                Intent intent = new Intent(MainActivity.this, StationsListActivity.class);
                startActivity(intent);
                break;

            case R.id.Return_Button:
                setContentView(R.layout.activity_main);
                setMainActivityListeners();
                break;
        }

    }

    public void setMainActivityListeners()
    {
        Button rechercher_Button = findViewById(R.id.Recherche_Button);
        rechercher_Button.setOnClickListener(this);

        Button metro_List_Button = findViewById(R.id.MlistButton);
        metro_List_Button.setOnClickListener(this);
    }

    public void setMetro_ListListeners()
    {
        ImageButton m1Button = findViewById(R.id.logo_m1);
        m1Button.setOnClickListener(this);

        ReturnButton = findViewById(R.id.Return_Button);
        ReturnButton.setOnClickListener(this);
    }
}
