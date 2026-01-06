package ch.bbcag.backend.bid;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class BidRequestDTO {

    @NotNull
    private Integer accountId;

    @NotNull
    private Integer containerId;

    @NotNull
    @Positive
    private BigDecimal amount;

    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }

    public Integer getContainerId() { return containerId; }
    public void setContainerId(Integer containerId) { this.containerId = containerId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
