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

private String name;

private int age;

private String city;

private int number;
    
}
