package s6.moderatorservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostCreatedEvent {
    private Integer id;
    private String text;
    private Integer userId;
}
