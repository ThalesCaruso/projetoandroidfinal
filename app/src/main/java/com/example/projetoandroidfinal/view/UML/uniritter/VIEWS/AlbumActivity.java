package com.example.projetoandroidfinal.view.UML.uniritter.VIEWS;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetoandroidfinal.R;
import com.example.projetoandroidfinal.view.UML.uniritter.PRESENTERS.ListsPresenter;
import com.example.projetoandroidfinal.view.UML.uniritter.PRESENTERS.PresenterContract;


public class AlbumActivity extends AppCompatActivity implements PresenterContract.view{
    private static final String tagLog = "AlbumActivity";
    private PresenterContract.presenterLists presenterLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterLists = new ListsPresenter(this);

        presenterLists.setAdapterRVAlbuns( ((RecyclerView) findViewById(R.id.RVAlbuns)) );

    }

    @Override
    public void message(String msg) {

    }

    @Override
    public Activity getActivity() {
        return null;
    }
}
