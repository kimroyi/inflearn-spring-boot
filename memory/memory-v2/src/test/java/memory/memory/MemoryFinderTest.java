package memory.memory;

import memory.Memory;
import memory.MemoryFinder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryFinderTest {

    @Test
    void get() {
        MemoryFinder memoryFinder = new MemoryFinder();
        Memory memory = memoryFinder.get();
        assertThat(memory).isNotNull();
    }
}