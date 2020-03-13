package com.linhlx.pessimisticLocking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface TestObjectRepository extends JpaRepository<TestObject, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select o from TestObject o where o.status != 'used'")
    List<TestObject> getUnlockedObject();

}
