package com.linhlx.pessimisticLocking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TestObjectService {

    @Autowired
    private TestObjectRepository testObjectRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public TestObject getTestObject() throws Exception{
        TestObject testObject = (TestObject) entityManager.createQuery("select o from TestObject o where o.status != 'used'")
                .setMaxResults(1)
                .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                .getSingleResult();
        System.out.println("Getting "+testObject.getId());
        TimeUnit.SECONDS.sleep(3);
        testObject.setStatus("used");
        System.out.println("set "+testObject.getId()+" to used");
        testObjectRepository.save(testObject);
        return testObject;

    }

}
