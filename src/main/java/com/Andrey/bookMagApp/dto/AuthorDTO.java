package com.Andrey.bookMagApp.dto;

import javax.validation.constraints.NotNull;

public class AuthorDTO {
    @NotNull
    private long authorId;
    @NotNull
    private String authorName;

    public AuthorDTO() {
    }

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

    @Override
    public String toString() {
        return "id автора: " + authorId + " , Имя автора = " + authorName + '\'';
    }
}
