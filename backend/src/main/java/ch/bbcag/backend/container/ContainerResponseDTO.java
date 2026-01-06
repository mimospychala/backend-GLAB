package ch.bbcag.backend.container;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ContainerResponseDTO {

    private Integer id;

    private Integer ownerId;
    private String ownerName;

    private String name;
    private String description;
    private BigDecimal askingPrice;
    private List<String> imageUrls;
    private LocalDateTime createdAt;
    private ContainerStatus status;

    private BigDecimal highestBid;
    private Long bidCount;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getOwnerId() { return ownerId; }
    public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getAskingPrice() { return askingPrice; }
    public void setAskingPrice(BigDecimal askingPrice) { this.askingPrice = askingPrice; }

    public List<String> getImageUrls() { return imageUrls; }
    public void setImageUrls(List<String> imageUrls) { this.imageUrls = imageUrls; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public ContainerStatus getStatus() { return status; }
    public void setStatus(ContainerStatus status) { this.status = status; }

    public BigDecimal getHighestBid() { return highestBid; }
    public void setHighestBid(BigDecimal highestBid) { this.highestBid = highestBid; }

    public Long getBidCount() { return bidCount; }
    public void setBidCount(Long bidCount) { this.bidCount = bidCount; }
}
