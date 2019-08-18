package com.training.model.topico.service;

import com.hazelcast.core.HazelcastInstance;
import com.training.dao.TopicoRepository;
import com.training.model.topico.entity.Topico;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    @Qualifier("hazelcastInstance")
    private HazelcastInstance hazelcastInstance;

    @Cacheable(value = "topico")
    public Page<Topico> listarTodos(Pageable pageable)
    {
       // ConcurrentMap<Object, Object> topicoCache = this.hazelcastInstance.getMap("topico");

        Page<Topico> topicos = this.topicoRepository.findAll(pageable);

//        topicos.forEach(element -> {
//            topicoCache.put(element.getCodigo(),element);
//        });

        return topicos;
    }

    @CachePut(value = "topico",key = "#topico.getCodigo()")
    public Topico salvar(Topico topico)
    {
       return  this.topicoRepository.save(topico);
    }

    public Page<Topico> filtrar(String filtro, Pageable pageable)
    {
        return this.topicoRepository.findByCursoNome(filtro,pageable);
    }

    @Cacheable(value = "topico",key = "#id")
    public Topico buscar(Long id)
    {
        Optional<Topico> topico = this.topicoRepository.findById(id);
        return topico.orElse(null);
    }

    public Topico alterar(Topico topico) {
        return this.salvar(topico);
    }

    @CacheEvict(value = "topico", key = "#codigo")
    public void remover(Long codigo) {
        this.topicoRepository.deleteById(codigo);
    }
}
