package com.example.hellorest.members.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.hellorest.members.model.Member;

@Repository("members.dao.membersDaoH2")
public class MembersDaoH2 implements MembersDao {

	private Logger logger = LoggerFactory.getLogger(MembersDaoH2.class);

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public void insertNewMember(Member member) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MEMBER (NAME, USERNAME) ");
		sql.append(" VALUES (?, ?) ");

		int resultCount = jdbcTemplate.update(sql.toString(), member.getName(), member.getUsername());
		logger.debug("insertNewMember Result Count : " + resultCount);
	}

	@Override
	public List<Member> selectAllMembers() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MEMBER_ID, NAME, USERNAME ");
		sql.append(" FROM MEMBER ");

		List<Member> resultList = jdbcTemplate.query(sql.toString(), new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setId(rs.getInt("MEMBER_ID"));
				member.setName(rs.getString("NAME"));
				member.setUsername(rs.getString("USERNAME"));

				return member;
			}
		});

		return resultList;
	}

	@Override
	public Member selectOneMember(long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MEMBER_ID, NAME, USERNAME ");
		sql.append(" FROM MEMBER ");
		sql.append(" WHERE MEMBER_ID = ? ");

		return jdbcTemplate.queryForObject(sql.toString(), new Object[] { id }, (rs, rowNum) -> {
			Member member = new Member();
			member.setId(rs.getInt(1));
			member.setName(rs.getString(2));
			member.setUsername(rs.getString(3));
			return member;
		});
	}

	@Override
	public void deleteOneMember(long id) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM MEMBER ");
		sql.append(" WHERE MEMBER_ID = ? ");

		int resultCount = jdbcTemplate.update(sql.toString(), id);
		logger.debug("deleteOneMember Result Count" + resultCount);
	}

	@Override
	public Member updateOneMember(long id, Member member) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE MEMBER ");
		sql.append(" SET NAME = ?, USERNAME = ? ");
		sql.append(" WHERE MEMBER_ID = ? ");

		int resultCount = jdbcTemplate.update(sql.toString(), member.getName(), member.getUsername(), id);
		logger.debug("updateOneMember Result Count : " + resultCount);

		return this.selectOneMember(id);
	}

}
