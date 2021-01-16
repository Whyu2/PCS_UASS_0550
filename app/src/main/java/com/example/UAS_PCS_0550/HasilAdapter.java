package com.example.UAS_PCS_0550;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HasilAdapter extends RecyclerView.Adapter<HasilAdapter.ListViewHolder> {

    private ArrayList<Hasil> listHasil;
    private Context context;
//    private Button button;

    public HasilAdapter(ArrayList<Hasil> listHasil, Context context) {
        this.listHasil = listHasil;
        this.context = context;
    }

    public HasilAdapter(ArrayList<Hasil> listHasil) {
        this.listHasil = listHasil;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Hasil hasil = listHasil.get(position);

        holder.txtMatch.setText(hasil.getMatch());
        holder.txtDate.setText(hasil.getDate());
//        holder.txtLiga.setText(movie.getLiga());
        holder.txtHomescore.setText(hasil.getHomescore());
        holder.txtAwayscore.setText(hasil.getAwayscore());

        Glide.with(context).load(listHasil.get(position).getGambar()).into(holder.imgGambar);



        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailActivity = new Intent(context, DetailActivity.class);
                detailActivity.putExtra("EXTRA_TITLE", hasil.getMatch().toString());
                detailActivity.putExtra("EXTRA_DATE", hasil.getDate().toString());
                detailActivity.putExtra("EXTRA_LIGA", hasil.getLiga().toString());
                detailActivity.putExtra("EXTRA_HOME", hasil.getHomescore().toString());
                detailActivity.putExtra("EXTRA_AWAY", hasil.getAwayscore().toString());
                detailActivity.putExtra("EXTRA_JAM", hasil.getJam().toString());
                detailActivity.putExtra("EXTRA_SEASON", hasil.getSeason().toString());
                detailActivity.putExtra("EXTRA_TUAN", hasil.getTuan().toString());
                detailActivity.putExtra("EXTRA_GAMBAR", hasil.getGambar().toString());
                detailActivity.putExtra("EXTRA_STADION", hasil.getStadion().toString());
                detailActivity.putExtra("EXTRA_ID", hasil.getIdmatch().toString());
                detailActivity.putExtra("EXTRA_FULLNAME", hasil.getFullname().toString());

                context.startActivity(detailActivity);
//            }
            }
        });

    }

    @Override

    public int getItemCount() {
        return listHasil.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtMatch;
//        TextView txtLiga;
        TextView txtHomescore;
        TextView txtAwayscore;
        TextView txtDate;
        Button btnDetail;

        ImageView imgGambar;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDetail = itemView.findViewById(R.id.btnDetail);

            txtMatch = itemView.findViewById(R.id.txtMatchh);
            txtHomescore = itemView.findViewById(R.id.txtHomescore);
            txtAwayscore = itemView.findViewById(R.id.txtAwayscore);
            txtDate = itemView.findViewById(R.id.txtDate);
            imgGambar = itemView.findViewById(R.id.imgGambar);

        }
    }





}

