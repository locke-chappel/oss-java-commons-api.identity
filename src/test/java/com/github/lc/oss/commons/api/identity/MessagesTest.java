package com.github.lc.oss.commons.api.identity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.lc.oss.commons.api.identity.Messages.Application;
import com.github.lc.oss.commons.api.identity.Messages.Authentication;
import com.github.lc.oss.commons.serialization.Message.Category;

public class MessagesTest {
    @Test
    public void test_collisions() {
        Set<String> all = new HashSet<>();
        Messages.Application.all().stream(). //
                map(m -> String.format("%s.%s.%d", m.getCategory().name(), m.getSeverity().name(), m.getNumber())). //
                forEach(id -> {
                    Assertions.assertTrue(all.add(id), String.format("Duplicate ID '%s'", id));
                });
        Messages.Authentication.all().stream(). //
                map(m -> String.format("%s.%s.%d", m.getCategory().name(), m.getSeverity().name(), m.getNumber())). //
                forEach(id -> {
                    Assertions.assertTrue(all.add(id), String.format("Duplicate ID '%s'", id));
                });
    }

    @Test
    public void test_categories() {
        Messages.Categories[] values = Messages.Categories.values();
        Set<Category> all = Messages.Categories.all();
        Assertions.assertEquals(values.length, all.size());
        Assertions.assertSame(all, Messages.Categories.all());
        Arrays.stream(values).forEach(v -> Assertions.assertTrue(all.contains(v)));
        all.stream().forEach(a -> {
            Assertions.assertTrue(Messages.Categories.hasName(a.name()));
            Assertions.assertSame(a, Messages.Categories.byName(a.name()));
            Assertions.assertSame(a, Messages.Categories.tryParse(a.name()));
        });
    }

    @Test
    public void test_application() {
        Messages.Application[] values = Messages.Application.values();
        Set<Application> all = Messages.Application.all();
        Assertions.assertEquals(values.length, all.size());
        Assertions.assertSame(all, Messages.Application.all());
        Arrays.stream(values).forEach(v -> Assertions.assertTrue(all.contains(v)));
        all.stream().forEach(a -> {
            Assertions.assertTrue(Messages.Application.hasName(a.name()));
            Assertions.assertSame(a, Messages.Application.byName(a.name()));
            Assertions.assertSame(a, Messages.Application.tryParse(a.name()));
        });
    }

    @Test
    public void test_authentication() {
        Messages.Authentication[] values = Messages.Authentication.values();
        Set<Authentication> all = Messages.Authentication.all();
        Assertions.assertEquals(values.length, all.size());
        Assertions.assertSame(all, Messages.Authentication.all());
        Arrays.stream(values).forEach(v -> Assertions.assertTrue(all.contains(v)));
        all.stream().forEach(a -> {
            Assertions.assertTrue(Messages.Authentication.hasName(a.name()));
            Assertions.assertSame(a, Messages.Authentication.byName(a.name()));
            Assertions.assertSame(a, Messages.Authentication.tryParse(a.name()));
        });
    }
}
