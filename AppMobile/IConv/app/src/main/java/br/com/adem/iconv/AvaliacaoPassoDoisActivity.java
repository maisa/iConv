package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.adem.iconv.model.Convenio;

public class AvaliacaoPassoDoisActivity extends AppCompatActivity {

    private Button btConfirmaAvalicao;
    private Convenio convenioSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_passo_dois);

        convenioSelecionado = (Convenio) getIntent().getSerializableExtra("convenio");

        // capturando o botao btConfirmaAvalicao do XML pela ID.
        btConfirmaAvalicao = (Button) findViewById(R.id.btConfirmaAvalicao);
        // Evento de click do botao btConfirmaAvalicao.
        btConfirmaAvalicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Avaliação Confirmada!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void voltarTelaAvaliacaoPassoUm(View view) {
        Intent voltarTelaActivity = new Intent(view.getContext(), AvaliacaoPassoUmActivity.class);
        voltarTelaActivity.putExtra("convenio", convenioSelecionado);
        startActivity(voltarTelaActivity);
    }
}
