/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PHONE")
@NamedQueries({
        @NamedQuery(name = "Phone.findAll", query = "SELECT s FROM Phone s")
})
@Getter @Setter
@EqualsAndHashCode(of = "model")
@ToString(of = {"id", "model"})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 3, max = 128)
    @Column(name = "MODEL")
    private String model;

    @Column(name = "PRICE")
    private double price;

    @JoinTable(name = "PHONE_SHOP", joinColumns = {
            @JoinColumn(name = "PHONE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "SHOP_ID", referencedColumnName = "ID")})
    @ManyToMany
    @JohnzonIgnore
    private List<Shop> shopsList = new ArrayList<>();

    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "ID")
    @ManyToOne
    @JohnzonIgnore
    private Manufacturer manufacturer;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;

}
