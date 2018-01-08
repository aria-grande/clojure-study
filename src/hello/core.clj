(ns hello.core
  (:gen-class))

; 11. 10에서 만든 users 벡터에서 개발자의 나이를 합산하는 sum-developer-age 함수를 만들어보시오.
; (defn sum-developer-age [users]
;   (reduce + (map (fn [u] (:age u)) (filter (fn [user] (= :developer (:role user))) users))))
;
; (defn -main [& args]
;   (def users [{:name "Bob" :role :manager :age 10}
;               {:name "Aria" :role :developer :age 11}
;               {:name "Tomas" :role :developer :age 20}])
;   (println (sum-developer-age users)))


; 6. 사칙 연산 문자열(+, -, *, /)과 두 수를 입력 받아 해당 연산을 출력하는 프로그램
(defn -main [& args]
  (def op (first args))
  (def numbers (map #(Long/parseLong %) (rest args)))
  (println ((resolve (symbol op)) (first numbers) (second numbers))))

; 5. 두 숫자를 입력 받아 합을 출력하는 프로그램
; (defn -main [& args]
;   (println (+ (Long/parseLong (first args)) (Long/parseLong (second args))))))

; 4. 이름을 입력 받아 "Hello 이름"을 출력하는 프로그램
; (defn -main
;   [& args]
;   (println "Hello " args))
