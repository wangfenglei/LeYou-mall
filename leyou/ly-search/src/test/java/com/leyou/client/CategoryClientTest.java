package com.leyou.client;

import com.leyou.LySearchService;
import com.leyou.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

/**
 * @author wfl
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LySearchService.class)
public class CategoryClientTest {
    @Autowired
    private CategoryClient categoryClient;

    @Test
    public void testQueryCategories() {
        List<Category> categories = categoryClient.queryCategoryListByids(Arrays.asList(1L, 2L, 3L));
        for (Category category : categories) {
            System.out.println(category);
        }
    }
}