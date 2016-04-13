//
//  ListaPagamentos.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/7/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation
import UIKit

class ListaPagamentos: UIViewController, UITableViewDelegate, UITableViewDataSource{
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return dataPagamentos.count
    }
    
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCellWithIdentifier("cell") as! ListaPagamentosCell
        cell.cnpj.text = cnpjFornecedor[indexPath.row]
        cell.data.text = dataPagamentos[indexPath.row]
        cell.fornecedor.text = fornecedor[indexPath.row]
        cell.notaFiscal.text = ""
        cell.valor.text = valorPagamento[indexPath.row]
        return cell
    }
    
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        tableView.deselectRowAtIndexPath(indexPath, animated: true)
    }
}