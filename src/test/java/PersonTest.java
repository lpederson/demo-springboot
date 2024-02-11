import org.junit.jupiter.api.Test;

import java.util.Objects;

public class PersonTest {

    @Test
    public void PersonTest() {
        Person p = new Person();
        p.setName("foo");
        assert Objects.equals(p.name, "foo");
    }
}
