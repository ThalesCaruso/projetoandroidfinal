package com.example.projetoandroidfinal.view.UML.uniritter.REPOSITORY;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetoandroidfinal.view.UML.uniritter.MODELS.Todos;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class TodosDB implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "TodosDB";

    private static List<Todos> todos;
    private static TodosDB instance = null;

    private TodosDB(Context context){
        super();
        if (todos == null){
            todos = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/todos";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this );
            queue.add(jaRequest);
        }
    }

    public static List<Todos> getTodos(){ return todos; }

    public static TodosDB getInstance(Context context){
        instance = new TodosDB(context);
        return instance;
    }

    @Override
    public void onErrorResponse(VolleyError error) { Log.e(tagLog, tagLog+"/"+error.getMessage()); }

    @Override
    public void onResponse(JSONArray response) {
        for (int i=0;i< response.length();i++){
            try{
                JSONObject json = response.getJSONObject(i);
                todos.add( new Todos(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getBoolean("completed")
                ) );
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}

