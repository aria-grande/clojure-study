(ns hello.core
  (:gen-class))

(defn -main [& args]
  (println (+ (Long/parseLong (first args)) (Long/parseLong (second args)))))
; (defn -main
;   [& args]
;   (println "Hello " args))
