package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirTelaConfiguracao(View view) {
        Intent configuracaoActivity = new Intent(this, ConfiguracaoActivity.class);
        startActivity(configuracaoActivity);
    }

    public void abrirTelaListaConvenios(View view) {
        String estado = "Roraima";
        String municipio = "Boa Vista";

        Intent listaConveniosActivity = new Intent(this, ListaConveniosActivity.class);
        listaConveniosActivity.putExtra("estado", estado);
        listaConveniosActivity.putExtra("municipio", municipio);
        startActivity(listaConveniosActivity);
    }
}
