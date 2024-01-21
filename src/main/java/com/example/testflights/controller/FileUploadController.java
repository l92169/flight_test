package com.example.testflights.controller;

import com.example.testflights.exception.BadFormatFileException;
import com.example.testflights.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
@AllArgsConstructor
public class FileUploadController {
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> fileUploading(@RequestParam("file") MultipartFile file) throws BadFormatFileException {
        fileService.fillTable(file);
        return ResponseEntity.ok("Successfully uploaded the file");
    }


}
