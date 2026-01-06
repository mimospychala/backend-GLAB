package ch.bbcag.backend.container;

import ch.bbcag.backend.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContainerMapper {

    private ContainerMapper() {}

    public static Container fromRequestDTO(ContainerRequestDTO dto, Account owner) {
        Container c = new Container();
        c.setOwner(owner);
        c.setName(dto.getName());
        c.setDescription(dto.getDescription());
        c.setAskingPrice(dto.getAskingPrice());
        c.setImageUrls(dto.getImageUrls());
        c.setCreatedAt(LocalDateTime.now());
        c.setStatus(ContainerStatus.ACTIVE);
        return c;
    }

    public static void updateFromRequestDTO(Container c, ContainerRequestDTO dto, Account owner) {
        if (owner != null) c.setOwner(owner);
        if (dto.getName() != null) c.setName(dto.getName());
        if (dto.getDescription() != null) c.setDescription(dto.getDescription());
        if (dto.getAskingPrice() != null) c.setAskingPrice(dto.getAskingPrice());
        if (dto.getImageUrls() != null) c.setImageUrls(dto.getImageUrls());
    }

    public static ContainerResponseDTO toResponseDTO(Container c, BigDecimal highestBid, Long bidCount) {
        ContainerResponseDTO dto = new ContainerResponseDTO();
        dto.setId(c.getId());
        dto.setOwnerId(c.getOwner().getId());
        dto.setOwnerName(c.getOwner().getUsername());
        dto.setName(c.getName());
        dto.setDescription(c.getDescription());
        dto.setAskingPrice(c.getAskingPrice());
        dto.setImageUrls(c.getImageUrls());
        dto.setCreatedAt(c.getCreatedAt());
        dto.setStatus(c.getStatus());
        dto.setHighestBid(highestBid);
        dto.setBidCount(bidCount);
        return dto;
    }
}
