package com.example.projetoandroidfinal.view.UML.uniritter.VIEWS;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoandroidfinal.R;
import com.example.projetoandroidfinal.view.UML.uniritter.PRESENTERS.CadastroPresenter;
import com.example.projetoandroidfinal.view.UML.uniritter.PRESENTERS.PresenterContract;

public class CadastroActivity extends AppCompatActivity implements PresenterContract.view{
    private static final String tagLog = "CadastroActivity";
    private PresenterContract.presenterCadastro presenterCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterCadastro = new CadastroPresenter(this);

        ((Button)findViewById(R.id.btEnviarCadastro)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenterCadastro.criarUsuario(
                        ((EditText)findViewById(R.id.etNomeCadastro)).getText().toString(),
                        ((EditText)findViewById(R.id.etLoginCadastro)).getText().toString(),
                        ((EditText)findViewById(R.id.etSenhaCadastro)).getText().toString()
                );
            }
        });
    }

    @Override
    public void message(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show(); }

    @Override
    public Activity getActivity() { return this; }
}
