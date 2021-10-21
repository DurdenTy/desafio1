package com.example.financys.controller;

import com.example.financys.DTO.DtoChart;
import com.example.financys.entity.Entry;
import com.example.financys.service.EntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService){

        this.entryService = entryService;

    }

    @PostMapping("/lancamentos")
    public Long create(@RequestBody @Valid DtoChart dto_chart) {

        return entryService.save(dto_chart).getId();

    }

    public List<Entry> read(){

        return entryService.findAll();

    }

    @GetMapping("/lancamentos/{id}")
    public ResponseEntity<Entry> findEntryById(@PathVariable Long id) {

        return entryService.findById(id);

    }

    @PutMapping("/lancamentos/{id}")
    public ResponseEntity<Entry> update(@RequestBody @Valid Entry entry, @PathVariable Long id) {

        return entryService.update(id, entry);

    }

    @DeleteMapping("/lancamentos/{id}")
    public void delete(@PathVariable Long id) {
        entryService.delete(id);
    }

    @GetMapping("/lancamentos")
    public Map<String, List<DtoChart>> readDTO(){
        return entryService.retornarListaDTO();
    }

    @GetMapping("/calcula/{x}/{y}")
    public Integer calculaMedia(@PathVariable(value = "x") Integer x,
                                @PathVariable(value = "y") Integer y){
        return entryService.calculaMedia(x, y);
    }

}
