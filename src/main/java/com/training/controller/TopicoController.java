package com.training.controller;

import com.hazelcast.core.HazelcastInstance;
import com.training.model.topico.dto.TopicoDTO;
import com.training.model.topico.entity.Topico;
import com.training.model.topico.service.TopicoService;
import com.training.util.RetirarLazy;
import com.training.util.event.CreateEvent;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topico")
public class TopicoController
{

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @Qualifier("hazelcastInstance")
    private HazelcastInstance hazelcastInstance;

    @Autowired
    private ApplicationEventPublisher publisher;//publicador de evento

    @GetMapping
    public ResponseEntity<Page<Object>> listarTodos(@RequestParam(required = false) String filtro,
                                                    @PageableDefault(sort = "mensagem", direction = Sort.Direction.DESC) Pageable pageable)
    {

       System.out.println("TAMANHO DO MAP " + this.hazelcastInstance.getMap("topico").size());
//        http://localhost:8080/api/topico?page=0&size=2&sort=codigo,desc&sort=codigoDoUsuario,desc exemplo de

        if (filtro == null)
        {
            return ResponseEntity.ok(atualizarListaResponse(topicoService.listarTodos(pageable)));
        } else
        {
            return ResponseEntity.ok(atualizarListaResponse(topicoService.filtrar(filtro, pageable)));
        }
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)//invalida cache
    public ResponseEntity<Object> salvar(@RequestBody @Valid Topico topico, HttpServletResponse response)
    {
        topico.setCodigoDoUsuario(1l);
        topico.setCodidoDoCurso(1l);

        Topico topicoEntity = topicoService.salvar(topico);
        this.publisher.publishEvent(new CreateEvent(this,response,topicoEntity.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(atualizarEntidadeResponse(topicoEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id)
    {
        Topico topico = topicoService.buscar(id);

        if (topico != null)
        {
            System.out.println("TAMANHO DO MAP " + this.hazelcastInstance.getMap("topico").size());
            return ResponseEntity.ok(atualizarEntidadeResponse(new RetirarLazy<Topico>(topico).execute()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<Object> alterar(@RequestBody @Valid Topico topico)
    {

        return ResponseEntity.ok(atualizarEntidadeResponse(topicoService.alterar(topico)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaDeTopicos", allEntries = true)
    public ResponseEntity<Object> remover(@PathVariable Long id)
    {
        topicoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    private Object atualizarEntidadeResponse(Topico topico)
    {
        return convertToDto(topico);
    }

    private Page<Object> atualizarListaResponse(Page<Topico> topicoList)
    {
        return topicoList.map(topico -> convertToDto(new RetirarLazy<Topico>(topico).execute()));
    }

    private TopicoDTO convertToDto(Topico topico)
    {
        TopicoDTO dto = new TopicoDTO();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.map(topico, dto);

        return dto;
    }
}
