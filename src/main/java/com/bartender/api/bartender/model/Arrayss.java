package com.bartender.api.bartender.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "arrays")
public class Arrayss {
    @Id
    @Min(value = 1, message = "El id debe ser minmo 1")
    @Max(value = 5, message = "El id debe ser máximo 5")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Debe agregar un array")
    @NotBlank(message = "El array no puede estar vacio")
    @Column(length = 20)
    private String input_array;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInput_array() {
        return input_array;
    }

    public void setInput_array(String input_array) {
        this.input_array = input_array;
    }

    
}
