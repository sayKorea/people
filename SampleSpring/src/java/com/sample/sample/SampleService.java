package com.sample.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sample.common.DAO;


/**
 * @author Administrator
 *
 */
@Service("sampleService")
public class SampleService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	@Named("DAO")
	private DAO dao;
	
	/**
	 * @param commandMap
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,String>> getMenuList(Map<String,Object> paramMap) throws Exception{
		log.info("Welcome home! The client locale is {}.");
		List<Map<String,String>> rtnList = new ArrayList<Map<String,String>>();
		rtnList = dao.selectList("sample.selectBoardList") ;
        return rtnList;
    }
}
