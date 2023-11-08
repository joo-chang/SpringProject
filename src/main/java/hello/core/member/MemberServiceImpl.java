package hello.core.member;

import hello.core.study.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean (MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.empty();
    }

    @Override
    public void validate(Long memberId) {

    }

    @Override
    public void notify(Study newstudy) {

    }

    @Override
    public void notify(Member member) {

    }

    // 테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
