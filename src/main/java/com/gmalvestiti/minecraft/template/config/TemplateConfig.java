package com.gmalvestiti.minecraft.template.config;

import com.gmalvestiti.minecraft.liteconfig.api.annotations.Config;
import com.gmalvestiti.minecraft.liteconfig.api.annotations.Entry;
import com.gmalvestiti.minecraft.liteconfig.api.annotations.Ignore;

import java.util.List;
import java.util.Map;

@Config(name="template", comment=" Test", sync = true)
public class TemplateConfig {

    @Entry(name = "test_one", comment = "Test comment")
    public int test1 = 0;

    public List<String> testList = List.of("test1", "test2", "test3");
    public Map<String, Integer> testMap = Map.of("test1", 1, "test2", 2, "test3", 3);

    public TestInner testInner = new TestInner();

    @Ignore
    public int test2 = 0;

    public static class TestInner {
        public double test3 = 11.1;
        public long test4 = 9L;
        @Entry(name = "test_five", comment = "Test comment")
        public int test5 = 10;
    }

    @Entry(restart = true)
    public int test6 = 0;
}
