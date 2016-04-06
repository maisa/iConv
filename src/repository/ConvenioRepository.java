package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Convenio;
import model.PrestacaoContas;
import model.Usuario;
import util.BdUtil;

public class ConvenioRepository {
	private Connection dbConnection;

	public ConvenioRepository() {
		dbConnection = BdUtil.getConnection();
	}

	public void gravaArquivoPrestacao(byte[] bfile, String nr_convenio) {
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("insert into arquivo_prestacao_conta (nr_convenio,arquivo) values(?,?)");
				prepStatement.setString(1, nr_convenio);
				prepStatement.setBytes(2, bfile);

				prepStatement.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String listaConvenioByCpfProponente(String cpf_responsavel_proponente) {
		String lista = "";
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("select nr_convenio from convenio where cpf_responsavel_proponente = ?");
				prepStatement.setString(1, cpf_responsavel_proponente);

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						lista = lista + result.getString("nr_convenio") + ";";			
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	public Convenio findByNumero(String nr_convenio) {
		Convenio convenio = new Convenio();
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("select * from convenio where nr_convenio = ?");
				prepStatement.setString(1, nr_convenio);

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						
						convenio.setNr_convenio(result.getString("nr_convenio"));
						convenio.setObjeto(result.getString("objeto"));
						convenio.setTx_situacao(result.getString("tx_situacao"));
						convenio.setUf_proponente(result.getString("uf_proponente"));
						convenio.setNm_orgao_concedente(result.getString("nm_orgao_concedente"));
						convenio.setDt_inicio_vigencia(result.getString("dt_inicio_vigencia"));
						convenio.setDt_fim_vigencia(result.getString("dt_fim_vigencia"));
						convenio.setVl_convenio(new BigDecimal(result.getString("vl_convenio")));
						convenio.setVl_liberado(new BigDecimal(result.getString("vl_liberado")));
						convenio.setVl_arepassar(convenio.getVl_convenio().subtract(convenio.getVl_liberado()));
						return convenio;
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return convenio;
	}

	public List<PrestacaoContas> listaPrestacao(String nr_convenio) {
		PrestacaoContas prestacao = new PrestacaoContas();
		List<PrestacaoContas> lista = new ArrayList<PrestacaoContas>();
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("select * from prestacao_conta_convenente where nr_convenio = ?");
				prepStatement.setString(1, nr_convenio);

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						prestacao = new PrestacaoContas();
						prestacao.setData(result.getString("dt_inclusao_mov_financeira"));
						prestacao.setValor(result.getString("vl_pgto"));
						lista.add(prestacao);
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}
