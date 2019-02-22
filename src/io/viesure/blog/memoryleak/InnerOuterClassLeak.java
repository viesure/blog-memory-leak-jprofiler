package io.viesure.blog.memoryleak;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class InnerOuterClassLeak {
    public static final int NUMBER_OF_OBJECTS = 50_000_000;

    public static void main(String... args) throws IOException {
        List<Model.Attribute> modelAttributes = getAllModelAttributes();

        // computation using the model Attributes ...

        System.out.println("GC should pick up classes");
        System.gc(); // try to force garbage collection
        System.in.read(); // stop the application from terminating
    }

    private static List<Model.Attribute> getAllModelAttributes() {
        // Model is only used in scope of this method
        List<Model> models = Model.getModelList();

        return models.stream()
                .map(Model::getAttribute)
                .collect(Collectors.toList());
    }
}
