package kh.spring.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kh.spring.DAO.AdminDAO;
import kh.spring.DAO.ImgDAO;
import kh.spring.DTO.ClassDTO;
import kh.spring.DTO.ImgDTO;
import kh.spring.DTO.MemberDTO;
import kh.spring.DTO.Pagination;
import kh.spring.DTO.RegStdsDTO;


@Service
public class AdminService {

	@Autowired
	AdminDAO adao;
	
	@Autowired
	ImgDAO idao;
	
	@Autowired
	Gson g;

	//1. 관리자 페이지 메인



	//회원리스트 뽑기
	public List<MemberDTO> memberListByPage(Pagination page,String targetType,String target){
		List<MemberDTO> mList = adao.selectMemberByPage(page,targetType,target);//회원정보
		for(MemberDTO mdto:mList) {
			if(mdto.getType().equals("M")) {
				mdto.setType("일반회원");
			}else if(mdto.getType().equals("B")) {
				mdto.setType("블랙리스트");
			}else {
				mdto.setType("관리자");
			}		
		}
		return  mList;
	}

	//신고수 및 등록강의수 뽑기
	public List<Map<String,String>> rNcCountList(List<MemberDTO> mList){

		List<Map<String,String>> rNcCountList = new ArrayList<Map<String,String>>();//신고수와 개설강의수 넣어줄 리스트
		for(MemberDTO dto:mList) {
			//신고 수 뽑기
			Map<String,String> map = new HashMap<String,String>();
			String reportCount = Integer.toString(adao.countReportById(dto.getEmail()));
			map.put("reportCount", reportCount);

			//개설 강의 수 뽑기
			String openClassCount = Integer.toString(adao.CountOpenClassById(dto.getEmail()));
			map.put("openClassCount", openClassCount);

			rNcCountList.add(map);	
		}

		return rNcCountList;
	}

	//  조건에 맞는 회원 수(페이징)
	public int selectMemberCount(String targetType,String target) {
		return adao.selectMemberCount(targetType,target);
	}
	
	//신고수 뽑기(회원상세페이지)
	public int reportCount(String email) {
		return adao.countReportById(email);
	}
	
	//회원정보 수정
	public void adminMemberUpdate(String modiType,String modiContents,String email) {
		adao.adminMemberUpdate(modiType,modiContents,email);
	}
	
	//메인 이미지 뽑기
	public List<ImgDTO> selectMainImgBySeq(List<ClassDTO> buycList){
		
		List<ImgDTO> mainImgList = new ArrayList<ImgDTO>();
		
		for(ClassDTO cdto:buycList) {
			ImgDTO idto =idao.selectMByPSeq(cdto.getClass_seq());
			mainImgList.add(idto);
		}
		
		return mainImgList;
	}
	
	//해당 회원이 구매한 클래스 뽑기
//	public List<ClassDTO> buyClass(String email){
//		List<RegStdsDTO> buycSeqList = adao.buyClassByEmail(email);
//		System.out.println(buycSeqList.size());
//		List<ClassDTO> buycList = new ArrayList<ClassDTO>();
//		
//		for(RegStdsDTO rdto : buycSeqList) {
//			ClassDTO cdto = adao.classListBySeq(rdto.getParent_seq());
//			buycList.add(cdto);
//		}
//		
//		return buycList;
//	}
	
	public List<Timestamp> buydayList(List<ClassDTO> buycList){
		List<Timestamp> buydayList = new ArrayList<Timestamp>();
		
		for(ClassDTO rdto: buycList) {
			String buyday = adao.buydayBySeq(rdto.getClass_seq());
			
			Timestamp timestamp = Timestamp.valueOf(buyday);
			
			buydayList.add(timestamp);
		}
		
		return buydayList;
	}
	
	public int buyCountByEmail(String email) {
		return adao.buyCountByEmail(email);
	}
	
	public List<ClassDTO> buyClassListByPage(String email,int start,int end){		
	return adao.buyClassListByPage(email,start,end);
		
	}
	
	public List<String> class_dateToString(List<ClassDTO> buyClassList){
		List<String> class_dateList = new ArrayList<String>();
		for(ClassDTO cdto:buyClassList) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        	//원하는 데이터 포맷 지정
			String strNowDate = simpleDateFormat.format(cdto.getClass_date()); 
        	//지정한 포맷으로 변환 
			class_dateList.add(strNowDate);
		}
		
		return class_dateList;
	}
	
	public List<String> selectNicknameByEmail(List<ClassDTO> buyClassList){
		List<String> nicknameList = new ArrayList<String>();
		
		for(ClassDTO cdto: buyClassList ) {
			String nickname = adao.selectNicknameByEmail(cdto.getCreater_id());
			nicknameList.add(nickname);
		}
		
		return nicknameList;
	}
//	public List<Timestamp> buyDayByEmailAndSeq(List<ClassDTO> BuyClassList){
//		for(ClassDTO cdto : BuyClassList) {
//			adao.buyDayByEmailAndSeq(cdto.getClass_seq(),cdto.)
//		}
//	}
}
