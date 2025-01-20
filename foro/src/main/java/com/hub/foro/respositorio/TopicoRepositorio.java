package com.hub.foro.respositorio;

import com.hub.foro.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepositorio extends JpaRepository<Topico, Long> {


}
