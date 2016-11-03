package com.sample.sample;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.org.eclipse.jdt.core.dom.ThisExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/sample")
public class SampleController {
	private  Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="sampleService")
	private SampleService sampleService;

	/**
	 * @param commandMap
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/test.do")
	public ModelAndView getList(Map<String,Object> paramMap,Locale locale) throws Exception{
		log.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		log.debug(formattedDate);
		sampleService.getMenuList(paramMap);
		ModelAndView mv = new ModelAndView("");
        log.debug("샘플 콘트롤러");
        mv.addObject("serverTime", formattedDate);
        mv.setViewName("home");
        return mv;
    }

}
