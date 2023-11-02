package com.Andrey.bookMagApp.controller;

import com.Andrey.bookMagApp.converter.PurchaseHistoryConverter;
import com.Andrey.bookMagApp.dto.PurchaseHistoryDTO;
import com.Andrey.bookMagApp.model.PurchaseHistory;
import com.Andrey.bookMagApp.model.User;
import com.Andrey.bookMagApp.service.PurchaseHistoryService;
import com.Andrey.bookMagApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchaseHistory")
public class PurchaseHistoryController {
    private final PurchaseHistoryService purchaseHistoryServiceImpl;
    private final UserService userService;
    private final PurchaseHistoryConverter purchaseHistoryConverter;
    @Autowired
    public PurchaseHistoryController(PurchaseHistoryService purchaseHistoryServiceImpl, UserService userService, PurchaseHistoryConverter purchaseHistoryConverter) {
        this.purchaseHistoryServiceImpl = purchaseHistoryServiceImpl;
        this.userService = userService;
        this.purchaseHistoryConverter = purchaseHistoryConverter;
    }

    //Make purchase
    @RequestMapping(value = "/make-purchase", method = RequestMethod.POST)
    public void makePurchase(
            @RequestParam("userId") int userId,
            @RequestParam("productId") int productId,
            @RequestParam("quantity") int quantity
    ) {
        User user = userService.getById(userId);
        purchaseHistoryServiceImpl.makePurchase(user, productId, quantity);
    }


    //CRUD Operation

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<PurchaseHistoryDTO> getAllPurchaseHistory() {
        return purchaseHistoryConverter.toPurchaseHistoryDTOList(purchaseHistoryServiceImpl.getAll());
    }

    @RequestMapping(value = "/one/{purchaseId}", method = RequestMethod.GET)
    @ResponseBody
    public PurchaseHistoryDTO getPurchaseHistoryById(@PathVariable("purchaseId") int purchaseId) {
        return purchaseHistoryConverter.toPurchaseHistoryDTO(purchaseHistoryServiceImpl.getById(purchaseId));
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public void addPurchaseHistory(@RequestBody PurchaseHistory purchaseHistory) {
        purchaseHistoryServiceImpl.add(purchaseHistory);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updatePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory) {
        purchaseHistoryServiceImpl.update(purchaseHistory);
    }

    @RequestMapping(value = "/del/{purchaseId}", method = RequestMethod.DELETE)
    public void deletePurchaseHistory(@PathVariable("purchaseId") int purchaseId) {
        purchaseHistoryServiceImpl.delete(purchaseId);
    }
}