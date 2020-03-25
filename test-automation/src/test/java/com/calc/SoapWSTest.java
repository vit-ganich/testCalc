package com.calc;

import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.WSDLParser;
import com.predic8.wstool.creator.RequestTemplateCreator;
import com.predic8.wstool.creator.SOARequestCreator;
import groovy.xml.MarkupBuilder;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.StringWriter;
import java.util.HashMap;

public class SoapWSTest {

    @Test
    @Ignore
    public void getRequestStructure() {
        String endpointUrl = "http://localhost:8080/testCalc/soapWS";
        WSDLParser parser = new WSDLParser();
        Definitions wsdl = parser.parse(endpointUrl + "?wsdl");

        StringWriter requestBody = new StringWriter();
        HashMap<String, String> formParams = new HashMap<>();

        SOARequestCreator creator = new SOARequestCreator(wsdl, new RequestTemplateCreator(), new MarkupBuilder(requestBody));
        creator.setFormParams(formParams);
        Object request = creator.createRequest("TestCalcSoapImplementationPort", "add", "TestCalcSoapImplementationPortBinding");

        System.out.println(requestBody);
    }
}
