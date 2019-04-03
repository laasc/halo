package cc.ryanc.halo.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

/**
 * Gallery entity
 *
 * @author : RYAN0UP
 * @date : 2019-03-12
 */
@Data
@Entity
@Table(name = "galleries")
@SQLDelete(sql = "update galleries set deleted = true where id = ?")
@Where(clause = "deleted = false")
@ToString
@EqualsAndHashCode(callSuper = true)
public class Gallery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Picture name.
     */
    @Column(name = "name", columnDefinition = "varchar(255) not null")
    private String name;

    /**
     * Picture description.
     */
    @Column(name = "description", columnDefinition = "varchar(255) default ''")
    private String description;

    /**
     * Shooting time / creation time.
     */
    @Column(name = "take_time", columnDefinition = "timestamp not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takeTime;

    /**
     * Picture location.
     */
    @Column(name = "location", columnDefinition = "varchar(255) default ''")
    private String location;

    /**
     * Thumbnail
     */
    @Column(name = "thumbnail", columnDefinition = "varchar(1023) default ''")
    private String thumbnail;

    /**
     * Picture access path.
     */
    @Column(name = "url", columnDefinition = "varchar(1023) not null")
    private String url;

    @Override
    public void prePersist() {
        super.prePersist();
        id = null;
    }
}