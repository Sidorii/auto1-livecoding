package auto1.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SecretStorageImplTest {


    private Map<Object, String> persistentStorage = new HashMap<>();
    private SecretStorageImpl storage = new SecretStorageImpl(persistentStorage);

    @Test
    public void shouldAddPairAndReturnTheKey() {
        String key = "mY-cUsTom-kEy";
        String value = "My secret no one should know!";

        var result = storage.addPair(key, value);
        assertEquals(key, result);
        assertTrue(persistentStorage.containsKey(key));
        assertTrue(persistentStorage.containsValue(value));
    }

    @Test
    public void shouldFailValidationForInvalidKey() {
        String nullKey = null;
        String tooLongKey = "mY-cUsTom-kEymY-cUsTom-kEy";
        String value = "My secret no one should know!";

        assertThrows(IllegalArgumentException.class, () -> storage.addPair(nullKey, value));
        assertThrows(IllegalArgumentException.class, () -> storage.addPair(tooLongKey, value));
    }

    @Test
    public void shouldTestGetMethod() {
        String key = "mY-cUsTom-kEy";
        String value = "My secret no one should know!";
        persistentStorage.put(key, value);

        assertEquals(value, storage.getValue(key).orElseThrow());
    }

    @Test
    public void shouldUseDigitAsAKey() {
//        int, long, double, float, BigInteger, BigDecimal

        int a = 1;
        long b = 2;
        double c = 3.23;
        float d = 23.23f;
        String str = "1";

        storage.addPair(a, "int");
        storage.addPair(b, "long");
        storage.addPair(c, "double");
        storage.addPair(d, "float");
        storage.addPair(str, "string");


        assertEquals("int", storage.getValue(a).orElseThrow());
        assertEquals("long", storage.getValue(b).orElseThrow());
        assertEquals("double", storage.getValue(c).orElseThrow());
        assertEquals("float", storage.getValue(d).orElseThrow());
        assertEquals("string", storage.getValue(str).orElseThrow());
    }
}