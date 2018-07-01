package net.tbnrshadowplayz.Listcord4J.Entities;

import org.json.JSONObject;

public class Bot {
    private String ID;
    private String username;
    private String discriminator;
    private String avatar;
    private String description;
    private String website;
    private String support;
    private String invite;
    private boolean online;
    private int servers;
    private int invites;
    private int votes;
    private boolean premium;
    private String[] owners;
    private int nextVote;
    public Bot(JSONObject botJSONObject){
        ID = botJSONObject.getString("id");
        username = botJSONObject.getString("username");
        discriminator = botJSONObject.getString("discriminator");
        avatar = botJSONObject.getString("avatar");
        description = botJSONObject.getString("description");
        website = botJSONObject.getString("website");
        support = botJSONObject.getString("support");
        invite = botJSONObject.getString("invite");
        online = botJSONObject.getBoolean("online");
        servers = botJSONObject.getInt("servers");
        invites = botJSONObject.getInt("invites");
        votes = botJSONObject.getInt("votes");
        premium = botJSONObject.getBoolean("premium");
        owners = new String[botJSONObject.getJSONArray("owners").length()];
        for(int i = 0; i < botJSONObject.getJSONArray("owners").length(); i++){
            owners[i] = botJSONObject.getJSONArray("owners").getString(i);
        }
        nextVote = botJSONObject.getInt("nextVote");
    }
    public String getID(){
        return ID;
    }
    public String getUsername(){
        return username;
    }
    public String getDiscriminator(){
        return discriminator;
    }
    public String getAvatar(){
        return avatar;
    }
    public String getDescription(){
        return description;
    }
    public String getWebsite(){
        return website;
    }
    public String getSupport(){
        return support;
    }
    public String getInvite(){
        return invite;
    }

    public boolean isOnline() {
        return online;
    }

    public int getServers() {
        return servers;
    }

    public int getInvites() {
        return invites;
    }

    public int getVotes() {
        return votes;
    }

    public boolean isPremium() {
        return premium;
    }

    public String[] getOwners() {
        return owners;
    }

    public int getNextVote() {
        return nextVote;
    }
}
