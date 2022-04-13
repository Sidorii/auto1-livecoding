package auto1.example;

import java.util.Optional;

public interface SecretStorage {

    String addPair(String key, String value);

    Optional<String> getValue(String key);

    <T extends Number> T addPair(T key, String value);

    <T extends Number> Optional<String> getValue(T key);
}
