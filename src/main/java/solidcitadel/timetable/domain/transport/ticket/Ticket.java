package solidcitadel.timetable.domain.transport.ticket;

import lombok.Data;
import solidcitadel.timetable.domain.transport.Time;
import solidcitadel.timetable.domain.transport.Type;
import solidcitadel.timetable.domain.transport.stop.Stop;

@Data
public class Ticket {
    private Long id;
    private Type type;
    private Stop departure;
    private Stop destination;
    private Time departureTime;
    private Time requiredTime;
    private Integer fare;

    public Ticket(Type type, Stop departure, Stop destination, Time departureTime, Time requiredTime, Integer fare) {
        this.type = type;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.requiredTime = requiredTime;
        this.fare = fare;
    }
}
