package ch.bbcag.backend.price;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Objects;

public class PriceRequestDTO {
    @NotBlank(message = "volume must not be empty")
    private String volume;
    @Min(value = 0, message = "must not be smaller than 0")
    private BigDecimal price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceRequestDTO that = (PriceRequestDTO) o;
        return Objects.equals(volume, that.volume) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, price);
    }

    public @NotBlank(message = "volume must not be empty") String getVolume() {
        return volume;
    }

    public void setVolume(@NotBlank(message = "volume must not be empty") String volume) {
        this.volume = volume;
    }

    public @Min(value = 0, message = "must not be smaller than 0") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@Min(value = 0, message = "must not be smaller than 0") BigDecimal price) {
        this.price = price;
    }
}
