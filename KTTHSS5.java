import java.util.Scanner;
public class KTTHSS5 {
    static final int MAX=100;
    static String[] mssvList=new String[MAX];
    static int size=0;
    static Scanner sc=new Scanner(System.in);
    static boolean validMSSV(String s){
        return s.matches("B\\d{7}");
    }
    static void show(){
        if(size==0){
            System.out.println("Danh sách trống");
            return;
        }
        for(int i=0;i<size;i++){
            System.out.println((i+1)+". "+mssvList[i]);
        }
    }
    static void add(){
        if(size==MAX){
            System.out.println("Danh sách đã đầy");
            return;
        }
        String m;
        do{
            System.out.print("Nhập MSSV: ");
            m=sc.nextLine();
        }while(!validMSSV(m));
        mssvList[size++]=m;
    }
    static void update(){

    }
    static void delete(){

    }
    static void search(){
        System.out.print("Nhập chuỗi cần tìm: ");
        String key=sc.nextLine().toLowerCase();
        boolean found=false;
        for(int i=0;i<size;i++){
            if(mssvList[i].toLowerCase().contains(key)){
                System.out.println(mssvList[i]);
                found=true;
            }
        }
        if(!found)System.out.println("Không tìm thấy");
    }
    public static void main(String[] args){
        while(true){
            System.out.println("1.Hiển thị mã sinh viên");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Thoát");
            System.out.print("Chọn: ");
            int c=Integer.parseInt(sc.nextLine());
            switch(c){
                case 1:
                    show();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
