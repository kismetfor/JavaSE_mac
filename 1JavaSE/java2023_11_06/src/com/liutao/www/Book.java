package com.liutao.www;

public class Book {
    private String name;
    private String author;
    private int shuliang;
    private String chubanshe;

    public Book() {
    }

    public Book(String name, String author, int shuliang, String chubanshe) {
        this.name = name;
        this.author = author;
        this.shuliang = shuliang;
        this.chubanshe = chubanshe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getShuliang() {
        return shuliang;
    }

    public void setShuliang(int shuliang) {
        this.shuliang = shuliang;
    }

    public String getChubanshe() {
        return chubanshe;
    }

    public void setChubanshe(String chubanshe) {
        this.chubanshe = chubanshe;
    }

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", shuliang=" + shuliang +
                ", chubanshe='" + chubanshe + '\'' +
                '}';
    }
}
