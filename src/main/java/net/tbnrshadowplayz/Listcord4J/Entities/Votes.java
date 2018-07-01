package net.tbnrshadowplayz.Listcord4J.Entities;

import org.json.JSONObject;

public class Votes {
    private String ID;
    private int count;
    private int lastVote;
    private int nextVote;
    public Votes(JSONObject votesJSONObject){
        ID = votesJSONObject.getString("id");
        count = votesJSONObject.getInt("count");
        lastVote = votesJSONObject.getInt("lastVote");
        nextVote = votesJSONObject.getInt("nextVote");
    }
    public String getID() {
        return ID;
    }
    public int getCount() {
        return count;
    }
    public int getLastVote() {
        return lastVote;
    }
    public int getNextVote() {
        return nextVote;
    }
}
