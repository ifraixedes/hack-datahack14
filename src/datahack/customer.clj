(ns datahack.customer
  (:require [datahack.loader :refer [load-from filter-from-by]]))

(def fields {
             :customer-id 0
             :form 1
             :to 2
             :circuit 3
             :router-name 4
             :port 5
             :country 6 })

(defn- data-source [] 
  (load-from "customer.csv"))

(defn- format-row [row]
  (vector (get row 0)
   (get row 4)
   (get (re-matches #".*-([\w\d]{3,3})-.*" (get row 1)) 1)
   (get row 1)
   (get row 2)
   (get row 3)
   (get row 5)))

(defn find-all [field-name field-value]
  "filter data from csv file by the specified value in colum name"
  (filter (fn [row]
            (= (get row (get fields field-name)) field-value))
            (map format-row (data-source))))
