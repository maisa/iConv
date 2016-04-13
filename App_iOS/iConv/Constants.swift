//
//  Constants.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/6/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation


let URL_BASE = "http://api.convenios.gov.br/siconv/v1/consulta/municipios.json?uf="

let estados = ["AC","AL","AM","AP","BA","CE","DF","ES","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN","RS","RO","RR","SC","SE","SP","TO"]


let estadosNome = [["AC","Acre"], ["AL","Alagoas"], ["AM","Amazonas"],["AP","Amapá"],["BA","Bahia"],["CE","Ceará"],["DF","Distrito Federal"],["ES","Espírito Santo"],["GO","Goiás"],["MA","Maranhão"],["MG","Minas Gerais"],["MS","Mato Grosso do Sul"],["MT","Mato Grosso"],["PA","Pará"],["PB","Paraíba"],["PE","Pernambuco"],["PI","Piauí"],["PR","Paraná"],["RJ","Rio de Janeiro"],["RN","Rio Grande do Norte"],["RS","Rio Grande do Sul"],["RO","Rondônia"],["RR","Roraima"],["SC","Santa Catarina"],["SE","Sergipe"],["SP","São Paulo"],["TO","Tocantins"]]


let numConvenio = ["801847","797382","793507","793474","792558","792504","792129","791946","790639","785408","782978","782748","782643","782455"
,"779430","779428","776823","776448","776371","774378","774259"]

let objetoResumido = ["O exame Nacional do Ensino Medio  ENEM e um evento de magnitude nacional, de natureza democratica onde os candidatos concorrem em mesmas condicoes, tendo em vista aplicacao padrao de avaliacao, ao acesso as Instituicoes de Ensino Superior - IES. Isto posto presume-se a participacao substantiva de grande parte da sociedade (previsao de mais de sete milhoes de candidatos inscritos nas proximas edicoes e quatrocentas mi", "Estudos e pesquisas voltados para acoes de vigilancia, prevencao e controle da Malaria.", "Implantacao de 25 (vinte e cinco) nucleos do Programa de  Esporte e Lazer da Cidade - PELC  NUCLEO URBANO no municipio de MANAUS/AM.", "FORTALECIMENTO DA DELEGACIA ESPECIALIZADA DE HOMICIDIOS E SEQUESTRO DO ESTADO DO AMAZONAS.", "MUNICIPALIZACAO DA PROTECAO E DEFESA DO CONSUMIDOR NO ESTADO DO AMAZONAS", "Capacitacao e treinamento dos profissionais da assistencia tecnica e da area da Piscicultura, com enfoque nas Boas Praticas de Manejo na criacao de peixes em viveiros, tanques redes e canais de igarapes.", "MANUTENCAO DO PROGRAMA NACIONAL TELESSAUDE BRASIL REDES", "Fortalecimento do Conselho Estadual de SeguranAa Alimentar e Nutricional e a CAmara Intersetorial de SeguranAa Alimentar e Nutricional, componentes do SISAN, alAm da elaboraAAo do Plano de SeguranAa Alimentar e Nutricional do AMAZONAS, com ampla participaAAo do Consea Estadual ,bem como a sensibilizaAAo de pelo menos 50% dos municApios do estado para a adesAo ao SISAN.", "Modernizacao de Unidades de Apoio a Distribuicao de Produtos da Agricultura Familiar.", "Instituir cooperacao tecnico-cientifica entre as convenentes para a execucao do Programa de Excelencia em Pesquisa Basica e Aplicada em Saude - PROEP do Centro de Pesquisa Leonidas e Maria Deane/FIOCRUZ, visando a promocao de projetos de pesquisa estrategicos.", "Modernizacao das instalacoes da Fundacao Vila Olimpica Danilo Duarte de Mattos Areosa.", "ACOES DE PREVENCAO E REAPARELHAMENTO DOS ORGAOS ENVOLVIDOS NAS POLITICAS DE ENFRENTAMENTO A REDUCAO DA DEMANDA DE CRACK E OUTRAS DROGAS NO ESTADO DO AMAZONAS.", "Programas e Projetos de Extensao da UEA para 2013.", "Construcao do Centro de Detencao Provisoria Masculino de Manaus - CDP II com capacidade para 571 vagas.", "Realizar estudo do impacto da tecnica Xpert MTB/RIF para o diagnostico da tuberculose pulmonar em pacientes residentes no interior do estado do Amazonas.", "Estudos e Pesquisas para avaliar a eficacia de esquemas antimalaricos alternativos em associacao a primaquina no tratamento de pacientes com malaria vivax sem complicacoes, provenientes das unidades de diagnostico e tratamento de malaria da atencao basica do municipio de Coari-AM e da FMT-HDV em Manaus-AM.", "Estudo e pesquisa para determinar a acuracia dos fatores de mau prognostico para a dengue", "Promover a reorientacao da formacao profissional em saude - PRO-SAUDE e PET-SAUDE", "Estruturar os Institutos de Criminalistica - IC, de Identificacao - II e Medico Legal - IML pertencentes ao Departamento de Policia Tecnico-Cientifica da Policia Civil do Estado do Amazonas com acoes voltadas ao aprimoramento e estruturacao dos servicos prestados pelos Institutos nas areas de pericia em local de crimes violentos, medicina legal, balistica forense, DNA (criminal), informatica forense, quimica forense", "Implementar o Programa de Pesquisa para o Sistema Unico de Saude - SUS: gestao compartilhada de saude (PPSUS) do Departamento de Ciencia e Tecnologia da Secretaria de Ciencia, Tecnologia e Insumos Estrategicos do Ministerio da Saude (DECIT/SCTI/MS), que busca apoiar pesquisas voltadas para problemas prioritarios de saude e o fortalecimento da gestao do SUS, no Estado no Amazonas - Edicao 2012.", "Implementacao do CIAB-AD (Centro Interdisciplinar de Atencao Biopsicosocial  Alcool e drogas) para o desenvolvimento das atividades de prevencao, apoio, tratamento, acompanhamento e reabilitacao de profissionais do Sistema de Seguranca Publica do Estado do Amazonas, nos casos do uso abusivo de substancias psicoativas."]

