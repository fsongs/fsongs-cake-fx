package cn.fsongs.cake.common.util.core;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络相关工具类
 * @author fsongs
 * @version 1.0
 * @date 2022/5/16 15:00
 */
@Slf4j
public class NetworkUtil {
    // private static final Logger log = LoggerFactory.getLogger(NetworkUtil.class);
    private static String LOCAL_HOST = "";

    /**
     * 获取客户端真实ip
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
                ip = getLocalHost();
            }
        }
        if (ip != null && ip.length() > 15 && ip.indexOf(",") > 0) {
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip;
    }

    /**
     * 获取本地ip
     */
    private static String getLocalHost() {
        if ("".equals(LOCAL_HOST)) {
            try {
                LOCAL_HOST = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException var1) {
                log.error("获取本地IP失败");
            }
        }
        return LOCAL_HOST;
    }
}
