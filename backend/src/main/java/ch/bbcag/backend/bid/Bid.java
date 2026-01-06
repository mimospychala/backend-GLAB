package ch.bbcag.backend.bid;

import ch.bbcag.backend.account.Account;
import ch.bbcag.backend.container.Container;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Account account;

    @ManyToOne(optional = false)
    private Container container;

    private BigDecimal amount;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BidStatus status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    public Container getContainer() { return container; }
    public void setContainer(Container container) { this.container = container; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public BidStatus getStatus() { return status; }
    public void setStatus(BidStatus status) { this.status = status; }
}

