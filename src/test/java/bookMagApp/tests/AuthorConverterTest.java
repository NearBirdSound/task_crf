package bookMagApp.tests;

import com.Andrey.bookMagApp.model.Author;
import com.Andrey.bookMagApp.dto.AuthorDTO;
import com.Andrey.bookMagApp.converter.AuthorConverter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthorConverterTest {
    private AuthorConverter authorConverter;

    @Before
    public void setUp() {
        authorConverter = new AuthorConverter();
    }

    @Test
    public void testToAuthorDTO() {
        Author author = new Author();
        author.setAuthorId(1L);
        author.setAuthorName("Александр Пушкин");

        AuthorDTO authorDTO = authorConverter.toAuthorDTO(author);

        assertEquals(author.getAuthorId(), authorDTO.getAuthorId());
        assertEquals(author.getAuthorName(), authorDTO.getAuthorName());
    }

    @Test
    public void testToAuthor() {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setAuthorId(1L);
        authorDTO.setAuthorName("Александр Пушкин");

        Author author = authorConverter.toAuthor(authorDTO);

        assertEquals(authorDTO.getAuthorId(), author.getAuthorId());
        assertEquals(authorDTO.getAuthorName(), author.getAuthorName());
    }

    @Test
    public void testToAuthorDTOList() {
        List<Author> authors = new ArrayList<>();
        Author author1 = new Author();
        author1.setAuthorId(1L);
        author1.setAuthorName("Александр Пушкин");
        Author author2 = new Author();
        author2.setAuthorId(2L);
        author2.setAuthorName("Александр Пушкин");
        authors.add(author1);
        authors.add(author2);

        List<AuthorDTO> authorDTOList = authorConverter.toAuthorDTOList(authors);

        assertEquals(2, authorDTOList.size());
        assertEquals(author1.getAuthorId(), authorDTOList.get(0).getAuthorId());
        assertEquals(author1.getAuthorName(), authorDTOList.get(0).getAuthorName());
        assertEquals(author2.getAuthorId(), authorDTOList.get(1).getAuthorId());
        assertEquals(author2.getAuthorName(), authorDTOList.get(1).getAuthorName());
    }
}
