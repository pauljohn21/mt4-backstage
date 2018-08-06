package com.kajie88.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadWriteExcel {
    private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    /**
     * 判断Excel的版本,获取Workbook
     * @param in
     * @param
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(InputStream in,File file) throws IOException{
        Workbook wb = null;
        if(file.getName().endsWith(EXCEL_XLS)){  //Excel 2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){  // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    /**
     * 判断文件是否是excel
     * @throws Exception
     */
    public static void checkExcelVaild(File file) throws Exception{
        if(!file.exists()){
            throw new Exception("文件不存在");
        }
        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
            throw new Exception("文件不是Excel");
        }
    }

    /**
     * 读取Excel测试，兼容 Excel 2003/2007/2010
     * @throws Exception
     */
    public static Map<String,Object> readExcel(File excelFile,Integer tableHead) throws Exception {
        Map<String,Object> excelInfo = new HashMap<>();
        List<String> tableHeadList = new ArrayList<>();
        List<List<String>> tableBodyList = new ArrayList<>();
        excelInfo.put("tableHead",tableHeadList);
        excelInfo.put("tableBody",tableBodyList);
//        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("E:/xxx/InsertSql.txt")));
        try {
            // 同时支持Excel 2003、2007
//            File excelFile = new File("E:/xxx.xlsx"); // 创建文件对象
            FileInputStream is = new FileInputStream(excelFile); // 文件流
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbok(is,excelFile);
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
            /**
             * 设置当前excel中sheet的下标：0开始
             */
            Sheet sheet = workbook.getSheetAt(0);   // 遍历第一个Sheet

            // 为跳过第一行目录设置count
            int count = 0;

            for (Row row : sheet) {
                // 判断 列表标题的 所在行号 上方的跳过 下方的的为内动 当前好为表头信息
                if(tableHead!=null){
                    if(count < tableHead&&tableHead!=0){
                        count++;
                        continue;
                    }else if(count==tableHead){
                        readRowInfo4Head(row,tableHeadList);
                        count++;
                        continue;
                    }
                }
                // 如果当前行没有数据，跳出循环
                if(row.getCell(0).toString().equals("")){
                    return excelInfo;
                }
                readRowInfo(row,tableBodyList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            return excelInfo;
        }
    }

    private static void readRowInfo(Row row,List<List<String>> rowInfo){

//                String rowValue = "";
        int cellnum = 0;

        //一行的信息
        List<String> rowInfoList = new ArrayList<>();

        for (Cell cell : row) {
            if(cell.toString() == null){
                rowInfoList.add("");
                continue;
            }
            int cellType = cell.getCellType();
            String cellValue = "";
            switch (cellType) {
                case Cell.CELL_TYPE_STRING:     // 文本
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:    // 数字、日期
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = fmt.format(cell.getDateCellValue());
                    } else {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cellValue = String.valueOf(cell.getRichStringCellValue().getString());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:    // 布尔型
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_BLANK: // 空白
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_ERROR: // 错误
                    cellValue = "错误#";
                    break;
                case Cell.CELL_TYPE_FORMULA:    // 公式
                    // 得到对应单元格的公式
                    //cellValue = cell.getCellFormula() + "#";
                    // 得到对应单元格的字符串
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
                    break;
                default:
                    break;
            }
//                    rowValue += cellValue;

            //将每列的数据 放入rowList
            rowInfoList.add(cellValue);
//                    }
            cellnum++;
        }
        //每行循环一遍后将行信息放入excel数据中
        rowInfo.add(rowInfoList);

//      System.out.println(rowValue);
    }
    private static void readRowInfo4Head(Row row,List<String> rowInfo){

//                String rowValue = "";
        int cellnum = 0;

        //一行的信息

        for (Cell cell : row) {
            if(cell.toString() == null){
                rowInfo.add("");
                continue;
            }
            int cellType = cell.getCellType();
            String cellValue = "";
            switch (cellType) {
                case Cell.CELL_TYPE_STRING:     // 文本
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:    // 数字、日期
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = fmt.format(cell.getDateCellValue());
                    } else {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cellValue = String.valueOf(cell.getRichStringCellValue().getString());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:    // 布尔型
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_BLANK: // 空白
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_ERROR: // 错误
                    cellValue = "错误#";
                    break;
                case Cell.CELL_TYPE_FORMULA:    // 公式
                    // 得到对应单元格的公式
                    //cellValue = cell.getCellFormula() + "#";
                    // 得到对应单元格的字符串
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cellValue = String.valueOf(cell.getRichStringCellValue().getString()) + "#";
                    break;
                default:
                    break;
            }
//                    rowValue += cellValue;

            //将每列的数据 放入rowList
            rowInfo.add(cellValue);
//                    }
            cellnum++;
        }
        //每行循环一遍后将行信息放入excel数据中
    }
}