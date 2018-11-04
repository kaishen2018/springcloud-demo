package com.softtek.irain.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by kaishen on 06/09/2018.
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.example.demo.*(..))")
    public void before() {
        logger.info("before");
    }

    public void after() {

    }

//    @Pointcut("execution(* com.example.demo.controller..*(..))")
//    public void pointCut() {
//
//    }

//    @Around("pointCut() ")
//    public Object interceptor(ProceedingJoinPoint pjp) {
//
//        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
//
////        RequestDTO requestObj = new RequestDTO();
////        requestObj.setRequestURI(request.getRequestURI());
//
//        List<Object> params = new ArrayList<>();
//        for (Object obj : pjp.getArgs()) {
//            if (!(obj instanceof ServletRequest || obj instanceof ServletResponse)) {
//                params.add(obj);
//            }
//        }
//
////        requestObj.setRequestArgs(params.toArray());
//        logger.info("request: " + request.getRequestURI() + " params:" + pjp.getArgs());
//        Object result = null;
//
//        try {
//            result = pjp.proceed();
//
//        } catch (Throwable e){
//            logger.info("response: " + request.getRequestURI() + " result:" + result);
//        }
//        logger.info("response: " + request.getRequestURI() + " result:" + result);
//        return result;
//
//    }

}
