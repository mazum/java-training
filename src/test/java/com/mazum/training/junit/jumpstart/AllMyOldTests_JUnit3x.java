/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mazum.training.junit.jumpstart;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class AllMyOldTests_JUnit3x {
    public static Test suite() {
        return new TestSuite(TaxCalculatorImplOldTest.class);
    }
}
