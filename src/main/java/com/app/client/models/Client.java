package com.app.client.models;

import com.app.address.models.Address;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;
    private String name;
    private String document;
    @OneToOne
    private Address address;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
