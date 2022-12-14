package com.example.projetoandroidfinal.view.UML.uniritter.REPOSITORY;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetoandroidfinal.view.UML.uniritter.MODELS.Posts;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PostDB implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "PostDB";

    private static List<Posts> posts;
    private static PostDB instance = null;

    private PostDB(Context context){
        super();
        if (posts == null){
            posts = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/posts";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this);
            queue.add(jaRequest);

        }
    }

    public static List<Posts> getPosts() { return posts; }

    public static PostDB getInstance(Context context){
        instance = new PostDB(context);
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
                posts.add( new Posts(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("body")
                ) );
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}
