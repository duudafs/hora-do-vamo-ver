package com.mfs.milagre.services;

import com.mfs.milagre.models.MilagreModel;
import com.mfs.milagre.repositories.MilagreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="milagres")
public class MilagreService {

    @Autowired
    private MilagreRepository milagreRepository;

    @GetMapping
    public List<MilagreModel> findAll(){
        return milagreRepository.findAll();
    }

    @PostMapping
    public MilagreModel criarMilagre(MilagreModel milagreModel){
        return milagreRepository.save(milagreModel);
    }


    public MilagreModel buscarId(Long id){
        return milagreRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deletar(Long id){
        milagreRepository.deleteById(id);
    }

    @PutMapping ("/{id}")
    public MilagreModel atualizar(@PathVariable Long id, @RequestBody MilagreModel milagreModel){
        MilagreModel newMilagre = milagreRepository.findById(id).get();
        newMilagre.setNome(milagreModel.getNome());
        return milagreRepository.save(newMilagre);
    }
}
