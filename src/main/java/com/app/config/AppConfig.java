package com.app.config;

import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import com.app.model.Employee;

@Configuration
@ComponentScan(basePackages="com.app")
@PropertySource("classpath:app.properties")
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
	@Autowired
	private Environment env;

	@Bean
	public InternalResourceViewResolver vr() {
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("mvc.prefix"));
		v.setSuffix(env.getProperty("mvc.suffix"));
		return v;
	}


	//multi-language concept

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource r=new ReloadableResourceBundleMessageSource();
		r.setBasename("classpath:messages");
		r.setDefaultEncoding("UTF-8");
		return r;
	}

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver c=new CookieLocaleResolver();
		c.setDefaultLocale(Locale.ENGLISH);
		c.setCookieName("mycke");
		return c;	
	}

	@Bean
	public LocaleChangeInterceptor lci() {
		LocaleChangeInterceptor l=new LocaleChangeInterceptor();
		l.setParamName("lang");
		return l;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(lci());
	}

	//1. DataSource
	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setDriverClassName(env.getProperty("dc"));
		d.setUrl(env.getProperty("url"));
		d.setUsername(env.getProperty("un"));
		d.setPassword(env.getProperty("pwd"));
		return d;
	}
	//2. SessionFactory
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean s=new LocalSessionFactoryBean();
		s.setDataSource(ds());
		s.setHibernateProperties(props());
		s.setAnnotatedClasses(Employee.class);
		return s;
	}
	@Bean
	public Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("dialect"));
		p.put("hibernate.show_sql", env.getProperty("showql"));
		p.put("hibernate.format_sql", env.getProperty("fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));
		return p;
	}
	//3. HT
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sf().getObject());
		return h;
	}

	//4. HTxM
	@Bean
	public HibernateTransactionManager htxm() {
		HibernateTransactionManager h=new HibernateTransactionManager();
		h.setSessionFactory(sf().getObject());
		return h;
	}

}