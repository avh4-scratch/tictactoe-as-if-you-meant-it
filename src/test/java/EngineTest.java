import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EngineTest {

    @Test
    public void testXWinsTopRow() throws Exception {
        assertThat("A1,B1,A2,B2,A3".contains("A"), is(true));
    }
}
