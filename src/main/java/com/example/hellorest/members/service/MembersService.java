package com.example.hellorest.members.service;

import java.util.List;

import com.example.hellorest.members.model.Member;

public interface MembersService {

	public void save(Member member);

	public List<Member> getAll();

	public Member getOne(long id);

	public void removeOne(long id);

	public Member updateOne(long id, Member member);

}
