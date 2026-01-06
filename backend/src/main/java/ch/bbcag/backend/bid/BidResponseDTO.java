package ch.bbcag.backend.bid;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BidResponseDTO {

    private Integer id;
    private Integer accountId;
    private String accountName;
    private Integer containerId;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private BidStatus status;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }

    public String getAccountName() { return accountName; }
    public void setAccountName(String accountName) { this.accountName = accountName; }

    public Integer getContainerId() { return containerId; }
    public void setContainerId(Integer containerId) { this.containerId = containerId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public BidStatus getStatus() { return status; }
    public void setStatus(BidStatus status) { this.status = status; }
}
