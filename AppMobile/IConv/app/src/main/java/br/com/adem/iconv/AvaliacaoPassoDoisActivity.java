package br.com.adem.iconv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.adem.iconv.model.Convenio;

public class AvaliacaoPassoDoisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_passo_dois);

        final Convenio convenio = (Convenio) getIntent().getSerializableExtra("convenio");
        if (convenio != null) {
            TextView txtConvenioTelaAvaliacaoDois = (TextView) findViewById(R.id.txtConvenioTelaAvaliacaoDois);
            TextView txtConcedenteTelaAvaliacaoDois = (TextView) findViewById(R.id.txtConcedenteTelaAvaliacaoDois);
            TextView txtConvenenteTelaAvaliacaoDois = (TextView) findViewById(R.id.txtConvenenteTelaAvaliacaoDois);

            txtConvenioTelaAvaliacaoDois.setText(convenio.getConvenio());
            txtConcedenteTelaAvaliacaoDois.setText(convenio.getConcedente());
            txtConvenenteTelaAvaliacaoDois.setText(convenio.getConvenente());
        }
    }
}
