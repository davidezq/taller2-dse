package sv.edu.udbvirtual.talle2DSE.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.edu.udbvirtual.talle2DSE.models.Contacto;
import sv.edu.udbvirtual.talle2DSE.service.ContactoService;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {
    @Autowired
    private ContactoService service;

    @GetMapping
    public ResponseEntity<?> mostrarContactos() {
         Iterable<Contacto> contactos = service.findAll();
        return ResponseEntity.ok().body(contactos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarContacto(@PathVariable Long id){
        Optional<Contacto> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(o.orElseThrow());
    }

    @PostMapping
    public ResponseEntity<?> guardarContacto(@RequestBody Contacto contacto){
        Contacto contactoGuardado = service.save(contacto);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactoGuardado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarContacto(@RequestBody Contacto contacto, @PathVariable Long id){
        Optional<Contacto> o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Contacto contactoDB = o.orElseThrow();
        contactoDB.setNombres(contacto.getNombres());
        contactoDB.setApellidos(contacto.getApellidos());
        contactoDB.setEdad(contacto.getEdad());
        contactoDB.setSexo(contacto.getSexo());
        contactoDB.setPais(contacto.getPais());

        Contacto contactoGuardado = service.save(contactoDB);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactoGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarContacto(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
