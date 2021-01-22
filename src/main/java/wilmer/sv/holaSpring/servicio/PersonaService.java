/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilmer.sv.holaSpring.servicio;

import java.util.List;
import wilmer.sv.holaSpring.dominio.Persona;

/**
 *
 * @author wilme
 */
public interface PersonaService {
    public List<Persona> listarPersona();
    
    public void guardarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
}
