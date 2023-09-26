package com.ebank.app.ebank.web;


import com.ebank.app.ebank.payloads.GenericResponse;
import com.ebank.app.ebank.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {


    @Autowired
    private ReportService service;


    @GetMapping("/generate/{clientType}")
    public ResponseEntity<Resource> generateReport(@PathVariable("clientType") String clientType) throws IOException {
        File response = service.generateReport(clientType);


        Path path = Paths.get(response.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));


        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=LocalClientReport.csv");


        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(response.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
