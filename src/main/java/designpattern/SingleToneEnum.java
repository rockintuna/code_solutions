package designpattern;

public enum SingleToneEnum {
    //장점
    // thread safety
    // 리플랙션 객체 생성 방어
    // deserialize로도 동일한 객체 생성
    //단점
    // 이른 초기화
    // 상속 사용 불가능
    WaitingQueue
}
