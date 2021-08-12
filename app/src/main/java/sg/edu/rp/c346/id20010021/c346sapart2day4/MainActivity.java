package sg.edu.rp.c346.id20010021.c346sapart2day4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDateLU;
    Button btnPsiLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDateLU=findViewById(R.id.tvDateLU);
        btnPsiLog=findViewById(R.id.btnPsiLog);

        btnPsiLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Second_Activity.class);

            }
        });




    }
}