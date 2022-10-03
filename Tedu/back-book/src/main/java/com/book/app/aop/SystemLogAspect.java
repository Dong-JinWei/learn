package com.book.app.aop;


import com.book.app.entity.TbLog;
import com.book.app.service.TbLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private TbLogService logsService;

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    // Controller层切点
    @Pointcut("@annotation(SystemControllerLog)")
    public void controllerAspect() {

    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取登录用户信息
        TbLog logs = new TbLog();
        // 操作方法
        logs.setMethods((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
        // 方法描述
        logs.setDdesc(getControllerMethodDescription(joinPoint));
        // 获得IP地址
        logs.setIp(request.getRemoteAddr());
        System.out.println(logsService.save(logs) ? "记录日志成功" : "记录日志失败");
    }

    /**
     * @Description 获取注解中对方法的描述信息 用于Controller层注解
     * @date 2020年11月9日 上午12:01
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();// 目标方法名
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }


}
