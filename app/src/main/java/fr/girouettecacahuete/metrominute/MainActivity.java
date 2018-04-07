package fr.girouettecacahuete.metrominute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rechercher_Button = findViewById(R.id.RButton);
        rechercher_Button.setOnClickListener(this);

        Button metro_List_Button = findViewById(R.id.MlistButton);
        metro_List_Button.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.RButton:

                break;

            case R.id.MlistButton:
                setContentView(R.layout.metro_list);
                break;
        }

    }
}
