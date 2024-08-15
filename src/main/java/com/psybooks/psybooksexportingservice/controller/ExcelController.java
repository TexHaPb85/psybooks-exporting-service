package com.psybooks.psybooksexportingservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.psybooks.psybooksexportingservice.service.ExcelReadingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/items/rest")
@RequiredArgsConstructor
public class ExcelController {

    private final ExcelReadingService excelReadingService;

    @PostMapping("/import-items")
    public void importItems(@RequestParam("file") MultipartFile file) {
        excelReadingService.saveFileOfItems(file);
    }
}
