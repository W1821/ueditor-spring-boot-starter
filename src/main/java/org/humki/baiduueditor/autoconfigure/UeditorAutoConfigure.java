package org.humki.baiduueditor.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.humki.baiduueditor.config.UeditorConfig;
import org.humki.baiduueditor.config.UeditorUploadConfig;
import org.humki.baiduueditor.configurer.UeditorWebMvcConfigurer;
import org.humki.baiduueditor.controller.UeditorController;
import org.humki.baiduueditor.action.DefaultAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@EnableConfigurationProperties({UeditorUploadConfig.class, UeditorConfig.class})
@Import(DefaultAction.class)
public class UeditorAutoConfigure {

    private final DefaultAction defaultAction;
    private final UeditorUploadConfig ueditorUploadConfig;

    public UeditorAutoConfigure(DefaultAction defaultAction, UeditorUploadConfig ueditorUploadConfig) {
        this.defaultAction = defaultAction;
        this.ueditorUploadConfig = ueditorUploadConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    UeditorWebMvcConfigurer ueditorWebMvcConfigurer() {
        return new UeditorWebMvcConfigurer(ueditorUploadConfig);
    }

    @Bean
    @ConditionalOnMissingBean
    UeditorController ueditorController() {
        return new UeditorController(defaultAction);
    }
}
