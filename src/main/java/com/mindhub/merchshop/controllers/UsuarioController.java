package com.mindhub.merchshop.controllers;

import com.mindhub.merchshop.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@RequestMapping(path="/api")
@RestController
public class UsuarioController {

    @Autowired
    private FileService fileService;
    @PostMapping("/usuario/avatar")
    public ResponseEntity<Object> upload(@RequestParam MultipartFile file) {

        try{
            String fileUrl=fileService.upload(file);
            return new ResponseEntity<>("Archivo subido correctamente", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }

    }

//    @PostMapping("/usuario/avatar/{fileName}")
//    public Object download(@PathVariable String fileName) throws IOException {
////        logger.info("HIT -/download | File Name : {}", fileName);
//        return fileService.download(fileName);
//    }
}
