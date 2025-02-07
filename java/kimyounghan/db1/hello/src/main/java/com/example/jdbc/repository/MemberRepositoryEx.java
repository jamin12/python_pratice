package com.example.jdbc.repository;

import java.sql.SQLException;

import com.example.jdbc.domain.Member;

public interface MemberRepositoryEx {
	Member save(Member member) throws SQLException;

	Member findById(String memberId) throws SQLException;

	void update(String memberId, int money) throws SQLException;

	void delete(String memberId) throws SQLException;
}