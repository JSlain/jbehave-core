/*
 * Created on 05-Aug-2004
 * 
 * (c) 2003-2004 ThoughtWorks Ltd
 *
 * See license.txt for license details
 */
package com.thoughtworks.jbehave.core;

import java.io.PrintWriter;

import com.thoughtworks.jbehave.core.listeners.TextReporter;
import com.thoughtworks.jbehave.core.verifiers.InvokeMethodWithSetUpAndTearDown;

/**
 * @author <a href="mailto:dan.north@thoughtworks.com">Dan North</a>
 */
public class Run {
    public static void main(String[] args) {
        try {
            Class classToVerify = Class.forName(args[0]);
            TextReporter textReporter = new TextReporter(new PrintWriter(System.out));
            BehaviourClass visitableClass = new BehaviourClass(classToVerify, new InvokeMethodWithSetUpAndTearDown());
            visitableClass.accept(textReporter);

//            TextListener textListener = new TextListener(new PrintWriter(System.out));
//            BehaviourVerifier verifier = new BehaviourVerifier();
//            verifier.registerListener(textListener);
//            BehaviourClass behaviourClass = new BehaviourClass(classToVerify, verifier, new InvokeMethodWithSetUpAndTearDown());
//            verifier.verify(behaviourClass);
//            textListener.printReport();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Problem verifying behaviour class " + args[0]);
            System.exit(1);
        }
    }
}
