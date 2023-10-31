package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        var tomorrow = LocalDate.now().plusDays(1);
        var issue = new Issue("App flow tests?", "We need to test the App!", tomorrow);
        var task = new Task("Test the application flow", "Pesho", tomorrow);

        Board board = new Board();

        board.addItem(issue);
        board.addItem(task);
        System.out.println(board.totalItems()); // 2
    }

}
