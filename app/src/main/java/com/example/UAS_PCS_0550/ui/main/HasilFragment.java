package com.example.UAS_PCS_0550.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.UAS_PCS_0550.Hasil;
import com.example.UAS_PCS_0550.HasilAdapter;
import com.example.UAS_PCS_0550.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class  HasilFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_playing, container, false);

        final RecyclerView rv_movie = view.findViewById(R.id.rv_movie);
        RequestQueue queue = Volley.newRequestQueue(container.getContext());
        String url ="https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328";

        final ArrayList<Hasil> hasil = new ArrayList<Hasil>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray events = obj.getJSONArray("events");
                            for(int x=0;x<events.length();x++){
                                JSONObject item = events.getJSONObject(x);
                                String match = item.getString("strEvent");
                                String date = item.getString("dateEvent");
                                String homescore = item.getString("intHomeScore");
                                String awayscore = item.getString("intAwayScore");
                                String liga = item.getString("strLeague");
                                String season = item.getString("strSeason");
                                String jam = item.getString("strTime");
                                String tuan = item.getString("strHomeTeam");
                                String stadion = item.getString("strVenue");
                                String gambar = item.getString("strThumb");
                                String id = item.getString("idEvent");
                                String fullname = item.getString("strFilename");


                                hasil.add(new Hasil(match,date,homescore,awayscore,liga,season,jam,tuan,stadion,gambar,id,fullname));

                                HasilAdapter hasilAdapter = new HasilAdapter(hasil, container.getContext());


                                rv_movie.setAdapter(hasilAdapter);
                                rv_movie.setLayoutManager(new LinearLayoutManager(container.getContext()));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });


        queue.add(stringRequest);


        return view;
    }
}