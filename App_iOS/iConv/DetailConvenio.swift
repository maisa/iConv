//
//  DetailConvenio.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/7/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation
import UIKit

class DetailConvenio: UIViewController{
    
    @IBOutlet weak var nConvenio: UILabel!
    @IBOutlet weak var Concedente: UILabel!
    @IBOutlet weak var Convenente: UILabel!
    
    
    @IBOutlet weak var valorConvenio: UILabel!
    @IBOutlet weak var valorRepassado: UILabel!
    @IBOutlet weak var aRepassar: UILabel!
    
    @IBOutlet weak var objetoResumido: UILabel!
    
    var saRepassar = ""
    var sConcedente = ""
    var sConvenente = ""
    var snConvenio = ""
    var sobjetoResumido = ""
    var svalorConvenio = ""
    var svalorRepassado = ""

    override func viewDidLoad() {
        super.viewDidLoad()
        nConvenio.text = snConvenio
        Concedente.text = sConcedente
        Convenente.text = sConvenente
        valorConvenio.text = svalorConvenio
        valorRepassado.text = svalorRepassado
        aRepassar.text = saRepassar
        objetoResumido.text = sobjetoResumido
    }
}