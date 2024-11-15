package kr.co.hanbit.product.management;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() { // 하는 이유가 setter 없이 product랑 prodcutDto 변환 해주려고
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().
				setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).
				setFieldMatchingEnabled(true);
		return modelMapper;
	}

	@Bean
	public ApplicationRunner runner(DataSource dataSource) {
		return args -> {
			//ㅇㅣ 부분에 실행할 코드를 넣으면 된다.
			Connection connection = dataSource.getConnection();
		};
	}

}
