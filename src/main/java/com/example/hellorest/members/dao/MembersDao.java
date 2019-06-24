package com.example.hellorest.members.dao;

import java.util.List;

import com.example.hellorest.members.model.Member;

public interface MembersDao {

	public void insertNewMember(Member member);

	public List<Member> selectAllMembers();

	public Member selectOneMember(long id);

	public void deleteOneMember(long id);

	public Member updateOneMember(long id, Member member);

}
