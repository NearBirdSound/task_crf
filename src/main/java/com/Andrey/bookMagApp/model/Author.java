package com.Andrey.bookMagApp.model;

/**
 * Класс-сущность автора.
 */
public class Author {
    private long authorId;
    private String authorName;

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
