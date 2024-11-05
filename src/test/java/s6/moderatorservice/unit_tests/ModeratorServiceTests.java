package s6.moderatorservice.unit_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import s6.moderatorservice.service.ModeratorService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ModeratorServiceTests {
    private ModeratorService moderatorService;
    @BeforeEach
    public void setUp() {
        moderatorService = new ModeratorService();
    }

    @Test
    public void testOffensiveText_Success(){
        String text1 = "offensive";
        String text2 = "Offensive";

        Boolean result1 = moderatorService.isOffensive(text1);
        Boolean result2 = moderatorService.isOffensive(text2);

        assertTrue(result1);
        assertTrue(result2);
    }
    @Test
    public void testOffensiveTextNull_False(){
        String text = null;

        Boolean result = moderatorService.isOffensive(text);

        assertFalse(result);
    }
    @Test
    public void testOffensiveTextEmpty_False(){
        String text = "";

        Boolean result = moderatorService.isOffensive(text);

        assertFalse(result);
    }
    @Test
    public void testNonOffensiveText_Success(){
        String text = "not offensive";

        Boolean result = moderatorService.isOffensive(text);

        assertFalse(result);
    }
}
