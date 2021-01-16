package com.example.UAS_PCS_0550;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DatangAdapter extends RecyclerView.Adapter<DatangAdapter.ListViewHolder> {

    private ArrayList<Datang> listDatang;
    private Context context;
//    private Button button;

    public DatangAdapter(ArrayList<Datang> listDatang, Context context) {
        this.listDatang = listDatang;
        this.context = context;
    }

    public DatangAdapter(ArrayList<Datang> listDatang) {
        this.listDatang = listDatang;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datang, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Datang datang = listDatang.get(position);

        holder.txtMatch.setText(datang.getMatch());
        holder.txtDate.setText(datang.getDate());

        Glide.with(context).load(listDatang.get(position).getGambar()).into(holder.imgGambar);
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailActivity = new Intent(context, detail_datang.class);
                detailActivity.putExtra("EXTRA_TITLE", datang.getMatch().toString());
                detailActivity.putExtra("EXTRA_DATE", datang.getDate().toString());
                detailActivity.putExtra("EXTRA_LIGA", datang.getLiga().toString());
                detailActivity.putExtra("EXTRA_HOME", datang.getHomescore().toString());
                detailActivity.putExtra("EXTRA_AWAY", datang.getAwayscore().toString());
                detailActivity.putExtra("EXTRA_JAM", datang.getJam().toString());
                detailActivity.putExtra("EXTRA_SEASON", datang.getSeason().toString());
                detailActivity.putExtra("EXTRA_TUAN", datang.getTuan().toString());
                detailActivity.putExtra("EXTRA_GAMBAR", datang.getGambar().toString());
                detailActivity.putExtra("EXTRA_STADION", datang.getStadion().toString());
                detailActivity.putExtra("EXTRA_ID", datang.getIdmatch().toString());
                detailActivity.putExtra("EXTRA_FULLNAME", datang.getFullname().toString());

                context.startActivity(detailActivity);
//            }
            }
        });

    }

    @Override

    public int getItemCount() {
        return listDatang.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtMatch;

        TextView txtDate;
        Button btnDetail;

        ImageView imgGambar;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            btnDetail = itemView.findViewById(R.id.btnDetail);
            txtMatch = itemView.findViewById(R.id.txtMatchh);
            txtDate = itemView.findViewById(R.id.txtDate);
            imgGambar = itemView.findViewById(R.id.imgGambar);

        }
    }
}

