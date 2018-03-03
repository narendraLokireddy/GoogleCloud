package com.spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.spring.pdfexcel.AbstractPdfView;
import com.spring.pdfexcel.ExcelBuilder;


@Configuration
@EnableWebMvc
@Import({SpringSecurityConfig.class,RootConfig.class})
@ComponentScan(basePackages= {"com.spring.controller","com.aop"})
public class WebConfig extends WebMvcConfigurerAdapter{
	 @Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		registry.jsp("/WEB-INF/JSP/", ".jsp");
		//registry.enableContentNegotiation(new AbstractPdfView(),new ExcelBuilder());
	}
 
	 @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		        registry.addResourceHandler("./WEB-INF/assets/js/**").addResourceLocations("./WEB-INF/assets/js**");
		        registry.addResourceHandler("./WEB-INF/assets/css/**").addResourceLocations("./WEB-INF/assets/css**");
		        registry.addResourceHandler("./WEB-INF/assets/fonts/**").addResourceLocations("./WEB-INF/assets/fonts**");
		        registry.addResourceHandler("./WEB-INF/assets/images/**").addResourceLocations("./WEB-INF/assets/images**");
		       /* registry.addResourceHandler("/WEB-INF/").addResourceLocations("classpath:/WEB-INF/**"); 
*/
	}
	 
	 @Bean
	    public ViewResolver resourceBundleViewResolver() {
	        
	        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
	        viewResolver.setBasename("views");
	        viewResolver.setOrder(1);
	        return viewResolver;
	    }
	        
		@Bean(name = "messageSource")
		public MessageSource newMessageSource() {
			ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
			messageSource.addBasenames("formerrors");
			return messageSource;
		}
	 
}
