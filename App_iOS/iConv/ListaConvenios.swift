//
//  ListaConvenios.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/7/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation
import UIKit


class ListaConvenios: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    @IBOutlet weak var listaConvenios: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return numConvenio.count
    }
    
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCellWithIdentifier("cell") as! ListaConveniosCell
        cell.nConvenio.text = numConvenio[indexPath.row]
        cell.aRepassar.text = aRepassar[indexPath.row]
        cell.concedente.text = concedente[indexPath.row]
        cell.convenente.text = convenente[indexPath.row]
        cell.objetoResumido.text = objetoResumido[indexPath.row]
        cell.vRepassado.text = valorRepassado[indexPath.row]
        cell.vConvenio.text = valorConvenio[indexPath.row]
        return cell
    }
    
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        tableView.deselectRowAtIndexPath(indexPath, animated: true)
    }
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
      //  print(segue.identifier)
        
        if segue.identifier == "DetailView"
        {
            // print("ENTROU AQUI")
            if let indexpath = listaConvenios.indexPathForSelectedRow {
               
                if let dvc = segue.destinationViewController as? DetailConvenio {

                dvc.saRepassar = aRepassar[indexpath.row]
                dvc.sConcedente = concedente[indexpath.row]
                dvc.sConvenente = convenente[indexpath.row]
                dvc.snConvenio = numConvenio[indexpath.row]
                dvc.sobjetoResumido = objetoResumido[indexpath.row]
                dvc.svalorConvenio = valorConvenio[indexpath.row]
                dvc.svalorRepassado = valorRepassado[indexpath.row]
                }
                
            }
            
        }
    }
    
}