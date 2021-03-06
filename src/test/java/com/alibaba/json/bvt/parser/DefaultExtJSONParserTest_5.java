package com.alibaba.json.bvt.parser;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.parser.DefaultExtJSONParser;
import com.alibaba.fastjson.parser.Feature;

public class DefaultExtJSONParserTest_5 extends TestCase {
    
    public void test_0() throws Exception {
        DefaultExtJSONParser parser = new DefaultExtJSONParser("{,,,,\"value\":3,\"id\":1}");
        parser.config(Feature.AllowArbitraryCommas, true);
        Entity entity = new Entity();
        parser.parseObject(entity);
        Assert.assertEquals(3, entity.getValue());
    }
    
    public void test_1() throws Exception {
        DefaultExtJSONParser parser = new DefaultExtJSONParser("{\"value\":3,\"id\":1}");
        parser.config(Feature.AllowArbitraryCommas, false);
        Entity entity = new Entity();
        parser.parseObject(entity);
        Assert.assertEquals(3, entity.getValue());
    }

    public static class Entity {

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }
}
