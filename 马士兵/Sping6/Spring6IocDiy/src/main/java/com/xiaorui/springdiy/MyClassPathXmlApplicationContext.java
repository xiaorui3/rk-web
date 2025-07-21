package com.xiaorui.springdiy;

import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;

public class MyClassPathXmlApplicationContext implements MyFactory{
    public MyClassPathXmlApplicationContext(String xmlpath) {
        parseXml(xmlpath);
        instanceBean();
    }

    private void instanceBean() {
    }

    private void parseXml(String xmlpath) {
        SAXReader saxReader=new SAXReader();

    }

    @Override
    public Object getBean(String id) {
        return null;
    }
}
