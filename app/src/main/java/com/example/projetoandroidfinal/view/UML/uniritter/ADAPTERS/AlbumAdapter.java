package com.example.projetoandroidfinal.view.UML.uniritter.ADAPTERS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetoandroidfinal.R;
import com.example.projetoandroidfinal.view.UML.uniritter.MODELS.Albuns;
import com.example.projetoandroidfinal.view.UML.uniritter.MODELS.User;


import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Albuns> dadosAlbuns;
    private List<User> dadosUser;

    public AlbumAdapter(List<Albuns> dadosAlbuns, List<User> dadosUser) {
        this.dadosAlbuns = dadosAlbuns;
        this.dadosUser = dadosUser;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_album_list, parent, false);
        return new AlbumViewHolder(layoutViewHolder);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Albuns objAlbuns = dadosAlbuns.get(position);
        User objUser = dadosUser.get( objAlbuns.getUserID()-1 );
        if ( objUser.getId() == objAlbuns.getUserID() ) {
            ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.tvUserIdAlbum)).setText("User: "+objUser.getNome());
            ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.tvIdAlbum)).setText("ID: "+Integer.toString(objAlbuns.getId()));
            ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.tvTituloAlbum)).setText("Titulo: "+ objAlbuns.getTitle());
        }

    }



    @Override
    public int getItemCount() { return dadosAlbuns.size(); }



}
class AlbumViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public AlbumViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
    }
}