(ns datahack.loader
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn load-from 
  "Get data from CSV file to return a lazy sequence of vectors"
  [file-name]
  (rest (csv/read-csv (io/reader (str "data/" file-name)))))

(defn filter-from-by [csv-data column-idx column-value]
  "filter data from csv file by the specified value in colum name"
  (filter (fn [row] 
            (= (get row column-idx) column-value))
          csv-data))
