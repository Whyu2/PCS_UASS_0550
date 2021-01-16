package com.example.UAS_PCS_0550;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView NamaEvent,Homescore,Awayscore;
    Button tambahFavorit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tambahFavorit = findViewById(R.id.buttonFav);
        NamaEvent = findViewById(R.id.txtMatchh);
        Homescore = findViewById(R.id.txtHomescore);
        Awayscore = findViewById(R.id.txtAwayscore);

        final String id = getIntent().getStringExtra("EXTRA_ID");

        final SQLiteDatabase mydatabase = openOrCreateDatabase("database_0550",MODE_PRIVATE,null);

        tambahFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor resultSet = mydatabase.rawQuery(String.format("SELECT * FROM favorit WHERE idevent='%s'",id),null);
                resultSet.moveToFirst();
                int size = resultSet.getCount();
                if(size>0){
                    Toast.makeText(getApplicationContext(),
                            "Data Sudah Ada", Toast.LENGTH_SHORT).show();
                }else{
                    mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Favorit(idevent VARCHAR, namaevent VARCHAR);");
                    mydatabase.execSQL(String.format("INSERT INTO Favorit VALUES('%s','%s','%s','%s');",id,NamaEvent.getText(),Homescore.getText(),Awayscore.getText()));
                    Toast.makeText(getApplicationContext(),
                            "Data Dimasukkan Ke List Favorite", Toast.LENGTH_SHORT).show();
                }
            }
        });

        String match = getIntent().getStringExtra("EXTRA_FULLNAME");
        String date = getIntent().getStringExtra("EXTRA_DATE");
        String liga = getIntent().getStringExtra("EXTRA_LIGA");
        String home = getIntent().getStringExtra("EXTRA_HOME");
        String away = getIntent().getStringExtra("EXTRA_AWAY");
        String jam = getIntent().getStringExtra("EXTRA_JAM");
        String season = getIntent().getStringExtra("EXTRA_SEASON");
        String tuan = getIntent().getStringExtra("EXTRA_TUAN");
        String gambar = getIntent().getStringExtra("EXTRA_GAMBAR");
        String stadion = getIntent().getStringExtra("EXTRA_STADION");

        TextView txtMatch = findViewById(R.id.txtMatchh);
        TextView txtDate = findViewById(R.id.txtDate);
        TextView txtLiga = findViewById(R.id.txtLiga);
        TextView txtHome = findViewById(R.id.txtHomescore);
        TextView txtAway = findViewById(R.id.txtAwayscore);
        TextView txtJam = findViewById(R.id.txtJam);
        TextView txtSeason = findViewById(R.id.txtSeason);
        TextView txtTuan = findViewById(R.id.txtTuan);
        ImageView imgGambar = findViewById(R.id.imgGambar);
        TextView txtStadion = findViewById(R.id.txtStadion);

        txtMatch.setText(match);
        txtDate.setText(date);
        txtLiga.setText(liga);
        txtHome.setText(home);
        txtAway.setText(away);
        txtJam.setText(jam);
        txtSeason.setText(season);
        txtTuan.setText(tuan);
        txtStadion.setText(stadion);

        Glide.with(this)
                .load(""+gambar.toString())
                .into(imgGambar);
    }

}
