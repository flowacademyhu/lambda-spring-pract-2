package hu.flowacademy.cowstable.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Stable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Getter
    private String address;
    @OneToMany(cascade = ALL, mappedBy = "stable")
    @Getter
    @JsonIgnore
    private Collection<Cow> cows;
}
