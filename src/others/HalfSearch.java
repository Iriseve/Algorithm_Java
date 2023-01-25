package others;

/**
 * @ClassName HalfSearch
 * @Description 折半查找
 * @Author yiling
 * @date 2022/12/3 14:34
 */
public class HalfSearch {
    //非递归
    public static int searchKey(int[] a, int key) {
        int low = 0, high = a.length - 1;//设置区间初值
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == key) return mid; //找到啦！！欢呼
            else if (key < a[mid]) //缩小区间
                high = mid - 1; //在前半段查找
            else low = mid + 1; //在后半段找
        }
        return -1; //没找到呜呜呜
    }

    //递归
    public static int searchKey2(int[] a,int key,int low,int high){
        int i;
        if(low>high) return -1;//查找失败的标志
        int mid = (low + high)/2;
        if(key == a[mid]) return mid;
        else if(key<a[mid]) {
            i = searchKey2(a, key, low, mid - 1);
        } else {
            i = searchKey2(a, key, mid + 1, high);
        }
        return i; //注意最后return的是i，即每次返回给上一层的是i
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,10};
        //int result = searchKey(a,100);
        int result = searchKey2(a,15,0,a.length-1);
        System.out.println(result);
    }
}

