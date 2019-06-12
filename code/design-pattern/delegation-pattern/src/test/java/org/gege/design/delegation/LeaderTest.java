package org.gege.design.delegation;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author gege
 * @Description
 * @date 2019/3/20 15:26
 */
public class LeaderTest {

    @Test
    public void doing() {
        //客户请求（Boss）、委派者（Leader）、被被委派者（Target）
        //委派者要持有被委派者的引用
        //代理模式注重的是过程， 委派模式注重的是结果
        //策略模式注重是可扩展（外部扩展），委派模式注重内部的灵活和复用
        //委派的核心：就是分发、调度、派遣
        //委派模式：就是静态代理和策略模式一种特殊的组合
        new Boss().command("B",new Leader());
    }
}