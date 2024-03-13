package memory;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemoryFinder {

    // JVM에서 메모리 정보를 실시간으로 조회하는 기능이다.
    public Memory get() {
        // JVM이 사용할 수 있는 최대 메모리, 이 수치를 넘어가면 OOM이 발생한다.
        long max = Runtime.getRuntime().maxMemory();
        // JVM이 확보한 전체 메모리(JVM은 처음부터 `max`까지 다 확보하지 않고 필요할 때 마다 조금씩 확보한다.)
        long total = Runtime.getRuntime().totalMemory();
        // free는 `total`중에 사용하지 않은 메모리(JVM이 확보한 전체 메모리 중에 사용하지 않은 것)
        long free = Runtime.getRuntime().freeMemory();
        // used는 JVM이 사용중인 메모리이다.(`used = total - free`)
        long used = total - free;
        return new Memory(used, max);
    }

    @PostConstruct
    public void init() {
        log.info("init memoryFinder");
    }
}