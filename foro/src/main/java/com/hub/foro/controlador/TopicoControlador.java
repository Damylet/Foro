package com.hub.foro.controlador;

import com.hub.foro.modelo.Topico;
import com.hub.foro.servicio.TopicoSevicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoControlador {

    @Autowired
    private TopicoSevicio topicoSevicio;

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@Valid @RequestBody Topico topico) {
        Topico savedTopico = topicoSevicio.save(topico);
        return ResponseEntity.ok(savedTopico);
    }

    @GetMapping
    public List<Topico> getAllTopics() {
        return topicoSevicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopicById(@PathVariable Long id) {
        Optional<Topico> topico = topicoSevicio.findById(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopic(@PathVariable Long id, @Valid @RequestBody Topico topicoDetails) {
        Optional<Topico> topicoOptional = topicoSevicio.findById(id);
        if (!topicoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Topico topico = topicoOptional.get();
        topico.setTitulo(topicoDetails.getTitulo());
        topico.setMensaje(topicoDetails.getMensaje());
        topico.setAutor(topicoDetails.getAutor());
        topico.setCurso(topicoDetails.getCurso());

        Topico updatedTopico = topicoSevicio.save(topico);
        return ResponseEntity.ok(updatedTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        if (!topicoSevicio.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        topicoSevicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
