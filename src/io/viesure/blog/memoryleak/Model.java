package io.viesure.blog.memoryleak;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.viesure.blog.memoryleak.InnerOuterClassLeak.NUMBER_OF_OBJECTS;

public class Model {
    private String modelName = "TestModelName";
    private Attribute attribute = new Attribute();

    public static List<Model> getModelList(){
        return IntStream.range(0, NUMBER_OF_OBJECTS).mapToObj(a -> new Model()).collect(Collectors.toList());
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public /* static */ class Attribute{
        private String name = "random Attribute";
        private String value = "42";
    }
}
