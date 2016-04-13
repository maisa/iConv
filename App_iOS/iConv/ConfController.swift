//
//  ConfController.swift
//  iConv
//
//  Created by Leandro Paiva Andrade on 4/6/16.
//  Copyright © 2016 Leandro Paiva Andrade. All rights reserved.
//

import Foundation
import UIKit
import SwiftyJSON

class ConfController: UITableViewController{
    
    var selectedMunicipio: Municipio!
   
    
    @IBOutlet weak var cidadeText: UITextField!
    @IBOutlet weak var estadoText: UITextField!
    @IBOutlet weak var estadoPicker: UIPickerView!
    @IBOutlet weak var cidadePicker: UIPickerView!
    
    var selectedEstado = "AC"
    var test = [Municipio]()
    
    var allMunicipios = [Municipio]()
    var i = 0
    var data = [[String: [Municipio]]]()
    override func viewDidLoad() {
        super.viewDidLoad()
        
//        if let path = NSBundle.mainBundle().pathForResource("estados-cidades", ofType: "json") {
//            if let data = NSData(contentsOfFile: path){
//                let json = JSON(data: data, options: NSJSONReadingOptions.AllowFragments, error: nil)
//                //print("jsonData:\(json)")
//            }
//        }
//        runAPI()
        
//        gradePicker.dataSource = self
//        gradePicker.delegate = self
        
    
        cidade()
        estadoPicker.showsSelectionIndicator = true     
        
    }

    
    @IBAction func federalButton(sender: CheckboxButton) {
        let state = sender.on ? "ON" : "OFF"
        
        print("CheckboxButton: did turn \(state)")
    }
    
    @IBAction func estadualButton(sender: CheckboxButton) {
        let state = sender.on ? "ON" : "OFF"
        
        print("CheckboxButton: did turn \(state)")
    }
    
    @IBAction func municipalButton(sender: CheckboxButton) {
        let state = sender.on ? "ON" : "OFF"
        
        print("CheckboxButton: did turn \(state)")
    }
    
    @IBAction func privadaButton(sender: CheckboxButton) {
        let state = sender.on ? "ON" : "OFF"
        
        print("CheckboxButton: did turn \(state)")
    }
    
    @IBAction func encerradoButton(sender: CheckboxButton) {
        let state = sender.on ? "ON" : "OFF"
        
        print("CheckboxButton: did turn \(state)")
    }
    
    @IBAction func execucaoButton(sender: CheckboxButton) {
        let state = sender.on ? "ON" : "OFF"
        
        print("CheckboxButton: did turn \(state)")
    }
    
    func cidade(){
       print(data)
        
        for item in data{
            if let test = item[estados[i]] {
               print(estados[i])
               print(test.count)
               print("")
               
            }
            i = i + 1
        }
    }
    
    func textFieldShouldBeginEditing(textField: UITextField) -> Bool {
        if textField.placeholder == "Estado"{
        toggleDatepicker(0)
        }
        if textField.placeholder == "Cidade"{
            toggleDatepicker(1)
        }
        return false
    }
    
    @IBAction func closePicker(sender: UIButton) {
        toggleDatepicker(0)
    }
    
    @IBAction func closeCidade(sender: UIButton) {
        toggleDatepicker(1)
    }
    
    ///let test = ["lala", "elel"]
    func pickerView(pickerView: UIPickerView!, didSelectRow row: Int, inComponent component: Int)
    {
        if pickerView.tag == 1 {
        estadoText.text = estadosNome[row][1]
            selectedEstado = estadosNome[row][0]
            print(selectedEstado)
            cidadeText.text = "Cidade"
            cidadePicker.reloadAllComponents()
            
            
        }
        if pickerView.tag == 2 {
            cidadeText.text = test[row].nome
            selectedMunicipio = test[row]
        }
        //estadoPicker.hidden = true;
        
    }
    
    func numberOfComponentsInPickerView(pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView.tag == 1{
        return estados.count
        } else {
            var countMuni = 0;
            for item in data{
                if let test = item[selectedEstado] {
                    //print(selectedEstado)
                    countMuni = test.count
                   // print("")
                    
                }
                i = i + 1
            }
            return countMuni
        }
    }
    
    func pickerView(pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String! {
        if pickerView.tag == 1{
        return estadosNome[row][1]
        } else {
            if selectedEstado.isEmpty {
                print(selectedEstado)
            } else {
                for item in data{
                    if let test2 = item[selectedEstado] {
                        test = test2
                        //print(selectedEstado)
                        // print("")
                        
                    }
                }
            }
            return test[row].nome
        }
        
    }
    
    override func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        if indexPath.section == 1 && indexPath.row == 0 {
            toggleDatepicker(0)
        }
        if( indexPath.section == 2){
            toggleDatepicker(1)
        }
    }
    var estadoPickerHide = true
    var cidadePickerHide = true
    override func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        if estadoPickerHide && indexPath.section == 1 && indexPath.row == 1 {
            return 0
        }

        else if cidadePickerHide && indexPath.section == 2 && indexPath.row == 1{
            return 0
        }
            
        else{
            return super.tableView(tableView, heightForRowAtIndexPath: indexPath)
        }
    }
    
    func toggleDatepicker(toggleHide: Int){
        if(toggleHide == 0){
            estadoPickerHide = !estadoPickerHide
            if(cidadePickerHide == false){
                cidadePickerHide = true
            }
        }
        
        if(toggleHide == 1){
            cidadePickerHide = !cidadePickerHide
            if(estadoPickerHide == false){
                estadoPickerHide = true
            }
        }
        
        tableView.beginUpdates()
        tableView.endUpdates()
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if segue.identifier == "segueToMuni"{
            let DestView : HomeScreen = segue.destinationViewController as! HomeScreen
            //print(dict)
            DestView.data = self.selectedMunicipio
        }
        
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}