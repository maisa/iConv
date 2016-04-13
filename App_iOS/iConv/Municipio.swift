//
//  Municipio.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/6/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation

class Municipio{
    
    private var _id: Int!
    private var _nome: String!
    private var _cod_siconv: Int!
    private var _href: String!
    private var _proponentes: String!
    private var _uf: String!
    private var _regiao: String!
    private var _regiaoSigla: String!
    private var _ufNome: String!
    
    private var _proximo: String!
    private var _total_registro: Int!
    
    var id: Int{
        return _id
    }
    
    var nome: String{
        return _nome
    }
    
    var cod_siconv: Int{
        return _cod_siconv
    }
    
    var href: String{
        return _href
    }
    
    var proponentes: String{
        return _proponentes
    }
    
    var uf: String{
        return _uf
    }
    
    var regiao: String{
        return _regiao
    }
    
    var regiaoSigla: String{
        return _regiaoSigla
    }
    
    var ufNome: String{
        return _ufNome
    }
    
    var proximo: String{
        get{
            return self._proximo
        }
        
        set(proxValue){
            self._proximo = proxValue
        }
    }
    
    var total_registros: Int{
        get{
            return self._total_registro
        }
        
        set(total){
            self._total_registro = total
        }
    }
    
    init(data:[String: AnyObject] ){
        
        if let nome = data["nome"] as? String{
            self._nome = nome
        } else {
            self._nome = "Invalido"
        }
        
        if let cod = data["cod_sconv"] as? Int{
            self._cod_siconv = cod
        } else {
            self._cod_siconv = -1
        }
        
        if let href = data["href"] as? String{
            self._href = href
        } else {
            self._href = "Invalido"
        }
        
        if let proponentes = data["proponentes"]{
            if let propref = proponentes["href"] as? String{
                self._proponentes = propref
            } else {
                self._proponentes = "Invalido"
            }
        }
        
        if let uf = data["uf"]{
            if let regiao = uf["regiao"]{
                if let regname = regiao!["nome"] as? String{
                    self._regiao = regname
                } else {
                    self._regiao = "Invalido"
                }
                if let sigla = regiao!["sigla"] as? String{
                    self._regiaoSigla = sigla
                } else {
                    self._regiaoSigla = "Invalido"
                }
            }
            
            if let nomeUf = uf["nome"] as? String{
                self._ufNome = nomeUf
            } else {
                self._ufNome = "Invalido"
            }
            
            if let ufSigla = uf["sigla"] as? String{
                self._uf = ufSigla
            } else {
                self._uf = "Invalido"
            }
            
        }
        
    }
    
}