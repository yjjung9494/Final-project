package kh.spring.Service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.DAO.CommunityDAO;
import kh.spring.DAO.ImgDAO;
import kh.spring.DAO.SeqDAO;
import kh.spring.DTO.CommunityDTO;
import kh.spring.DTO.ImgDTO;

@Service
public class CommunityService {
	@Autowired
	private CommunityDAO dao;
	@Autowired
	private ImgDAO imgDao;
	@Autowired
	private SeqDAO seqDao;
	
	//게시글 생성
	@Transactional
	public void insert(String categoryOption, CommunityDTO dto, MultipartFile[] file, String realPath) throws Exception {

		String sequence = seqDao.getCommunitySeq(categoryOption);//시퀀스 형식 가져와서 셋.(ex) 'q'||question_seq"  )
		dto.setBoard_seq(sequence);
		String seq = dao.insert(dto); //게시글 정보 board테이블에 삽입 및 seq가져오기	
		

		//파일 업로드/////////////
		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) {
			realPathFile.mkdir();
		}
		
		for(MultipartFile mf : file) {
			String ori_name = mf.getOriginalFilename();
			if(ori_name.equals("")) {
				break;
			}
			String sys_name = UUID.randomUUID() + "_" + ori_name;
			mf.transferTo(new File(realPath + "/" + sys_name));
			
			String imgSequence = seqDao.getSeq("co");//시퀀스 형식 가져와서 셋.(ex) 'co'||comImage_seq )
			
			ImgDTO imgDTO = new ImgDTO(imgSequence, ori_name, sys_name, null, seq);
			imgDao.insert(imgDTO);
		}
	}
	
	//해당 페이지의 댓글 가져오기
	public List<CommunityDTO> selectByPage(int cpage, String category) {
		int start = (cpage-1) *10 +1;//해당 페이지의 첫 게시글 번호
		int end = cpage * 10;//해당 페이지의 끝 게시글 번호
		
		return dao.selectByPage(start, end, category);
		
	}
	
	//게시글 별 totalPage 가져오기
	public int totalPage(String category) {
		return dao.totalPage(category);
	}

	
	
	
	
	
	//게시글 더미 데이터 만들기
	public void dumy(){
		dao.dumy();
	}
	
}
