package com.example.projetoandroidfinal.view.UML.uniritter.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoandroidfinal.R;
import com.example.projetoandroidfinal.view.UML.uniritter.presenter.ListsPresenter;
import com.example.projetoandroidfinal.view.UML.uniritter.presenter.PresenterContract;

public class TodosActivity extends AppCompatActivity implements PresenterContract.view{
    private static final String tagLog = "TodosActivity";
    private PresenterContract.presenterLists presenterLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterLists = new ListsPresenter(this);

        presenterLists.setAdapterRVTodos( ((RecyclerView) findViewById(R.id.RVTodos)) );

    }

    @Override
    public void message(String msg) { /**/ }

    @Override
    public Activity getActivity() { return this; }
}