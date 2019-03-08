package com.portjs.base.aop;

import com.alibaba.fastjson.JSONObject;
import com.portjs.base.entity.Log;
import com.portjs.base.service.LogService;
import com.portjs.base.util.UserUtils;
import io.micrometer.core.instrument.util.StringUtils;
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
 * */


@Component
@Aspect
public class LogBaseAspect {
	private static final String tag = "LogAspect======";
	private static final Logger logger = LoggerFactory.getLogger(LogBaseAspect.class);

	@Autowired
	LogService logService;

	// 切面
	@Pointcut("execution(public * com.portjs.base.controller.*.*(..))") // 两个..代表所有子目录，最后括号里的两个..代表所有参数
	public void logPointCut() {
	}

	@Around("logPointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

		try {
			// 接收到请求，记录请求内容
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();


			//设置Log属性值
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
			Date time=null;
			try {
				time= sdf.parse(sdf.format(new Date()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			long currntTimeMills = System.currentTimeMillis();
			Object obj = pjp.proceed();// obj 为方法的返回值
			String operatorName = UserUtils.getCurrentUser().getUsername();//获取登录用户名
			String remoteName = System.getenv().get("USERNAME");//获取客户端名
			MethodSignature signature = (MethodSignature) pjp.getSignature();
			String ip = LogBaseAspect.getClientIp(request);
			LogInfo logInfo = signature.getMethod().getAnnotation(LogInfo.class);

			//组装bean
			Log log = new Log();
			log.setCreatetime(time);
			log.setConsumeTime(System.currentTimeMillis() - currntTimeMills);
			log.setOperatorName(operatorName==null ? "游客" : operatorName);
			log.setRemoteIp(ip.equals("0:0:0:0:0:0:0:1")==true?"127.0.0.1":ip);
			log.setRemoteUser(remoteName!=null?remoteName:"未知客户端");

			log.setMethodInfo(pjp.getSignature().getDeclaringTypeName() + "_" + pjp.getSignature().getName());
			log.setMethodName(logInfo==null?"":logInfo.methodName());
			log.setModelName(logInfo==null?"":logInfo.modelName());
			log.setRequestMessage(Arrays.toString(pjp.getArgs()));
			//log.setResponseMessage(JSONObject.toJSONString(obj));

			//保存数据库
			logService.insertSelective(log);

			return obj;
		} catch (Exception e) {
			logger.error(tag + "日志切面出错", e);
			throw e;
		}
	}


/**
	 *  获取客户端ip地址
	 * @param request
	 * @return ip*/


	public static String getClientIp(HttpServletRequest request) {
			String ip = request.getHeader("X-Forwarded-For");
			if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
					//多次反向代理后会有多个ip值，第一个ip才是真实ip
				   int index = ip.indexOf(",");
				   if(index != -1){
						   return ip.substring(0,index);
					   }else{
					   	return ip;
				   }
				}
			ip = request.getHeader("X-Real-IP");
			if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
					return ip;
			   }
			return request.getRemoteAddr();
		}
}