let concedente = ["MEC/INEP/INST.NAC.DE EST.E PESQ.EDUCAC./DF", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE", "SUBSECRET.DE PLANEJ. ORCAM. E ADMINISTRACAO", "SECRETARIA NACIONAL DE SEG. PUBLICA - SENASP", "SECRETARIA DE DIREITO ECONOMICO - SDE", "MINISTERIO DA PESCA E AQUICULTURA", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE", "Secretaria Nacional de Seg. Alim.e Nutricional", "PROJETO DE OPERACIONALIZ. DOS PROGRAMAS SESAN", "FUNDACAO OSWALDO CRUZ/RJ", "CEF/MINISTERIO DO ESPORTE", "FUNDO NACIONAL ANTIDROGAS", "SECRETARIA DE EDUCACAO SUPERIOR", "CEF - DEPARTAMENTO PENITENCIARIO NACIONAL-MJ", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE", "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE", "SECRETARIA NACIONAL DE SEG. PUBLICA - SENASP", "CNPQ - ADMINSTRACAO CENTRAL", "SECRETARIA NACIONAL DE SEG. PUBLICA - SENASP"]

let convenente = ["SECRETARIA DE ESTADO DA SEGURANCA PUBLICA", "FUNDACAO DE MEDICINA TROPICAL * DOUTOR HEITOR VIEIRA DOURADO", "SECRETARIA DE ESTADO DA JUVENTUDE, ESPORTE E LAZER", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA", "SECRETARIA DE ESTADO DE JUSTICA, DIREITOS HUMANOS E CIDADANIA", "SECRETARIA DE ESTADO DE PRODUCAO RURAL", "UNIVERSIDADE DO ESTADO DO AMAZONAS", "SECRETARIA DE ESTADO DA ASSISTENCIA SOCIAL E CIDADANIA", "SECRETARIA DE ESTADO DE PRODUCAO RURAL", "FUNDACAO DE AMPARO A PESQUISA DO ESTADO DO AMAZONAS - FAPEAM", "SECRETARIA DE ESTADO DA JUVENTUDE, ESPORTE E LAZER", "SECRETARIA DE ESTADO DE JUSTICA, DIREITOS HUMANOS E CIDADANIA", "UNIVERSIDADE DO ESTADO DO AMAZONAS", "SECRETARIA DE ESTADO DE ADMINISTRACAO PENITENCIARIA - SEAP", "FUNDACAO DE MEDICINA TROPICAL * DOUTOR HEITOR VIEIRA DOURADO", "FUNDACAO DE MEDICINA TROPICAL * DOUTOR HEITOR VIEIRA DOURADO", "FUNDACAO DE MEDICINA TROPICAL * DOUTOR HEITOR VIEIRA DOURADO", "UNIVERSIDADE DO ESTADO DO AMAZONAS", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA", "FUNDACAO DE AMPARO A PESQUISA DO ESTADO DO AMAZONAS - FAPEAM", "SECRETARIA DE ESTADO DA SEGURANCA PUBLICA"]

let valorConvenio = ["306.103,37", "475.000,00", "3.480.320,00", "409.800,00", "498.938,94", "198.616,98", "2.432.000,00", "362.820,48", "7.600.000,00", "2.088.000,00", "6.000.000,00", "112.028,77", "353.015,67", "12.709.386,00", "141.611,90", "396.720,00", "121.125,00", "663.894,00", "600.000,00", "2.000.000,00","813.501,20"]

let valorRepassado = ["259.063,37", "475.000,00", "2.340.160,00", "409.800,00", "498.938,94", "198.616,98", "2.432.000,00", "362.820,48", "2.851.790,00", "1.518.698,98", "1.524.000,00", "112.028,77", "353.015,67", "10.167.508,80", "141.611,90", "396.720,00", "121.125,00", "107.152,49", "600.000,00", "200.0000,00", "813.501,20"]

let aRepassar = [ "47.040,00", "0,00", "1.140.160,00", "0,00", "0,00", "0,00", "0,00", "0,00", "4.748.210,00", "569.301,02", "4.476.000,00", "0,00", "0,00", "2.541.877,20", "0,00", "0,00", "0,00", "556.741,51", "0,00", "0,00", "0,00"]

let valorContraPartida = [ "3.092,00", "25.000,00", "248.070,00", "21.569,00", "51.015,06", "22.000,02", "128.000,00", "19.095,82", "487.300,00", "937.920,00", "1.091.334,29", "0,00", "20.405,67", "9.277.717,12", "7.453,26", "20.880,00", "6.375,00", "6.706,26", "6.095,72", "100.0000,00", "8.784,00"]

let dataInicioVigencia = [ "27/06/2014", "26/12/2013", "31/12/2013", "27/12/2013", "30/12/2013", "31/12/2013", "31/12/2013", "23/12/2013", "30/12/2013", "02/12/2013", "03/12/2013", "09/10/2013", "02/09/2013", "16/09/2013", "26/12/2012", "26/12/2012", "12/12/2012", "26/12/2012", "27/12/2012", "23/01/2013", "27/12/2012"]

let dataFimVigencia = [ "31/12/2016", "27/10/2017", "08/06/2016", "26/08/2016", "30/04/2016", "01/07/2016", "09/06/2016", "31/01/2017", "27/06/2016", "01/12/2017", "30/06/2016", "09/10/2016", "13/05/2016", "15/09/2016", "25/11/2016", "20/06/2016", "07/05/2016", "05/05/2016", "17/06/2016", "06/10/2016", "24/04/2016"]

let dataPagamentos = ["15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013","15/05/2013"]
    
let valorPagamento = ["313,37","605,42","679,18","78,00","24.499,98","25.425,44","11.664,24","14.277,67","396,56","279,31","1.274,57","1.374,49","297,22","2.230,41","299,39"]

let cnpjFornecedor = ["76535800000000","5423960000000","5423960000000","5423960000000","76535800000000","76535800000000","76535800000000","76535800000000","76535800000000","76535800000000","76535800000000","76535800000000","76535800000000","5423960000000","76535800000000"]
                      
let fornecedor = ["OI S.A.","14 BRASIL TELECOM CELULAR S/A","14 BRASIL TELECOM CELULAR S/A","14 BRASIL TELECOM CELULAR S/A","OI S.A.","OI S.A.","OI S.A.","OI S.A.","OI S.A.","OI S.A.","OI S.A.","OI S.A.","OI S.A.","14 BRASIL TELECOM CELULAR S/A","OI S.A."]

//    pagamento15.setData("15/05/2013");
//    pagamento15.setValor("299,39");
//    pagamento15.setCnpjFornecedor("76535800000000");
//    pagamento15.setFornecedor("OI S.A.");
//    
//    pagamento16.setData("15/05/2013");
//    pagamento16.setValor("14.696,05");
//    pagamento16.setCnpjFornecedor("76535800000000");
//    pagamento16.setFornecedor("OI S.A.");
//    
//    pagamento17.setData("15/05/2013");
//    pagamento17.setValor("17.276,71");
//    pagamento17.setCnpjFornecedor("76535800000000");
//    pagamento17.setFornecedor("OI S.A.");
//    
//    pagamento18.setData("15/05/2013");
//    pagamento18.setValor("78,00");
//    pagamento18.setCnpjFornecedor("76535800000000");
//    pagamento18.setFornecedor("OI S.A.");
//   
//    pagamento19.setData("15/05/2013");
//    pagamento19.setValor("81,23");
//    pagamento19.setCnpjFornecedor("5423960000000");
//    pagamento19.setFornecedor("14 BRASIL TELECOM CELULAR S/A");
//    
//    pagamento20.setData("15/05/2013");
//    pagamento20.setValor("273,32");
//    pagamento20.setCnpjFornecedor("76535800000000");
//    pagamento20.setFornecedor("OI S.A.");
           