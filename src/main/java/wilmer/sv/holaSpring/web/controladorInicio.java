/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilmer.sv.holaSpring.web;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import wilmer.sv.holaSpring.servicio.PersonaService;
import wilmer.sv.holaSpring.dominio.Persona;
/**
 *
 * @author wilme
 */
@Controller
@Slf4j
public class controladorInicio {
    @Autowired
    private PersonaService personaService;   
    @GetMapping("/")
    public String inicio(Model modelo){
        var personas = personaService.listarPersona();
        modelo.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errors){
        if (errors.hasErrors()) {
           return "modificar"; 
        }
        personaService.guardarPersona(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    
    public String editar(Persona persona, Model modelo){
        persona = personaService.encontrarPersona(persona);
        modelo.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminarPersona(persona);
        return "redirect:/";
    }
}
