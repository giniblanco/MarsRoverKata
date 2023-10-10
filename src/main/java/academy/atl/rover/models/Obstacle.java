package academy.atl.rover.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "obstacle")
public class Obstacle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "pos_x")
    private Integer x;
    @Column(name = "pos_y")
    private Integer y;
}
