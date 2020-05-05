package metanet.poc.inventoryservice.controller;

import metanet.poc.inventoryservice.dto.ProductDto;
import metanet.poc.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/inventory", produces = MediaType.APPLICATION_JSON_VALUE)
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/reduceStock")
    @ResponseStatus(HttpStatus.OK)
    public void reduceStock(@RequestBody ProductDto reduceStockRequest) {
        inventoryService.reduceStock(reduceStockRequest);
    }
}