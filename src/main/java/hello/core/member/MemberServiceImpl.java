package hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //구현 객체 선택

    //생성자 생성시켜줌(멤버 리포지토리의 구현체를 어느 것을 선택할지 생성자를 통해 결정)
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

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
