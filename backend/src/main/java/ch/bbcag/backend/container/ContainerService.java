package ch.bbcag.backend.container;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.account.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {

    private final ContainerRepository containerRepository;
    private final AccountRepository accountRepository;

    public ContainerService(ContainerRepository containerRepository, AccountRepository accountRepository) {
        this.containerRepository = containerRepository;
        this.accountRepository = accountRepository;
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

    public Container insertFromDTO(ContainerRequestDTO dto) {
        Account owner = accountRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new EntityNotFoundException("Account not found with id " + dto.getOwnerId()));
        Container container = ContainerMapper.fromRequestDTO(dto, owner);
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

    public void deleteById(Integer id) {
        Container existing = findById(id);
        containerRepository.delete(existing);
    }
}
