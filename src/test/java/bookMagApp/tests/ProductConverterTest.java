package bookMagApp.tests;

import com.Andrey.bookMagApp.model.Product;
import com.Andrey.bookMagApp.dto.ProductDTO;
import com.Andrey.bookMagApp.converter.ProductConverter;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductConverterTest {
    private ProductConverter productConverter;

    @Before
    public void setUp() {
        productConverter = new ProductConverter();
    }

    @Test
    public void testToProductDTO() {
        Product product = new Product();
        product.setProductId(1L);
        product.setProductType("Книга");
        product.setTitle("Пример книги");
        product.setPurchasePrice(new BigDecimal("10.0"));
        product.setMarkup(new BigDecimal("2.0"));
        product.setQuantityProducts(100);

        ProductDTO productDTO = productConverter.toProductDTO(product);

        assertEquals(product.getProductId(), productDTO.getProductId());
        assertEquals(product.getProductType(), productDTO.getProductType());
        assertEquals(product.getTitle(), productDTO.getTitle());
        assertEquals(product.getPurchasePrice(), productDTO.getPurchasePrice());
        assertEquals(product.getMarkup(), productDTO.getMarkup());
        assertEquals(product.getQuantityProducts(), productDTO.getQuantityProducts());
    }

    @Test
    public void testToProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(2L);
        productDTO.setProductType("Журнал");
        productDTO.setTitle("Пример журнала");
        productDTO.setPurchasePrice(new BigDecimal("5.0"));
        productDTO.setMarkup(new BigDecimal("1.0"));
        productDTO.setQuantityProducts(50);

        Product product = productConverter.toProduct(productDTO);

        assertEquals(productDTO.getProductId(), product.getProductId());
        assertEquals(productDTO.getProductType(), product.getProductType());
        assertEquals(productDTO.getTitle(), product.getTitle());
        assertEquals(productDTO.getPurchasePrice(), product.getPurchasePrice());
        assertEquals(productDTO.getMarkup(), product.getMarkup());
        assertEquals(productDTO.getQuantityProducts(), product.getQuantityProducts());
    }

    @Test
    public void testToProductDTOList() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId(1L);
        product1.setProductType("Книга");
        product1.setTitle("Пример книги");
        product1.setPurchasePrice(new BigDecimal("10.0"));
        product1.setMarkup(new BigDecimal("2.0"));
        product1.setQuantityProducts(100);

        Product product2 = new Product();
        product2.setProductId(2L);
        product2.setProductType("Журнал");
        product2.setTitle("Пример журнала");
        product2.setPurchasePrice(new BigDecimal("5.0"));
        product2.setMarkup(new BigDecimal("1.0"));
        product2.setQuantityProducts(50);

        products.add(product1);
        products.add(product2);

        List<ProductDTO> productDTOList = productConverter.toProductDTOList(products);

        assertEquals(2, productDTOList.size());
        assertEquals(product1.getProductId(), productDTOList.get(0).getProductId());
        assertEquals(product2.getProductId(), productDTOList.get(1).getProductId());
    }
}
