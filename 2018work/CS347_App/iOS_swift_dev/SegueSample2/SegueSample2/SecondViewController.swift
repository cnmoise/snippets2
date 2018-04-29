//
//  SecondViewController.swift
//  SegueSample2
//
//  Created by student on 4/17/18.
//  Copyright © 2018 student. All rights reserved.
//

import Foundation
import UIKit

class SecondViewController: UIViewController{
    
    @IBOutlet var greeting: UILabel!
    
    var name = ""
    
    //overriding defalut viewdidload behavior
    override func viewDidLoad() {
        super.viewDidLoad()
        
        greeting.text = "Hello \(name)"
    }
}
