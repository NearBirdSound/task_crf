package bookMagApp.tests;

import com.Andrey.bookMagApp.model.PurchaseHistory;
import com.Andrey.bookMagApp.dto.PurchaseHistoryDTO;
import com.Andrey.bookMagApp.converter.PurchaseHistoryConverter;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PurchaseHistoryConverterTest {
    private PurchaseHistoryConverter purchaseHistoryConverter;

    @Before
    public void setUp() {
        purchaseHistoryConverter = new PurchaseHistoryConverter();
    }

    @Test
    public void testToPurchaseHistoryDTO() {
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setPurchaseId(1);
        purchaseHistory.setUserId(2);
        purchaseHistory.setProductId(3);
        purchaseHistory.setQuantity(4);
        purchaseHistory.setCost(new BigDecimal("50.0"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date purchaseDate = new Date();
        try {
            purchaseDate = dateFormat.parse("2023-11-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        purchaseHistory.setPurchaseDate(new java.sql.Date(purchaseDate.getTime()));

        PurchaseHistoryDTO purchaseHistoryDTO = purchaseHistoryConverter.toPurchaseHistoryDTO(purchaseHistory);

        assertEquals(purchaseHistory.getPurchaseId(), purchaseHistoryDTO.getPurchaseId());
        assertEquals(purchaseHistory.getUserId(), purchaseHistoryDTO.getUserId());
        assertEquals(purchaseHistory.getProductId(), purchaseHistoryDTO.getProductId());
        assertEquals(purchaseHistory.getQuantity(), purchaseHistoryDTO.getQuantity());
        assertEquals(purchaseHistory.getCost(), purchaseHistoryDTO.getCost());
        assertEquals("2023-11-01", purchaseHistoryDTO.getPurchaseDate());
    }

    @Test
    public void testToPurchaseHistory() {
        PurchaseHistoryDTO purchaseHistoryDTO = new PurchaseHistoryDTO();
        purchaseHistoryDTO.setPurchaseId(1);
        purchaseHistoryDTO.setUserId(2);
        purchaseHistoryDTO.setProductId(3);
        purchaseHistoryDTO.setQuantity(4);
        purchaseHistoryDTO.setCost(new BigDecimal("50.0"));
        purchaseHistoryDTO.setPurchaseDate("2023-11-01");

        PurchaseHistory purchaseHistory = purchaseHistoryConverter.toPurchaseHistory(purchaseHistoryDTO);

        assertEquals(purchaseHistoryDTO.getPurchaseId(), purchaseHistory.getPurchaseId());
        assertEquals(purchaseHistoryDTO.getUserId(), purchaseHistory.getUserId());
        assertEquals(purchaseHistoryDTO.getProductId(), purchaseHistory.getProductId());
        assertEquals(purchaseHistoryDTO.getQuantity(), purchaseHistory.getQuantity());
        assertEquals(purchaseHistoryDTO.getCost(), purchaseHistory.getCost());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date expectedPurchaseDate = dateFormat.parse("2023-11-01");
            assertEquals(expectedPurchaseDate, purchaseHistory.getPurchaseDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToPurchaseHistoryDTOList() {
        List<PurchaseHistory> purchaseHistories = new ArrayList<>();
        PurchaseHistory purchaseHistory1 = new PurchaseHistory();
        purchaseHistory1.setPurchaseId(1);
        purchaseHistory1.setUserId(2);
        purchaseHistory1.setProductId(3);
        purchaseHistory1.setQuantity(4);
        purchaseHistory1.setCost(new BigDecimal("50.0"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date purchaseDate1 = new Date();
        try {
            purchaseDate1 = dateFormat.parse("2023-11-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        purchaseHistory1.setPurchaseDate(new java.sql.Date(purchaseDate1.getTime()));

        PurchaseHistory purchaseHistory2 = new PurchaseHistory();
        purchaseHistory2.setPurchaseId(5);
        purchaseHistory2.setUserId(6);
        purchaseHistory2.setProductId(7);
        purchaseHistory2.setQuantity(8);
        purchaseHistory2.setCost(new BigDecimal("75.0"));
        Date purchaseDate2 = new Date();
        try {
            purchaseDate2 = dateFormat.parse("2023-11-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        purchaseHistory2.setPurchaseDate(new java.sql.Date(purchaseDate2.getTime()));

        purchaseHistories.add(purchaseHistory1);
        purchaseHistories.add(purchaseHistory2);

        List<PurchaseHistoryDTO> purchaseHistoryDTOList = purchaseHistoryConverter.toPurchaseHistoryDTOList(purchaseHistories);

        assertEquals(2, purchaseHistoryDTOList.size());
        assertEquals(purchaseHistory1.getPurchaseId(), purchaseHistoryDTOList.get(0).getPurchaseId());
        assertEquals(purchaseHistory2.getPurchaseId(), purchaseHistoryDTOList.get(1).getPurchaseId());
    }
}
