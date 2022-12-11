package cn.fsongs.cake.app.config;

import cn.fsongs.cake.common.util.core.NetworkUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 日志记录
 * @author fsongs
 * @version 1.0
 * @date 2022/6/15 14:05
 */
@Component
@Aspect
@Slf4j
public class LogAop {
    private static ThreadLocal<Long> ACCESS_TIME = new ThreadLocal<>();

    private static final List<String> WHITE_URI = Lists.newArrayList("heartbeat");

    @Around(value = "execution(* cn.fsongs..*.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        preProcess(point);
        Object obj = point.proceed();
        postProcess(point, obj);
        return obj;
    }

    private void preProcess(ProceedingJoinPoint pjp) {
        ACCESS_TIME.set(System.currentTimeMillis());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = NetworkUtil.getClientIp(request);
        String uri = request.getRequestURI();

        MDC.put("traceId", UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
        if (isPrintResult(getMethodName(pjp))) {
            log.info("ip：{}, uri：{}，Method：{}, Args：{}", ip, uri, getMethodName(pjp), Arrays.toString(pjp.getArgs()));
        }
    }

    private void postProcess(ProceedingJoinPoint pjp, Object obj) {
        if (isPrintResult(getMethodName(pjp))) {
            log.info("Method：{}, time：{}ms, retValue={}", getMethodName(pjp), System.currentTimeMillis() - ACCESS_TIME.get(),
                    isPrintResult(getMethodName(pjp)) ? (obj == null ? "" : JSONObject.toJSONString(obj)) : "wu");
        }
        MDC.remove("traceId");
    }

    private boolean isPrintResult(String methodName) {
        if (StringUtils.isEmpty(methodName)) {
            return false;
        }
        return WHITE_URI.stream().noneMatch(x -> methodName.toLowerCase().contains(x.toLowerCase()));
    }

    private String getMethodName(ProceedingJoinPoint point) {
        return point.getTarget().getClass().getSimpleName() + "." + point.getSignature().getName();
    }
}
