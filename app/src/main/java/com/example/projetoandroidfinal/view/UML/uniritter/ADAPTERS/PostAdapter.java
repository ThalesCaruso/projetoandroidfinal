package com.example.projetoandroidfinal.view.UML.uniritter.ADAPTERS;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetoandroidfinal.R;
import com.example.projetoandroidfinal.view.UML.uniritter.MODELS.Posts;
import com.example.projetoandroidfinal.view.UML.uniritter.MODELS.User;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Posts> dadosPosts;
    private List<User> dadosUser;



    public PostAdapter(List<Posts> dadosPosts, List<User> dadosUser) {
        this.dadosPosts = dadosPosts;
        this.dadosUser = dadosUser;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_posts_list, parent, false);
        return new PostViewHolder(layoutViewHolder);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Posts objPost = dadosPosts.get(position);
        User objUser = dadosUser.get( objPost.getUserID()-1 );

        if ( objUser.getId() == objPost.getUserID() ){
            ((TextView)((PostViewHolder) holder).view.findViewById(R.id.tvNomeUserPostRV)).setText("User: "+objUser.getNome());
            ((TextView)((PostViewHolder) holder).view.findViewById(R.id.tvIdPostRV)).setText("ID: "+Integer.toString(objPost.getId() ) );
            ((TextView)((PostViewHolder) holder).view.findViewById(R.id.tvTituloPostRV)).setText("Titulo: "+objPost.getTitle());
            ((TextView)((PostViewHolder) holder).view.findViewById(R.id.tvBodyPostRV)).setText(" "+objPost.getBody());
        }

    }

    @Override
    public int getItemCount() {
        return dadosPosts.size();
    }

}


class PostViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public PostViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
    }
}
