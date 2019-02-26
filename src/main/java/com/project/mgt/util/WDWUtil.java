package com.project.mgt.util;
/**
 * 判断传输进来的是什么版本的Excel
 * @author user
 *
 */
public class WDWUtil {
	public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }


}
