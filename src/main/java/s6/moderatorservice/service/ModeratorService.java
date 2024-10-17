package s6.moderatorservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeratorService {
    public Boolean isOffensive(String result) {
        if(result == null || result.isEmpty()){
            return false;
        }
        return result.equalsIgnoreCase("offensive");
    }
}
