package com.alibaba.nacos.api.config;

import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

/**
 * 配置中心服务接口
 *
 * @author Nacos
 */
public interface ConfigService {
    
    /**
     * 配置查询
     *
     * @param dataId    dataId
     * @param group     group
     * @param timeoutMs 超时时间
     * @return 配置值
     */
    String getConfig(String dataId, String group, long timeoutMs) throws NacosException;

    /** 配置查询、注册监听器 */
    String getConfigAndSignListener(String dataId, String group, long timeoutMs, Listener listener) throws NacosException;
    
    /** 添加监听器 */
    void addListener(String dataId, String group, Listener listener) throws NacosException;
    
    /** 发布配置 */
    boolean publishConfig(String dataId, String group, String content) throws NacosException;
    boolean publishConfig(String dataId, String group, String content, String type) throws NacosException;
    
    /** CAS发布配置 */
    boolean publishConfigCas(String dataId, String group, String content, String casMd5) throws NacosException;
    boolean publishConfigCas(String dataId, String group, String content, String casMd5, String type) throws NacosException;
    
    /** 移除配置 */
    boolean removeConfig(String dataId, String group) throws NacosException;
    
    /** 移除监听器 */
    void removeListener(String dataId, String group, Listener listener);
    
    /** 获取服务端健康状态 */
    String getServerStatus();
    
    /** 关闭资源服务 */
    void shutDown() throws NacosException;
}
