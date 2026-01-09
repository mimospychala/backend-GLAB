package ch.bbcag.backend.container;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountRepository;
import ch.bbcag.backend.bid.BidRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;
    private final AccountRepository accountRepository;
    private final BidRepository bidRepository;

    public ContainerService(ContainerRepository containerRepository, AccountRepository accountRepository, BidRepository bidRepository) {
        this.containerRepository = containerRepository;
        this.accountRepository = accountRepository;
        this.bidRepository = bidRepository;
    }

    public Container findById(Integer id) {
        return containerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Container not found with id " + id));
    }

    public List<Container> findAll() {
        return containerRepository.findAll();
    }

    public List<Container> findByName(String name) {
        return containerRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Container> findByOwnerId(Integer ownerId) {
        return containerRepository.findByOwnerId(ownerId);
    }

    public Container insertFromDTO(ContainerRequestDTO dto, Account currentUser) {
        // Owner kommt aus JWT (currentUser), nicht aus DTO
        Container container = ContainerMapper.fromRequestDTO(dto, currentUser);
        return containerRepository.save(container);
    }



    public Container updateFromDTO(Integer id, ContainerRequestDTO dto) {
        Container existing = findById(id);

        Account owner = null;
        if (dto.getOwnerId() != null) {
            owner = accountRepository.findById(dto.getOwnerId())
                    .orElseThrow(() -> new EntityNotFoundException("Account not found with id " + dto.getOwnerId()));
        }

        ContainerMapper.updateFromRequestDTO(existing, dto, owner);
        return containerRepository.save(existing);
    }

    @Transactional
    public void deleteById(Integer id, Account currentUser) {
        Container existing = findById(id);

        if (!existing.getOwner().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You are not the owner of this container");
        }

        // ✅ zuerst alle Bids löschen
        bidRepository.deleteByContainerId(id);

        // ✅ dann Container löschen
        containerRepository.delete(existing);
    }

}
