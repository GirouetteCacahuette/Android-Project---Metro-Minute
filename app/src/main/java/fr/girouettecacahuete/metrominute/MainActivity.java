package fr.girouettecacahuete.metrominute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {
    private static final int DIALOG_ALERT = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setMainActivityListeners();

    }

    @Override
    public void onClick(View view) {

        String tag = view.getTag().toString(); // We will use the buttons tag to know wich line the user chose
        String code = "";
        if(tag.contains("logo_m"))
        {
            code = tag.substring(6);
            tag = tag.substring(0,6);
        }

        switch (tag)
        {
            case "Recherche_Button": // User clicked on search button

                break;

            case "MlistButton": // User clicked on Metro list Button
                setContentView(R.layout.metro_list); // We change the content to show the metros list
                setMetro_ListListeners();
                break;

            case "logo_m": // User clicked on a Metro Logo
                Intent intent = new Intent(MainActivity.this, StationsListActivity.class);
                intent.putExtra("CODE", code);
                startActivity(intent); // We change the active activity, to show the chosen line stations. We send the number corresponding to the chosen line
                break;

            case "Return_Button": // User clicked on a return Button
                setContentView(R.layout.activity_main); // We return to first content
                setMainActivityListeners();
                break;
        }

    }

    public void setMainActivityListeners() // Sets all the listeners for the first content
    {
        Button rechercher_Button = findViewById(R.id.Recherche_Button);
        rechercher_Button.setOnClickListener(this);

        Button metro_List_Button = findViewById(R.id.MlistButton);
        metro_List_Button.setOnClickListener(this);
    }

    public void setMetro_ListListeners() // Sets all the listeners for the second content
    {
        ImageButton m1Button = findViewById(R.id.logo_m1);
        m1Button.setOnClickListener(this);

        ImageButton m2Button = findViewById(R.id.logo_m2);
        m2Button.setOnClickListener(this);

        ImageButton m3Button = findViewById(R.id.logo_m3);
        m3Button.setOnClickListener(this);

        ImageButton m3bButton = findViewById(R.id.logo_m3b);
        m3bButton.setOnClickListener(this);

        ImageButton m4Button = findViewById(R.id.logo_m4);
        m4Button.setOnClickListener(this);

        ImageButton m5Button = findViewById(R.id.logo_m5);
        m5Button.setOnClickListener(this);

        ImageButton m6Button = findViewById(R.id.logo_m6);
        m6Button.setOnClickListener(this);

        ImageButton m7Button = findViewById(R.id.logo_m7);
        m7Button.setOnClickListener(this);

        ImageButton m7bButton = findViewById(R.id.logo_m7b);
        m7bButton.setOnClickListener(this);

        ImageButton m8Button = findViewById(R.id.logo_m8);
        m8Button.setOnClickListener(this);

        ImageButton m9Button = findViewById(R.id.logo_m9);
        m9Button.setOnClickListener(this);

        ImageButton m10Button = findViewById(R.id.logo_m10);
        m10Button.setOnClickListener(this);

        ImageButton m11Button = findViewById(R.id.logo_m11);
        m11Button.setOnClickListener(this);

        ImageButton m12Button = findViewById(R.id.logo_m12);
        m12Button.setOnClickListener(this);

        ImageButton m13Button = findViewById(R.id.logo_m13);
        m13Button.setOnClickListener(this);

        ImageButton m14Button = findViewById(R.id.logo_m14);
        m14Button.setOnClickListener(this);

        ImageButton mOrvButton = findViewById(R.id.logo_mOrv);
        mOrvButton.setOnClickListener(this);

        Button ReturnButton = findViewById(R.id.Return_Button);
        ReturnButton.setOnClickListener(this);
    }
}
