package server.models;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Message {
    public static ArrayList<Message> messages = new ArrayList<>();
    private int id;
    private String text;
    private String postDate;
    private String author;
    private int board;

    public Message(int id, String text, String postDate, String author, int board){
        this.id = id;
        this.text = text;
        this.postDate = postDate;
        this.author = author;
        this.board = board;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getAuthor() {
        return author;
    }

    public int getBoard() {
        return board;
    }

    public static int nextId() {
        int id = 0;
        for (Message m : messages) {
            if (m.getId() > id) {
                id = m.getId();
            }
        }
        return id + 1;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", postDate='" + postDate + '\'' +
                ", author='" + author + '\'' +
                ", board=" + board + '\'' +
                '}';
    }

    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject j = new JSONObject();
        j.put("id", getId());
        j.put("text", getText());
        j.put("postDate", getPostDate());
        j.put("author", getAuthor());
        j.put("board", getBoard());
        return j;
    }

}