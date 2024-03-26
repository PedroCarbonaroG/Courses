package view;

import model.entities.Department;

public class Prompt {
    
    public void startPrompt() {
        Department dp = new Department(1, "Books");
        System.err.println(dp);
    }
}
