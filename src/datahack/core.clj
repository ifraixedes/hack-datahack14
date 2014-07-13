(ns datahack.core
  (:require 
    [datahack.quos :as quos]
    [datahack.customer :as customer]
    [datahack.traffic :as traffic])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  ;(println (quos/find-all :from "SQN"))
  ;(println (customer/find-all :circuit "0JC-HK2-NP3"))
  (println (traffic/find-all :minimum-commitment 500))
  (println "End!!"))

