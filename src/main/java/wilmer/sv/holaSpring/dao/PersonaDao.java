/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilmer.sv.holaSpring.dao;
import wilmer.sv.holaSpring.dominio.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author wilme
 */

public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
