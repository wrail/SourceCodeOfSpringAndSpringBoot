package com.wrial.art6_rest.http.convert.properties;
/*
 * @Author  Wrial
 * @Date Created in 13:58 2019/7/24
 * @Description 实现自定义的PropertiesHttpMessageConverter
 * {@link Properties} {@link HttpMessageConverter} 实现
 */

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

//Generic 一般的   Internal 内部的
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    /*
    //可以从父类的源码中看出可以在构造方法中初始化MediaType
    protected AbstractGenericHttpMessageConverter(MediaType supportedMediaType) {
		super(supportedMediaType);
	}

     */

    public PropertiesHttpMessageConverter(){
        // 设置支持的 MediaType,没有它就不能适配自定义的消息转换器，自然也不能被转换
        //在配置跨域请求测试时必须要注释此MediaType，因为它会让Thymeleaf模板引擎自动装配失效
//        super(new MediaType("text", "properties"));
    }

    /*
     可以看到properties中方法基本都是字符流，因此，字符流需要注意编码
     */

    /*
    从内存写出去
     */
    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        OutputStream outputStream = outputMessage.getBody();
        HttpHeaders headers = outputMessage.getHeaders();
        MediaType mediaType = headers.getContentType();
        //字符编码有可能不存在，需要给一个默认值
        Charset charset = mediaType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);

        properties.store(outputStreamWriter,"From PropertiesHttpMessageConverter,writeInternal");


    }

    /*
     读到内存中去
    */
    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        Properties properties = new Properties();
        HttpHeaders headers = inputMessage.getHeaders();
        MediaType mediaType = headers.getContentType();
        //字符编码有可能不存在，需要给一个默认值
        Charset charset = mediaType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        InputStream inputStream = inputMessage.getBody();
        //使用Reader输入流加上字符编码
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);

        properties.load(inputStreamReader);

        return properties;
    }

    //从上面的实现可以看出clazz用处不大
    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }
}
