package hello;

import hello.config.MyDataSourceConfigV1;
import hello.config.MyDataSourceConfigV2;
import hello.config.MyDataSourceEnvConfig;
import hello.config.MyDataSourceValueConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

//@Import(MyDataSourceEnvConfig.class)
//@Import(MyDataSourceValueConfig.class)

//@Import(MyDataSourceConfigV1.class)
@Import(MyDataSourceConfigV2.class)
@SpringBootApplication(scanBasePackages = "hello.datasource")
/**
 * `@ConfigurationProperties`를 특정 범위로 자동 등록할 때는 `@ConfigurationPropertiesScan`를 사용한다.
 * 빈은 직접 등록하는 것과 컴포넌트 스캔을 사용하는 차이와 비슷하다.
 */
@ConfigurationPropertiesScan
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
