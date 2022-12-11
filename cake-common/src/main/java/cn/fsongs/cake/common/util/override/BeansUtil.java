package cn.fsongs.cake.common.util.override;

import com.google.common.collect.Lists;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 复制
 * @author fsongs
 * @version 1.0
 * @date 2022/7/1 17:29
 */
@Component
public class BeansUtil implements ApplicationContextAware {
    private static ApplicationContext APPLICATION_CONTEXT;

    /**
     * 确保Collection成员属性值正确拷贝
     */
    public static <T, E> E copyProperties(T source, Class<E> target) {
        if (source == null) {
            return null;
        }
        try {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return mapper.map(source, target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 确保Collection成员属性值正确拷贝
     */
    public static <T, E> List<E> copyProperties(List<T> source, Class<E> target) {
        try {
            if (CollectionUtils.isEmpty(source)) {
                return Lists.newArrayList();
            }
            List<E> result = Lists.newArrayListWithCapacity(source.size());
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            source.forEach(x -> result.add(mapper.map(x, target)));
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    public static Object getBean(String beanName) {
        return APPLICATION_CONTEXT.getBean(beanName);
    }

    public static <T> T getBean(Class<T> cls) {
        return APPLICATION_CONTEXT.getBean(cls);
    }
}
