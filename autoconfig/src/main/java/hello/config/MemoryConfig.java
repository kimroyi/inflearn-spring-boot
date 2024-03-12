package hello.config;

import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
// if문과 유사, MemoryCondition의 실행결과가 true이면 빈 등록 그렇지 않으면 빈등록을 안한다.
//@Conditional(MemoryCondition.class)

/*
 * 스프링은 `@Conditional`과 관련해서 개발자가 편리하게 사용할 수 있도록 수 많은 `@ConditionalOnXxx`를 제공한다.
 * `@Conditional`자체는 스프링 부트가 아니라 스프링 프레임워크의 기능이다.
 * 스프링 부트는 이 기능을 확장해서 `@ConditionalOnXxx`를 제공한다.
 */
@ConditionalOnProperty(name = "memory", havingValue = "on") //추가
public class MemoryConfig {

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public  MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
