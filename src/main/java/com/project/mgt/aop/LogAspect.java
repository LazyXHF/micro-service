package com.project.mgt.aop;

import com.alibaba.fastjson.JSONObject;
import com.project.mgt.entity.TXietongSysLog;
import com.project.mgt.service.impl.XietongSysLogService;
import com.project.mgt.util.UserUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日志切面
 * 
 * @author sunyuan
 *
 */
@Component
@Aspect
public class LogAspect {
	static final String tag = "LogAspect======";
	static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Autowired
	XietongSysLogService xietongSysLogService = null;

	// 切面
	@Pointcut("execution(public * com.project.mgt..controller.*.*(..))") // 两个..代表所有子目录，最后括号里的两个..代表所有参数
	public void logPointCut() {
	}

	@Around("logPointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

		try {
			// 接收到请求，记录请求内容
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			TXietongSysLog xietongSysLog = new TXietongSysLog();
			//0代表未删除，1代表删除  默认是0
			Integer j=0;
			/*xietongSysLog.setId(String.valueOf(i));*/
			xietongSysLog.setIsdelete(j);
			xietongSysLog.setRequestUrl(request.getRequestURL().toString()); // 请求地址
			xietongSysLog.setRequestMessage(Arrays.toString(pjp.getArgs())); // 请求参数
			long currntTimeMills = System.currentTimeMillis();
			/*SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String startTime=f.format(currntTimeMills);
			java.util.Date date=f.parse(startTime);
			logger.info(startTime);
			System.out.println(date);
			xietongSysLog.setCreatetime(date);*/
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			java.util.Date time=null;
			try {
				time= sdf.parse(sdf.format(new Date()));

			} catch (Exception e) {

				e.printStackTrace();
			}
			xietongSysLog.setCreatetime(time);
			Object obj = pjp.proceed();// obj 为方法的返回值

			xietongSysLog.setResponseMessage(JSONObject.toJSONString(obj));
			String OperatorName=UserUtils.getCurrentUser().getUsername();
			String OperatorId = UserUtils.getCurrentUser().getId();
			if(OperatorName!=null){
			xietongSysLog.setOperatorName(OperatorName);
			}else{
				xietongSysLog.setOperatorName("游客");
			}
			xietongSysLog.setOperatorId(OperatorId);
				xietongSysLog.setLasttime(String.valueOf(System.currentTimeMillis() - currntTimeMills));
			/*设置最后退出时间  类型是Date*/
			/*long exitTimeMills=currntTimeMills+Long.parseLong(xietongSysLog.getLasttime());
			SimpleDateFormat ff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String exitTime=ff.format(exitTimeMills);
			java.util.Date data2=ff.parse(exitTime);*/
			/*SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			java.util.Date time2=null;
			try {
				time2= sdf2.parse(sdf2.format(new Date()));

			} catch (Exception e) {

				e.printStackTrace();
			}*/
			//设置退出时间
			Long exit=System.currentTimeMillis();
			SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date d=sm.parse(sm.format(exit));
			xietongSysLog.setExittime(d);
			MethodSignature signature = (MethodSignature) pjp.getSignature();
			LogInfo logInfo = signature.getMethod().getAnnotation(LogInfo.class);
			if (logInfo != null) {
				xietongSysLog.setMethodName(logInfo.methodName());
			}
			xietongSysLog.setMethodInfo(pjp.getSignature().getDeclaringTypeName() + "_" + pjp.getSignature().getName());

			xietongSysLogService.insertSyslog(xietongSysLog);

			return obj; // 方法的返回值
		} catch (Exception e) {
			logger.error(tag + "日志切面出错", e);
			throw e;
		}
	}

}
