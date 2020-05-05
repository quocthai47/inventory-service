package metanet.poc.inventoryservice.service;


import metanet.poc.inventoryservice.dto.ProductDto;

public interface InventoryService {

    void reduceStock(ProductDto productDto);
}
