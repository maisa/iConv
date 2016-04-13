//
//  ViewController.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/6/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    var dict = [[String: [Municipio]]]()
    var allMunicipios = [Municipio]()
    var i = 0
    var j = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        Loading().showLoading()
        runAPI()
    }
    
    func runAPI() {
        
        
        //Call API
        let api = APIManager()
        //var offset = 0
        
//        for item in estados{
//            print(URL_BASE+item)
            api.loadData(URL_BASE + "AC", completion: didLoadData)
       // }
    }
    
    func didLoadData(data: [Municipio], dado : Metadados){
        print(i)
         let api = APIManager()
        
        if i < 27 && dado.proximo != "Invalido"{
            api.loadData(URL_BASE + estados[i], completion: didLoadMoreData)
        } else{
            if i < 27 {
                dict.append([estados[i]:data])
                j = j+1
                if j > 26{
                    Loading().hideLoading()
                }
            }
            i = i+1
            if estados[i-1] == "AC"{
                api.loadData(URL_BASE + estados[i], completion: didLoadData)
            } else {
                if i < 27 && dado.proximo == "Invalido"{
                    api.loadData(URL_BASE + estados[i], completion: didLoadData)
                }
            }
        }
        
        
        //        for item in data{
        //            if item.cod_siconv == -9 { print("Tirou 1")
        //            } else {
        //                if item.cod_siconv == -8 { print("Tioru 2")
        //                } else {
        //                    if item.cod_siconv == -7 { print ("Tirou 3")
        //                    } else {
        //                        allMunicipios.append(item)
        //                    }
        //                }
        //            }
        //        }
        //        for item in allMunicipios {
        //            print(item.nome)
        //        }
        //        print(allMunicipios.count)
        
    }
    
    func didLoadMoreData (data: [Municipio], dado : Metadados){
        print(i)
        let api = APIManager()
        for item in data{
            allMunicipios.append(item)
        }
//        print(estados[i])
//        print(allMunicipios.count)
        if dado.proximo != "Invalido" {
            //print(estados[i])
            api.loadData(dado.proximo, completion: didLoadMoreData)
        } else {
            if i < 27 {
                dict.append([estados[i]:allMunicipios])
                j = j+1
                if j > 26{
                    Loading().hideLoading()
                }
            }
            i = i+1
            allMunicipios.removeAll()
            api.loadData(URL_BASE + estados[i], completion: didLoadData)
        }
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if segue.identifier == "segueToConf"{
            let DestView : ConfController = segue.destinationViewController as! ConfController
            //print(dict)
            DestView.data = self.dict
        }
        

    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

