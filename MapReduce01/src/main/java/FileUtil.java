import java.io.File;

/**
 * Created by YYL on 2017/7/18.
 */
//删除output文件的函数
public class FileUtil {
    public static boolean deleteDir(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            for (File f : dir.listFiles()) {
                if (f.isDirectory()) {
                    deleteDir(f.getName());
                } else {
                    f.delete();
                }
            }
            dir.delete();
            return true;
        } else {
            System.out.println("文件(夹)不存在!");
            return false;
        }
    }
}
