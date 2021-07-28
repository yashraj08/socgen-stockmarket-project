package com.example.importservice.controllers;



import com.example.importservice.Dtos.StockDto;
import com.example.importservice.services.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/import")
@CrossOrigin
public class ImportController {
    @Autowired
    private ImportService importService;

    @PostMapping
    public List<StockDto> uploadFile(@RequestParam MultipartFile stockDataFile) throws IOException {
        return importService.uploadFile(stockDataFile);
    }


}
