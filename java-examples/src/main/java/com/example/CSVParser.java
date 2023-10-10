package com.example;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import au.com.bytecode.opencsv.CSVReader;

public class CSVParser {
  private String path;

  public CSVParser(String path){
    this.path = path;
  }

  public List<Map<String, String>> parse(){
    List<Map<String, String>> dataList = new ArrayList<>();

    try (CSVReader reader = new CSVReader(new FileReader(this.path))) {
      List<String[]> allRows = reader.readAll();
      
      // Assuming the first row is the header
      String[] headers = allRows.get(0);

      for (int i = 1; i < allRows.size(); i++) {
        Map<String, String> data = new HashMap<>();
        String[] row = allRows.get(i);
        
        for (int j = 0; j < headers.length; j++) {
          data.put(headers[j], row[j]);
        }
        
        dataList.add(data);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return dataList;

  }
}
