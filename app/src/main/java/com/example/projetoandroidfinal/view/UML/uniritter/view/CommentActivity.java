package com.example.projetoandroidfinal.view.UML.uniritter.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoandroidfinal.R;
import com.example.projetoandroidfinal.view.UML.uniritter.presenter.ListsPresenter;
import com.example.projetoandroidfinal.view.UML.uniritter.presenter.PresenterContract;

public class CommentActivity extends AppCompatActivity implements PresenterContract.view{
    private static final String tagLog = "CommentActivity";
    private PresenterContract.presenterLists presenterLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterLists = new ListsPresenter(this);

        presenterLists.setAdapterRVComments( ((RecyclerView) findViewById(R.id.RVComments)) );

    }

    @Override
    public void message(String msg) { /**/ }
    @Override
    public Activity getActivity() { return this; }
}
