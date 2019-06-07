package com.n2017948072.main.domain;

import com.n2017948072.main.repository.BasicRepository;
import com.n2017948072.main.repository.ProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BasicTest {

    @Autowired
    private BasicRepository basicRepository;

    private ProfileRepository profileRepository;
    private Basic savedBasic;

    @Before
    public void init(){
        savedBasic = basicRepository.save(Basic.builder()
                .name("홍길동")
                .label("도적")
                .email("hong@naver.com")
                .phone("012-3456-789")
                .build());
    }

    @Test
    public void testFindIDBasic(){
        Basic foundBasic = basicRepository.findById(savedBasic.getIdx()).orElse(null);
        assertThat(foundBasic.getIdx()).isEqualTo(savedBasic.getIdx());
    }
    @Test
    public void testFindNameBasic(){
        Basic findNameBasic = basicRepository.findFirstByName("홍길동");
        assertThat(findNameBasic.getName()).isEqualTo("홍길동");
    }
}
