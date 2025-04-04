package ch.bbcag.backend.price;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> findAll() {
        return priceRepository.findAll();
    }

    public Price findById(Integer id) {
        return priceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Price insert(Price price) {
        return priceRepository.save(price);
    }

    public Price update(Price changingPrice, Integer id) {
        Price existingPrice = this.findById(id);
        changingPrice.setId(id);
        return priceRepository.save(changingPrice);
    }

    public void deleteById(Integer id) {
        findById(id); // throw exception if not found
        priceRepository.deleteById(id);
    }
}
