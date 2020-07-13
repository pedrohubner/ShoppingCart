package com.app.address.models;

import com.app.country.models.Country;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;
    private String street;
    private Integer number;
    @OneToOne
    @ToString.Exclude
    private Country country;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
