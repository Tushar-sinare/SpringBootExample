package com.app.config;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.app.model.Product;


@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private StepBuilderFactory st;

	@Bean
	public Step stepA() {
		return st.get("StepA").<Product, Product>chunk(3).reader(reader()).processor(processor()).writer(writer())
				.build();
	}

	@Autowired
	private JobBuilderFactory jf;

	@Bean
	public Job jobA() {
		return jf.get("jobA").incrementer(new RunIdIncrementer()).start(stepA()).build();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("JAVA");
		ds.setPassword("JAVA");
		return ds;
	}

	@Bean
	public ItemReader<Product> reader() {
		FlatFileItemReader<Product> reader = new FlatFileItemReader<Product>();
		
		reader.setResource(new ClassPathResource("myprods.csv"));
		
		reader.setLineMapper(new DefaultLineMapper<Product>() {
			{
				
				setLineTokenizer(new DelimitedLineTokenizer() {
					{

						setNames("prodId", "prodName", "prodCost");
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {
					{
						
						setTargetType(Product.class);
					}
				});
			}
		});
		return reader;
	}

@Bean
public ItemProcessor<Product, Product> processor() {

 return (p)-> {
 p.setDisc(p.getCost()*3/100.0);
 p.setGst(p.getCost()*12/100.0);
 return p;
 };
}
	@Bean
	public ItemWriter<Product> writer() {
		JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource());
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());
		writer.setSql(
				"INSERT INTO PRODSTAB(PID, PNAME, PCOST, PGST, PDISC)VALUES(:Id, :Name, :Cost, :Gst, :Disc)");
		return writer;
	}
}
