package ch.bbcag.backend.bid;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BidRepository extends JpaRepository<Bid, Integer> {

    List<Bid> findByAccountId(Integer accountId);

    List<Bid> findByContainerId(Integer containerId);

    long countByContainerId(Integer containerId);

    Optional<Bid> findTopByContainerIdOrderByAmountDesc(Integer containerId);
}
