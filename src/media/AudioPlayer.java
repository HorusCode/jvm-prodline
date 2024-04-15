package media;

import core.ItemType;
import core.Product;

public class AudioPlayer extends Product implements MultimediaControl {
    private String audioSpecification;
    private ItemType mediaType;
    public AudioPlayer(String name, String audioSpecification) {
        super(name);
        this.audioSpecification = audioSpecification;
        this.mediaType = ItemType.AUDIO;
    }


    @Override
    public void play() {
        System.out.println("Играет");
    }

    @Override
    public void stop() {
        System.out.println("Стоп");
    }

    @Override
    public void previous() {
        System.out.println("Предыдущий");
    }

    @Override
    public void next() {
        System.out.println("Следующий");
    }

    @Override
    public String toString() {
        return super.toString() + "\nСпецификация : " + audioSpecification + "\nТип : " + mediaType;
    }
}
