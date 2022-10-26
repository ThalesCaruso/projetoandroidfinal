package com.example.projetoandroidfinal.view.UML.uniritter.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetoandroidfinal.R;
import com.example.projetoandroidfinal.view.UML.uniritter.model.User;
import com.example.projetoandroidfinal.view.UML.uniritter.view.PerfilUserActivity;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> dados;

    public UserAdapter(List<User> dados) { this.dados = dados; }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user_list, parent, false);
        return new UserViewHolder(layoutViewHolder);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User objUser = dados.get(position);
        ((TextView)((UserViewHolder) holder).view.findViewById(R.id.tvIdUserRV)).setText("ID: "+Integer.toString( objUser.getId() ) );
        ((TextView)((UserViewHolder) holder).view.findViewById(R.id.tvNomeUserRV)).setText("Nome: "+objUser.getNome());
        ((TextView)((UserViewHolder) holder).view.findViewById(R.id.tvLoginUserRV)).setText("Login: "+objUser.getLogin());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), PerfilUserActivity.class);
                intent.putExtra("USER_OBJECT", objUser);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}



class UserViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }
}

