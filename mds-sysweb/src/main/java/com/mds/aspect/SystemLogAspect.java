package com.mds.aspect;

import com.mds.annotation.SystemControllerLog;
import com.mds.annotation.SystemServiceLog;
import com.mds.common.WebConstants;
import com.mds.entity.SystemLog;
import com.mds.entity.User;
import com.mds.service.SystemLogService;
import com.mds.utils.DateUtil;
import com.mds.utils.HttpUtil;
import com.mds.utils.JSONUtil;
import com.mds.utils.UUIDUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 2018/1/6
 * Time: 14:58
 * To change this template use File | Settings | File Templates.
 */
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private SystemLogService systemLogService;

    //本地异常日志记录对象
    private  static  final Logger logger = Logger.getLogger(SystemLogAspect.class);
    //Service层切点
    @Pointcut("@annotation(com.mds.annotation.SystemServiceLog)")
    public  void serviceAspect() {}
    //Controller层切点
    @Pointcut("@annotation(com.mds.annotation.SystemControllerLog)")
    public  void controllerAspect() {}

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     * @param joinPoint
     */
    @Before("controllerAspect()")
    public void doControllerBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        User user = (User)session.getAttribute(WebConstants.CURRENT_USER);
        //请求的IP
        String ip = HttpUtil.getClientIpAddress(request);
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        params = request.getQueryString();
       /* if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                Object [] obj = joinPoint.getArgs();
                params += JSONUtil.toJSONString(joinPoint.getArgs()[i]) + ";";
            }
        }*/
        try {
            Map<String,Object> resultMap = getControllerMethodAnnotationValue(joinPoint);
            String module = (String)resultMap.get("module");
            String option = (String)resultMap.get("option");
            String description = (String)resultMap.get("description");
            //*========控制台输出=========*//
            logger.info("=====前置通知开始=====");
            logger.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            logger.info("方法描述:" + getControllerMethodAnnotationValue(joinPoint));
            logger.info("请求人:" + (user==null?"session未发现用户信息":user.getUserName()));
            logger.info("请求IP:" + ip);
            //*========数据库日志=========*//
            SystemLog log = new SystemLog();
            log.setId(UUIDUtils.getUUID());
            log.setUserId((user==null?"":user.getId()));
            log.setType("0");
            log.setModule(module==""?request.getContextPath():module);
            log.setOption(option);
            log.setDescription(description);
            log.setMethodName(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            log.setParameter(params);
            log.setCreateTime(DateUtil.getCurrentDateTime());
            log.setUserIp(ip);
            //保存数据库
            systemLogService.addSystemLog(log);
            logger.info("=====前置通知结束=====");
        }  catch (Exception e) {
            e.printStackTrace();
            //记录本地异常日志
            logger.error("==前置通知异常==");
            e.printStackTrace();
        }
    }
    /**
     * 前置通知 用于拦截service层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before("serviceAspect()")
    public  void doBefore(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        User user = (User)session.getAttribute(WebConstants.CURRENT_USER);
        //请求的IP
        String ip = HttpUtil.getClientIpAddress(request);
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                if(joinPoint.getArgs()[i] instanceof String){
                    params += joinPoint.getArgs()[i] + ";";
                    continue;
                }else if(joinPoint.getArgs()[i] instanceof Integer){
                    params += joinPoint.getArgs()[i] + ";";
                    continue;
                }else if(joinPoint.getArgs()[i] instanceof Double){
                    params += joinPoint.getArgs()[i] + ";";
                    continue;
                }else{
                    params += JSONUtil.toJSONString(joinPoint.getArgs()[i]) + ";";
                }

            }
        }
        try {
            Map<String,Object> resultMap = getServiceMethodAnnotationValue(joinPoint);
            String module = (String)resultMap.get("module");
            String option = (String)resultMap.get("option");
            String description = (String)resultMap.get("description");
            //*========控制台输出=========*//
            logger.info("=====前置通知开始=====");
            logger.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            logger.info("方法描述:" + getServiceMethodAnnotationValue(joinPoint));
            logger.info("请求人:" + (user==null?"session未发现用户信息":user.getUserName()));
            logger.info("请求IP:" + ip);
            logger.info("请求参数:" + params);
            //*========数据库日志=========*//
            SystemLog log = new SystemLog();
            log.setId(UUIDUtils.getUUID());
            log.setUserId((user==null?"":user.getId()));
            log.setType("1");
            log.setModule(module==""?request.getContextPath():module);
            log.setOption(option);
            log.setDescription(description);
            log.setMethodName(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            log.setParameter(params);
            log.setCreateTime(DateUtil.getCurrentDateTime());
            log.setUserIp(ip);
            //保存数据库
            systemLogService.addSystemLog(log);
            logger.info("=====前置通知结束=====");
        }  catch (Exception e) {
            //记录本地异常日志
            logger.error("==前置通知异常==");
            e.printStackTrace();
        }
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        User user = (User)session.getAttribute(WebConstants.CURRENT_USER);
        //获取请求ip
        String ip = HttpUtil.getClientIpAddress(request);
        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                if(joinPoint.getArgs()[i] instanceof String){
                    params += joinPoint.getArgs()[i] + ";";
                    continue;
                }else if(joinPoint.getArgs()[i] instanceof Integer){
                    params += joinPoint.getArgs()[i] + ";";
                    continue;
                }else if(joinPoint.getArgs()[i] instanceof Double){
                    params += joinPoint.getArgs()[i] + ";";
                    continue;
                }else{
                    params += JSONUtil.toJSONString(joinPoint.getArgs()[i]) + ";";
                }
            }
        }

        try {
            Map<String,Object> resultMap = getServiceMethodAnnotationValue(joinPoint);
            String module = (String)resultMap.get("module");
            String option = (String)resultMap.get("option");
            String description = (String)resultMap.get("description");
            /*========控制台输出=========*/
//            logger.info("=====异常通知开始=====");
            logger.info("异常代码:" + e.getClass().getName());
            logger.info("异常信息:" + e.getMessage());
            logger.info("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            logger.info("方法描述:" + getServiceMethodAnnotationValue(joinPoint));
            logger.info("请求人:" + (user==null?"session未发现用户信息":user.getUserName()));
            logger.info("请求IP:" + ip);
            logger.info("请求参数:" + params);
            /*==========数据库日志=========*/
            SystemLog log = new SystemLog();
            log.setId(UUIDUtils.getUUID());
            log.setUserId((user==null?"":user.getId()));
            log.setType("3");
            log.setModule(module==""?request.getContextPath():module);
            log.setOption(option);
            log.setDescription(description);
            log.setMethodName(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
            log.setParameter(params);
            log.setCreateTime(DateUtil.getCurrentDateTime());
            log.setUserIp(ip);
            //保存数据库
            systemLogService.addSystemLog(log);
//            logger.info("=====异常通知结束=====");
        }  catch (Exception ex) {
            //记录本地异常日志
            logger.error("==异常通知异常==");
            e.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static Map<String,Object> getServiceMethodAnnotationValue(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        Map<String,Object> resultMap = new HashMap<String,Object>();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    resultMap.put("module",method.getAnnotation(SystemServiceLog.class).module());
                    resultMap.put("option",method.getAnnotation(SystemServiceLog.class).option());
                    resultMap.put("description",method.getAnnotation(SystemServiceLog.class).description());
                    break;
                }
            }
        }
        return resultMap;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static Map<String,Object> getControllerMethodAnnotationValue(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        Map<String,Object> resultMap = new HashMap<String,Object>();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    resultMap.put("module",method.getAnnotation(SystemControllerLog.class).module());
                    resultMap.put("option",method.getAnnotation(SystemControllerLog.class).option());
                    resultMap.put("description",method.getAnnotation(SystemControllerLog.class).description());
                    break;
                }
            }
        }
        return resultMap;
    }

}
