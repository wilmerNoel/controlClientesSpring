/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilmer.sv.holaSpring.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wilmer.sv.holaSpring.dao.PersonaDao;
import wilmer.sv.holaSpring.dominio.Persona;

/**
 *
 * @author wilme
 */
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaDao personaDao;
    @Override
    
    @Transactional(readOnly = true)
    public List<Persona> listarPersona() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardarPersona(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminarPersona(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
