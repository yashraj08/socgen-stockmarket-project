package com.example.importservice.services;


import com.example.importservice.Dtos.StockDto;
import com.example.importservice.exceptions.EmptyInputException;
import com.example.importservice.mappers.StockMapper;
import com.example.importservice.entities.Company;
import com.example.importservice.entities.Stock;
import com.example.importservice.entities.StockExchange;
import com.example.importservice.repositories.CompanyRepository;
import com.example.importservice.repositories.StockExchangeRepository;
import com.example.importservice.repositories.StockRepository;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImportService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private StockExchangeRepository stockExchangeRepository;
    @Autowired
    private StockMapper stockMapper;

    public List<StockDto> uploadFile(@org.jetbrains.annotations.NotNull MultipartFile StockDataFile) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(StockDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        List<StockDto> stockDtos=new ArrayList<>();
        Stock stock=new Stock();
        for(int i=1;i<worksheet.getPhysicalNumberOfRows();i++){
            XSSFRow row=worksheet.getRow(i);

            Optional<Company> companyOptional=companyRepository.findById((int)row.getCell(0).getNumericCellValue());
            if(companyOptional.isPresent())
                stock.setCompany(companyOptional.get());
            else{
              throw new EmptyInputException("604","Error in row "+"i+1"+" Company not Present");
            }
            Optional<StockExchange>stockExchangeOptional=stockExchangeRepository.findById((int)row.getCell(1).getNumericCellValue());
            if(stockExchangeOptional.isPresent())
                stock.setStockExchange(stockExchangeOptional.get());
            else
                throw new EmptyInputException("604","Error in row "+"i+1"+" StockExchange not Present");
            stock.setCurrentPrice((float)row.getCell(2).getNumericCellValue());
            stock.setDate(row.getCell(3).getDateCellValue());
            stock.setTime((Time) row.getCell(4).getDateCellValue());
            stockRepository.save(stock);
            StockDto stockdto=stockMapper.map(stock,StockDto.class);
            stockdto.setCompanyId(companyOptional.get().getId());
            stockdto.setStockExchangeId(stockExchangeOptional.get().getId());
            stockDtos.add(stockdto);
        }
        return stockDtos;
    }



}
