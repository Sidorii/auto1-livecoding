package auto1.example;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class SecretStorageImpl implements SecretStorage {

    private final Map<Object, String> storage;
    private final int MAX_KEY_LENGTH = 20;

    private final Random random = new Random();

    public SecretStorageImpl(Map<Object, String> storage) {
        this.storage = storage;
    }

    @Override
    public String addPair(String key, String value) {
        validateKey(key);
        storage.put(key, value);
        return key;
    }

    private void validateKey(String key) {
        if (key == null ) {
            throw new IllegalArgumentException("Key shouldn't be null");
        }

        if (key.length() > MAX_KEY_LENGTH) {
            throw new IllegalArgumentException("Key length should be no more than " + MAX_KEY_LENGTH + " character long");
        }
    }


    @Override
    public Optional<String> getValue(String key) {
        return Optional.ofNullable(storage.get(key));
    }

    @Override
    public <T extends Number> T addPair(T key, String value) {
        if (key == null) {
            throw new IllegalArgumentException("Key shouldn't be null");
        }
        storage.put(key, value);
        return key;

    }

    @Override
    public <T extends Number> Optional<String> getValue(T key) {
        int lowest = 27;
        int highest = 120;
        int length = 21;
        char[] randomKey = new char[length];

        return Optional.ofNullable(storage.get(key));
    }

    //      random key generation logic
//        for (int i = 0; i < length; i++) {
//            char ch = (char) (lowest + random.nextInt(highest - lowest));
//        }

}
