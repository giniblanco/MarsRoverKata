package academy.atl.rover.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rover")
public class Rover {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "pos_x")
    private Integer x;
    @Column(name = "pos_y")
    private Integer y;
    @Enumerated(EnumType.STRING)
    @Column(name = "direction")
    private Direction direction;
}
