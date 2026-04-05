import static org.junit.Assert.*;
import org.junit.Test;


public class VectorHeapTest {

    @Test
    public void testAddAndRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();

        heap.add(new Paciente("Juan", "fractura", 'C'));
        heap.add(new Paciente("Maria", "apendicitis", 'A'));
        heap.add(new Paciente("Carmen", "parto", 'B'));

        assertEquals("Maria", heap.remove().getNombre());
        assertEquals("Carmen", heap.remove().getNombre());
        assertEquals("Juan", heap.remove().getNombre());
    }

    @Test
    public void testEmptyHeap() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty());
    }
}