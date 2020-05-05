package metanet.poc.inventoryservice.service.impl;

import metanet.poc.inventoryservice.dto.ProductDto;
import metanet.poc.inventoryservice.entity.Inventory;
import metanet.poc.inventoryservice.repository.InventoryRepository;
import metanet.poc.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.Optional;


@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public void reduceStock(ProductDto productDto) {

        Optional<Inventory> itemInventoryOpt = inventoryRepository.findById(productDto.getItemId());

        if(!itemInventoryOpt.isPresent()) {
            throw new InvalidParameterException("Can not found item id " +  productDto.getItemId().toString());
        } else {
            Inventory itemInventory =  itemInventoryOpt.get();

            if(itemInventory.getQuantity() < productDto.getQuantity()) {
                throw new InvalidParameterException("Out of stock " +  productDto.getItemId().toString());
            }


            Integer updateQuantity = itemInventory.getQuantity() - productDto.getQuantity();
            itemInventory.setQuantity(updateQuantity);
            inventoryRepository.save(itemInventory);
        }

    }
}
