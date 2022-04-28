package com.company;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        serializeSimple();
        deserializeSimple();
    }
    static void serializeSimple(){
        //Simple person = new Simple("Sam", 16, true);
        //System.out.println(person);
        ToDo todo1 = new ToDo("Walk the dog", false, 0, 3, "dog");
        ToDo todo2 = new ToDo("Pay the bills", false, 1, 1, "bills");
        ArrayList<ToDo> todos = new ArrayList<ToDo>();
        todos.add(todo1);
        todos.add(todo2);
        Gson gson = new Gson();
        //String json = gson.toJson(person);
        String json = gson.toJson(todos);
        try {
            FileWriter writer = new FileWriter("data.json");
            //gson.toJson(person, writer);
            gson.toJson(todos, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deserializeSimple(){
        //String person2Json = "{\"name\": \"Sam\", \"age\": 16, \"isDev\": true}";
        String toDoList = "{\n" +
                "  \"todos\": [\n" +
                "    {\n" +
                "      \"body\": \"Walk the dog\",\n" +
                "      \"done\": false,\n" +
                "      \"id\": 0,\n" +
                "      \"priority\": 3,\n" +
                "      \"title\": \"dog\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"body\": \"Pay the bills\",\n" +
                "      \"done\": false,\n" +
                "      \"id\": 1,\n" +
                "      \"priority\": 1,\n" +
                "      \"title\": \"bills\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JsonParser parser = new JsonParser();
        //JsonElement test = parser.parse(person2Json);
        JsonElement test = parser.parse(toDoList);
        System.out.println(test.isJsonObject());
        Gson gson = new Gson();
        //Simple person2 = gson.fromJson(person2Json, Simple.class);
        //System.out.println(person2.getClass().getSimpleName());
        Simple todosList = gson.fromJson(toDoList, Simple.class);
        System.out.println(todosList.getClass().getSimpleName());
        System.out.println(toDoList.toString());
    }
}
class ToDo{
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public ToDo(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}
class Simple{
    private String name;
    private int age;
    private boolean isDev;

    public Simple(String name, int age, boolean isDev) {
        this.name = name;
        this.age = age;
        this.isDev = isDev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDev() {
        return isDev;
    }

    public void setDev(boolean dev) {
        isDev = dev;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isDev=" + isDev +
                '}';
    }

}