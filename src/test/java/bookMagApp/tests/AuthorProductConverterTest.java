package bookMagApp.tests;

import com.Andrey.bookMagApp.model.AuthorProduct;
import com.Andrey.bookMagApp.dto.AuthorProductDTO;
import com.Andrey.bookMagApp.converter.AuthorProductConverter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class AuthorProductConverterTest {
    private AuthorProductConverter authorProductConverter;

    @Before
    public void setUp() {
        authorProductConverter = new AuthorProductConverter();
    }

    @Test
    public void testToAuthorProductDTO() {
        AuthorProduct authorProduct = new AuthorProduct();
        authorProduct.setAuthorId(1L);
        authorProduct.setProductId(2L);

        AuthorProductDTO authorProductDTO = authorProductConverter.toAuthorProductDTO(authorProduct);

        assertEquals(authorProduct.getAuthorId(), authorProductDTO.getAuthorId());
        assertEquals(authorProduct.getProductId(), authorProductDTO.getProductId());
    }

    @Test
    public void testToAuthorProduct() {
        AuthorProductDTO authorProductDTO = new AuthorProductDTO();
        authorProductDTO.setAuthorId(3L);
        authorProductDTO.setProductId(4L);

        AuthorProduct authorProduct = authorProductConverter.toAuthorProduct(authorProductDTO);

        assertEquals(authorProductDTO.getAuthorId(), authorProduct.getAuthorId());
        assertEquals(authorProductDTO.getProductId(), authorProduct.getProductId());
    }

    @Test
    public void testToAuthorProductDTOList() {
        List<AuthorProduct> authorProducts = new ArrayList<>();
        AuthorProduct authorProduct1 = new AuthorProduct();
        authorProduct1.setAuthorId(1L);
        authorProduct1.setProductId(2L);
        AuthorProduct authorProduct2 = new AuthorProduct();
        authorProduct2.setAuthorId(3L);
        authorProduct2.setProductId(4L);
        authorProducts.add(authorProduct1);
        authorProducts.add(authorProduct2);

        List<AuthorProductDTO> authorProductDTOList = authorProductConverter.toAuthorProductDTOList(authorProducts);

        assertEquals(2, authorProductDTOList.size());
        assertEquals(authorProduct1.getAuthorId(), authorProductDTOList.get(0).getAuthorId());
        assertEquals(authorProduct1.getProductId(), authorProductDTOList.get(0).getProductId());
        assertEquals(authorProduct2.getAuthorId(), authorProductDTOList.get(1).getAuthorId());
        assertEquals(authorProduct2.getProductId(), authorProductDTOList.get(1).getProductId());
    }
}
