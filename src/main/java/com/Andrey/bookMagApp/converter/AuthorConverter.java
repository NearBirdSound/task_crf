package com.Andrey.bookMagApp.converter;

import com.Andrey.bookMagApp.model.Author;
import com.Andrey.bookMagApp.dto.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorConverter {
    public AuthorDTO toAuthorDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setAuthorId(author.getAuthorId());
        authorDTO.setAuthorName(author.getAuthorName());
        return authorDTO;
    }

    public Author toAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setAuthorId(authorDTO.getAuthorId());
        author.setAuthorName(authorDTO.getAuthorName());
        return author;
    }

    public List<AuthorDTO> toAuthorDTOList(List<Author> authors) {
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author : authors) {
            AuthorDTO authorDTO = toAuthorDTO(author);
            authorDTOList.add(authorDTO);
        }

        return authorDTOList;
    }
}
