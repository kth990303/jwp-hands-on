package reflection;

import annotation.Controller;
import annotation.Repository;
import annotation.Service;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReflectionsTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    void showAnnotationClass() {
        Reflections reflections = new Reflections("examples");

        getClassMetaData(reflections, Controller.class);
        getClassMetaData(reflections, Service.class);
        getClassMetaData(reflections, Repository.class);
    }

    private void getClassMetaData(final Reflections reflections, final Class<? extends Annotation> target) {
        final List<Class<?>> targetClasses = reflections.getTypesAnnotatedWith(target)
                .stream()
                .collect(Collectors.toUnmodifiableList());

        for (Class<?> targetClass : targetClasses) {
            log.info("{} class: {}", target.getSimpleName(), targetClass);
        }
    }
}
