package cn.fsongs.cake.common.util.business;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.read.listener.ReadListener;

import java.io.InputStream;
import java.util.List;

/**
 * 报表相关工具人-EasyExcel
 * @author fsongs
 * @version 1.0
 * @date 2022/6/23 10:53
 */
public class ExcelUtil {
    /**
     * 读取 excel 较大文件不建议用
     */
    public static <T> List<T> readExcel(InputStream inputStream, Class<T> cls, ReadListener<T> listener) {
        return EasyExcelFactory.read(inputStream, cls, listener).doReadAllSync();
    }

    public static List<?> readExcel(InputStream inputStream) {
        return EasyExcelFactory.read(inputStream).doReadAllSync();
    }
}
