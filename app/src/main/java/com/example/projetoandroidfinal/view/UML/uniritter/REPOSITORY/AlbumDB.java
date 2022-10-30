package com.example.projetoandroidfinal.view.UML.uniritter.REPOSITORY;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetoandroidfinal.view.UML.uniritter.MODELS.Albuns;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class AlbumDB implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "AlbumDB";

    private static List<Albuns> albuns;
    private static AlbumDB instance = null;

    private AlbumDB(Context context){
        super();
        if (albuns == null){
            albuns = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/albums";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this );
            queue.add(jaRequest);
        }
    }

    public static List<Albuns> getAlbuns() { return albuns; }

    public static AlbumDB getInstance(Context context){
        instance = new AlbumDB(context);
        return instance;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(tagLog, tagLog+"/"+error.getMessage());
    }

    @Override
    public void onResponse(JSONArray response) {
        for (int i=0;i< response.length();i++){
            try{
                JSONObject json = response.getJSONObject(i);
                albuns.add( new Albuns(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title")
                ));
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}

