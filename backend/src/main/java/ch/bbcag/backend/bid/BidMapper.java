package ch.bbcag.backend.bid;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.container.Container;

import java.time.LocalDateTime;

public class BidMapper {

    private BidMapper() {}

    public static Bid fromRequestDTO(BidRequestDTO dto, Account account, Container container) {
        Bid bid = new Bid();
        bid.setAccount(account);
        bid.setContainer(container);
        bid.setAmount(dto.getAmount());
        bid.setCreatedAt(LocalDateTime.now());
        bid.setStatus(BidStatus.PENDING);
        return bid;
    }

    public static BidResponseDTO toResponseDTO(Bid bid) {
        BidResponseDTO dto = new BidResponseDTO();
        dto.setId(bid.getId());
        dto.setAccountId(bid.getAccount().getId());
        dto.setAccountName(bid.getAccount().getUsername());
        dto.setContainerId(bid.getContainer().getId());
        dto.setAmount(bid.getAmount());
        dto.setCreatedAt(bid.getCreatedAt());
        dto.setStatus(bid.getStatus());
        return dto;
    }
}
