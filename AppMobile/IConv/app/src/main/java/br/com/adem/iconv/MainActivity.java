package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Abrindo Tela Principal.", Toast.LENGTH_LONG).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putString("estado", "Amazonas");

        Intent listaConveniosActivity = new Intent(this, ListaConveniosActivity.class);

        startActivity(listaConveniosActivity);
    }

    public void abrirTelaConfiguracao(View view) {
        Toast.makeText(this, "Carregando as preferências.", Toast.LENGTH_LONG).show();

        Intent configuracaoActivity = new Intent(this, ConfiguracaoActivity.class);
        startActivity(configuracaoActivity);
    }
}
