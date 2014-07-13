(ns datahack.quos
  (:require [datahack.loader :refer [load-from filter-from-by]])
  (:import (java.text SimpleDateFormat)
           (java.lang Float)))

(def fields {
             :date 0
             :from 1
             :to 2 
             :latency 3
             :packet-loss 4
             :jitter 5})

(defn- data-source [] 
  (load-from "quos.csv"))

(defn- format-row [row]
  (vector (. (SimpleDateFormat. "dd/MM/yyyy") parse (get row 0))
   (get row 1)
   (get row 2)
   (. Float parseFloat (get row 3))
   (. Float parseFloat (get row 4))
   (. Float parseFloat (get row 5))))

(defn find-all [field-name field-value]
  "filter data from csv file by the specified value in colum name"
  (map format-row (filter-from-by (data-source) (get fields field-name) field-value)))
  

