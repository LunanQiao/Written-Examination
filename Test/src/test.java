import java.util.Scanner;

/**
 * Created by Zz on 2018/4/3.
 */
public class test {
    public  void test() {

     /*
        网易笔试1题
        牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床

        输入描述:
        每个输入包含一个测试用例。
       每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
       接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
       接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
       接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
       数据保证至少有一个闹钟可以让牛牛及时到达教室。

       输出描述:
       输出两个整数表示牛牛最晚起床时间。

      输入例子1:
      3
      5 0
      6 0
      7 0
      59
      6 59

      输出例子1:
      6 0
        (注意：输入的闹钟时间不一定按照顺序，)
         */

        Scanner sc = new Scanner(System.in);
        int n = 0 ;
        int retime;
        int time=1440;
        int hour=0,min=0;
        if(sc.hasNextInt()) n = sc.nextInt();
        int[][] clocktime = new int[n][2];

        for (int i = 0; i < n; i++) {           //二维数组表示闹钟，小时和分钟分开
            clocktime[i][0] = sc.nextInt();
            clocktime[i][1] = sc.nextInt();
        }
        int [][] gotime=new int[n][2];        //不可使用clone或者=来复制数组，因为那样他们会共用内存，一方改变另一方也跟着改变
        for (int i=0;i<n;i++){
            gotime[i][0]=clocktime[i][0];
            gotime[i][1]=clocktime[i][1];
        }

        int X = sc.nextInt();
        int classhour = sc.nextInt();
        int classmin = sc.nextInt();

        for (int i = 0; i < n; i++) {     //计算出发时间
            if (gotime[i][1] + X < 60) {
                gotime[i][1] =clocktime[i][1]+X;
            } else {
                gotime[i][0] += 1;
                gotime[i][1] = clocktime[i][1] + X - 60;
            }
        }
        for (int j = 0; j < n; ) {           //计算可行的闹钟剩余时间
            if(classhour-gotime[j][0]>0){
                retime=(classhour-gotime[j][0])*60+classmin-gotime[j][1];

            }else if(classhour-gotime[j][0]==0&&classmin>=gotime[j][1]){
                retime=classmin-gotime[j][1];
            }else {
                retime=1440;

            }
            if(retime < time){
                hour=clocktime[j][0];
                min=clocktime[j][1];
                time=retime;
            }
            j++;
        }
        System.out.print(hour+" "+min);

    }
}
