package hello.core.member;

import hello.core.study.Study;

import java.util.Optional;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);
}
