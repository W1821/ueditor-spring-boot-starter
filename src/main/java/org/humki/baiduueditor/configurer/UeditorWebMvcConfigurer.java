package org.humki.baiduueditor.configurer;

import org.humki.baiduueditor.config.UeditorUploadConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * <br>
 * <b>功能：</b>MVC配置<br>
 * 例如：public/image/** -> 磁盘某个位置<br>
 * 例如：拦截器<br>
 * <b>作者：</b>Pan.ShiJu<br>
 * <b>日期：</b>2017/4/11 23:27<br>
 *
 * @author Kael
 */
@Configuration
public class UeditorWebMvcConfigurer implements WebMvcConfigurer {

    private static final String FILE_START = "file:";

    private final UeditorUploadConfig ueditorUploadConfig;

    @Autowired
    public UeditorWebMvcConfigurer(UeditorUploadConfig ueditorUploadConfig) {
        this.ueditorUploadConfig = ueditorUploadConfig;
    }

    /**
     * 静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ueditor编辑器静态资源访问配置要以文件分隔符结尾
        registry.addResourceHandler(ueditorUploadConfig.getResourceHandler()).addResourceLocations(getFileLocation(ueditorUploadConfig.getRootPath()));
    }

    private String getFileLocation(String rootPath) {
        String fileUploadLocation = FILE_START + rootPath;
        if (!fileUploadLocation.endsWith(File.separator)) {
            fileUploadLocation = fileUploadLocation + File.separator;
        }
        return fileUploadLocation;
    }


}
