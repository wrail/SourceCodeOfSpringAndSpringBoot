package com.wrial.art6_rest.method.support;
/*
 * @Author  Wrial
 * @Date Created in 20:31 2019/7/24
 * @Description 自定义Properties的参数解析，不依赖于RequestBody注解
 */

import com.wrial.art6_rest.http.convert.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //判断是不是Properties
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();

        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        // Servlet Request API
        HttpServletRequest request = servletWebRequest.getRequest();

        /*
        因为ServletServerHttpRequest实现了HttpInputMessage
        public interface ServerHttpRequest extends HttpRequest, HttpInputMessage {

         */
        HttpInputMessage httpInputMessage = new ServletServerHttpRequest(request);

        //读取内容，返回一个Properties
        return converter.read(null, null, httpInputMessage);
    }
}
