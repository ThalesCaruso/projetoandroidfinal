package com.example.projetoandroidfinal.view.UML.uniritter.presenter;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoandroidfinal.view.UML.uniritter.adapters.UserAdapter;
import com.example.projetoandroidfinal.view.UML.uniritter.adapters.TodoAdapter;
import com.example.projetoandroidfinal.view.UML.uniritter.adapters.PostAdapter;
import com.example.projetoandroidfinal.view.UML.uniritter.adapters.PhotoAdapter;
import com.example.projetoandroidfinal.view.UML.uniritter.adapters.CommentAdapter;
import com.example.projetoandroidfinal.view.UML.uniritter.adapters.AlbumAdapter;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.AlbumDB;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.CommentDB;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.PhotoDB;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.PostDB;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.TodosDB;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.UserDB;

public class ListsPresenter implements PresenterContract.presenterLists{
    private static final String tagLog = "ListsPresenter";

    private PresenterContract.view view;
    public ListsPresenter(PresenterContract.view view) { this.view = view; }


    @Override
    public void setAdapterRVPosts(RecyclerView rv, String idUser, String nomeUser) {
        Log.d(tagLog, tagLog+"/setAdapterRVPosts");
        PostAdapter adapterPost = new PostAdapter(PostDB.getPosts(), UserDB.getUsers());
        rv.setAdapter(adapterPost);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }


    @Override
    public void setAdapterRVComments(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVComments");
        CommentAdapter adapterComment = new CommentAdapter(CommentDB.getComments());
        rv.setAdapter(adapterComment);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }



    @Override
    public void setAdapterRVAlbuns(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVAlbuns");
        AlbumAdapter adapterAlbum = new AlbumAdapter(AlbumDB.getAlbuns(), UserDB.getUsers());
        rv.setAdapter(adapterAlbum);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }


    @Override
    public void setAdapterRVPhotos(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVPhotos");
        PhotoAdapter adapterPhoto = new PhotoAdapter(PhotoDB.getPhotos());
        rv.setAdapter(adapterPhoto);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }



    @Override
    public void setAdapterRVTodos(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVTodos");
        TodoAdapter adapterTodo = new TodoAdapter(TodosDB.getTodos(), UserDB.getUsers());
        rv.setAdapter(adapterTodo);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );

    }


    @Override
    public void setAdapterRVUsers(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVUsers");
        UserAdapter adapterUser = new UserAdapter(UserDB.getUsers());
        rv.setAdapter(adapterUser);
        rv.setLayoutManager(new LinearLayoutManager(view.getActivity()));
    }

}
