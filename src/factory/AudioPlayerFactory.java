package factory;

import core.Product;
import media.AudioPlayer;

public class AudioPlayerFactory implements ProductFactory {
    public Product createProduct(String name) {
        return new AudioPlayer(name, "Generic Audio");
    }
}
