package com.example.hellorest.members.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.hellorest.members.model.Member;

@Repository("members.dao.MembersDaoInMemory")
public class MembersDaoInMemory implements MembersDao {

	private Map<Long, Member> members;

	private long id;

	public MembersDaoInMemory() {
		this.members = new HashMap<Long, Member>();
	}

	@Override
	public void insertNewMember(Member member) {
		member.setId(++id);
		members.put(id, member);

	}

	@Override
	public List<Member> selectAllMembers() {
		List<Member> result = new ArrayList<Member>();
		result = this.members.entrySet().stream().map((entry) -> entry.getValue()).collect(Collectors.toList());
		return result;
	}

	@Override
	public Member selectOneMember(long id) {
		return this.members.get(id);
	}

	@Override
	public void deleteOneMember(long id) {
		this.members.remove(id);
	}

	@Override
	public Member updateOneMember(long id, Member member) {
		Member originalMember = this.selectOneMember(id);
		if (member.getName().length() > 0) {
			originalMember.setName(member.getName());
		}
		if (member.getUsername().length() > 0) {
			originalMember.setUsername(member.getUsername());
		}
		return this.members.put(id, originalMember);
	}

}
