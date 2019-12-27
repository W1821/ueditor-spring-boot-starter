package org.humki.baiduueditor.config;

import lombok.Data;
import org.humki.baiduueditor.util.PathUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author Kael
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "humki.ueditor.upload")
public class UeditorUploadConfig {

    /**
     * 所有上传文件根目录
     */
    private String rootPath;
    /**
     * 图片访问映射前缀
     */
    private String resourcePrefix = "/public/ueditor";
    /**
     * 图片文件映射匹配
     */
    private String resourceHandler = "/public/ueditor/**";

    public String getRootPath() {
        // 如果没有配置文件上传根目录，默认使用当前项目目录
        if (PathUtil.isInvalidFilePath(this.rootPath)) {
            this.rootPath = PathUtil.getRootPath() + File.separator + "upload" + File.separator + "ueditor";
        }
        return this.rootPath;
    }

}
