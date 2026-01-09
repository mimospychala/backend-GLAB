package ch.bbcag.backend.bid;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountRepository;
import ch.bbcag.backend.container.Container;
import ch.bbcag.backend.container.ContainerRepository;
import ch.bbcag.backend.container.ContainerStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BidService {

    private final BidRepository bidRepository;
    private final AccountRepository accountRepository;
    private final ContainerRepository containerRepository;

    public BidService(BidRepository bidRepository,
                      AccountRepository accountRepository,
                      ContainerRepository containerRepository) {
        this.bidRepository = bidRepository;
        this.accountRepository = accountRepository;
        this.containerRepository = containerRepository;
    }

    public Bid findById(Integer id) {
        return bidRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bid not found with id " + id));
    }

    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    public List<Bid> findByAccountId(Integer accountId) {
        return bidRepository.findByAccountId(accountId);
    }

    public List<Bid> findByContainerId(Integer containerId) {
        return bidRepository.findByContainerId(containerId);
    }

    @Transactional
    public Bid createFromDTO(BidRequestDTO dto) {
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id " + dto.getAccountId()));

        Container container = containerRepository.findById(dto.getContainerId())
                .orElseThrow(() -> new EntityNotFoundException("Container not found with id " + dto.getContainerId()));

        if (container.getStatus() != ContainerStatus.ACTIVE) {
            throw BidException.conflict("Container is not active");
        }

        // Nicht auf eigenen Container bieten
        if (container.getOwner().getId().equals(account.getId())) {
            throw BidException.badRequest("Owner cannot bid on own container");
        }

        // Muss höher als aktuelles HighestBid sein
        BigDecimal currentHighest = getHighestBidAmountForContainer(container.getId());
        if (currentHighest != null && dto.getAmount().compareTo(currentHighest) <= 0) {
            throw BidException.conflict(
                    "Neues Gebot muss höher sein als das höchste Gebot (" + currentHighest + " CHF)."
            );
        }

        // Balance check
        if (account.getBalance().compareTo(dto.getAmount()) < 0) {
            throw BidException.conflict("Nicht genügend Balance für dieses Gebot.");
        }

        // Balance abziehen
        account.setBalance(account.getBalance().subtract(dto.getAmount()));
        accountRepository.save(account);

        Bid bid = BidMapper.fromRequestDTO(dto, account, container);
        return bidRepository.save(bid);
    }


    public void deleteById(Integer id) {
        Bid existing = findById(id);
        bidRepository.delete(existing);
    }

    public BigDecimal getHighestBidAmountForContainer(Integer containerId) {
        return bidRepository.findTopByContainerIdOrderByAmountDesc(containerId)
                .map(Bid::getAmount)
                .orElse(null);
    }

    public Long countBidsForContainer(Integer containerId) {
        return bidRepository.countByContainerId(containerId);
    }
}
