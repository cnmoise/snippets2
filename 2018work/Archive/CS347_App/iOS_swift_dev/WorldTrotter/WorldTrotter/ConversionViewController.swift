//
//  ViewController.swift
//  WorldTrotter
//
//  Created by student on 3/27/18.
//  Copyright © 2018 student. All rights reserved.
//

import UIKit

class ConversionViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet var celsiusLabel: UILabel!
    @IBOutlet var textField: UITextField!
    
    func textField(_ textField : UITextField, shouldChangeCharactersIn range: NSRange,
                   replacementString string: String) -> Bool {
        
//        print("Current text: \(textField.text)")
//        print("Replacement text: \(string)")
        let existingTextHasDecimalSeparator = textField.text?.range(of:".")
        let replacementTextHasDecimalSeparator = string.range(of: ".")
        
        if existingTextHasDecimalSeparator != nil &&
            replacementTextHasDecimalSeparator != nil {
            return false
        }
        
        return true
    }
    
    //initialize a variable based on a function
    var fahrenheitValue: Double? {
        didSet{
            updateCelsiusLabel()
        }
    }
    var celsiusValue: Double? {
        if let fahrenheitValue = fahrenheitValue {
                return (fahrenheitValue - 32) * (5/9)
        } else{
            return nil
        }
    }
    func updateCelsiusLabel(){
        if let value = celsiusValue{
            celsiusLabel.text = NSString(format: "%.2f",value) as String
        }else{
            celsiusLabel.text = "???"
        }
    }
    
    @IBAction func dismissKeyboard(sender:AnyObject){
        textField.resignFirstResponder()
    }
    
//    this action changes text from label to that of the tb
    @IBAction func fahrenheitFieldEditingChanged(textField:UITextField){
        //celsiusLabel.text = textField.text
        
        //condition, list
        if let text = textField.text, let value = Double(text){
            fahrenheitValue=value
            
        } else {
            fahrenheitValue=nil
        }
        
    }

    
    override func viewDidLoad() {
        super.viewDidLoad()
//        //creates blue rectangle
//        let firstFrame = CGRect(x:160,y:240,width:100,height:150)
//        let firstView = UIView(frame:firstFrame)
//        firstView.backgroundColor = UIColor.blue
//        view.addSubview(firstView)
//        // Do any additional setup after loading the view, typically from a nib.
//
//        let secondFrame = CGRect(x:20,y:30, width:50, height:50)
//        let secondView = UIView(frame:secondFrame)
//        secondView.backgroundColor = UIColor.green
//        firstView.addSubview(secondView)
        
        
    }

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        print("ConversionViewController's View appeared")
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
}

