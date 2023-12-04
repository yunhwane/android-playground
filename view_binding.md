## 뷰 바인딩

```java
TextView tvName = findViewById(R.id.tv_name);
tvName.setText("snack");
```

- 웹 프로젝트 했을 때 자바스크립트로 dom 쓰는 것과 마찬가지로 규모있는 프로젝트를 하게 되면 코드가 더러워 질 것 같다.
- 또한 없는 id 값을 적었을 때 NULL 발생한다.

## VIEW BINDING 이란?
- xml 과 연겷할 때, 바인딩 클래스가 자동으로 생성되어 그 클래스의 멤버로 xml의 모든 view 를 참조하는 참조 변수

```java
android {
	...
    buildFeatures {
        viewBinding true
    }
}
```

```java
// 뷰 바인딩을 위한 변수 선언
    private lateinit var binding: ActivityMainBinding

    // 앱이 최초 실행되었을 때 수행되는 역할
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이제 binding 객체를 사용하여 뷰에 접근
        binding.tvTitle.text = "하이요!"
    }
```

1. 바인딩 초기화
   - layout 파일 이름 : 카멜 케이스로 변환
   - id 값 : 파스칼 케이스로 변환

```java
val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
```
- lazy로 바로 초기화 해도 된다.

## 여기서 알아가는 코틀린 문법

### lateinit
```java
fun main(){
    lateinit var text: String

     var result1 = 30

     text = "Result : $result1"
     println(text)


     val result2 = 50

    text = "Result : ${result1 + result2}"
    println(text)

```
- lateinit을 사용하면 늦은 초기화 이후에도 값이 계속 바뀔 수 있다.
- 만약 늦은 초기화를 안해주면 컴파일 단계에서 오류가 발생한다. 따라서 잠재적 오류를 방지한다.
- 무조건 var 을 사용해야 하며, Primitive Type (Int, Float, Double, Long 등) 에는 사용할 수 없다.

### lazy
```java
fun main(){
   lateinit var text: String

    val textLength: Int by lazy {
        text.length
    }

    // 대충 중간에 뭔가 했음
    text = "H43RO_Velog"
    println(textLength)

```
- 한 번의 늦은 초기화가 이루어지고 이후에는 값이 불변함을 보장한다.
- 즉 호출 시에 어떻게 초기화 해줄 지 정의할 수 있는 구문이다.

### 용법 생각하기
- lateinit : 초기화 이후에 계속하여 값이 바뀔 수 있을 때
- by lazy : 초기화 이후에 읽기 전용 값으로 사용할 때





