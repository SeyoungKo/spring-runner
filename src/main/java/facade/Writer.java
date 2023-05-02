package facade;

public class Writer {
    private String fileName;

    public Writer(String fileName){
        this.fileName = fileName;
    }

    public void fileConnect(){
        String msg = String.format("Writer %s 로 연결합니다.", fileName);
        System.out.println(msg);
    }

    public void fileWrite(){
        String msg = String.format("writer %s 로 내용을 씁니다", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("writer %s 로 연결을 종료합니다", fileName);
        System.out.println(msg);
    }
}
