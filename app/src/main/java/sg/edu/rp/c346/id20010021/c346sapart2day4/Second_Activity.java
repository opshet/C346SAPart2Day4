package sg.edu.rp.c346.id20010021.c346sapart2day4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Second_Activity  extends AppCompatActivity {

    Button btnLogPSI;
    ListView lv;
    ArrayList<PSIReading> PSIlist;

    CustomAdapter psia;
    CustomAdapter songstuff;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        btnLogPSI=findViewById(R.id.btnLogPSI);
        lv = findViewById(R.id.lv);


        DBHelper dbh = new DBHelper(this);
        PSIlist = dbh.getPSI();
        dbh.close();

        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, songList);
        psia = new CustomAdapter(this, R.layout.customview, PSIlist);
        lv.setAdapter(psia);

        btnLogPSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.layout, null);


                final EditText etPSId = viewDialog.findViewById(R.id.etPSId);
                final EditText etLocationd = viewDialog.findViewById(R.id.etLocationd);

                final EditText etPSIr = viewDialog.findViewById(R.id.etPSIr);
                final EditText etLocation = viewDialog.findViewById(R.id.etLocation);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(Second_Activity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Add Log");
                myBuilder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user


                        String PSI= etPSId.getText().toString();
                        int psii=Integer.parseInt(PSI);
                        String location= etLocationd.getText().toString();

                        etPSIr.setText(PSI);
                        etLocation.setText(location);



                        DBHelper dbh = new DBHelper(Second_Activity.this);
                        dbh.insertPSI(psii, location);





                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });







    }
}
