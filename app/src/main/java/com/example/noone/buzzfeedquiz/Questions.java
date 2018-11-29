package com.example.noone.buzzfeedquiz;

public class Questions {

    public String question;

    public Questions(String question) {
        this.question = question;
    }

    public static Questions [] getQuestions(){

        Questions [] questions ={
                new Questions("What do you like to do on your free time?"),
                new Questions("If you could go anywhere in the world, where would you go?"),
                new Questions("What kind of super powers would you like?"),
                new Questions("What kind of pet do you want?"),
                new Questions("What kind of food do you like to eat?")
        };
        return questions;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Questions)){
            return false;
        }
        else{
            return this.question.equals(((Questions) obj).question);
        }
    }

    public static String printQuestions(Questions [] questions, int i) {

        return questions[i].question;

        }

}
