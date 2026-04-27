package expedition33;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class Tests {

    @Test
    void testCasoNormal() {
        String[] nombres = {"Alice", "Bob"};
        int[] edades = {20, 26};
        int G = 30;

        ArrayList<String> res = ElGoummageExpedition33.resolverCaso(G, nombres, edades);

        assertEquals("Alice -> desapareix a edat 25, expedició 5", res.get(0));
        assertEquals("Bob -> desapareix a edat 28, expedició 2", res.get(1));
    }

    @Test
    void testCasoLimiteEdadIgualG() {
        String[] nombres = {"Clara"};
        int[] edades = {30};
        int G = 30;

        ArrayList<String> res = ElGoummageExpedition33.resolverCaso(G, nombres, edades);

        assertEquals("Clara -> desapareix a edat 30, expedició 0", res.get(0));
    }

    @Test
    void testEntradaMinima() {
        String[] nombres = {"Solo"};
        int[] edades = {10};
        int G = 20;

        ArrayList<String> res = ElGoummageExpedition33.resolverCaso(G, nombres, edades);

        assertEquals("Solo -> desapareix a edat 15, expedició 5", res.get(0));
    }

    @Test
    void testMultiplesPersonas() {
        String[] nombres = {"A", "B", "C"};
        int[] edades = {10, 20, 30};
        int G = 50;

        ArrayList<String> res = ElGoummageExpedition33.resolverCaso(G, nombres, edades);

        assertEquals(3, res.size());
        assertEquals("A -> desapareix a edat 30, expedició 20", res.get(0));
        assertEquals("B -> desapareix a edat 35, expedició 15", res.get(1));
        assertEquals("C -> desapareix a edat 40, expedició 10", res.get(2));
    }

    @Test
    void testValoresGrandes() {
        String[] nombres = {"X"};
        int[] edades = {0};
        int G = 100;

        ArrayList<String> res = ElGoummageExpedition33.resolverCaso(G, nombres, edades);

        assertEquals("X -> desapareix a edat 50, expedició 50", res.get(0));
    }
}