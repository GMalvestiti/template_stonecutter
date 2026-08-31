package com.gmalvestiti.minecraft.template;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.gmalvestiti.minecraft.template.injection.TemplateItem;
import net.minecraft.SharedConstants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.item.Items;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.gmalvestiti.minecraft.template.TemplateCommon.CONFIG;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemplateTest {

    @BeforeAll
    static void beforeAll() {
        SharedConstants.tryDetectVersion();
        Bootstrap.bootStrap();
    }

    @Test
    void testRegistries() {
        assertTrue(BuiltInRegistries.ITEM.containsKey(Identifier.fromNamespaceAndPath("minecraft", "diamond")));
    }

    @Test
    void testMixin() {
        assertEquals(CONFIG.data().test1, ((TemplateItem) Items.DIAMOND).template$getValue());
    }

    @Test
    void testConfig() {
        int newValue = 11;

        CONFIG.update(config -> config.test1 = newValue);
        TemplateItem item = (TemplateItem) Items.DIAMOND;
        item.template$updateValue();

        assertEquals(newValue, item.template$getValue());
    }

    @Test
    void testDependencies() {
        assertDoesNotThrow(() -> {
            Cache<String, String> cache = Caffeine.newBuilder().build();
            cache.put("key", "value");
        });
    }
}
