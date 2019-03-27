package com.portjs.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.portjs.base.dao")
//@Configuration
//如果service实现类中加入事务注解，需要此处添加该注解进行开启事务管理
@EnableTransactionManagement
@EnableScheduling
public class BaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}
	
	/**
	 * 配置上传文件大小的配置
	 * @return
	 */
	/*@Bean
	public MultipartConfigElement multipartConfigElement() {
	   MultipartConfigFactory factory = new MultipartConfigFactory();
	   //  单个数据大小
	   factory.setMaxFileSize("102400KB");
	   /// 总上传数据大小
	   factory.setMaxRequestSize("102400KB");
	   return factory.createMultipartConfig();
	}*/
	

}