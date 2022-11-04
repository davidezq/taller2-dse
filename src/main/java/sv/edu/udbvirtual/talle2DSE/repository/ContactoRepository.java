package sv.edu.udbvirtual.talle2DSE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.edu.udbvirtual.talle2DSE.models.Contacto;

public interface ContactoRepository extends JpaRepository<Contacto,Long> {
    
}
