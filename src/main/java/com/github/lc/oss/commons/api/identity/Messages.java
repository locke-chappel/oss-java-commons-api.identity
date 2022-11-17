package com.github.lc.oss.commons.api.identity;

import java.util.Set;

import com.github.lc.oss.commons.serialization.Message.Category;
import com.github.lc.oss.commons.serialization.Message.Severities;
import com.github.lc.oss.commons.serialization.Message.Severity;
import com.github.lc.oss.commons.util.TypedEnumCache;

public interface Messages {
    enum Categories implements Category {
        Application,
        Authentication;

        private static final TypedEnumCache<Categories, Category> CACHE = new TypedEnumCache<>(Categories.class);

        public static Set<Category> all() {
            return Categories.CACHE.values();
        }

        public static Category byName(String name) {
            return Categories.CACHE.byName(name);
        }

        public static boolean hasName(String name) {
            return Categories.CACHE.hasName(name);
        }

        public static Category tryParse(String name) {
            return Categories.CACHE.tryParse(name);
        }
    }

    enum Application implements Messages {
        UnhandledError(Severities.Error, 1),
        RequiredFieldMissing(Severities.Error, 2),
        InvalidField(Severities.Error, 3),
        NotFound(Severities.Error, 404);

        private static final TypedEnumCache<Application, Application> CACHE = new TypedEnumCache<>(Application.class);

        public static Set<Application> all() {
            return Application.CACHE.values();
        }

        public static Application byName(String name) {
            return Application.CACHE.byName(name);
        }

        public static boolean hasName(String name) {
            return Application.CACHE.hasName(name);
        }

        public static Application tryParse(String name) {
            return Application.CACHE.tryParse(name);
        }

        private final Category category;
        private final Severity severity;
        private final int number;

        private Application(Severity severiy, int number) {
            this.category = Categories.Application;
            this.severity = severiy;
            this.number = number;
        }

        @Override
        public Category getCategory() {
            return this.category;
        }

        @Override
        public Severity getSeverity() {
            return this.severity;
        }

        @Override
        public int getNumber() {
            return this.number;
        }
    }

    enum Authentication implements Messages {
        InvalidCredentials(Severities.Error, 1),
        InvalidToken(Severities.Error, 2);

        private static final TypedEnumCache<Authentication, Authentication> CACHE = new TypedEnumCache<>(Authentication.class);

        public static Set<Authentication> all() {
            return Authentication.CACHE.values();
        }

        public static Authentication byName(String name) {
            return Authentication.CACHE.byName(name);
        }

        public static boolean hasName(String name) {
            return Authentication.CACHE.hasName(name);
        }

        public static Authentication tryParse(String name) {
            return Authentication.CACHE.tryParse(name);
        }

        private final Category category;
        private final Severity severity;
        private final int number;

        private Authentication(Severity severiy, int number) {
            this.category = Categories.Authentication;
            this.severity = severiy;
            this.number = number;
        }

        @Override
        public Category getCategory() {
            return this.category;
        }

        @Override
        public Severity getSeverity() {
            return this.severity;
        }

        @Override
        public int getNumber() {
            return this.number;
        }
    }

    Category getCategory();

    Severity getSeverity();

    int getNumber();
}
