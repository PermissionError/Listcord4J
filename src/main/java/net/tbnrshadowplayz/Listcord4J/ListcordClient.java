package net.tbnrshadowplayz.Listcord4J;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import net.tbnrshadowplayz.Listcord4J.Entities.Bot;
import net.tbnrshadowplayz.Listcord4J.Entities.Votes;
import org.json.JSONObject;

public class ListcordClient {
    private String token;
    private String listcord = "https://listcord.com/api/";
    public ListcordClient(String token){
        this.token = token;
    }
    public String[] getBots(String limit, String offset, String query) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(listcord + "bots/" + limit + "/" + offset)
                .header("Authorization", token)
                .queryString("q?", query)
                .asJson();
        String[] array = new String[response.getBody().getArray().length()];
        for(int i = 0;i < response.getBody().getArray().length(); i++){
            array[i] = response.getBody().getArray().getString(i);
        }
        return array;
    }
    public Bot getBotByID(String ID) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(listcord + "bot/" + ID)
                .header("Authorization", token)
                .asJson();
        return new Bot(response.getBody().getObject());
    }
    public Votes getVotesByID(String ID) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(listcord + "bot/" + ID + "/votes")
                .header("Authorization", token)
                .asJson();
        return new Votes(response.getBody().getObject());
    }
    public void updateGuildCount(String ID, int guilds) throws UnirestException {
        Unirest.post(listcord + "bot/" + ID + "/guilds")
                .header("Authorization", token)
                .body(new JSONObject().put("guilds", guilds))
                .asJson();
    }
    public void updateShardGuildCount(String ID, int guilds, int shardID) throws UnirestException {
        Unirest.post(listcord + "bot/" + ID + "/guilds")
                .header("Authorization", token)
                .body(new JSONObject().put("guilds", guilds).put("shard", shardID))
                .asJson();
    }
}
