package sv.edu.udbvirtual.talle2DSE.service;

import java.util.Optional;

import sv.edu.udbvirtual.talle2DSE.models.Contacto;

public interface ContactoService {
    //Listar todos
    public Iterable<Contacto> findAll();

    //Buscar por id
    public Optional<Contacto> findById(Long id);

    //Guardar un contacto
    public Contacto save(Contacto alumno);

    //Borrar un contacto
    public void deleteById(Long id);

}
