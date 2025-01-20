package com.hub.foro.servicio;


import com.hub.foro.modelo.Topico;
import com.hub.foro.respositorio.TopicoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoSevicio {


    private final TopicoRepositorio topicoRepositorio;

    public TopicoSevicio(TopicoRepositorio topicoRepositorio) {
        this.topicoRepositorio = topicoRepositorio;
    }


        @Autowired
        private TopicoRepositorio topicoRepositorioRepository;

        public List<Topico> findAll() {
            return topicoRepositorio.findAll();
        }

        public Optional<Topico> findById(Long id) {
            return topicoRepositorio.findById(id);
        }

        @Transactional
        public Topico save(Topico topico) {
            return topicoRepositorio.save(topico);
        }

        @Transactional
        public void deleteById(Long id) {
            topicoRepositorio.deleteById(id);
        }
    }




