package br.com.adem.iconv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.adem.iconv.model.Convenio;

public class AvaliacaoPassoUmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_passo_um);

        Convenio convenio = (Convenio) getIntent().getSerializableExtra("convenio");
        if (convenio != null) {
            TextView txtConvenioTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConvenioTelaAvaliacaoUm);
            TextView txtConcedenteTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConcedenteTelaAvaliacaoUm);
            TextView txtConvenenteTelaAvaliacaoUm = (TextView) findViewById(R.id.txtConvenenteTelaAvaliacaoUm);

            txtConvenioTelaAvaliacaoUm.setText(convenio.getConvenio());
            txtConcedenteTelaAvaliacaoUm.setText(convenio.getConcedente());
            txtConvenenteTelaAvaliacaoUm.setText(convenio.getConvenente());
        }
    }
}
