package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

//설정 정보
@Configuration
// @Component 어노테이션 붙은 애들 스캔
// @Configuration은 제외
// @Configuration이 붙은 설정 정보도 자동으로 등록되기 떄문에 (AppConfig 같은 곳에 이미 등록되고 실행됨)
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class))
public class AutoAppConfig {

}