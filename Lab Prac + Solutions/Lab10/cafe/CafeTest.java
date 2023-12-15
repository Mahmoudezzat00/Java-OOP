package cafe;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CafeTest {
    @Test
    public void test() {
        Bartender bartender = new Bartender(18);
        assertTrue(bartender.order(new Adult("X Y", 17)));
    }
}
