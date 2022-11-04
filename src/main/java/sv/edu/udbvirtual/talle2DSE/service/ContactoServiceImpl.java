package sv.edu.udbvirtual.talle2DSE.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.edu.udbvirtual.talle2DSE.models.Contacto;
import sv.edu.udbvirtual.talle2DSE.repository.ContactoRepository;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Contacto> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contacto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Contacto save(Contacto contacto) {
        return repository.save(contacto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
