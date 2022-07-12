package kh.spring.DAO;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.DTO.ReportDTO;

@Repository
public class RegStdsDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	// 구매 관련
		public int regOrNot(Map<String,String> map) {
			return mybatis.selectOne("RegStds.regOrNot",map);
		}
		
		public int reg(Map<String,String> map) {
			return mybatis.insert("RegStds.reg",map);
		}
		
		public int countStds(String parent_seq) {
			return mybatis.selectOne("RegStds.countStds",parent_seq);
		}
		
		public int getRegSeq() {
			return mybatis.selectOne("RegStds.getRegSeq");
		}
}