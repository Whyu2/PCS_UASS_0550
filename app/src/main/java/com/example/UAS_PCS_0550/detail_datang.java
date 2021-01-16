package com.example.UAS_PCS_0550;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class detail_datang extends AppCompatActivity {
    TextView NamaEvent;
    Button tambahFavorit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_datang);

        tambahFavorit = findViewById(R.id.buttonFav);
        NamaEvent = findViewById(R.id.txtMatchh);

        String match = getIntent().getStringExtra("EXTRA_FULLNAME");
        String date = getIntent().getStringExtra("EXTRA_DATE");
        String liga = getIntent().getStringExtra("EXTRA_LIGA");

        String jam = getIntent().getStringExtra("EXTRA_JAM");
        String season = getIntent().getStringExtra("EXTRA_SEASON");
        String tuan = getIntent().getStringExtra("EXTRA_TUAN");
        String gambar = getIntent().getStringExtra("EXTRA_GAMBAR");
        String stadion = getIntent().getStringExtra("EXTRA_STADION");

        TextView txtMatch = findViewById(R.id.txtMatchh);
        TextView txtDate = findViewById(R.id.txtDate);
        TextView txtLiga = findViewById(R.id.txtLiga);

        TextView txtJam = findViewById(R.id.txtJam);
        TextView txtSeason = findViewById(R.id.txtSeason);
        TextView txtTuan = findViewById(R.id.txtTuan);

        ImageView imgGambar = findViewById(R.id.imgGambar);
        TextView txtStadion = findViewById(R.id.txtStadion);

        txtMatch.setText(match);
        txtDate.setText(date);
        txtLiga.setText(liga);

        txtJam.setText(jam);
        txtSeason.setText(season);
        txtTuan.setText(tuan);
        txtStadion.setText(stadion);

        Glide.with(this)
                .load(""+gambar.toString())
                .into(imgGambar);
    }

}
