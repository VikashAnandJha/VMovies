package com.vaj.vmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vaj.vmovies.Adapters.MovieListAdapter;
import com.vaj.vmovies.Modal.MoviesListModal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView nowPlayingRV;
    private RecyclerView.Adapter nowPlayingAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList nowPlayingResults;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();



        //// Get Now Playing

        nowPlayingResults = new ArrayList<MoviesListModal>();
        nowPlayingRV = (RecyclerView) findViewById(R.id.nowPlayingMovieRv);
        nowPlayingRV.setHasFixedSize(false);
         mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        nowPlayingRV.setLayoutManager(mLayoutManager);

        nowPlayingAdapter = new MovieListAdapter(this, nowPlayingResults);
        nowPlayingRV.setAdapter(nowPlayingAdapter);






        searchView=(SearchView)findViewById(R.id.searchInput);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(s.length()>1)
                searchMovie(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(s.length()>1)
                searchMovie(searchView.getQuery().toString()+"");
                return false;
            }
        });

    }


    private void searchMovie(String q)
    { RequestQueue queue = Volley.newRequestQueue(this);
        String url = Config.API_SEARCH_MOVIE_URL+"&query="+q;

        Log.d("profile",url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {


                       // Log.d("response",response);



                        try {
                            JSONObject resp = new JSONObject(response);
                           JSONArray jArray = new JSONArray(resp.getString("results"));
                           //
                            if(nowPlayingResults.size()>0){


                                nowPlayingResults.clear();
                                ((MovieListAdapter) nowPlayingAdapter).clear();
                            }

                            for (int i = 0; i < jArray.length(); i++) {


                                JSONObject json_data = jArray.getJSONObject(i);


                               // Log.d("response",json_data.getString("title"));

                                String title=json_data.getString("title");
                                String poster=json_data.getString("poster_path");

                                MoviesListModal   obj = new MoviesListModal(11,"imdb122",title,"https://image.tmdb.org/t/p/w300"+poster,"","Graeat movie","9.2","20-2-2019","en");

                                ((MovieListAdapter) nowPlayingAdapter).addItem(obj, i);

nowPlayingAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            Log.e("log_tag", "Error parsing data " + e.toString());
                        }

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);

    }
}
