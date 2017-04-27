package com.example.fadni.week4class;

import java.util.ArrayList;

/**
 * Created by Fadni on 13/04/2017.
 */

public class Ideas {
    private ArrayList<Idea> ideaList;

    Ideas(){
        ideaList = new ArrayList<>();
    }

    public void newIdea(Idea idea){
        ideaList.add(idea);
    }

    public ArrayList<String> getIdeas(){
        ArrayList<String> ideasToReturn = new ArrayList<>();
        for(Idea idea: ideaList)
        {
            ideasToReturn.add(idea.getIdea());
        }
        return ideasToReturn;
    }

    public ArrayList<Idea> getIdeaList() {
        return ideaList;
    }
}
