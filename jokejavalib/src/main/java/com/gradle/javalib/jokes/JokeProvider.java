package com.gradle.javalib.jokes;

public class JokeProvider {
    String[] jokes = {
            "A plateau is the highest form of flattery.",
            "It’s hard to explain puns to kleptomaniacs because they always take things literally.",
            "Time flies like an arrow, fruit flies like a banana.",
            "A soldier survived mustard gas in battle, and then pepper spray by the police. He's now a seasoned veteran.",
            "What's the best thing about Switzerland? I don't know, but their flag is a huge plus.",
            "I'm addicted to brake fluid, but I can stop whenever I want.",
            "What's the difference between my ex and the titanic? The titanic only went down on 1,000 people."};
    public String getJokes(){
        int min=0;
        int max = jokes.length-1;
        int index = (int) ((Math.random()*(max-min)) + min);
        return jokes[index];
    }
}
