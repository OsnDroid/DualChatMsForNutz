package com.osn;



import java.io.FileOutputStream;  
import java.io.IOException;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.streaming.SXSSFWorkbook;  

public class TestExcel {
	  public static void main(String[] args) throws Exception {  
		  TestExcel tm = new TestExcel();  
          tm.jdbcex(true);  
  }  

  public void jdbcex(boolean isClose) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException, InterruptedException {  
          String xlsFile = "d:/test100.xlsx";                                        //输出文件  
          Workbook wb = new SXSSFWorkbook(2000);                                //创建excel文件，内存只有100条记录【关键语句】  
          Sheet sheet = wb.createSheet("我的第一个工作簿");                //建立新的sheet对象  

          Row nRow = null;  
          Cell nCell   = null;  

            
          long  startTime = System.currentTimeMillis();        //开始时间  
          System.out.println("strat execute time: " + startTime);  
          //context  
          int rowNo = 0;  
          int colNo = 0;  
          boolean flag= true;
          while(flag) {  
                  colNo = 0;  
                  nRow = sheet.createRow(rowNo++);  

                  nCell = nRow.createCell(colNo++);  
                  nCell.setCellValue("测试");  
                    
                  nCell = nRow.createCell(colNo++);  
                  nCell.setCellValue("测试");  
                    
                  if(rowNo%2000==0){  
                          System.out.println("row no: " + rowNo);  
                  }  
                    
                  Thread.sleep(1);                        //休息一下，防止对CPU占用  
                  if(rowNo>100000){
                	  flag = false;
                  }
          }  
            
          long finishedTime = System.currentTimeMillis();        //处理完成时间  
          System.out.println("finished execute  time: " + (finishedTime - startTime)/1000 + "m");  
            
            
          FileOutputStream fOut = new FileOutputStream(xlsFile);  
          wb.write(fOut);  
          fOut.flush();  
          fOut.close();  
            
          long stopTime = System.currentTimeMillis();                //写文件时间  
          System.out.println("write xlsx file time: " + (stopTime - startTime)/1000 + "m");  
            
          
  }  
    
         
}
