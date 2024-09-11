package solidcitadel.transitplanner.domain.transport.stop;

import lombok.Data;
import solidcitadel.transitplanner.domain.transport.Type;

@Data
public class Stop {
    private Long id;
    private String name;
    private Type type;

    public Stop(Type type, String name) {
        this.type = type;
        this.name = name;
    }
}
