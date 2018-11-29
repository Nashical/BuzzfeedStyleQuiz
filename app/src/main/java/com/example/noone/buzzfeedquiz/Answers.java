package com.example.noone.buzzfeedquiz;

public class Answers {

    private String answer;

    private Answers(String question) {
        this.answer = question;
    }

    public static Answers [][] getAnswers(){

        Answers [][] answers = {
                {
                        new Answers("a) Stay home"),
                        new Answers("b) Read"),
                        new Answers("c) Play video games"),
                        new Answers("d) Hang out with friends")
                },

                {
                        new Answers("a) I don't really care"),
                        new Answers("b) Somewhere with less people around"),
                        new Answers("c) Exploring an exotic place"),
                        new Answers("d) Somewhere normally impossible to reach")
                },

                {
                        new Answers("a) Invisibility"),
                        new Answers("b) Summon animal companions"),
                        new Answers("c) Super strength"),
                        new Answers("d) Laser eyes")
                },

                {
                        new Answers("a) A Hamster"),
                        new Answers("b) A cat"),
                        new Answers("c) A dog"),
                        new Answers("d) A lion")
                },

                {
                        new Answers("a) Any of my Mom's cooking"),
                        new Answers("b) High tea"),
                        new Answers("c) Pizza"),
                        new Answers("d) Sushi")
                }
        };

        return answers;
    }

    public static boolean check(String Answer) {

        if (Answer.equals("A") || Answer.equals("B") || Answer.equals("C") || Answer.equals("D")){
            return true;
        }

        else if (Answer.equals("a") || Answer.equals("b") || Answer.equals("c") || Answer.equals("d")){
            return true;
        }

        else {
            System.out.println("That is not a valid option. Please enter a valid answer:");
            return false;
        }

    }

    public static int [] parse(String [] results){

        int [] Tally = new int [4];

        for (int i = 0; i < results.length; i ++) {

            switch (results[i]) {
                case "A":
                    Tally[0] ++;
                    break;
                case "a":
                    Tally[0] ++;
                    break;
                case "B":
                    Tally[1] ++;
                    break;
                case "b":
                    Tally[1] ++;
                    break;
                case "C":
                    Tally[2] ++;
                    break;
                case "c":
                    Tally[2] ++;
                    break;
                case "D":
                    Tally[3] ++;
                    break;
                case "d":
                    Tally[3] ++;
                    break;
            }
        }
        return Tally;
    }

    public static int total (int [] Tally) {
        int Maximum = 0;
        int index = 0;
        int maxCount = 0;

        for (int i = 0; i < Tally.length; i++) {
            Maximum = Math.max(Maximum, Tally[i]);
        }

        for(int i = 0; i < Tally.length; i++){
            if(Tally[i] == Maximum) {
                index = i;
                maxCount++;
            }
        }

        if(maxCount > 1){
            MainActivity.Tie = true;
        }

        return index;
    }

    public static String getResults(Boolean Tie, int index) {

        String message;

        if (MainActivity.Tie) {
            message = "You are well rounded in almost every category!";
        }
        else {
            if (index == 0) {
                message = "Personality: Bland";
            } else if (index == 1) {
                message = "Personality: Quiet";
            } else if (index == 2) {
                message = "Personality: Normie";
            } else {
                message = "Personality: Adventurous";
            }
        }
        return message;
    }

    public static String printAnswers(Answers [][] Answers, int i, int j) {

                return Answers[i][j].answer;

    }
}
