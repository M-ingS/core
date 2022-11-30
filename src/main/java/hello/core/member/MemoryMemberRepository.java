package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    //동시성 이슈가 발생할 수 있기에 컨커런트 해쉬맵을 쓰는 걸 추천

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);     //memberId로 회원 객체를 찾기
    }


}
