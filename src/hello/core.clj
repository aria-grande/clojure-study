(ns hello.core
  (:gen-class))

; 13. 10에서 만든 users 벡터에 특정 id 사용자를 삭제하는 remove-user라는 함수를 만들어 보시오.
; (defn remove-user [users id]
;   (filter (fn [u] (not= id (get u :id))) users))
; (defn -main [& args]
;   (def users [{:id 1 :name "Bob" :role :manager :age 10},
;               {:id 2 :name "Aria" :role :developer :age 11}])
;   (println (remove-user users 2)))

; 12. 10에서 만든 users 벡터에 마지막에 사용자를 추가하는 add-user라는 함수를 만들어 보시오.
; (defn add-user [users user]
;   (conj users user))
;
; (defn -main [& args]
;  (def users [{:name "Bob" :role :manager :age 10}
;              {:name "Aria" :role :developer :age 11}
;              {:name "Tomas" :role :developer :age 20}))
;   (def new-user {:name "Tom" :role :developer :age 21})
;   (println (add-user users new-user)))


; 11. 10에서 만든 users 벡터에서 개발자의 나이를 합산하는 sum-developer-age 함수를 만들어보시오.
; (defn developer? [user]
;   (= :developer (:role user)))
;
; (defn sum-developer-age [users]
;   (reduce + (map :age (filter developer? users))))
;
; (defn -main [& args]
;   (def users [{:name "Bob" :role :manager :age 10}
;               {:name "Aria" :role :developer :age 11}
;               {:name "Tomas" :role :developer :age 20}])
;
;   (println (sum-developer-age users)))

; 7. 여러개의 숫자를 입력 받아 해당 숫자를 모두 더하는 프로그램을 작성하시오.
; (defn -main [& args]
;   (def nums (map #(Long/parseLong %) args))
;   (println (apply + nums)))

; 6. 사칙 연산 문자열(+, -, *, /)과 두 수를 입력 받아 해당 연산을 출력하는 프로그램
; (defn -main [& args]
;   (def op (first args))
;   (def numbers (map #(Long/parseLong %) (rest args)))
;   (println ((resolve (symbol op)) (first numbers) (second numbers))))

; 5. 두 숫자를 입력 받아 합을 출력하는 프로그램
; (defn -main [& args]
;   (println (+ (Long/parseLong (first args)) (Long/parseLong (second args))))))

; 4. 이름을 입력 받아 "Hello 이름"을 출력하는 프로그램
; (defn -main
;   [& args]
;   (println "Hello " args))
