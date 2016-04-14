//
//  AprovaController.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/13/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation
import UIKit

class AprovaController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func confirma(sender: UIButton) {
        let alertController = UIAlertController(title: "Obrigado!", message:
            "Sua opinião foi salva!", preferredStyle: UIAlertControllerStyle.Alert)
        alertController.addAction(UIAlertAction(title: "Ok!", style: UIAlertActionStyle.Default,handler:{ action in
             self.navigationController?.popViewControllerAnimated(true)
            }
            ))
        
        self.presentViewController(alertController, animated: true, completion: nil)
    }
}
