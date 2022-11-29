package logic;

import java.io.Serializable;

public class User extends Player implements Serializable {

    private final String name;
    public User(String name,CardList list){
        super(list);
        this.name = name;

    }
    public String getName() {
        return name;
    }
}
