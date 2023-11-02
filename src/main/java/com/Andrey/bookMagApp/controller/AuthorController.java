package com.Andrey.bookMagApp.controller;

import com.Andrey.bookMagApp.converter.AuthorConverter;
import com.Andrey.bookMagApp.dto.AuthorDTO;
import com.Andrey.bookMagApp.model.Author;
import com.Andrey.bookMagApp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorConverter authorConverter;
    @Autowired
    public AuthorController(AuthorService authorService, AuthorConverter authorConverter) {
        this.authorService = authorService;
        this.authorConverter = authorConverter;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorService.getAll();
        return authorConverter.toAuthorDTOList(authors);
    }

    @RequestMapping(value = "/one/{authorId}", method = RequestMethod.GET)
    @ResponseBody
    public AuthorDTO getAuthorById(@PathVariable("authorId") int authorId) {
        return authorConverter.toAuthorDTO(authorService.getById(authorId));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addAuthor(@RequestBody Author author) {
        authorService.add(author);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateAuthor(@RequestBody Author author) {
        authorService.update(author);
    }

    @RequestMapping(value = "/del/{authorId}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable("authorId") int authorId) {
        authorService.delete(authorId);
    }
}
