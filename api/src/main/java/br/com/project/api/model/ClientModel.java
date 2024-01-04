package br.com.project.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "clients")
@Data
public class ClientModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long code;

@NonNull
private String name;

@NonNull
@Size(min = 3)
private int age;

@NonNull
private String city;

@NotNull(message = "O numero não pode ser nulo.")
@Size(min = 11, message = "O número deve ter no mínimo 11 caracteres.")
@Column(unique = true, nullable = false)
private int number;
    
}
