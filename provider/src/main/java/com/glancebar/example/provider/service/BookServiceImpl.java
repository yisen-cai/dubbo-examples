package com.glancebar.example.provider.service;

import com.glancebar.commons.CommonHandling;
import com.glancebar.example.api.dto.BookDTO;
import com.glancebar.example.api.service.BookService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * 示例的简单实现
 *
 * @author YISHEN CAI
 */
@DubboService(version = "0.0.1", protocol = "dubbo", timeout = 3000)
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public List<BookDTO> searchByMatch(String keyword) {
        Object value = RpcContext.getContext().get("something");
        logger.info("value is: {}", value);

        // 获取客户端隐式调用参数
        String index = RpcContext.getContext().getAttachment("index");
        logger.info("隐式调用参数为：{}", index);
        return Arrays.asList(new BookDTO("Book Name", "Book ISBN"));
    }

    @CommonHandling(message = "hello", countLastTime = true, errPropagating = true)
    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        if (bookDTO.getName().contains("Book")) {
            throw new RuntimeException("非法参数");
        }
        return bookDTO;
    }

}
