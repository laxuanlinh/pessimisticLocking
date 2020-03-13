package com.linhlx.pessimisticLocking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestObjectService testObjectService;

    @GetMapping(value = "/")
    public TestObject test() throws Exception{
        return testObjectService.getTestObject();
    }

}
