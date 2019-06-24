package com.example.hellorest.members.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.hellorest.members.dao.MembersDao;
import com.example.hellorest.members.model.Member;

@Service
public class MembersServiceImpl implements MembersService {

	@Autowired
	@Qualifier("members.dao.MembersDaoInMemory")
	private MembersDao membersDao;

	@Override
	public void save(Member member) {
		membersDao.insertNewMember(member);
	}

	@Override
	public List<Member> getAll() {
		return membersDao.selectAllMembers();
	}

	@Override
	public Member getOne(long id) {
		return membersDao.selectOneMember(id);
	}

	@Override
	public void removeOne(long id) {
		membersDao.deleteOneMember(id);
	}

	@Override
	public Member updateOne(long id, Member member) {
		return membersDao.updateOneMember(id, member);
	}

}
