# Introduction

sample lein project for studying clojure
(Ref. https://eunmin.gitbooks.io/clojure-for-beginners/)

# Clojure
Lisp에서 파생된 함수형 프로그래밍 언어이다.
- jvm 위에서 동작
- REPL(read-eval-print loop) 환경에서의 빠른 개발, clj
- 1급 객체로서의 함수
- 멀티스레딩 개발에 

# 기본 문법

```clojure
(method param[, param ...])

=> (println "sum" (+ 2 3))
=> sum 5
```


# Concurrency

ex. transfer

```clojure
(def checking (ref 10000))
(def savings (ref 20000))

(defn transfer [from to amount]
  (dosync
    (alter from - amount)
    (alter to + amount)))
      
(defn stress-thread [from to iterations amount]
  (Thread. #(dotimes [_ iterations] (transfer from to amount))))
  
(defn start[]
  (let [t1 (stress-thread checking savings 100 100)
        t2 (stress-thread savings checking 200 100)]
  (.start t1)
  (.start t2)
  (.join t1)
  (.join t2)
  (println @checking @saving))
```

ex. clojure.core
- http://clojure.github.io/core.async/

```clojure
(def ch (chan))
(go
  (let [x (<! ch)
        y (<! ch)]
  (println "sum:" (+ x y ))))
  
(>!! ch 1) ; 채널에 값이 들어오면 스레드 풀에서 스레드를 가져와 x 값을 설정하고, 채널에 또 값이 들어오길 기다리는 이벤트 핸들러를 만들고 종료
;; true 
(>!! ch 2)
;; true
;; sum:3
```

# 모나드
*컨텍스트*가 있는 *연속된 계산*을 *읽기 쉽게* 작성하기 위한 *순수한 함수형* 패턴

1. 컨텍스트
- 로직, 데이터 ..
- Maybe 모나드:연속된 계산 중 결과가 nil이면 전체 결과가 nil
  ```clojure
  (defn bind [mv f]
    (if mv
      (f mv)
      nil))
  ```
- Writer 모나드: 연속된 계산 중 다른 환경에 값을 기록하고 싶은 경우
- State 모나드: 연속된 계산 중 읽고 쓰는 환경이 필요한 경우
- ...
2. 연속된 계산
```clojure
(((fn [x]
    (fn [y]
       (+ x y))) 
       1) 
         2)
;; x=1 y=2
```
3. 읽기 쉽게: 작은 메소드들을 큰 메소드에 넣어서 추상화
4. 순수한 함수형: 부수효과, 상대, 전역값이 존재하지 않음

- 읽어보면 좋을 것: http://tech.kakao.com/2016/03/03/monad-programming-with-scala-future/

