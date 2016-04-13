//
//  Metadados.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/6/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation

class Metadados{
    private var _proximo: String!
    private var _total_registro: Int!
    
    var proximo: String{
        return self._proximo
    }
    
    var total_registro: Int{
        return self._total_registro
    }
    
    init(data: [String: AnyObject]){
        
        if let prox = data["proximos"] as? String{
            self._proximo = prox
        } else {
            self._proximo = "Invalido"
        }
        
        if let total = data["total_registros"] as? Int{
            self._total_registro = total
        } else {
            self._total_registro = -1
        }
    }
}