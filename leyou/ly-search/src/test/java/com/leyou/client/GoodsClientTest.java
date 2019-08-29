package com.leyou.client;

import com.leyou.LySearchService;
import com.leyou.pojo.SpuDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wfl
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LySearchService.class)
public class GoodsClientTest {

    @Autowired
    private GoodsClient goodsClient;

    @Test
    public void testGoods(){
        SpuDetail spuDetail = goodsClient.querySpuDetailById(2L);
        System.out.println("spuDetail = " + spuDetail.toString());
    }

}