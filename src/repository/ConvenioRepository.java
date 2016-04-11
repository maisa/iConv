package repository;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import model.AvaliacaoUsuario;
import model.Convenio;
import model.PrestacaoContaArquivo;
import model.PrestacaoContas;
import model.RankingAvaliacoes;
import model.Usuario;
import util.BdUtil;

public class ConvenioRepository {
	private Connection dbConnection;

	public ConvenioRepository() {
		dbConnection = BdUtil.getConnection();
	}	

	public void gravaArquivoPrestacao(byte[] bfile, String nome, String tipo, String nr_convenio) {
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("insert into arquivo_prestacao_conta (nr_convenio,arquivo,nome_arquivo,tipo_arquivo) values(?,?,?,?)");
				
				prepStatement.setString(1, nr_convenio);
				prepStatement.setBytes(2, bfile);
				prepStatement.setString(3, nome);
				prepStatement.setString(4, tipo);

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
						.prepareStatement("select nr_convenio from gestor_convenente_convenio where cpf_gestor = ?");
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
						convenio.setUf_proponente(result.getString("uf"));
						convenio.setNm_orgao_concedente(result.getString("nome_concedente"));
						convenio.setDt_inicio_vigencia(result.getString("dt_inicio_vigencia"));
						convenio.setDt_fim_vigencia(result.getString("dt_fim_vigencia"));
						convenio.setVl_convenio(new BigDecimal(result.getString("vl_convenio")));
						convenio.setVl_liberado(new BigDecimal(result.getString("vl_liberado")));
						convenio.setVl_contrapartida(new BigDecimal(result.getString("vl_contrapartida")));
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
	
	public List<RankingAvaliacoes> rankingAvaliacoes() {
		RankingAvaliacoes ranking = new RankingAvaliacoes();
		List<RankingAvaliacoes> lista = new ArrayList<RankingAvaliacoes>();
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("select a.nr_convenio,c.nome_concedente,c.nome_convenente,c.objeto, COUNT(DISTINCT(id_app)) n_reprovacoes from avaliacao a, convenio c where a.nr_convenio = c.nr_convenio group by a.nr_convenio,c.nome_concedente,c.nome_convenente,c.objeto order by n_reprovacoes desc ");


				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						ranking = new RankingAvaliacoes();
						ranking.setNr_convenio(result.getString("nr_convenio"));
						ranking.setNome_concedente(result.getString("nome_concedente"));
						ranking.setNome_convenente(result.getString("nome_convenente"));
						ranking.setObjeto(result.getString("objeto"));
						ranking.setN_reprovacoes(result.getString("n_reprovacoes"));
						lista.add(ranking);
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	public List<AvaliacaoUsuario> listaAvaliacoes(String nr_convenio) {
		AvaliacaoUsuario avaliacao = new AvaliacaoUsuario();
		List<AvaliacaoUsuario> lista = new ArrayList<AvaliacaoUsuario>();
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("select a.nr_convenio, q.tx_questao, count(*) as quantidade from avaliacao a, questao q where a.id_questao = q.id_questao and  a.nr_convenio = ? group by a.id_questao,q.tx_questao,a.nr_convenio ");
				prepStatement.setString(1, nr_convenio);

				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						avaliacao = new AvaliacaoUsuario();
						avaliacao.setNr_convenio(result.getString("nr_convenio"));
						avaliacao.setResposta(result.getString("tx_questao"));
						avaliacao.setQuantidade(result.getString("quantidade"));
						lista.add(avaliacao);
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	public List<PrestacaoContaArquivo> listaPrestacaoArquivo(String nr_convenio) {
		PrestacaoContaArquivo prestacaoArquivo = new PrestacaoContaArquivo();
		List<PrestacaoContaArquivo> lista = new ArrayList<PrestacaoContaArquivo>();
		if (dbConnection != null) {
			try {				
				PreparedStatement prepStatement = dbConnection
						.prepareStatement("select * from arquivo_prestacao_conta where nr_convenio = ?");
				prepStatement.setString(1, nr_convenio);
				File f = null;
				ResultSet result = prepStatement.executeQuery();
				if (result != null) {
					while (result.next()) {
						prestacaoArquivo = new PrestacaoContaArquivo();
						prestacaoArquivo.setNr_convenio(result.getString("nr_convenio"));
						byte [] bytes = result.getBytes("arquivo");
						if (bytes == null) {
							continue;
						}
						
						ServletContext context = ServletActionContext.getServletContext();
						System.out.println(context.getRealPath("/assets"));
						
						prestacaoArquivo.setNome_arquivo(result.getString("nome_arquivo"));
						
						f = new File(context.getRealPath("/assets/")+prestacaoArquivo.getNome_arquivo());
				        FileOutputStream fos = new FileOutputStream( f);
				           
				        fos.write( bytes );
				        fos.close();
						
						prestacaoArquivo.setArquivo(f);
						
						lista.add(prestacaoArquivo);
						
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}
