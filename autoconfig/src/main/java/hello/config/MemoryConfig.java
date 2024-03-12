package hello.config;

import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
// if문과 유사, MemoryCondition의 실행결과가 true이면 빈 등록 그렇지 않으면 빈등록을 안한다.
@Conditional(MemoryCondition.class)
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
