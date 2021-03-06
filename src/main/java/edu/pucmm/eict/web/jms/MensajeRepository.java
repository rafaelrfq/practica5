package edu.pucmm.eict.web.jms;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
    Mensaje findById(long id);
    List<Mensaje> findAll();
}
