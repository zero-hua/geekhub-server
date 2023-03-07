package ink.geekhub.server;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    public RestHighLevelClient client;


    // 测试索引的创建， Request PUT liuyou_index
    @Test
    public void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("yixin_index");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        //   System.out.println(response);
        System.out.println(response.isAcknowledged());// 查看是否创建成功
        System.out.println(response);// 查看返回对象
        client.close();
    }


}
