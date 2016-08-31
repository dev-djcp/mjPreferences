package net.djcp.mjpreferences.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import net.djcp.mjpreferences.Preferences;

public class MainActivity extends AppCompatActivity {

    Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Preferences.putInt("Test", 200);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Test -> " + Preferences.getInt("Test", 0), Toast.LENGTH_LONG).show();
            }
        });
    }
}
