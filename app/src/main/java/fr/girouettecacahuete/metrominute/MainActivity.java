package fr.girouettecacahuete.metrominute;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView texteCentral = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texteCentral = findViewById(R.id.text);
        texteCentral.setText("");
    }
}
