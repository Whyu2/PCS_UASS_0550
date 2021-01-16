package com.example.UAS_PCS_0550.ui.main;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.UAS_PCS_0550.Favorite;
import com.example.UAS_PCS_0550.MainActivity;
import com.example.UAS_PCS_0550.R;

import java.util.ArrayList;


public class FavoriteFragment extends Fragment {

    SwipeRefreshLayout refresh;
    ArrayList<Favorite> arrayFavorite = new ArrayList<Favorite>();
    RecyclerView rv_favorite;


//    void setData(String jsonString){
//        try {
//            InputStream is =getResources().openRawResource(R.raw.data);
//            Writer writer = new StringWriter();
//            char[] buffer = new char[1024];
//            try {
//                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//                int n;
//                while ((n=reader.read(buffer))!= -1){
//                    writer.write(buffer,0,n);
//                }
//            } finally {
//                is.close();
//            }
//
//            jsonMovie = writer.toString();
//
//            JSONObject jsonObjectData = new JSONObject(jsonMovie);
//            JSONArray jsonArray = new JSONArray(jsonObjectData.getString("events").toString());
//
//            listMovie = new ArrayList<>();
//            for (int i=0;i<jsonArray.length();i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//
//                Log.d("Data", jsonObject.getString("strEvent"));
//
//                Movie mov = new Movie(jsonObject.getString("strEvent"), jsonObject.getString("dateEvent"), jsonObject.getString("intHomeScore"), jsonObject.getString("intAwayScore"), jsonObject.getString("strLeague"),  jsonObject.getString("strSeason"), jsonObject.getString("strTime"), jsonObject.getString("strHomeTeam"),jsonObject.getString("strVenue"),jsonObject.getString("strThumb"),jsonObject.getString("idEvent"));
//                listMovie.add(mov);
//            }
//        } catch (IOException | JSONException e){
//            e.printStackTrace();
//        }
//
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        refresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        refresh.setOnRefreshListener(() -> {

            Intent i = new Intent(getContext(), MainActivity.class);
            startActivity(i);
            refresh.setRefreshing(false);
        });


        final SQLiteDatabase mydatabase = getActivity().openOrCreateDatabase("database_0550",android.content.Context.MODE_PRIVATE,null);

        Cursor res =  mydatabase.rawQuery( "SELECT * FROM favorit", null );

        res.moveToFirst();

        rv_favorite = view.findViewById(R.id.rv_favorite);

        while(res.isAfterLast() == false){
            String idMatch = res.getString(0);
            String match = res.getString(1);
            String homescore = res.getString(2);
            String awayscore = res.getString(3);

            arrayFavorite.add(new Favorite(idMatch,match,homescore,awayscore));
            res.moveToNext();
        }

        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(container.getContext(),arrayFavorite);

        rv_favorite.setAdapter(favoriteAdapter);
        rv_favorite.setLayoutManager(new LinearLayoutManager(container.getContext()));


        return view;
    }
}