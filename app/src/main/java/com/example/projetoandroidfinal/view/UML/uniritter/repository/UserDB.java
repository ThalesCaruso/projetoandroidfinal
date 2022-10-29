package com.example.projetoandroidfinal.view.UML.uniritter.repository;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetoandroidfinal.view.UML.uniritter.model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class UserDB implements Response.Listener<JSONArray>, Response.ErrorListener{
    private static final String tagLog = "UserDB";

    private static List<User> users;
    private static UserDB instance = null;

    private UserDB(Context context){
        super();
        if (users == null) {
            users = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/users";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this);
            queue.add(jaRequest);

        }
    }

    public static List<User> getUsers(){ return users; }

    public static UserDB getInstance(Context context) {

        instance = new UserDB(context);

        return instance;
    }

    @Override
    public void onResponse(JSONArray response) {
        for (int i=0;i<response.length();i++){
            try {
                JSONObject json = response.getJSONObject(i);
                users.add(new User(
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("username"),
                        json.getString("username")
                ) );
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Log.e(tagLog, tagLog+"/"+error.getMessage());
    }

}
