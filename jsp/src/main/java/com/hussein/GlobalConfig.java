package com.hussein;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * <p>Title: GlobalConfig</p>
 * <p>Description: 如果jsp在module中需要制定webapp的路径</p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/28 4:51 PM
 */
@Configuration
public class GlobalConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory) -> {
            factory.addContextCustomizers((context) -> {
                        //模块中webapp相对路径
                        String relativePath = "jsp/src/main/webapp";
                        File docBaseFile = new File(relativePath);
                        // 如果路径不存在，则把这个路径加入进去
                        if (docBaseFile.exists()) {
                            context.setDocBase(docBaseFile.getAbsolutePath());
                        }
                    }
            );
        };
    }

}
