package com.example.projetoandroidfinal.view.UML.uniritter.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoandroidfinal.R;
import com.example.projetoandroidfinal.view.UML.uniritter.model.User;
import com.example.projetoandroidfinal.view.UML.uniritter.presenter.PerfilPresenter;
import com.example.projetoandroidfinal.view.UML.uniritter.presenter.PresenterContract;
import com.example.projetoandroidfinal.view.UML.uniritter.repository.UserDataBase;

public class PerfilUserActivity extends AppCompatActivity implements PresenterContract.view  {
    private static final String tagLog = "PerfilUserActivity";

    private PresenterContract.presenterPerfil presenterPerfil;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterPerfil = new PerfilPresenter(this);
        user = getIntent().getParcelableExtra("USER_OBJECT");

        ((TextView) findViewById(R.id.tvIdUser)).setText("ID: "+Integer.toString( user.getId() ));
        ((TextView) findViewById(R.id.tvNomeUser)).setText("Nome: "+user.getNome());
        ((TextView) findViewById(R.id.tvLoginUser)).setText("Login: "+user.getLogin());

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void message(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show(); }

    @Override
    public Activity getActivity() { return this; }

    public void logUsers() {
        for (int i = 0; i< UserDataBase.getUsers().size(); i++){
            Log.d("users",
                    "ID: "+Integer.toString(UserDataBase.getUsers().get(i).getId())+
                            " | Nome: "+UserDataBase.getUsers().get(i).getNome().toString()+
                            " | Login: "+UserDataBase.getUsers().get(i).getLogin().toString()
            );
        }
    }
}
