package com.n2017948072.main.domain;

import com.n2017948072.main.repository.ProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileTest {

    @Autowired
    private ProfileRepository profileRepository;
    private Profile savedProfile;

    @Before
    public void init(){
        savedProfile = profileRepository.save(Profile.builder()
                .network("트위터")
                .username("@hong")
                .url("https://twitter/@home")
                .createdAt(LocalDateTime.now())
                .build());
    }

    @Test
    public void testFindIDProfile(){
        Profile foundProfile = profileRepository.findById(savedProfile.getIdx()).orElse(null);
        assertThat(foundProfile.getIdx()).isEqualTo(savedProfile.getIdx());
    }
    public void testFindUserNameProfile(){
        Profile findUserNameProfile = profileRepository.findFirstByUsername("@hong");
        assertThat(findUserNameProfile.getUsername()).isEqualTo("@hong");
    }
}
