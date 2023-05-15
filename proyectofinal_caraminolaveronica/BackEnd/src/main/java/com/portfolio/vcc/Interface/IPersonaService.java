/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vcc.Interface;

import com.portfolio.vcc.Entity.Persona;
import java.util.List;

public interface IPersonaService {
//Trer una lista de personas
public List<Persona> getPersona();


//Guardar un objeto de tipo persona 
public void savePersona(Persona persona);

//Eiminar un objeto pero lo buscamos por ID
public void deletePersona(Long id);
//Buscar una persona por ID
public Persona findPersona(Long id);
}
