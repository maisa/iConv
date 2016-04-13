package br.com.adem.iconv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import br.com.adem.iconv.model.Convenio;
import br.com.adem.iconv.model.Estado;
import br.com.adem.iconv.model.Municipio;

public class AvaliacaoPassoDoisActivity extends AppCompatActivity {

    private Button btConfirmaAvalicao;
    private Convenio convenioSelecionado;
    private Estado estadoSelecionado;
    private Municipio municipioSelecionado;

    private static HashMap<Integer, String> mapQuestao;
    static {
        mapQuestao = new HashMap<Integer, String>();
        mapQuestao.put(1, "A prestação de contas é suspeita.");
        mapQuestao.put(2, "Os valores são suspeitos.");
        mapQuestao.put(3, "O convenente é suspeito.");
        mapQuestao.put(4, "O objetivo do convênio não foi alcançado.");
        mapQuestao.put(5, "Outros motivos.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_passo_dois);

        estadoSelecionado = (Estado) getIntent().getSerializableExtra("estado");
        municipioSelecionado = (Municipio) getIntent().getSerializableExtra("municipio");
        convenioSelecionado = (Convenio) getIntent().getSerializableExtra("convenio");

        // capturando o botao btConfirmaAvalicao do XML pela ID.
        btConfirmaAvalicao = (Button) findViewById(R.id.btConfirmaAvalicao);
        // Evento de click do botao btConfirmaAvalicao.
        btConfirmaAvalicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Sua opinião foi registrada!", Toast.LENGTH_SHORT).show();
                Intent listaConveniosActivity = new Intent(v.getContext(), ListaConveniosActivity.class);
                listaConveniosActivity.putExtra("convenio", convenioSelecionado);
                listaConveniosActivity.putExtra("estado", estadoSelecionado);
                listaConveniosActivity.putExtra("municipio", municipioSelecionado);
                startActivity(listaConveniosActivity);
            }
        });
    }

    public void voltarTelaAvaliacaoPassoUm(View view) {
        Intent voltarTelaActivity = new Intent(view.getContext(), AvaliacaoPassoUmActivity.class);
        voltarTelaActivity.putExtra("convenio", convenioSelecionado);
        voltarTelaActivity.putExtra("estado", estadoSelecionado);
        voltarTelaActivity.putExtra("municipio", municipioSelecionado);
        startActivity(voltarTelaActivity);
    }
}
