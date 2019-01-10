package com.gildedrose;

import com.google.common.collect.Range;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Rules {

    private final List<Rule> rules;

    public Rules(List<Rule> rules) {
        this.rules = rules;
    }

    public static class Rule {

        private final Range<Integer> range;
        private final Consumer<Item> f;

        public Rule(Range<Integer> range, Consumer<Item> f) {
            this.range = range;
            this.f = f;
        }

        public void apply(Item item) {
            f.accept(item);
        }

    }

    public Rules(Rule... rules) {
        this.rules = Arrays.asList(rules);
    }

    public void apply(Item item) {
        selectRule(item).apply(item);
    }

    private Rule selectRule(Item item) {
        for (Rule rule : rules){
          if (rule.range.contains(item.sellIn)) {
              return rule;
          }
       } return null;
    }

}
