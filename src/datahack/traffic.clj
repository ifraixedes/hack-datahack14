(ns datahack.traffic
  (:require [datahack.loader :refer [load-from filter-from-by]])
  (:import (java.lang Integer)))

(def fields {
             :customer-id 0
             :from 1
             :to 2
             :circuit 3
             :speed 4
             :minimum-commitment 5 })

(defn- data-source [] 
  (load-from "traffic.csv"))

(defn- format-row [row]
  (vector (get row 0)
   (get (re-matches #"([\w\d]{3,3})-.*-.*" (get row 1)) 1)
   (get (re-matches #".*-([\w\d]{3,3})-.*" (get row 1)) 1)
   (get row 1)
   (. Integer parseInt (get row 2))
   (. Integer parseInt (get row 3))))

(defn find-all [field-name field-value]
  "filter data from csv file by the specified value in colum name"
  (filter (fn [row]
            (= (get row (get fields field-name)) field-value))
            (map format-row (data-source))))
