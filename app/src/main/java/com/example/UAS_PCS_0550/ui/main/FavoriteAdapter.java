package com.example.UAS_PCS_0550.ui.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.UAS_PCS_0550.Favorite;
import com.example.UAS_PCS_0550.R;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ListViewHolder> {

    Context context;
    ArrayList<Favorite> favorite;
//    private Button button;

    public FavoriteAdapter(Context context, ArrayList<Favorite> favorite) {
        this.context=context;
        this.favorite=favorite;
    }


    @NonNull
    @Override
    public FavoriteAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new FavoriteAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ListViewHolder holder, int position) {


        holder.txtMatch.setText(favorite.get(position).getMatch());
        holder.txthomescore.setText(favorite.get(position).getHomescore());
        holder.txtawayscore.setText(favorite.get(position).getAwayscore());

        holder.btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SQLiteDatabase mydatabase = context.openOrCreateDatabase("database_0550",android.content.Context.MODE_PRIVATE,null);
                mydatabase.execSQL(String.format("DELETE FROM favorit WHERE idevent='%s'",favorite.get(position).getIdMatch()));
                Toast.makeText(context.getApplicationContext(),
                        "Data favorit berhasil dihapus", Toast.LENGTH_LONG).show();
            }
        });

//        holder.txtDate.setText(movie.getDate());
//        holder.txtLiga.setText(movie.getLiga());
//        holder.txtHomescore.setText(movie.getHomescore());
//        holder.txtAwayscore.setText(movie.getAwayscore());

//        Glide.with(context)
//                .load("" + movie.getGambar().toString())
//                .into(holder.imgGambar);



    }







    @Override

    public int getItemCount() {
        return favorite.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtMatch;
        TextView txthomescore;
        TextView txtawayscore;
        Button btnHapus;

//        Button btnDetail;

        ImageView imgGambar;

//        ImageView imgPoster;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
//            btnDetail = itemView.findViewById(R.id.btnDetail);
            txtMatch = itemView.findViewById(R.id.txtMatchh);
            txthomescore = itemView.findViewById(R.id.txtHomescore);
            txtawayscore = itemView.findViewById(R.id.txtAwayscore);
            btnHapus = itemView.findViewById(R.id.btnHapus);
//            txtHomescore = itemView.findViewById(R.id.txtHomescore);
//            txtAwayscore = itemView.findViewById(R.id.txtAwayscore);
//            txtDate = itemView.findViewById(R.id.txtDate);
//            imgGambar = itemView.findViewById(R.id.imgGambar);

//            imgPoster = itemView.findViewById(R.id.imgPoster);
        }
    }





}


