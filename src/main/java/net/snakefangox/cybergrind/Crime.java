package net.snakefangox.cybergrind;

import net.minecraft.util.Pair;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Crime {
    public static <T> List<Pair<T, String>> getStaticFields(Class<?> clazz, Class<T> type) {
        var t = clazz.getDeclaredFields();
        List<Pair<T, String>> collect = stream(clazz.getDeclaredFields())
                .filter(f -> Modifier.isStatic(f.getModifiers()))
                .filter(f -> f.getType().isAssignableFrom(type))
                .map(f -> {
                    try {
                        T v = (T) f.get(null);
                        return new Pair<>(v, f.getName().toLowerCase());
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
        return collect;
    }
}
