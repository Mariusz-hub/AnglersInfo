package com.angler;

import com.angler.domain.Fish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FishRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void FishPersistTest(){
        Fish fish = testEntityManager.find(Fish.class,1l);

        assertThat(fish.getId(),equalTo(1l) );
        assertThat(fish.getName(),equalTo("Szczupak") );
        assertThat(fish.getDescription().getId(),equalTo(1l) );

    }
}
