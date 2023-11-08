package hello.core.study;

import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Test
    void createStudyService(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("hello@naver.com");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        assertEquals("hello@naver.com", memberService.findById(1L).get().getEmail());

    }

    @Test
    void test(@Mock MemberService memberService, @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "테스트");

        Member member = new Member();
        member.setId(1L);
        member.setEmail("hello@naver.com");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));

//        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);

        assertNotNull(study.getOwnerId());
        assertEquals(member.getId(), study.getOwnerId());
    }
}