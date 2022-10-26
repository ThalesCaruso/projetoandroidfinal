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
import com.example.projetoandroidfinal.view.UML.uniritter.repository.AlbunsDataBase;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.CommentsDataBase;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.PhotosDataBase;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.PostsDataBase;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.TodosDataBase;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.UserDataBase;

public class ListsPresenter implements PresenterContract.presenterLists{
    private static final String tagLog = "ListsPresenter";

    private PresenterContract.view view;
    public ListsPresenter(PresenterContract.view view) { this.view = view; }


    @Override
    public void setAdapterRVPosts(RecyclerView rv, String idUser, String nomeUser) {
        Log.d(tagLog, tagLog+"/setAdapterRVPosts");
        PostAdapter adapterPost = new PostAdapter(PostsDataBase.getPosts(), UserDataBase.getUsers());
        rv.setAdapter(adapterPost);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }


    @Override
    public void setAdapterRVComments(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVComments");
        CommentAdapter adapterComment = new CommentAdapter(CommentsDataBase.getComments());
        rv.setAdapter(adapterComment);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }



    @Override
    public void setAdapterRVAlbuns(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVAlbuns");
        AlbumAdapter adapterAlbum = new AlbumAdapter(AlbunsDataBase.getAlbuns(), UserDataBase.getUsers());
        rv.setAdapter(adapterAlbum);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }


    @Override
    public void setAdapterRVPhotos(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVPhotos");
        PhotoAdapter adapterPhoto = new PhotoAdapter(PhotosDataBase.getPhotos());
        rv.setAdapter(adapterPhoto);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );
    }



    @Override
    public void setAdapterRVTodos(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVTodos");
        TodoAdapter adapterTodo = new TodoAdapter(TodosDataBase.getTodos(), UserDataBase.getUsers());
        rv.setAdapter(adapterTodo);
        rv.setLayoutManager( new LinearLayoutManager( view.getActivity() ) );

    }


    @Override
    public void setAdapterRVUsers(RecyclerView rv) {
        Log.d(tagLog, tagLog+"/setAdapterRVUsers");
        UserAdapter adapterUser = new UserAdapter(UserDataBase.getUsers());
        rv.setAdapter(adapterUser);
        rv.setLayoutManager(new LinearLayoutManager(view.getActivity()));
    }

}
