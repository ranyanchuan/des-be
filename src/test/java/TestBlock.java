//import com.alibaba.fastjson.JSONObject;
//import com.yyan.App;
//import com.yyan.pojo.Block;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.ArrayList;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = {App.class})
//public class TestBlock {
//
//
//    public static ArrayList<Block> blockchain = new ArrayList<>();
//    public static int difficulty = 5;
//
//    @Test
//    public void blockchainTest() {
//        //添加我们的区块到主链上
////        blockchain.add(new Block("这是创世区块", "0"));
////        System.out.println("正在挖掘创世区块... ");
////        blockchain.get(0).mineBlock(difficulty);
////
////        blockchain.add(new Block("这是第二个区块", blockchain.get(blockchain.size() - 1).hash));
////        System.out.println("正在挖掘第二个区块... ... ");
////        blockchain.get(1).mineBlock(difficulty);
////
////        blockchain.add(new Block("这是第三个区块", blockchain.get(blockchain.size() - 1).hash));
////        System.out.println("正在挖掘第三个区块... ... ");
////
////        blockchain.get(2).mineBlock(difficulty);
////
////        System.out.println("\n主链校验: " + isChainValid());
////
////        String blockchainJson = JSONObject.toJSONString(blockchain);
////        System.out.println("\n区块链: ");
////        System.out.println(blockchainJson);
//    }
//
//
//    /**
//     * 检查区块链的完整性:目的是循环区块链中的所有区块并且比较hash值，
//     * 这个方法用来检查hash值是否是于计算出来的hash值相等，
//     * 同时previousHash值是否和前一个区块的hash值相等。
//     * 或许你会产生如下的疑问，我们就在一个主函数中创建区块链中的区块，
//     * 所以不存在被修改的可能性，但是你要注意的是，
//     * 区块链中的一个核心概念就是去中心化，
//     * 每一个区块可能是在网络中的某一个节点中产生的，
//     * 所以很有可能某个节点把自己节点中的数据修改了，
//     * 那么根据上述的理论数据改变会导致整个区块链的破裂，
//     * 也就是区块链就无效了。
//     *
//     * @return
//     */
//    public static Boolean isChainValid() {
//        Block currentBlock;
//        Block previousBlock;
//        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
//
//        // 循环区块链，检查hash，验证是否被篡改
//        for (int i = 1; i < blockchain.size(); i++) {
//            currentBlock = blockchain.get(i);
//            previousBlock = blockchain.get(i - 1);
//            //比较注册哈希和计算哈希
//            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
//                System.out.println("当前区块 hash 不相等");
//                return false;
//            }
//            //比较前hash 与 注册hash
//            if (!previousBlock.hash.equals(currentBlock.preHash)) {
//                System.out.println("前区块 hash 不相等");
//                return false;
//            }
//            //检查哈希是否已解决
//            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
//                System.out.println("此区块尚未挖掘");
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//}
