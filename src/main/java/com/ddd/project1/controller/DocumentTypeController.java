package com.ddd.project1.controller;

import com.ddd.project1.dto.DocumentTypeDto;
import com.ddd.project1.dto.OperationTypeDto;
import com.ddd.project1.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/documentType")
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService service;

    @GetMapping("/getAll")
    public Flux<DocumentTypeDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Mono<DocumentTypeDto> getDocumentType(@PathVariable String id){
        Mono<DocumentTypeDto> documentTypeDtoMono=service.getDocumentType(id);
        System.out.println(documentTypeDtoMono.toString());
        return documentTypeDtoMono;
    }

    @PostMapping("/save")
    public Mono<DocumentTypeDto> saveDocumentType(@RequestBody Mono<DocumentTypeDto> documentTypeDtoMono){
        return service.saveDocumentType(documentTypeDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<DocumentTypeDto> updateDocumentType(@RequestBody Mono<DocumentTypeDto> documentTypeDtoMono, @PathVariable String id){
        return service.updateDocumentType(documentTypeDtoMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteDocumentType(@PathVariable String id){
        return service.deleteDocumentType(id);
    }


}
