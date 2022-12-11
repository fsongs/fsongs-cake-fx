package cn.fsongs.cake.job.config;

import com.google.common.collect.Lists;
import com.xxl.job.core.context.XxlJobHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * @author fsongs
 * @version 1.0
 * @date 2022/8/11 11:15
 */
@Component
@Slf4j
@Aspect
public class JobLog {
    private static ThreadLocal<Long> ACCESS_TIME = new ThreadLocal<>();

    private static final List<String> WHITE_URI = Lists.newArrayList("heartbeat");

    @Around(value = "execution(* cn.fsongs..*.task..*.*(..))")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        preProcess(point);
        Object obj = point.proceed();
        postProcess(point);
        return obj;
    }

    private void preProcess(ProceedingJoinPoint pjp) {
        ACCESS_TIME.set(System.currentTimeMillis());
        MDC.put("traceId", UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
        if (isPrintResult(getMethodName(pjp))) {
            log.info("--> startJob：{}, param：{}", getMethodName(pjp), XxlJobHelper.getJobParam());
        }
    }

    private void postProcess(ProceedingJoinPoint pjp) {
        if (isPrintResult(getMethodName(pjp))) {
            log.info("<-- endJob：{}, time：{}ms", getMethodName(pjp), System.currentTimeMillis() - ACCESS_TIME.get());
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
