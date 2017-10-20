/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.extension.siddhi.execution.test.length;

import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.wso2.extension.siddhi.execution.test.util.UnitTestAppender;
import org.wso2.siddhi.core.SiddhiAppRuntime;
import org.wso2.siddhi.core.SiddhiManager;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.exception.SiddhiAppCreationException;
import org.wso2.siddhi.core.executor.function.FunctionExecutor;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.util.EventPrinter;

/**
 * Test for UnitConversion MetreToFoot function
 */
public class MetreToFootTestCase {

    private static Logger logger = Logger.getLogger(MetreToFootTestCase.class);
    protected static SiddhiManager siddhiManager;

    @Test
    public void testProcessForMetreToFoot() throws Exception {
        logger.info("UnitConversionForMetreToFootFunctionExtension TestCase");

        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForMetreToFootStream (inValue int); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForMetreToFootStream "
                + " select unitconversion:mToft(inValue) "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager
                .createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);

        siddhiAppRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents,
                                Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                Double result;
                for (Event event : inEvents) {
                    result = (Double) event.getData(0);
                    AssertJUnit.assertEquals((Double) 3.280839895013123, result);
                }
            }
        });
        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("UnitConversionForMetreToFootStream");
        siddhiAppRuntime.start();
        inputHandler.send(new Object[]{1.0});
        Thread.sleep(100);
        siddhiAppRuntime.shutdown();
    }

    @Test
    public void testProcessForMetreToFoot2() throws Exception {
        logger.info("UnitConversionForMetreToFootFunctionExtension2 TestCase");

        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForMetreToFootStream (inValue int); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForMetreToFootStream "
                + " select unitconversion:mToft(inValue) "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager
                .createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);

        siddhiAppRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents,
                                Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                Double result;
                for (Event event : inEvents) {
                    result = (Double) event.getData(0);
                    AssertJUnit.assertEquals((Double) 0.0, result);
                }
            }
        });
        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("UnitConversionForMetreToFootStream");
        siddhiAppRuntime.start();
        inputHandler.send(new Object[]{0});
        Thread.sleep(100);
        siddhiAppRuntime.shutdown();
    }

    @Test
    public void testProcessForMetreToFoot3() throws Exception {
        logger.info("UnitConversionForMetreToFootFunctionExtension3 TestCase");

        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForMetreToFootStream (inValue int); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForMetreToFootStream "
                + " select unitconversion:mToft(inValue) "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager
                .createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);

        siddhiAppRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents,
                                Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                Double result;
                for (Event event : inEvents) {
                    result = (Double) event.getData(0);
                    AssertJUnit.assertEquals((Double) 7.0455500229658785E9, result);
                }
            }
        });
        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("UnitConversionForMetreToFootStream");
        siddhiAppRuntime.start();
        inputHandler.send(new Object[]{2147483647});
        Thread.sleep(100);
        siddhiAppRuntime.shutdown();
    }

    @Test (expectedExceptions = SiddhiAppCreationException.class)
    public void testProcessForMetreToFoot4() throws Exception {
        logger.info("UnitConversionForMetreToFootFunctionExtension4 TestCase");
        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForMetreToFootStream (inValue int); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForMetreToFootStream "
                + " select unitconversion:mToft() "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        siddhiManager.createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);
    }

    @Test (expectedExceptions = SiddhiAppCreationException.class)
    public void testProcessForMetreToFoot5() throws Exception {
        logger.info("UnitConversionForMetreToFootFunctionExtension4 TestCase");
        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForMetreToFootStream (inValue string); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForMetreToFootStream "
                + " select unitconversion:mToft(inValue) "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        siddhiManager.createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);
    }

    @Test
    public void testProcessForMetreToFoot6() throws Exception {
        logger.info("UnitConversionForMetreToFootFunctionExtension6 TestCase");
        logger = Logger.getLogger(FunctionExecutor.class);
        UnitTestAppender appender = new UnitTestAppender();
        logger.addAppender(appender);
        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForMetreToFootStream (inValue int); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForMetreToFootStream "
                + " select unitconversion:mToft(inValue) "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager
                .createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);

        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("UnitConversionForMetreToFootStream");
        siddhiAppRuntime.start();
        inputHandler.send(new Object[]{null});
        AssertJUnit.assertTrue(appender.getMessages().contains("Input to the UnitConversion function "
                                                                       + "cannot be null"));
        siddhiAppRuntime.shutdown();
    }
}
