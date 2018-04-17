//
//  ViewController.swift
//  Quiz
//
//  Created by student on 3/8/18.
//  Copyright © 2018 student. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet var questionLabel:UILabel!
    @IBOutlet var answerLabel:UILabel!
    let questions: [String] = ["From what is cognac made?",
                               "What is 7+7",
                               "What is the capital of Vermont"]
    let answers: [String] = ["Grapes",
                             "14",
                             "Montpellier"]
    var currentQuestionIndex: Int = 0;
    
    
    @IBAction func showNextQuestion(sender: AnyObject){
        currentQuestionIndex += 1
        if currentQuestionIndex == questions.count {
            currentQuestionIndex = 0
        }
        
        let question:String =
            questions[currentQuestionIndex]
        questionLabel.text = question
        answerLabel.text = "???"
    }
    
    @IBAction func showAnswer(sender:AnyObject){
        let answer:String = answers[currentQuestionIndex]
        answerLabel.text = answer
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        questionLabel.text = questions[currentQuestionIndex]
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

