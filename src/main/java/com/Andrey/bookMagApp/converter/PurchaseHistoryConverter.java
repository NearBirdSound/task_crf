package com.Andrey.bookMagApp.converter;

import com.Andrey.bookMagApp.model.PurchaseHistory;
import com.Andrey.bookMagApp.dto.PurchaseHistoryDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseHistoryConverter {
    public PurchaseHistoryDTO toPurchaseHistoryDTO(PurchaseHistory purchaseHistory) {
        PurchaseHistoryDTO purchaseHistoryDTO = new PurchaseHistoryDTO();
        purchaseHistoryDTO.setPurchaseId(purchaseHistory.getPurchaseId());
        purchaseHistoryDTO.setUserId(purchaseHistory.getUserId());
        purchaseHistoryDTO.setProductId(purchaseHistory.getProductId());
        purchaseHistoryDTO.setQuantity(purchaseHistory.getQuantity());
        purchaseHistoryDTO.setCost(purchaseHistory.getCost());

        // Преобразование Date в String
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String purchaseDateStr = dateFormat.format(purchaseHistory.getPurchaseDate());
        purchaseHistoryDTO.setPurchaseDate(purchaseDateStr);

        return purchaseHistoryDTO;
    }

    public PurchaseHistory toPurchaseHistory(PurchaseHistoryDTO purchaseHistoryDTO) {
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setPurchaseId(purchaseHistoryDTO.getPurchaseId());
        purchaseHistory.setUserId(purchaseHistoryDTO.getUserId());
        purchaseHistory.setProductId(purchaseHistoryDTO.getProductId());
        purchaseHistory.setQuantity(purchaseHistoryDTO.getQuantity());
        purchaseHistory.setCost(purchaseHistoryDTO.getCost());

        // Преобразование String в Date
        String purchaseDateStr = purchaseHistoryDTO.getPurchaseDate();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Формат даты
            java.util.Date utilDate = dateFormat.parse(purchaseDateStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            purchaseHistory.setPurchaseDate(sqlDate);
        } catch (ParseException e) {
            // Обработка ошибки парсинга даты
        }
        return purchaseHistory;
    }

    public List<PurchaseHistoryDTO> toPurchaseHistoryDTOList(List<PurchaseHistory> purchaseHistories) {
        List<PurchaseHistoryDTO> purchaseHistoryDTOList = new ArrayList<>();

        for (PurchaseHistory purchaseHistory : purchaseHistories) {
            PurchaseHistoryDTO purchaseHistoryDTO = toPurchaseHistoryDTO(purchaseHistory);
            purchaseHistoryDTOList.add(purchaseHistoryDTO);
        }

        return purchaseHistoryDTOList;
    }

}
