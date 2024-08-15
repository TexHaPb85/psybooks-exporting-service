package com.psybooks.psybooksexportingservice.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.psybooks.psybooksexportingservice.entity.CurrencyKey;
import com.psybooks.psybooksexportingservice.entity.Item;
import com.psybooks.psybooksexportingservice.entity.dto.ItemDto;
import com.psybooks.psybooksexportingservice.entity.dto.LocalizationEntity;
import com.psybooks.psybooksexportingservice.repo.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExcelReadingService {
    private final ItemRepository itemRepository;


    public List<ItemDto> saveFileOfItems(MultipartFile file) {
        try {
            List<ItemDto> items = parseItemsExcelFile(file.getInputStream());
            itemRepository.saveAll(items.stream().map(Item::new).toList());
            return items;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store excel data: " + e.getMessage());
        }
    }

    private List<ItemDto> parseItemsExcelFile(InputStream is) {
        List<ItemDto> itemDtos = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 1; rowIndex < 20; rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                ItemDto itemDto = new ItemDto();
                itemDto.setId(row.getCell(0).getStringCellValue());

                String descriptionKey = itemDto.getId() + "-description";
                String descriptionUa = row.getCell(3).getStringCellValue();
                String descriptionRu = row.getCell(4).getStringCellValue();
                LocalizationEntity localizationDescr = new LocalizationEntity(descriptionKey, descriptionUa, descriptionRu, null);
                itemDto.setDescriptionLocalizationKey(descriptionKey);

                String nameKey = itemDto.getId() + "-name";
                String nameUa = row.getCell(5).getStringCellValue();
                String nameRu = row.getCell(6).getStringCellValue();
                LocalizationEntity localizationName = new LocalizationEntity(nameKey, nameUa, nameRu, null);
                itemDto.setNameLocalizationKey(nameKey);

                itemDto.setCategory(row.getCell(8).getStringCellValue());
                itemDto.setPrice(Long.parseLong(row.getCell(9).getStringCellValue().replace(".", "")));
                itemDto.setCurrency(CurrencyKey.valueOf(row.getCell(11).getStringCellValue()));

                itemDtos.add(itemDto);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }
        return itemDtos;
    }
}
