package br.com.adem.iconv;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.adem.iconv.model.Convenio;
import br.com.adem.iconv.model.Estado;
import br.com.adem.iconv.model.Municipio;
import br.com.adem.iconv.model.Pagamento;

public class PrestacaoContasActivity extends AppCompatActivity {

    private Convenio convenioSelecionado;
    private Estado estadoSelecionado;
    private Municipio municipioSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestacao_contas);

        estadoSelecionado = (Estado) getIntent().getSerializableExtra("estado");
        municipioSelecionado = (Municipio) getIntent().getSerializableExtra("municipio");
        convenioSelecionado = (Convenio) getIntent().getSerializableExtra("convenio");

        String[] de = {"data", "valor", "fornecedor", "cnpj", "notafiscal"};
        int[] para = {R.id.txtDataPagamento, R.id.txtValor, R.id.txtFornecedor, R.id.txtCnpj, R.id.txtNotaFiscal};
        final SimpleAdapter aPagamento= new SimpleAdapter(this, listarPagamentos(convenioSelecionado), R.layout.layout_lista_pagamentos, de, para);
        final ListView listaPagamento = (ListView) findViewById(R.id.listViewListaPagamentosEfetuados);
        listaPagamento.setAdapter(aPagamento);
    }

    private List<? extends Map<String, ?>> listarPagamentos(Convenio convenio) {
        List<Map<String, Object>> listaPagamentos = new ArrayList<Map<String, Object>>();
        if (convenio != null && convenio.getPagamentoList() != null && convenio.getPagamentoList().isEmpty() == false) {
            for (Pagamento pagamento : convenio.getPagamentoList()) {
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("data", pagamento.getData());
                item.put("valor", pagamento.getValor());
                item.put("cnpj", pagamento.getCnpjFornecedor());
                item.put("fornecedor", pagamento.getFornecedor());
                listaPagamentos.add(item);
            }
        }
        return listaPagamentos;
    }

    public void voltarTelaAvaliacaoPassoUm(View view) {
        Intent voltarTelaActivity = new Intent(view.getContext(), AvaliacaoPassoUmActivity.class);
        voltarTelaActivity.putExtra("convenio", convenioSelecionado);
        voltarTelaActivity.putExtra("estado", estadoSelecionado);
        voltarTelaActivity.putExtra("municipio", municipioSelecionado);
        startActivity(voltarTelaActivity);
    }
}
