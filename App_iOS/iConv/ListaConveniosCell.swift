//
//  ListaConveniosCell.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/13/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation
import UIKit

class ListaConveniosCell: UITableViewCell{
//    
//    var objects: Municipio? {
//        didSet {
//            updateCell()
//        }
//    }
    
    @IBOutlet weak var nConvenio: UILabel!
    @IBOutlet weak var concedente: UILabel!
    
    @IBOutlet weak var convenente: UILabel!
        
    @IBOutlet weak var vConvenio: UILabel!
    @IBOutlet weak var vRepassado: UILabel!
    @IBOutlet weak var aRepassar: UILabel!
    @IBOutlet weak var objetoResumido: UILabel!
    
}