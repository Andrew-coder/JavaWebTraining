package Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 11/15/2016.
 */
public interface User {
    void sendMessage(String message);
    void getMessage(String message);
}

public interface Chat {
    void sendMessage(String message, User user);
}

public class Admin implements User {
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message,this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin receives the message!");
    }
}

public class SimpleUser implements User {
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message,this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User receives the message!");
    }
}

public class TextChat implements Chat {
    List<User> users;
    User admin;

    public TextChat() {
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void setAdmin(User admin) {
        this.admin=admin;
    }

    @Override
    public void sendMessage(String message, User user) {
        for(User u:users)
            u.getMessage(message);
        admin.getMessage(message);
    }
}

class Main {
    public static void main(String[] args) {
        TextChat chat = new TextChat();
        User u1 = new SimpleUser(chat);
        User u2 = new SimpleUser(chat);
        User admin = new Admin(chat);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.setAdmin(admin);

        u1.sendMessage("Hello from u1");
    }
}