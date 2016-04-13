//
//  APIManager.swift
//  MusicVideo
//
//  Created by Michael Rudowsky on 9/10/15.
//  Copyright © 2015 Michael Rudowsky. All rights reserved.
//

import Foundation
//import SwiftyJSON

class APIManager {
    
    func loadData(urlString:String, completion: ([Municipio], Metadados) -> Void ) {
        
        
        let config = NSURLSessionConfiguration.ephemeralSessionConfiguration()
        
        let session = NSURLSession(configuration: config)
        
        
        //        let session = NSURLSession.sharedSession()
        let url = NSURL(string: urlString)!
        
        let task = session.dataTaskWithURL(url) {
            (data, response, error) -> Void in
            
            if error != nil {
                
                print(error!.localizedDescription)
                
                
            } else {
                
                //Added for JSONSerialization
                //print(data)
                do {
                    /* .AllowFragments - top level object is not Array or Dictionary.
                    Any type of string or value
                    NSJSONSerialization requires the Do / Try / Catch
                    Converts the NSDATA into a JSON Object and cast it to a Dictionary */
                    
                    if let json = try NSJSONSerialization.JSONObjectWithData(data!, options: .AllowFragments) as? [String: AnyObject] {
                        
                        
                        if let muni = json["municipios"] as? [[String: AnyObject]]{
//                            print("  ")
//                            print("ENTRI AQUI")
                            var cidades = [Municipio]()
                            var dados : Metadados!
                            for entry in muni {
                                let data = Municipio(data: entry)
                                cidades.append(data)
                                let i = cidades.count
                             //   print("Numero de Eventos/Lugares --> \(i)")
                                
                                
                            }
                            
                            if let meta = json["metadados"] as? [String: AnyObject]{
                                   dados = Metadados(data: meta)
                            }
                            
                            let priority = DISPATCH_QUEUE_PRIORITY_HIGH
                            dispatch_async(dispatch_get_global_queue(priority, 0)) {
                                dispatch_async(dispatch_get_main_queue()) {
                                    completion(cidades, dados)
                                }
                            }
                        }
                        
                        
                            
                            
                        
                    }
                } catch {
                    print("error in NSJSONSerialization")
                    
                }
                
            }
        }
        
        task.resume()
    }
}
