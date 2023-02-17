package io.github.lc.oss.commons.api.identity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.lc.oss.commons.api.identity.Messages.Application;
import io.github.lc.oss.commons.api.identity.Messages.Authentication;
import io.github.lc.oss.commons.api.identity.Messages.Categories;
import io.github.lc.oss.commons.serialization.JsonMessage;
import io.github.lc.oss.commons.serialization.Message;
import io.github.lc.oss.commons.serialization.Message.Category;

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

    @Test
    public void test_isSame() {
        Message n1 = new JsonMessage(null, null, -1);
        Message n2 = new JsonMessage(Categories.Application, null, -1);
        Message m1 = new JsonMessage(Categories.Application, Message.Severities.Error, 1);
        Message m2 = new JsonMessage(Categories.Application, Message.Severities.Error, 1);
        Message m3 = new JsonMessage(Categories.Application, Message.Severities.Warning, 1);
        Message m4 = new JsonMessage(Categories.Authentication, Message.Severities.Error, 1);
        Message m5 = new JsonMessage(Categories.Application, Message.Severities.Error, 2);

        Assertions.assertTrue(n1.isSame(n1));
        Assertions.assertFalse(n1.isSame(null));

        Assertions.assertNotEquals(m1, m2);
        Assertions.assertNotSame(m1, m2);
        Assertions.assertFalse(m1 == m2);
        Assertions.assertFalse(m1.isSame(n1));
        Assertions.assertFalse(m1.isSame(n2));
        Assertions.assertTrue(m1.isSame(m2));
        Assertions.assertFalse(m1.isSame(m3));
        Assertions.assertFalse(m1.isSame(m4));
        Assertions.assertFalse(m1.isSame(m5));
    }
}
