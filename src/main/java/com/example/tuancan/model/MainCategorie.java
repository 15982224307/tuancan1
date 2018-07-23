package com.example.tuancan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maincategorie")

public class MainCategorie {

    /*食材主类编号*/
    @Id
    @Column(name = "maincategorie_id")
    private Integer maincategorieId;

    /*食材主类名称*/
    @Column(name = "maincategorie_name")
    private String maincategorieName;
}
