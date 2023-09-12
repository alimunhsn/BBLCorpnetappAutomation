package com.corpnet.util;


import com.corpnet.testcases.BaseTest;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MockData extends BaseTest {

    public String TransactionFile;

    public void writeMockBatchId(String batchId, String fileName) {
        try {
            //File myObj = new File(fileName+".txt");

            File myObj = new File("D:\\CorpnetAutomationTest\\CorpnetApp\\src\\test\\java\\CorpNetApp\\pom\\testData\\CheckerTransactionBatchId.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter("D:\\CorpnetAutomationTest\\CorpnetApp\\src\\test\\java\\CorpNetApp\\pom\\testData\\CheckerTransactionBatchId.txt");
            myWriter.write(batchId);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<String> readMockBatchId(String fileName) {
        List<String> mockData = new ArrayList<>();
        try {
            //  File myObj = new File(fileName+".txt");

            File myObj = new File("D:\\CorpnetAutomationTest\\CorpnetApp\\src\\test\\java\\CorpNetApp\\pom\\testData\\CheckerTransactionBatchId.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String transactionBatchId = myReader.nextLine();
                mockData.add(transactionBatchId);
                System.out.println(transactionBatchId);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return mockData;
    }

    public void deleteMockBatchId(String iftChBatch1) {

        File myObj = new File("D:\\CorpnetAutomationTest\\CorpnetApp\\src\\test\\java\\CorpNetApp\\pom\\testData\\CheckerTransactionBatchId.txt");
        ;
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");

        }
    }

    public void deleteFile(String BatchIdFile) {
        try {
            File f = new File("E:\\demo.txt");           //file to be delete
            if (f.delete())                      //returns Boolean value
            {
                System.out.println(f.getName() + " deleted");   //getting and printing the file name
            } else {
                System.out.println("failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateToExcel(int rowIndex, String transactionRef) {

        try {
            XSSFRow row;
            XSSFCell cell;
            int transactionRefColumnIndex = 4;
            int statusColumnIndex = 12;
            int debitAccountIndex= 5;
            TransactionFile=System.getProperty("user.dir")+getTransactionTracker();
            InputStream ExcelFileToRead = new FileInputStream(TransactionFile);
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            XSSFSheet sheet = wb.getSheetAt(0);
            row = sheet.getRow(rowIndex);
            row.getCell(transactionRefColumnIndex).setCellValue(transactionRef);
           // row.getCell(debitAccountIndex).setCellValue(DebitAccount);
            if(transactionRef.length() > 10 )
                row.getCell(statusColumnIndex).setCellValue("PASS");
//            if(transactionRef.isEmpty()  )
//                row.getCell(statusColumnIndex).setCellValue("Failed");
            else
                row.getCell(statusColumnIndex).setCellValue("FAILED");

          // FileOutputStream out = new FileOutputStream(new File(gettrxTracker()));
            FileOutputStream out = new FileOutputStream(TransactionFile);
            wb.write(out);
            out.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public void updateDebitAccToExcel(int rowIndex, String DebitAccount) {

        try {
            XSSFRow row;
            XSSFCell cell;
            int transactionRefColumnIndex = 4;
            int statusColumnIndex = 12;
            int debitAccountIndex = 5;
            TransactionFile = System.getProperty("user.dir") + getTransactionTracker();
            InputStream ExcelFileToRead = new FileInputStream(TransactionFile);
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            XSSFSheet sheet = wb.getSheetAt(0);
            row = sheet.getRow(rowIndex);
            // row.getCell(transactionRefColumnIndex).setCellValue(transactionRef);
            row.getCell(debitAccountIndex).setCellValue(DebitAccount);
            if (DebitAccount.length() <= 16)
                row.getCell(statusColumnIndex).setCellValue("PASS");
//            if(transactionRef.isEmpty()  )
//                row.getCell(statusColumnIndex).setCellValue("Failed");
            else
                row.getCell(statusColumnIndex).setCellValue("FAILED");

            // FileOutputStream out = new FileOutputStream(new File(gettrxTracker()));
            FileOutputStream out = new FileOutputStream(TransactionFile);
            wb.write(out);
            out.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}




